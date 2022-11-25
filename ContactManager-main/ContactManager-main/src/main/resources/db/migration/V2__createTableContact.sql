CREATE TABLE public."Contact"
(
    contact_id integer,
    first_name character varying,
    last_name character varying,
    phone_number character varying,
    address character varying,
    user_id integer,
    CONSTRAINT "User" PRIMARY KEY (contact_id)
);
