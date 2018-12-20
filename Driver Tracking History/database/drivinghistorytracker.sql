DROP TABLE IF EXISTS driving_history_tracker;
DROP TABLE IF EXISTS driver_name;
DROP TABLE IF EXISTS driving_tracker_results;

DROP SEQUENCE IF EXISTS driver_id_seq;
DROP SEQUENCE IF EXISTS name_id_seq;
DROP SEQUENCE IF EXISTS results_id_seq;

CREATE SEQUENCE driver_id_seq
  INCREMENT BY 1
  NO MAXVALUE
  NO MINVALUE
  CACHE 1;

CREATE TABLE driving_history_tracker (
  driver_id integer DEFAULT nextval('driver_id_seq'::regclass) NOT NULL,
  driver varchar(80) NOT NULL,
  start_time time NOT NULL,
  stop_time time NOT NULL,
  miles_driven decimal(10,2) NULL,
  CONSTRAINT driver_id_seq PRIMARY KEY (driver_id)
);

CREATE SEQUENCE name_id_seq
  INCREMENT BY 1
  NO MAXVALUE
  NO MINVALUE
  CACHE 1;

CREATE TABLE driver_name (
  name_id integer DEFAULT nextval('name_id_seq'::regclass) NOT NULL,
  name varchar(80) NOT NULL,
  CONSTRAINT name_id_seq PRIMARY KEY (name_id) FOREIGN KEY (driver_id)
);

CREATE SEQUENCE results_id_seq
  INCREMENT BY 1
  NO MAXVALUE
  NO MINVALUE
  CACHE 1;

CREATE TABLE driving_tracker_results (
  results_id integer DEFAULT nextval('results_id_seq'::regclass) NOT NULL,
  driver_id integer NOT NULL,
  driver varchar(80) NOT NULL,
  total_miles decimal(10,2) NOT NULL,
  average_speed integer NOT NULL,
  CONSTRAINT results_id_seq PRIMARY KEY (results_id) FOREIGN KEY (driver_id)
);

-- Sample Driver Data

-- Dan
-- INSERT INTO driving_history_tracker (driver, start_time, stop_time, miles_drive, mph)
-- VALUES ('Dan', '07:15', '07:45', 17.3, ?);

-- Alex
-- INSERT INTO park (name, location, establish_date, area, visitors, description)
-- VALUES ('Alex', '06:12', '06:32', 21.8, ?);

-- Bob
-- INSERT INTO park (name, location, establish_date, area, visitors, description)
-- VALUES ('Bob', '13:01', '13:05', 42.0, ?);
