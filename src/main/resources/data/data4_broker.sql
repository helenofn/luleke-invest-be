-- ### Adress
insert into luleke_invest.adress (cseq_adress, cseq_city, ds_district, ds_adress, ds_number, ds_complement, cd_zip_code)
values (1, 1, 'Vila Olímpia', 'Av. Chedid Jafet', '75', null, '4551060');

-- ### Broker
insert into luleke_invest.broker (cd_status, ds_name, ds_ein, cseq_adress)
values (1, 'Rico - XP Investimentos CCTVM S.A.', '2332886001682', 1);