CREATE DATABASE autocomplex;
CREATE SCHEMA online_shop;

CREATE TABLE online_shop.role (
  id   BIGSERIAL PRIMARY KEY,
  name CHARACTER VARYING(128) NOT NULL
);

CREATE TABLE online_shop.user (
  id         BIGSERIAL PRIMARY KEY,
  first_name CHARACTER VARYING(128) NOT NULL,
  last_name  CHARACTER VARYING(128) NOT NULL,
  email      CHARACTER VARYING(128) NOT NULL UNIQUE,
  password   CHARACTER VARYING(128) NOT NULL,
  role_id    BIGSERIAL              NOT NULL REFERENCES online_shop.role (id)
);

CREATE TABLE online_shop.contact (
  id                   BIGSERIAL PRIMARY KEY,
  phone_number         CHARACTER VARYING(20) NOT NULL UNIQUE,
  phone_number_reserve CHARACTER VARYING(20),
  city                 CHARACTER VARYING(128),
  street               CHARACTER VARYING(128),
  building             CHARACTER VARYING(20),
  user_id              BIGINT                NOT NULL REFERENCES online_shop.user (id)
);

CREATE TABLE online_shop.car (
  id      BIGSERIAL PRIMARY KEY,
  brand   CHARACTER VARYING(128),
  model   CHARACTER VARYING(128),
  year    NUMERIC(4),
  vin     CHARACTER VARYING(30) UNIQUE,
  user_id BIGINT NOT NULL REFERENCES online_shop.user (id)
);

CREATE TABLE online_shop.account (
  id      BIGSERIAL PRIMARY KEY,
  balance NUMERIC(7, 2) NOT NULL DEFAULT 0.0,
  user_id BIGINT        NOT NULL REFERENCES online_shop.user (id)
);

CREATE TABLE online_shop.search_history (
  id          BIGSERIAL PRIMARY KEY,
  article     CHARACTER VARYING(40) NOT NULL,
  brand       CHARACTER VARYING(40) NOT NULL,
  description CHARACTER VARYING(120),
  user_id     BIGINT                NOT NULL REFERENCES online_shop.user (id)
);

CREATE TABLE online_shop.wish (
  id          BIGSERIAL PRIMARY KEY,
  article     CHARACTER VARYING(40) NOT NULL,
  brand       CHARACTER VARYING(40) NOT NULL,
  description CHARACTER VARYING(120),
  price       NUMERIC(5),
  user_id     BIGINT                NOT NULL REFERENCES online_shop.user (id)
);

CREATE TABLE online_shop.orders (
  id          BIGSERIAL PRIMARY KEY,
  date_start  TIMESTAMP NOT NULL DEFAULT now(),
  date_finish TIMESTAMP,
  user_id     BIGINT    NOT NULL REFERENCES online_shop.user (id)
);

CREATE TABLE online_shop.category (
  id   BIGSERIAL PRIMARY KEY,
  name CHARACTER VARYING(40) NOT NULL UNIQUE
);

CREATE TABLE online_shop.product (
  id          BIGSERIAL PRIMARY KEY,
  article     CHARACTER VARYING(40) NOT NULL,
  brand       CHARACTER VARYING(40) NOT NULL,
  UNIQUE (article, brand),
  description CHARACTER VARYING(40) NOT NULL,
  quantity    NUMERIC(7)            NOT NULL,
  price_buy   NUMERIC(7, 2),
  price_sell  NUMERIC(7, 2)         NOT NULL
);

CREATE TABLE online_shop.product_category (
  product_id  BIGINT REFERENCES online_shop.product (id)  NOT NULL,
  category_id BIGINT REFERENCES online_shop.category (id) NOT NULL
);

CREATE TABLE online_shop.orders_product (
  order_id   BIGINT REFERENCES online_shop.orders (id)     NOT NULL,
  product_id BIGINT REFERENCES online_shop.product (id)    NOT NULL,
  PRIMARY KEY (order_id, product_id),
  quantity   INT                                           NOT NULL
);