CREATE TABLE IF NOT EXISTS address(
    id UUID NOT NULL PRIMARY KEY DEFAULT gen_random_uuid(),
    street VARCHAR(200) NOT NULL,
    addressNumber INT,
    complement VARCHAR(200),
    neighborhood_id UUID NOT NULL,
    CONSTRAINT fk_address_neighborhood FOREIGN KEY (neighborhood_id) REFERENCES neighborhood(id)
);
