INSERT INTO categories(id, image_url, name)
VALUES (1, '/images/CategoryTools.jpg', 'TOOLS'),
       (2, '/images/CategoryClearcoat.jpg', 'CLEAR'),
       (3, '/images/CategoryMasking.jpg', 'MASKING'),
       (4, '/images/CategoryBasecoat.jpg', 'BASECOAT'),
       (5, '/images/CategoryProtection.jpg', 'PROTECTION');


INSERT INTO products(id, description, image_url, price, title, category_id)
values (1, 'first description', '/images/New-Spray-Gun.webp', 22.99, 'Spraygun', 1),
       (2, 'second description', '/images/CategoryClearcoat.jpg', 33.99, 'Clearcoat', 2),
       (3, 'second description', '/images/maskingTape.jpg', 13.99, 'Masking', 3),
       (4, 'forth description', '/images/CategoryBasecoat.jpg', 33.99, 'Basecoat', 4),
       (5, 'fifth description', '/images/protectionGoggles.jpg', 33.99, 'Protection', 5);;

