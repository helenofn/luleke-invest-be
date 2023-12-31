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

-- ### AdressCountry
insert into luleke_invest.adress_country (cd_country, ds_name)
values (1, 'Brazil');

-- ### AdressState
insert into luleke_invest.adress_state (cseq_state, ds_sigla, ds_name, cd_country)
values (1, 'SP', 'São Paulo', 1);
insert into luleke_invest.adress_state (cseq_state, ds_sigla, ds_name, cd_country)
values (2, 'CE', 'Ceará', 1);

-- ### AdressCity
insert into luleke_invest.adress_city (cseq_city, ds_name, cseq_state)
values (1, 'São Paulo', 1);
insert into luleke_invest.adress_city (cseq_city, ds_name, cseq_state)
values (2, 'Eusébio', 2);

-- ### Adress
insert into luleke_invest.adress (cseq_adress, cseq_city, ds_district, ds_adress, ds_number, ds_complement, cd_zip_code)
values (1, 1, 'Vila Olímpia', 'Av. Chedid Jafet', '75', null, '4551060');
insert into luleke_invest.adress (cseq_adress, cseq_city, ds_district, ds_adress, ds_number, ds_complement, cd_zip_code)
values (2, 1, 'Jardim Paulistano', 'Avenida Brigadeiro Faria Lima', '1663', 'Andar 2', '1452001');
insert into luleke_invest.adress (cseq_adress, cseq_city, ds_district, ds_adress, ds_number, ds_complement, cd_zip_code)
values (3, 2, 'Jabuti', 'BR 116 KM 18', null, null, '61760000');

-- ### BrokerStatus
insert into luleke_invest.broker_status (cd_status, ds_status)
values (1, 'Ativo');
insert into luleke_invest.broker_status (cd_status, ds_status)
values (2, 'Inativo');

-- ### Broker
insert into luleke_invest.broker (cd_status, ds_name, ds_ein, cseq_adress)
values (1, 'Rico - XP Investimentos CCTVM S.A.', '2332886001682', 1);

-- ### Company
insert into luleke_invest.company (cseq_company, ds_name, ds_ein, cseq_adress)
values (1, 'M.DIAS BRANCO S.A. IND COM DE ALIMENTOS', '7206816000115', 3);

-- ### StockExchange
insert into luleke_invest.stock_exchange (cseq_stock_exchange, ds_name, ds_ein, cseq_adress)
values (1, 'B3 S.A. - BRASIL, BOLSA, BALCAO', '9346601001369', 1);

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

-- ### FinancialAsset
insert into luleke_invest.financial_asset (cseq_financial_asset, cseq_stock_exchange, ds_ticker, cseq_company, cseq_financial_asset_category, dh_last_update)
values (1, 1, 'IPCA_2035', null, 3, current_timestamp);
insert into luleke_invest.financial_asset (cseq_financial_asset, cseq_stock_exchange, ds_ticker, cseq_company, cseq_financial_asset_category, dh_last_update)
values (2, 1, 'IPCA_2045', null, 3, current_timestamp);

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