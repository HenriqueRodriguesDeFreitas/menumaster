CREATE TABLE IF NOT EXISTS person(
    id UUID NOT NULL PRIMARY KEY DEFAULT gen_random_uuid(),
    name VARCHAR(255) NOT NULL,
    cpf VARCHAR(11) NOT NULL UNIQUE,
    mobilePhone VARCHAR(11) NOT NULL,
    address_id UUID NOT NULL,
    CONSTRAINT fk_person_address FOREIGN KEY (address_id) REFERENCES address(id)
);
