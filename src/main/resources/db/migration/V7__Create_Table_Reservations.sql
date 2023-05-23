CREATE TABLE IF NOT EXISTS reservations(
	id int NOT NULL AUTO_INCREMENT,
	user_id int NOT NULL,
	garage_id int NOT NULL,
	spot_id int NOT NULL,
	start_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
	end_time TIMESTAMP,
	value DECIMAL(10, 2),
	paid boolean NOT NULL DEFAULT FALSE,
	
	PRIMARY KEY(id),
	CONSTRAINT FK_users_reservations FOREIGN KEY (user_id) REFERENCES users(id),
	CONSTRAINT fk_garages_reservations FOREIGN KEY (garage_id) REFERENCES garages(id),
	CONSTRAINT fk_spots_reservations FOREIGN KEY (spot_id) REFERENCES spots(id)
);