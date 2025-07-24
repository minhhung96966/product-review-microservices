CREATE TABLE products (
    id SERIAL PRIMARY KEY,
    product_id INTEGER NOT NULL UNIQUE,
    name VARCHAR(255) NOT NULL,
    weight INTEGER NOT NULL,
    version INTEGER
);

CREATE INDEX idx_products_product_id ON products(product_id);
