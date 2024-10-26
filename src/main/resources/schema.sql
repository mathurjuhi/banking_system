DROP TABLE IF EXISTS User_Account;
CREATE TABLE User_Account(
	account_id BIGINT NOT NULL PRIMARY KEY,
 	first_name VARCHAR(255), 
 	last_name VARCHAR(255), 
 	user_id VARCHAR(20) NOT NULL UNIQUE, 
  	pass VARCHAR(10) NOT NULL,
  	addres VARCHAR(255), 
  	email VARCHAR(255), 
  	mobile VARCHAR(10),
 	balance NUMERIC(10,3) NOT NULL);