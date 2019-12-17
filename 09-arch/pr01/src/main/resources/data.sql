INSERT INTO admins (username, pasword) VALUES ('admin', 'admin');

INSERT INTO categories (parent_cat_id, cat_name, cat_desc) VALUES (NULL, 'Racunari', 'Razni racunari');
INSERT INTO categories (parent_cat_id, cat_name, cat_desc) VALUES (1, 'Laptop', 'Prenosni racunari');
INSERT INTO categories (parent_cat_id, cat_name, cat_desc) VALUES (1, 'Desktop', 'Prenosni ali teski racunari');
INSERT INTO categories (parent_cat_id, cat_name, cat_desc) VALUES (1, 'Server', 'Tesko prenosni racunari');

INSERT INTO suppliers (sup_name, sup_address) VALUES ('Zika trade', 'Bul. oslobodjenja 1');
INSERT INTO suppliers (sup_name, sup_address) VALUES ('Zika computers', 'Bul. oslobodjenja 2');
INSERT INTO suppliers (sup_name, sup_address) VALUES ('Zika soft', 'Bul. oslobodjenja 3');

INSERT INTO products (category_id, supplier_id, prod_name, vendor, description, price) VALUES (2, 1, 'ThinkPad T61', 'IBM', 'trt', 1000);
INSERT INTO products (category_id, supplier_id, prod_name, vendor, description, price) VALUES (2, 1, 'Compaq nx9010', 'HP', 'trt', 1000);
INSERT INTO products (category_id, supplier_id, prod_name, vendor, description, price) VALUES (2, 1, 'Tecra S5', 'Toshiba', 'trt', 1000);

INSERT INTO users (username, pasword, first_name, last_name, user_address, email, receive_news) VALUES ('mbranko', 'mbranko', 'Branko', 'Milosavljevic', 'Fruskogorska 11', 'mbranko@uns.ac.rs', FALSE);
INSERT INTO users (username, pasword, first_name, last_name, user_address, email, receive_news) VALUES ('minja', 'minja', 'Milan', 'Vidakovic', 'Fruskogorska 11', 'minja@uns.ac.rs', FALSE);
