create table products (

    id serial not null,
    product_name varchar(150) not null,
    product_description varchar(300) not null,
    product_price decimal(200) not null,
    quantity bigint not null,

    primary key(id)
)