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

-- ### BrokerStatus
insert into luleke_invest.broker_status (cd_status, ds_status)
values (1, 'Ativo');
insert into luleke_invest.broker_status (cd_status, ds_status)
values (2, 'Inativo');

-- ### FinancialAssetCategory
insert into luleke_invest.financial_asset_category (cd_financial_asset_category, ds_name)
values (1, 'Ações');
insert into luleke_invest.financial_asset_category (cd_financial_asset_category, ds_name)
values (2, 'FIIs');
insert into luleke_invest.financial_asset_category (cd_financial_asset_category, ds_name)
values (3, 'Tesouro Direto');
insert into luleke_invest.financial_asset_category (cd_financial_asset_category, ds_name)
values (4, 'Stocks');
insert into luleke_invest.financial_asset_category (cd_financial_asset_category, ds_name)
values (5, 'REITs');

-- ### FinancialTransactionType
insert into luleke_invest.financial_transaction_type (cd_financial_transaction_type, ds_name)
values (1, 'Buy');
insert into luleke_invest.financial_transaction_type (cd_financial_transaction_type, ds_name)
values (2, 'Sell');
insert into luleke_invest.financial_transaction_type (cd_financial_transaction_type, ds_name)
values (3, 'Split');
insert into luleke_invest.financial_transaction_type (cd_financial_transaction_type, ds_name)
values (4, 'Inplit');
insert into luleke_invest.financial_transaction_type (cd_financial_transaction_type, ds_name)
values (5, 'Bonus Share');

-- ### Country
insert into luleke_invest.adress_country (cd_country, ds_name)
values (1, 'Brazil');

