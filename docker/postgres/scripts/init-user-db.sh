#!/bin/bash
set -e

psql -v ON_ERROR_STOP=1 --username "$POSTGRES_USER" --dbname "$POSTGRES_DB" <<-EOSQL
	CREATE SCHEMA IF NOT EXISTS people-registration;
	CREATE USER apppr WITH ENCRYPTED PASSWORD 'pswpr';
	ALTER USER apppr SET search_path TO people-registration;
	GRANT ALL PRIVILEGES ON DATABASE people-registration TO apppr;
	GRANT ALL PRIVILEGES ON SCHEMA people-registration TO apppr;
EOSQL
