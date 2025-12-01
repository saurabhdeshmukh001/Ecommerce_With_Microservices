INSERT INTO sneako1.category (
  categoryid, name, created_at, updated_at, created_by, updated_by, version
) VALUES
(1, 'Casual Shoes', NOW(), NOW(), 'ROLE_ADMIN', 'ROLE_ADMIN', 0),
(2, 'Running Shoes', NOW(), NOW(), 'ROLE_ADMIN', 'ROLE_ADMIN', 0),
(3, 'Skate Shoes', NOW(), NOW(), 'ROLE_ADMIN', 'ROLE_ADMIN', 0),
(4, 'Basketball Shoes', NOW(), NOW(), 'ROLE_ADMIN', 'ROLE_ADMIN', 0);


 INSERT INTO sneako1.product (
  product_name, price, description, image_url, categoryid, stock_quantity, created_at, updated_at, updated_by, created_by, version
) VALUES
('Converse All Star', 3500.00, 'Classic canvas high-top sneakers for casual wear.', 'https://images.unsplash.com/photo-1565379793984-e65b51b33b37?q=80&w=880&auto=format&fit=crop&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D', 1, 23, NOW(), NOW(), 'ROLE_ADMIN', 'ROLE_ADMIN', 0),
('Nike Air Force 1', 8999.00, 'Timeless style and comfort in a low-cut design.', 'https://images.unsplash.com/photo-1643535170091-319c6fe2e191?q=80&w=880&auto=format&fit=crop&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D', 1, 20, NOW(), NOW(), 'ROLE_ADMIN', 'ROLE_ADMIN', 0),
('Puma Suede Classic', 6500.00, 'Iconic suede sneakers with a retro feel.', 'https://images.unsplash.com/photo-1608231387042-66d1773070a5?q=80&w=1374&auto=format&fit=crop&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D', 1, 16, NOW(), NOW(), 'ROLE_ADMIN', 'ROLE_ADMIN', 0),
('Adidas Stan Smith', 7200.00, 'Clean, classic tennis shoe silhouette.', 'https://images.unsplash.com/photo-1505248254168-1de4e1abfa78?q=80&w=1469&auto=format&fit=crop&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D', 1, 20, NOW(), NOW(), 'ROLE_ADMIN', 'ROLE_ADMIN', 0),
('Reebok Club C 85', 6800.00, 'Vintage tennis style with modern comfort.', 'https://images.unsplash.com/photo-1695459590088-d6fd3cc97cfa?q=80&w=764&auto=format&fit=crop&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D', 1, 19, NOW(), NOW(), 'ROLE_ADMIN', 'ROLE_ADMIN', 0),
('Nike Cortez', 7800.00, 'The original Nike running shoe, a classic since 1972.', 'https://images.unsplash.com/photo-1606107557195-0e29a4b5b4aa?q=80&w=764&auto=format&fit=crop&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D', 2, 20, NOW(), NOW(), 'ROLE_ADMIN', 'ROLE_ADMIN', 0),
('Asics Gel-Kayano', 14500.00, 'Stability running shoe designed for long distances.', 'https://images.unsplash.com/photo-1571741590149-a29f00898167?q=80&w=687&auto=format&fit=crop&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D', 2, 20, NOW(), NOW(), 'ROLE_ADMIN', 'ROLE_ADMIN', 0),
('Converse Chuck 70', 4200.00, 'A refined, vintage version of the classic All Star.', 'https://images.unsplash.com/photo-1680204101574-dea570724119?q=80&w=687&auto=format&fit=crop&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D', 1, 20, NOW(), NOW(), 'ROLE_ADMIN', 'ROLE_ADMIN', 0),
('Vans Sk8-Hi', 5500.00, 'High-top skate shoe with a durable canvas and suede upper.', 'https://images.unsplash.com/photo-1620237468009-9bbd18f2de23?q=80&w=687&auto=format&fit=crop&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D', 3, 20, NOW(), NOW(), 'ROLE_ADMIN', 'ROLE_ADMIN', 0),
('Jordan 4 Retro', 15999.00, 'Classic silhouette with visible air cushioning and mesh panels. A street-wear favorite.', 'https://images.unsplash.com/photo-1694729238828-028c0b74c579?q=80&w=764&auto=format&fit=crop&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D', 4, 20, NOW(), NOW(), 'ROLE_ADMIN', 'ROLE_ADMIN', 0),
('Adidas Samba OG', 6999.00, 'Timeless indoor soccer shoe reborn as a lifestyle icon. Features a suede T-toe design.', 'https://images.unsplash.com/photo-1695552835054-95b185af3d11?q=80&w=687&auto=format&fit=crop&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D', 1, 266, NOW(), NOW(), 'ROLE_ADMIN', 'ROLE_ADMIN', 0);
