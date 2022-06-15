INSERT INTO users (id, email, first_name, last_name, image_url, is_active, password)
VALUES (1, 'kolevone@gmail.com', 'Stancho', 'Kolev', 'https://www.google.com/imgres?imgurl=https%3A%2F%2Fimages.pexels.com%2Fphotos%2F674010%2Fpexels-photo-674010.jpeg%3Fcs%3Dsrgb%26dl%3Dpexels-anjana-c-674010.jpg%26fm%3Djpg&imgrefurl=https%3A%2F%2Fwww.pexels.com%2Fsearch%2Fbeautiful%2F&tbnid=2nDXavJs9DoKTM&vet=12ahUKEwiV6f39nZb4AhUB47sIHebTBt8QMygAegUIARDVAQ..i&docid=B51x0PBR9KNzvM&w=2976&h=3968&q=images&ved=2ahUKEwiV6f39nZb4AhUB47sIHebTBt8QMygAegUIARDVAQ', 1, '0f277e15562d34fcbb60037d4ac0cdee7b7eb4795584fe2d788898ce94dd93351eebed7836c43b79');


INSERT INTO brands (id, name)
VALUES (1, 'Ford'),
       (2, 'Toyota');

INSERT INTO models (id, name, category, start_year, end_year, brand_id, image_url)
VALUES (1, 'Fiesta', 'CAR', 1976, null, 1, 'https://upload.wikimedia.org/wikipedia/commons/7/7d/2017_Ford_Fiesta_Zetec_Turbo_1.0_Front.jpg'),
       (2, 'Escort', 'CAR', 1968, 2000, 1, 'https://www.auto-data.net/images/f110/Ford-Escort-VII-Hatch-GAL-AFL.jpg'),
       (3, 'Yaris', 'CAR', 1999, null, 2, 'https://upload.wikimedia.org/wikipedia/commons/thumb/3/3e/2020_Toyota_Yaris_Design_HEV_CVT_1.5_Front.jpg/1280px-2020_Toyota_Yaris_Design_HEV_CVT_1.5_Front.jpg');
