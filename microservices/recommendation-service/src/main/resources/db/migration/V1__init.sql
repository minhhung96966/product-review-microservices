CREATE TABLE recommendations (
    id SERIAL PRIMARY KEY,
    product_id INTEGER NOT NULL,
    recommendation_id INTEGER NOT NULL,
    author VARCHAR(255) NOT NULL,
    rating INTEGER NOT NULL,
    content VARCHAR(255) NOT NULL,
    version INTEGER,
    CONSTRAINT unique_product_recommendation UNIQUE (product_id, recommendation_id)
);

CREATE INDEX idx_recommendations_product_id_recommendation_id ON recommendations(product_id, recommendation_id);

