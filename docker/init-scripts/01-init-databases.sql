-- Create databases for microservices
CREATE DATABASE customers_db;
CREATE DATABASE orders_db;
CREATE DATABASE products_db;

-- Create users for microservices (optional, for better security)
CREATE USER customers_user WITH ENCRYPTED PASSWORD 'customers_pass';
CREATE USER orders_user WITH ENCRYPTED PASSWORD 'orders_pass';
CREATE USER products_user WITH ENCRYPTED PASSWORD 'products_pass';

-- Grant privileges
GRANT ALL PRIVILEGES ON DATABASE customers_db TO customers_user;
GRANT ALL PRIVILEGES ON DATABASE orders_db TO orders_user;
GRANT ALL PRIVILEGES ON DATABASE products_db TO products_user;

-- Allow connections from microservices
GRANT ALL PRIVILEGES ON DATABASE customers_db TO admin;
GRANT ALL PRIVILEGES ON DATABASE orders_db TO admin;
GRANT ALL PRIVILEGES ON DATABASE products_db TO admin; 