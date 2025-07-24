CREATE TABLE reviews (
    id SERIAL PRIMARY KEY,
    product_id INTEGER NOT NULL,
    review_id INTEGER NOT NULL,
    author VARCHAR(255) NOT NULL,
    subject VARCHAR(255) NOT NULL,
    content VARCHAR(255) NOT NULL,
    version INTEGER,
    CONSTRAINT unique_product_review UNIQUE (product_id, review_id)
);

CREATE INDEX idx_reviews_product_id_review_id ON reviews(product_id, review_id);
