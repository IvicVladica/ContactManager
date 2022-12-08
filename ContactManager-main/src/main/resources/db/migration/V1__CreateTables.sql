CREATE TABLE if not exists contactType(
   type_id integer PRIMARY KEY,
   contact_type varchar(40),
   description varchar(100)
);

CREATE TABLE if not exists users(
   user_id UUID PRIMARY KEY,
   username varchar(100),
   email varchar(100) unique,
   password varchar(100),
   user_type varchar(100),
   created_date date,
   modified_date date
);

CREATE TABLE if not exists contacts(
   contact_id UUID PRIMARY KEY,
   first_name varchar(500),
   last_name varchar(50),
   address varchar(50),
   phone varchar(50),
   user_id uuid references users(user_id),
   contact_type_id integer REFERENCES contactType(type_id)
);
