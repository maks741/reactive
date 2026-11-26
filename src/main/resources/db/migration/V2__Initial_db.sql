CREATE TABLE bicycles (
    id BIGSERIAL,
    brand VARCHAR(100) NOT NULL,
    model VARCHAR(100) NOT NULL,
    type VARCHAR(50) NOT NULL,
    frame_size VARCHAR(20) NOT NULL,
    price NUMERIC(12, 2) NOT NULL,
    stock_quantity INTEGER NOT NULL DEFAULT 0,
    CONSTRAINT pk_bicycles PRIMARY KEY (id),
    CONSTRAINT chk_bicycles_price_non_negative CHECK (price >= 0),
    CONSTRAINT chk_bicycles_stock_non_negative CHECK (stock_quantity >= 0)
);

CREATE TABLE wheels (
    id BIGSERIAL,
    brand VARCHAR(100) NOT NULL,
    diameter VARCHAR(20) NOT NULL,
    position VARCHAR(20) NOT NULL,
    tubeless_ready BOOLEAN NOT NULL DEFAULT FALSE,
    price NUMERIC(12, 2) NOT NULL,
    stock_quantity INTEGER NOT NULL DEFAULT 0,
    CONSTRAINT pk_wheels PRIMARY KEY (id),
    CONSTRAINT chk_wheels_position CHECK (position IN ('FRONT', 'REAR', 'PAIR')),
    CONSTRAINT chk_wheels_price_non_negative CHECK (price >= 0),
    CONSTRAINT chk_wheels_stock_non_negative CHECK (stock_quantity >= 0)
);

CREATE TABLE orders (
    id BIGSERIAL,
    order_date TIMESTAMPTZ NOT NULL DEFAULT CURRENT_TIMESTAMP,
    total_price NUMERIC(12, 2) NOT NULL,
    status VARCHAR(30) NOT NULL,
    CONSTRAINT pk_orders PRIMARY KEY (id),
    CONSTRAINT chk_orders_total_price_non_negative CHECK (total_price >= 0),
    CONSTRAINT chk_orders_status CHECK (status IN ('NEW', 'PAID', 'SHIPPED', 'COMPLETED', 'CANCELLED'))
);

CREATE TABLE order_bicycles (
    order_id BIGINT NOT NULL,
    bicycle_id BIGINT NOT NULL,
    CONSTRAINT pk_order_bicycles PRIMARY KEY (order_id, bicycle_id),
    CONSTRAINT fk_order_bicycles_order FOREIGN KEY (order_id) REFERENCES orders (id) ON DELETE CASCADE,
    CONSTRAINT fk_order_bicycles_bicycle FOREIGN KEY (bicycle_id) REFERENCES bicycles (id) ON DELETE RESTRICT
);

CREATE TABLE order_wheels (
    order_id BIGINT NOT NULL,
    wheel_id BIGINT NOT NULL,
    CONSTRAINT pk_order_wheels PRIMARY KEY (order_id, wheel_id),
    CONSTRAINT fk_order_wheels_order FOREIGN KEY (order_id) REFERENCES orders (id) ON DELETE CASCADE,
    CONSTRAINT fk_order_wheels_wheel FOREIGN KEY (wheel_id) REFERENCES wheels (id) ON DELETE RESTRICT
);

CREATE INDEX idx_order_bicycles_bicycle_id ON order_bicycles (bicycle_id);
CREATE INDEX idx_order_wheels_wheel_id ON order_wheels (wheel_id);