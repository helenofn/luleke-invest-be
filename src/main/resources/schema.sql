CREATE SCHEMA IF NOT EXISTS LULEKE_INVEST;

drop table if exists luleke_invest.role_app_feature cascade;
drop table if exists luleke_invest.user_data cascade;
drop table if exists luleke_invest.user_data_role cascade;
drop table if exists luleke_invest.user_role cascade;
drop table if exists luleke_invest.user_status cascade;

create table IF NOT EXISTS luleke_invest.user_role (
 cd_role integer not null, 
 ds_name varchar(50) unique, 
 primary key (cd_role)
);

create table IF NOT EXISTS luleke_invest.app_feature (
 cd_feature integer not null, 
 ds_name varchar(22), 
 primary key (cd_feature)
);

create table IF NOT EXISTS luleke_invest.role_app_feature (
 cd_feature integer not null, 
 cd_role integer not null
);
alter table if exists luleke_invest.role_app_feature 
  add constraint fk_cd_feature01 foreign key (cd_feature) references luleke_invest.app_feature;
alter table if exists luleke_invest.role_app_feature 
 add constraint fk_cd_role01 foreign key (cd_role) references luleke_invest.user_role;

create table IF NOT EXISTS luleke_invest.user_status (
 cd_user_status integer not null, 
 ds_name varchar(50), 
 primary key (cd_user_status)
);

create table IF NOT EXISTS luleke_invest.user_data (
 cd_user_status integer, 
 cseq_user bigint generated by default as identity, 
 ds_cript_pass varchar(60), 
 ds_name varchar(100), 
 ds_email varchar(150) unique, 
 primary key (cseq_user)
);
alter table if exists luleke_invest.user_data 
 add constraint fk_cd_user_status01 foreign key (cd_user_status) references luleke_invest.user_status;

create table IF NOT EXISTS luleke_invest.user_data_role (
 cd_role integer not null, 
 cseq_user bigint not null
);
alter table if exists luleke_invest.user_data_role 
 add constraint fk_cd_role02 foreign key (cd_role) references luleke_invest.user_role;
alter table if exists luleke_invest.user_data_role
 add constraint fk_cseq_user01 foreign key (cseq_user) references luleke_invest.user_data;



