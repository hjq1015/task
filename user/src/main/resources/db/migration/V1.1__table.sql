CREATE TABLE users_temp (
  id bigserial PRIMARY KEY,
  name varchar(255),
  age integer,
  email varchar(32),
  createdAt timestamp,
  updatedAt timestamp
);