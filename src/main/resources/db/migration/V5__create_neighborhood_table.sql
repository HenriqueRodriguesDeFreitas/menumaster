CREATE TABLE IF NOT EXISTS neighborhood(
    id UUID NOT NULL PRIMARY KEY DEFAULT gen_random_uuid(),
    name VARCHAR(50) NOT NULL,
    city_id UUID NOT NULL,
    CONSTRAINT fk_neighborhood_city FOREIGN KEY (city_id) REFERENCES city(id)
);
