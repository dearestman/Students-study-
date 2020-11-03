DROP TABLE if exists js_passport_office;
DROP TABLE if exists js_pregister_office;
DROP TABLE if exists js_country_struct;
DROP TABLE if exists js_street;

create table js_street(
	street_code integer not null,
	street_name varchar (300),
	PRIMARY KEY (street_code)
);

create table js_country_struct(
	area_id char(12) not null,
	area_name varchar(200),
	PRIMARY KEY (area_id)
);

create table js_passport_office(
	p_office_id integer not null,
	P_office_area_id char(12),
	p_office_name varchar(200),
	PRIMARY KEY (p_office_id),
	FOREIGN KEY (p_office_area_id) references js_country_struct(area_id) on delete restrict
);

create table js_register_office(
	r_office_id integer not null,
	r_office_area_id char(12),
	r_office_name varchar(200),
	PRIMARY KEY (r_office_id),
	FOREIGN KEY (r_office_area_id) references js_country_struct(area_id) on delete restrict
)

