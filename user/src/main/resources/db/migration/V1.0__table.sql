CREATE TABLE users (
  id bigserial PRIMARY KEY,
  name varchar(255),
  age integer,
  email varchar(32),
  createdAt timestamp,
  updatedAt timestamp
);