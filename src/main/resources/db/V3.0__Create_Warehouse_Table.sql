-- shemant.singh, 09/03/2025
GRANT ALL ON SCHEMA inventory TO postgres;

CREATE EXTENSION IF NOT EXISTS citext;

CREATE TABLE IF NOT EXISTS inventory.warehouse(
warehouse_id SERIAL PRIMARY KEY,
warehouse_name citext NOT NULL,
location_id bigint NOT NULL REFERENCES inventory.location(location_id),
functional boolean NOT NULL,
createdBy text DEFAULT 'SYSTEM',
createdAt timestamp DEFAULT now(),
changedBy text DEFAULT 'SYSTEM',
changedAt timestamp DEFAULT now(),
CONSTRAINT "unique_key_location_id" UNIQUE (location_id)
);