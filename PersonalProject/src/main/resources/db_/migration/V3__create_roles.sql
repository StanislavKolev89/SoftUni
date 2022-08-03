INSERT INTO roles(id, name)
VALUES (1, 'ADMIN'),
       (2, 'USER');

INSERT INTO users(id, active, address, email, first_name, last_name, password, username, role_id)
VALUES (1,true,"ADMINADMIN23","admin@gmail.com","Admin","Adminov","25716ae4e2ae20a33f3cc5e42ca30d5862034fa853f3eefa3affc71afd5e781dadd2072b56f04206","admincho",1);

