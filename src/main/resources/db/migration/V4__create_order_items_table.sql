-- V4__create_order_items

CREATE TABLE order_items(
  id BIGSERIAL PRIMARY KEY,
  order_id BIGINT NOT NULL REFERENCES orders(id) ON DELETE CASCADE,
  product_id BIGINT NOT NULL REFERENCES products(id) ON DELETE RESTRICT,
  quantity INTEGER NOT NULL CHECK (quantity > 0),
  price_at_purchase NUMERIC(12, 2) NOT NULL CHECK (price_at_purchase >= 0),
  subtotal NUMERIC(12, 2) GENERATED ALWAYS AS (quantity * price_at_purchase) STORED,

  UNIQUE (order_id, product_id)
);

CREATE INDEX idx_order_items_order ON order_items(order_id);
CREATE INDEX idex_order_items_product ON order_items(product_id);