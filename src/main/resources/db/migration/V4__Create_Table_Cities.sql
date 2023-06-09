CREATE TABLE IF NOT EXISTS cities(
	id int NOT NULL AUTO_INCREMENT,
	state_id INT NOT NULL,
	name varchar(150),
	created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
	
	PRIMARY KEY(id),
	CONSTRAINT FK_state FOREIGN KEY(state_id) REFERENCES states(id)
);