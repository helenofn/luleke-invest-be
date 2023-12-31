-- ### Adress
insert into luleke_invest.adress (cseq_adress, cseq_city, ds_district, ds_adress, ds_number, ds_complement, cd_zip_code)
values (3, 2, 'Jabuti', 'BR 116 KM 18', null, null, '61760000');

-- ### Company
insert into luleke_invest.company (cseq_company, ds_name, ds_ein, cseq_adress)
values (1, 'M.DIAS BRANCO S.A. IND COM DE ALIMENTOS', '7206816000115', 3);