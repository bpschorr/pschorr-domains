DROP TABLE pschorr_domains CASCADE CONSTRAINTS;

CREATE TABLE pschorr_domains
(	domainRegistrationId NUMBER NOT NULL,
	domainName VARCHAR2(30) NOT NULL,
	domainExtension VARCHAR2(20) NOT NULL,
	customerName VARCHAR2(30) NOT NULL, 
	duration NUMBER NOT NULL,
	plan VARCHAR2(20) NOT NULL,
	adsRequired char,
	CONSTRAINT pschorr_domains_PK PRIMARY KEY(domainRegistrationId)
);


DROP SEQUENCE hibernate_sequence;

CREATE SEQUENCE hibernate_sequence start with 1008 increment by 1;

INSERT INTO pschorr_domains VALUES(1000,'javarocks','in','John',6,'Free','1');
INSERT INTO pschorr_domains VALUES(1001,'javainfo','com','Jim',12,'Combo','0');

COMMIT;

SELECT * FROM pschorr_domains;
