CREATE TABLE CATEGORIES (CATEGORY_ID INT IDENTITY(2001,1), CATEGORY VARCHAR, PRIMARY KEY (CATEGORY_ID));
CREATE TABLE PRODUCTS (ID INT IDENTITY(1001,1), NAME VARCHAR, DESCRIPTION VARCHAR, QUANTITY INT,CREATED_DATE DATE, LAST_MODIFIED_DATE DATE, CATEGORY_ID INT, PRIMARY KEY (ID), FOREIGN KEY (CATEGORY_ID) REFERENCES CATEGORIES(CATEGORY_ID));
INSERT INTO CATEGORIES (CATEGORY) VALUES ('Laptop');
INSERT INTO CATEGORIES (CATEGORY) VALUES ('Monitor');
INSERT INTO PRODUCTS (NAME, DESCRIPTION, QUANTITY, CATEGORY_ID) VALUES ('Dell 5401', 'Dell Description', 12, 2001);
INSERT INTO  PRODUCTS (NAME, DESCRIPTION, QUANTITY, CATEGORY_ID) VALUES ('Dell U2413', 'Dell Monitor', 15, 2002);
INSERT INTO  PRODUCTS (NAME, DESCRIPTION, QUANTITY, CATEGORY_ID) VALUES ('Samsung', 'Samsung Monitor', 9, 2002);

