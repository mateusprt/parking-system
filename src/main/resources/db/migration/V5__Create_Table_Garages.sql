CREATE TABLE IF NOT EXISTS garages(
	id int NOT NULL AUTO_INCREMENT,
	zip_code varchar(20) NOT NULL,
	street varchar(50),
	district varchar(50),
	address_number varchar(10),
	state_id int NOT NULL,
	city_id int NOT NULL,
	rate_compact decimal(10,2) NOT NULL,
	rate_regular decimal(10,2) NOT NULL,
	rate_large decimal(10,2) NOT NULL,
	created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
	
	PRIMARY KEY(id),
	CONSTRAINT FK_state_garage FOREIGN KEY(state_id) REFERENCES states(id),
	CONSTRAINT FK_city_garage FOREIGN KEY(city_id) REFERENCES cities(id)
);