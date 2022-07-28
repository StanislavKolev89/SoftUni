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

INSERT INTO used_products(id, description, image_url, phone_number, price, title, category_id, user_id)

values (1, 'first description', '/images/New-Spray-Gun.webp','1123123213121', 21.99, 'SPRAYGUN',1,null ),
       (2, 'second description', '/images/New-Spray-Gun.webp','1123123213122', 22.99, 'DRILL',1,null ),
       (3, 'third description', '/images/New-Spray-Gun.webp','1123123213a123', 23.99, 'Glasses',1,null ),
       (4, 'first description', '/images/New-Spray-Gun.webp','1123123213124', 24.99, 'Filler',1,null );