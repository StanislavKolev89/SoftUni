Use personal_data_base;

INSERT INTO roles(id, name)
VALUES (1, 'ADMIN'),
       (2, 'USER');

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

INSERT INTO warehouse(id, quantity, product_id)
VALUES (1,100,1),
       (2,100,2),
       (3,100,3),
       (4,100,4),
       (5,100,5);

INSERT INTO users(id, active, address, email, first_name, last_name, password, username, role_id)
VALUES (1,true,"ADMINADMIN23","admin@gmail.com","Admin","Adminov","25716ae4e2ae20a33f3cc5e42ca30d5862034fa853f3eefa3affc71afd5e781dadd2072b56f04206","admincho",1);

INSERT INTO used_products(id, description, image_url, phone_number, price, title, category_id, user_id)

values (1, 'first description', '/images/New-Spray-Gun.webp','1123123213121', 21.99, 'SPRAYGUN',1,1 ),
       (2, 'second description', '/images/New-Spray-Gun.webp','1123123213122', 22.99, 'DRILL',1,1 ),
       (3, 'third description', '/images/New-Spray-Gun.webp','1123123213a123', 23.99, 'Glasses',1,1 ),
       (4, 'first description', '/images/New-Spray-Gun.webp','1123123213124', 24.99, 'Filler',1,1 );
