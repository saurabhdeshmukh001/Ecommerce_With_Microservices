package org.genc.sneakoapp.AdminService.service.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.genc.sneakoapp.AdminService.dto.OrderDTO;
import org.genc.sneakoapp.AdminService.dto.ProductDTO;
import org.genc.sneakoapp.AdminService.dto.UserDetailsDTO;
import org.genc.sneakoapp.AdminService.exception.*;
import org.genc.sneakoapp.AdminService.service.api.AdminService;
import org.genc.sneakoapp.AdminService.util.PageResponse;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class AdminServiceImpl implements AdminService {

    private final RestTemplate restTemplate;

    private final String PRODUCT_SERVICE_URL = "http://localhost:8095/api/v1/product-service/product";
    private final String ORDER_SERVICE_URL = "http://localhost:8090/api/v1/order-service/order";
    private final String USER_SERVICE_URL = "http://localhost:8092/api/v1/user-service/users";

    @Override
    public ProductDTO findById(Long id) {
        String url = PRODUCT_SERVICE_URL + "/" + id;
        try {
            return restTemplate.getForObject(url, ProductDTO.class);
        } catch (Exception ex) {
            log.error("Error fetching product {}: {}", id, ex.getMessage(), ex);
            throw new ProductNotFoundException("Product not found with id " + id+ ex);
        }
    }

    @Override
    public ProductDTO createProduct(ProductDTO productDTO) {
        String url = PRODUCT_SERVICE_URL;
        try {
            ProductDTO createdProduct = restTemplate.postForObject(url, productDTO, ProductDTO.class);
            log.info("Created product with id: {}", createdProduct.getProductID());
            return createdProduct;
        } catch (Exception ex) {
            log.error("Error creating product: {}", ex.getMessage(), ex);
            throw new ProductCreateException("Failed to create product"+ ex);
        }
    }

    @Override
    public Page<ProductDTO> getProduct(Pageable pageable) {
        String url = PRODUCT_SERVICE_URL + "?page=" + pageable.getPageNumber() + "&size=" + pageable.getPageSize();
        try {
            ResponseEntity<PageResponse<ProductDTO>> response = restTemplate.exchange(
                    url,
                    HttpMethod.GET,
                    null,
                    new ParameterizedTypeReference<PageResponse<ProductDTO>>() {}
            );
            PageResponse<ProductDTO> pageResponse = response.getBody();
            return new PageImpl<>(pageResponse.getContent(), pageable, pageResponse.getTotalElements());
        } catch (Exception ex) {
            log.error("Error fetching products: {}", ex.getMessage(), ex);
            throw new RuntimeException("Failed to fetch products"+ ex);
        }
    }

    @Override
    public ProductDTO updateProduct(Long id, ProductDTO productDTO) {
        String url = PRODUCT_SERVICE_URL + "/" + id;
        try {
            restTemplate.put(url, productDTO);
            return findById(id);
        } catch (Exception ex) {
            log.error("Error updating product {}: {}", id, ex.getMessage(), ex);
            throw new ProductUpdateException("Failed to update product with id " + id+ ex);
        }
    }

    @Override
    public void deleteProduct(Long id) {
        String url = PRODUCT_SERVICE_URL + "/" + id;
        try {
            restTemplate.delete(url);
            log.info("Deleted product with id: {}", id);
        } catch (Exception ex) {
            log.error("Error deleting product {}: {}", id, ex.getMessage(), ex);
            throw new ProductDeleteException("Failed to delete product with id " + id+ ex);
        }
    }

    @Override
    public Long totalProduct() {
        String url = PRODUCT_SERVICE_URL + "/totalproducts";
        try {
            Long totalProducts = restTemplate.getForObject(url, Long.class);
            log.info("Fetched total products from ProductService: {}", totalProducts);
            return totalProducts;
        } catch (Exception ex) {
            log.error("Error fetching total products: {}", ex.getMessage(), ex);
            throw new RuntimeException("Failed to fetch total products", ex);
        }
    }

    @Override
    public Page<OrderDTO> getOrders(Pageable pageable) {
        String url = ORDER_SERVICE_URL + "?page=" + pageable.getPageNumber() + "&size=" + pageable.getPageSize();
        try {
            ResponseEntity<PageResponse<OrderDTO>> response = restTemplate.exchange(
                    url,
                    HttpMethod.GET,
                    null,
                    new ParameterizedTypeReference<PageResponse<OrderDTO>>() {}
            );
            PageResponse<OrderDTO> pageResponse = response.getBody();
            return new PageImpl<>(pageResponse.getContent(), pageable, pageResponse.getTotalElements());
        } catch (Exception ex) {
            log.error("Error fetching orders: {}", ex.getMessage(), ex);
            throw new RuntimeException("Failed to fetch orders", ex);
        }
    }

    @Override
    public OrderDTO updateOrderStatus(Long orderId, String newStatus) {
        String url = ORDER_SERVICE_URL + "/" + orderId;
        OrderDTO request = new OrderDTO();
        request.setOrderStatus(newStatus);
        try {
            ResponseEntity<OrderDTO> response = restTemplate.exchange(
                    url,
                    HttpMethod.PUT,
                    new HttpEntity<>(request),
                    OrderDTO.class
            );
            return response.getBody();
        } catch (Exception ex) {
            log.error("Error updating order {}: {}", orderId, ex.getMessage(), ex);
            throw new OrderUpdateException("Failed to update order with id " + orderId+ ex);
        }
    }

    @Override
    public Long totalOrders() {
        String url = ORDER_SERVICE_URL + "/totalorders";
        try {
            return restTemplate.getForObject(url, Long.class);
        } catch (Exception ex) {
            log.error("Error fetching total orders: {}", ex.getMessage(), ex);
            throw new RuntimeException("Failed to fetch total orders", ex);
        }
    }

    @Override
    public Long calculateTotalRevenue() {
        String url = ORDER_SERVICE_URL + "/totalrevenue";
        try {
            return restTemplate.getForObject(url, Long.class);
        } catch (Exception ex) {
            log.error("Error calculating total revenue: {}", ex.getMessage(), ex);
            throw new RuntimeException("Failed to calculate total revenue", ex);
        }
    }

    @Override
    public List<UserDetailsDTO> getAllUsers() {
        String url = USER_SERVICE_URL;
        try {
            ResponseEntity<List<UserDetailsDTO>> response = restTemplate.exchange(
                    url,
                    HttpMethod.GET,
                    null,
                    new ParameterizedTypeReference<List<UserDetailsDTO>>() {}
            );
            return response.getBody();
        } catch (Exception ex) {
            log.error("Error fetching users: {}", ex.getMessage(), ex);
            throw new RuntimeException("Failed to fetch users", ex);
        }
    }

    @Override
    @Transactional
    public void deleteUserById(Long id) {
        String url = USER_SERVICE_URL + "/" + id;
        try {
            restTemplate.delete(url);
            log.info("Deleted user with id: {}", id);
        } catch (Exception ex) {
            log.error("Error deleting user {}: {}", id, ex.getMessage(), ex);
            throw new UserDeleteException("Failed to delete user with id " + id+ex);
        }
    }

    @Override
    public UserDetailsDTO findUserById(Long id) {
        String url = USER_SERVICE_URL + "/admin/" + id;
        try {
            return restTemplate.getForObject(url, UserDetailsDTO.class);
        } catch (Exception ex) {
            log.error("Error fetching user {}: {}", id, ex.getMessage(), ex);
            throw new UserNotFoundException("User not found with id " + id +ex);
        }
    }

    @Override
    public Long TotalUsers() {
        String url = USER_SERVICE_URL + "/totalusers";
        try {
            Long totalUsers = restTemplate.getForObject(url, Long.class);
            log.info("Fetched total users from UserService: {}", totalUsers);
            return totalUsers;
        } catch (Exception ex) {
            log.error("Error fetching total users: {}", ex.getMessage(), ex);
            throw new RuntimeException("Failed to fetch total users", ex);
        }
    }
}
