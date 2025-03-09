-- shemant.singh, 09/03/2025
GRANT ALL ON SCHEMA inventory TO postgres;

CREATE EXTENSION IF NOT EXISTS citext;

CREATE TYPE country_enum AS ENUM(
	IND,
	NZL,
	UAE,
	DE,
	USA,
	AT,
	FRA,
	ITA,
	ROU
);

CREATE TABLE IF NOT EXISTS inventory.location(
location_id SERIAL PRIMARY KEY,
latitude varchar(15) NOT NULL,
longitude varchar(15) NOT NULL, 
street citext NOT NULL,
city citext NOT NULL,
pincode varchar(10) NOT NULL,
country country_enum NOT NULL,
createdBy text DEFAULT 'SYSTEM',
createdAt timestamp DEFAULT now(),
changedBy text DEFAULT 'SYSTEM',
changedAt timestamp DEFAULT now(),
CONSTRAINT "unique_key_latitude_longitude" UNIQUE (latitude, longitude)
);