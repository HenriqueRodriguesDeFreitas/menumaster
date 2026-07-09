CREATE TABLE IF NOT EXISTS customer(
  id UUID NOT NULL PRIMARY KEY DEFAULT gen_random_uuid(),
    CONSTRAINT fk_customer_person FOREIGN KEY (id) references person(id) ON DELETE CASCADE
);
