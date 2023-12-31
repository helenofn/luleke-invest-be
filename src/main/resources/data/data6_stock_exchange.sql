-- ### Adress
insert into luleke_invest.adress (cseq_adress, cseq_city, ds_district, ds_adress, ds_number, ds_complement, cd_zip_code)
values (2, 1, 'Jardim Paulistano', 'Avenida Brigadeiro Faria Lima', '1663', 'Andar 2', '1452001');

-- ### StockExchange
insert into luleke_invest.stock_exchange (cseq_stock_exchange, ds_name, ds_ein, cseq_adress)
values (1, 'B3 S.A. - BRASIL, BOLSA, BALCAO', '9346601001369', 2);