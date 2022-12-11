-- tag::originalDDL[]
create table Book (
  id bigint not null,
  title varchar(255),
  price float,
  description varchar(255),
  isbn varchar(255),
  nbOfPages integer,
  primary key (id));
-- end::originalDDL[]
-- tag::beanValidationDDL[]
create table Book (
  id bigint not null,
  title varchar(255) not null,
  price float,
  description varchar(2000),
  isbn varchar(13),
  nbOfPages integer,
  primary key (id));
-- end::beanValidationDDL[]
create sequence hibernate_sequence start with 1 increment by 1
create table Book (id bigint not null, description varchar(2000), isbn varchar(13), nbOfPages integer, price float, title varchar(255) not null, primary key (id))
create sequence hibernate_sequence start with 1 increment by 1
create table Book (id bigint not null, description varchar(2000), isbn varchar(13), nbOfPages integer, price float, title varchar(255) not null, primary key (id))
create sequence hibernate_sequence start with 1 increment by 1
create table Book (id bigint not null, description varchar(2000), isbn varchar(13), nbOfPages integer, price float, title varchar(255) not null, primary key (id))
create sequence hibernate_sequence start with 1 increment by 1
create table Book (id bigint not null, description varchar(2000), isbn varchar(13), nbOfPages integer, price float, title varchar(255) not null, primary key (id))
create sequence hibernate_sequence start with 1 increment by 1
create table Book (id bigint not null, description varchar(2000), isbn varchar(13), nbOfPages integer, price float, title varchar(255) not null, primary key (id))
create sequence hibernate_sequence start with 1 increment by 1
create table Book (id bigint not null, description varchar(2000), isbn varchar(13), nbOfPages integer, price float, title varchar(255) not null, primary key (id))
create sequence hibernate_sequence start with 1 increment by 1
create table Book (id bigint not null, description varchar(2000), isbn varchar(13), nbOfPages integer, price float, title varchar(255) not null, primary key (id))
create sequence hibernate_sequence start with 1 increment by 1
create table Book (id bigint not null, description varchar(2000), isbn varchar(13), nbOfPages integer, price float, title varchar(255) not null, primary key (id))
create sequence hibernate_sequence start with 1 increment by 1
create table Book (id bigint not null, description varchar(255), isbn varchar(255), nbOfPages integer, price float, title varchar(255), primary key (id))
create sequence hibernate_sequence start with 1 increment by 1
create table Book (id bigint not null, description varchar(255), isbn varchar(255), nbOfPages integer, price float, title varchar(255), primary key (id))
create sequence Book_SEQ start with 1 increment by 50;
create table Book (id bigint not null, description varchar(2000), isbn varchar(13), nbOfPages integer, title varchar(255) not null, primary key (id));
create sequence Book_SEQ start with 1 increment by 50;
create table Book (id bigint not null, description varchar(2000), isbn varchar(13), nbOfPages integer, columnName decimal(18,3), title varchar(255) not null, primary key (id));
create sequence Book_SEQ start with 1 increment by 50;
create table Book (id bigint not null, description varchar(2000), isbn varchar(13), nbOfPages integer, price decimal(18,3), title varchar(255) not null, primary key (id));
create sequence Book_SEQ start with 1 increment by 50;
create table Book (id bigint not null, description varchar(2000), isbn varchar(13), nbOfPages integer, price decimal(18,3), title varchar(255) not null, primary key (id));
create sequence Book_SEQ start with 1 increment by 50;
create table Book (id bigint not null, description varchar(2000), isbn varchar(13), nbOfPages integer, price decimal(18,3), title varchar(255) not null, primary key (id));
create sequence Book_SEQ start with 1 increment by 50;
create table Book (id bigint not null, description varchar(2000), isbn varchar(13), nbOfPages integer, price decimal(18,3), title varchar(255) not null, primary key (id));
create sequence Book_SEQ start with 1 increment by 50;
create table Book (id bigint not null, description varchar(2000), isbn varchar(13), nbOfPages integer, price decimal(18,3), title varchar(255) not null, primary key (id));
create sequence Book_SEQ start with 1 increment by 50;
create table Book (id bigint not null, description varchar(2000), isbn varchar(13), nbOfPages integer, price decimal(18,3), title varchar(255) not null, primary key (id));
create sequence Book_SEQ start with 1 increment by 50;
create table Book (id bigint not null, description varchar(2000), isbn varchar(13), nbOfPages integer, price decimal(18,3), title varchar(255) not null, primary key (id));
create sequence Book_SEQ start with 1 increment by 50;
create table Book (id bigint not null, description varchar(2000), isbn varchar(13), nbOfPages integer, price decimal(18,3), title varchar(255) not null, primary key (id));
create sequence Book_SEQ start with 1 increment by 50;
create table Book (id bigint not null, description varchar(2000), isbn varchar(13), nbOfPages integer, price decimal(18,3), title varchar(255) not null, primary key (id));
create sequence Book_SEQ start with 1 increment by 50;
create table Book (id bigint not null, description varchar(2000), isbn varchar(13), nbOfPages integer, price decimal(18,3), title varchar(255) not null, primary key (id));
