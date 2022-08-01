create table categories
(
    id        bigint auto_increment
        primary key,
    deleted   bit          not null,
    image_url varchar(255) not null,
    name      varchar(255) not null
);

create table products
(
    id          bigint auto_increment
        primary key,
    deleted     bit            not null,
    description varchar(255)   not null,
    image_url   varchar(255)   not null,
    price       decimal(19, 2) not null,
    title       varchar(255)   not null,
    category_id bigint null,
    constraint FKog2rp4qthbtt2lfyhfo32lsw9
        foreign key (category_id) references categories (id)
);

create table roles
(
    id   bigint auto_increment
        primary key,
    name varchar(255) not null
);

create table users
(
    id         bigint auto_increment
        primary key,
    active     bit          not null,
    address    varchar(255) not null,
    deleted    bit          not null,
    email      varchar(255) not null,
    first_name varchar(255) not null,
    last_name  varchar(255) not null,
    password   varchar(255) not null,
    username   varchar(255) not null,
    role_id    bigint null,
    constraint UK_6dotkott2kjsp8vw4d0m25fb7
        unique (email),
    constraint UK_r43af9ap4edm43mmtq01oddj6
        unique (username),
    constraint FKp56c1712k691lhsyewcssf40f
        foreign key (role_id) references roles (id)
);

create table orders
(
    id      bigint auto_increment
        primary key,
    date    datetime(6) not null,
    user_id bigint null,
    constraint FK32ql8ubntj5uh44ph9659tiih
        foreign key (user_id) references users (id)
);

create table ordered_products
(
    id         bigint auto_increment
        primary key,
    quantity   int not null,
    order_id   bigint null,
    product_id bigint null,
    constraint FKi7isf670mbq331v0muqqry1cd
        foreign key (order_id) references orders (id),
    constraint FKn042ir6sf41qikoy2c07gt87i
        foreign key (product_id) references products (id)
);

create table used_products
(
    id           bigint auto_increment
        primary key,
    description  varchar(255)   not null,
    image_url    varchar(255) null,
    phone_number varchar(255)   not null,
    price        decimal(19, 2) not null,
    title        varchar(255)   not null,
    category_id  bigint null,
    user_id      bigint null,
    constraint FK6dudjpfumrokdha1x1fni9eor
        foreign key (category_id) references categories (id),
    constraint FKp0i6ypn5mpd5du3tbibrumvrj
        foreign key (user_id) references users (id)
);

