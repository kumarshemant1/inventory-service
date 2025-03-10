-- shemant.singh, 09/03/2025
GRANT ALL ON SCHEMA inventory TO postgres;

CREATE EXTENSION IF NOT EXISTS citext;

CREATE TABLE IF NOT EXISTS inventory.location(
location_id SERIAL PRIMARY KEY,
latitude varchar(15) NOT NULL,
longitude varchar(15) NOT NULL, 
street citext NOT NULL,
city citext NOT NULL,
pincode varchar(10) NOT NULL,
country varchar(3) NOT NULL,
created_by text DEFAULT 'SYSTEM',
created_at timestamp DEFAULT now(),
changed_by text DEFAULT 'SYSTEM',
changed_at timestamp DEFAULT now(),
CONSTRAINT "unique_key_latitude_longitude" UNIQUE (latitude, longitude)
);