insert into client (id, name, address_line1, address_line2, city, post_code, payment_terms) values (1, 'Bobs Marketing Agency', '23 Brighton Street', 'Rottingdean', 'Brighton', 'BN2 7DP', 28);
insert into invoice (id, status, issued_date, currency, gross, net, vat, client_id) values (1, 'DRAFT', null, 'GBP', 120.00, 100.00, 20.00, 1);
insert into invoice (id, status, issued_date, currency, gross, net, vat, client_id) values (2, 'ISSUED', '2019-07-28', 'GBP', 1200.00, 1000.00, 200.00, 1);

insert into client (id, name, address_line1, address_line2, city, post_code, payment_terms) values (2, 'Jills Accountancy Company', '24 Eastbourne Rd', null, 'Eastbourne', 'BN23 5GP', 28);
insert into invoice (id, status, issued_date, currency, gross, net, vat, client_id) values (3, 'DRAFT', null, 'GBP', 120.00, 100.00, 20.00, 2);
