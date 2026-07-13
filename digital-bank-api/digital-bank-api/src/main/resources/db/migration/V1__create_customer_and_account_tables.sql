CREATE TABLE CUSTOMER (
                          CUSTOMER_ID NUMBER(20) PRIMARY KEY,
                          NAME        VARCHAR2(100 CHAR) NOT NULL,
                          CPF         VARCHAR2(11 CHAR) NOT NULL UNIQUE,
                          BIRTH_DATE  DATE NOT NULL
);

CREATE TABLE ACCOUNT (
                         ACCOUNT_NUMBER NUMBER(20) PRIMARY KEY,
                         CUSTOMER_ID    NUMBER(20) NOT NULL,
                         BALANCE        NUMBER(15,2) NOT NULL,
                         CREATED_AT     TIMESTAMP NOT NULL,
                         STATUS         VARCHAR2(20 CHAR) NOT NULL,

                         CONSTRAINT FK_ACCOUNT_CUSTOMER
                             FOREIGN KEY (CUSTOMER_ID)
                                 REFERENCES CUSTOMER(CUSTOMER_ID)
);