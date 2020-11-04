DROP TABLE if exists js_student_child;
DROP TABLE if exists js_student_order;
DROP TABLE if exists js_passport_office;
DROP TABLE if exists js_register_office;
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
);

create table js_student_order(
    student_order_id SERIAL,
    h_sur_name varchar (100) not null,
    h_given_name varchar (100) not null,
    h_patronymic varchar (100) not null,
    h_date_of_birth date not null,
    h_passport_serial varchar (10) not null,
    h_passport_number varchar (10) not null,
    h_passport_date date not null,
    h_passport_office_id integer not null,
    h_post_index varchar (10) not null,
    h_street_code integer not null,
    h_building varchar (10) not null,
    h_extension varchar (10),
    h_apartment varchar (10),
    w_sur_name varchar (100) not null,
    w_given_name varchar (100) not null,
    w_patronymic varchar (100) not null,
    w_date_of_birth date not null,
    w_passport_serial varchar (10) not null,
    w_passport_number varchar (10) not null,
    w_passport_date date not null,
    w_passport_office_id integer not null,
    w_post_index varchar (10) not null,
    w_street_code integer not null,
    w_building varchar (10) not null,
    w_extension varchar (10),
    w_apartment varchar (10),
    certificate_id varchar (20) not null ,
    register_office_id integer not null,
    marriage_date date not null,
    primary key (student_order_id),
    foreign key (h_street_code) references js_street(street_code) on delete restrict,
    foreign key (w_street_code) references js_street(street_code) on delete restrict,
    foreign key (register_office_id) references js_register_office(r_office_id) on delete restrict
);

CREATE TABLE js_student_child(
    student_child_id SERIAL,
    student_order_id integer not null,
    c_sur_name varchar (100) not null,
    c_given_name varchar (100) not null,
    c_patronymic varchar (100) not null,
    c_date_of_birth date not null,
    c_certificate varchar (10) not null,
    c_certificate_date date not null,
    c_register_office_id integer not null,
    c_post_index varchar (10) not null,
    c_street_code integer not null,
    c_building varchar (10) not null,
    c_extension varchar (10),
    c_apartment varchar (10),
    primary key (student_child_id),
    foreign key (c_street_code) references js_street(street_code) on delete restrict,
    foreign key (c_register_office_id) references js_register_office(r_office_id) on delete restrict
)
