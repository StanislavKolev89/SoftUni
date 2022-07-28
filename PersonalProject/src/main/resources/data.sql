Use personal_data_base;

INSERT INTO categories(id, image_url, name,deleted)
VALUES (1, '/images/CategoryTools.jpg', 'TOOLS',false),
       (2, '/images/CategoryClearcoat.jpg', 'CLEAR',false),
       (3, '/images/CategoryMasking.jpg', 'MASKING',false),
       (4, '/images/CategoryBasecoat.jpg', 'BASECOAT',false),
       (5, '/images/CategoryProtection.jpg', 'PROTECTION',false);


INSERT INTO products(id, description, image_url, price, title, category_id,deleted)
values (1, 'first description', '/images/New-Spray-Gun.webp', 22.99, 'Spraygun', 1,false),
       (2, 'second description', '/images/CategoryClearcoat.jpg', 33.99, 'Clearcoat', 2,false),
       (3, 'second description', '/images/maskingTape.jpg', 13.99, 'Masking', 3,false),
       (4, 'forth description', '/images/CategoryBasecoat.jpg', 33.99, 'Basecoat', 4,false),
       (5, 'fifth description', '/images/protectionGoggles.jpg', 33.99, 'Protection', 5,false);;

