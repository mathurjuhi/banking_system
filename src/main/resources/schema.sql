DROP TABLE IF EXISTS online_schema.TransactionDetail;
DROP TABLE IF EXISTS online_schema.User_Account;
DROP TABLE IF EXISTS online_schema.Customer;

DROP SCHEMA IF EXISTS online_schema;
CREATE SCHEMA online_schema;

CREATE TABLE online_schema.Customer(
	customer_id BIGINT NOT NULL PRIMARY KEY,
 	first_name VARCHAR(255), 
 	last_name VARCHAR(255), 
 	user_name VARCHAR(20) NOT NULL UNIQUE, 
  	pass VARCHAR(10) NOT NULL,
  	addres VARCHAR(255),
  	dob VARCHAR(30), 
  	email VARCHAR(255), 
  	mobile VARCHAR(10)
  	);

CREATE TABLE online_schema.User_Account(
	account_id BIGINT NOT NULL PRIMARY KEY,
 	user_id VARCHAR(20) NOT NULL REFERENCES Customer(customer_id),
 	acc_num BIGINT NOT NULL,
  	acc_type VARCHAR(10) NOT NULL,
  	is_active BOOLEAN, 
  	created_date VARCHAR(25), 
 	balance NUMERIC(10,3) NOT NULL);
 	
CREATE TABLE online_schema.TransactionDetail(
	 account_id BIGINT NOT NULL REFERENCES User_Account(account_id),
	 transaction_id BIGINT NOT NULL PRIMARY KEY,
	 type VARCHAR(10) NOT NULL, 
	 amount NUMERIC(10,3) NOT NULL, 
	 credit BIGINT,
	 debit BIGINT,
	 date_of_transaction DATE NOT NULL
	 );