#-------------------------------------------------------------------------------
# Database (postgres)
#-------------------------------------------------------------------------------
DROP DATABASE keycloak;

create user keycloak with password 'keycloak1234';

ALTER ROLE keycloak CREATEDB REPLICATION;

CREATE DATABASE keycloakdb OWNER keycloak ENCODING 'utf-8';

#-------------------------------------------------------------------------------
# Database (mysql)
#-------------------------------------------------------------------------------
use mysql;
create database keycloak;
#-------------------------------------------------------------------------------
# keycloak.conf
#-------------------------------------------------------------------------------

# jdbc:postgresql://10.0.2.2:5432/keycloak
db=postgres
db-username=keycloak
db-password=keycloak1234
db-url=jdbc:postgresql://10.0.2.2:5432/keycloakdb

# jdbc:mysql://192.168.16.11:3306/keycloak
db=mysql
db-username=root
db-password=seul1234
db-url=jdbc:mysql://192.168.16.11:3306/keycloak


