INSERT INTO categories(id, image_url, name)
VALUES (1, '/images/CategoryTools.jpg', 'TOOLS'),
       (2, 'images/CategoryClearcoat.jpg', 'CLEAR'),
       (3, '/images/CategoryBasecoat.jpg', 'BASECOAT');


INSERT INTO products(id, description, image_url, price, title, category_id)
values (1, 'first description', '/images/wallpaper.jpg', 22, 'Spraygun', 1),
       (2, 'second description', '/images/CategoryClearcoat.jpg', 44, 'Clearcoat', 2),
       (3, 'third description', '/ images/CategoryBasecoat.jpg', 33, 'Basecoat', 3);

