CREATE ROLE "thebook" WITH SUPERUSER;
CREATE USER "thebook-ro" WITH PASSWORD 'thebook-ro' IN ROLE "thebook";
CREATE USER "thebook-dml" WITH PASSWORD 'thebook-dml' IN ROLE "thebook";
CREATE USER "thebook-app" WITH PASSWORD 'thebook-app' IN ROLE "thebook";

ALTER USER "thebook-app" SET search_path = public, thebook;

CREATE DATABASE "thebook" WITH OWNER "thebook-app";