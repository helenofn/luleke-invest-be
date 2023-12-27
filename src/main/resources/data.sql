-- ### Roles
insert into luleke_invest.user_role (cd_role, ds_name)
values (1, 'PUBLIC');
insert into luleke_invest.user_role (cd_role, ds_name)
values (2, 'COMMON');
insert into luleke_invest.user_role (cd_role, ds_name)
values (3, 'REGISTER');
insert into luleke_invest.user_role (cd_role, ds_name)
values (4, 'ANALYST');

-- ### Features
insert into luleke_invest.app_feature (cd_feature, ds_name)
values (1, 'SIGNUP');

-- ### Role X Feature relationship
insert into luleke_invest.role_app_feature (cd_feature, cd_role)
values (1, 1);

-- ### UserStatus
insert into luleke_invest.user_status (cd_user_status, ds_name)
values (1, 'ATIVO');
insert into luleke_invest.user_status (cd_user_status, ds_name)
values (2, 'AGUARDANDO_CONFIRMACAO_MAIL');
insert into luleke_invest.user_status (cd_user_status, ds_name)
values (3, 'INATIVO');