CREATE TABLE admins (
  admin_id      INTEGER       NOT NULL AUTO_INCREMENT,
  username      VARCHAR(50)   NOT NULL,
  pasword       VARCHAR(50)   NOT NULL,
  PRIMARY KEY (admin_id)
);

CREATE TABLE users (
  user_id       INTEGER       NOT NULL AUTO_INCREMENT,
  username      VARCHAR(50)   NOT NULL,
  pasword       VARCHAR(50)   NOT NULL,
  first_name    VARCHAR(50)   NOT NULL,
  last_name     VARCHAR(50)   NOT NULL,
  user_address  VARCHAR(150)  NOT NULL,
  email         VARCHAR(50)   NOT NULL,
  receive_news  BOOL          NOT NULL,
  PRIMARY KEY (user_id)
);

CREATE TABLE categories (
  category_id   INTEGER       NOT NULL AUTO_INCREMENT,
  parent_cat_id INTEGER       NULL,
  cat_name      VARCHAR(50)   NOT NULL,
  cat_desc      VARCHAR(200)  NULL,
  PRIMARY KEY (category_id),
  FOREIGN KEY (parent_cat_id) REFERENCES categories (category_id) ON DELETE CASCADE
);

CREATE TABLE suppliers (
  supplier_id   INTEGER       NOT NULL AUTO_INCREMENT,
  sup_name      VARCHAR(100)  NOT NULL,
  sup_address   VARCHAR(200)  NOT NULL,
  PRIMARY KEY (supplier_id)
);

CREATE TABLE orders (
  order_id      INTEGER       NOT NULL AUTO_INCREMENT,
  user_id       INTEGER       NOT NULL,
  order_date    datetime      NOT NULL,
  PRIMARY KEY (order_id),
  FOREIGN KEY (user_id) REFERENCES users (user_id)
);

CREATE TABLE products (
  product_id    INTEGER       NOT NULL AUTO_INCREMENT,
  category_id   INTEGER       NOT NULL,
  supplier_id   INTEGER       NOT NULL,
  prod_name     VARCHAR(100)  NOT NULL,
  vendor        VARCHAR(100)  NOT NULL,
  description   VARCHAR(1000) NOT NULL,
  price         DECIMAL(9,2)  NOT NULL,
  PRIMARY KEY (product_id),
  FOREIGN KEY (category_id) REFERENCES categories (category_id) ON DELETE CASCADE,
  FOREIGN KEY (supplier_id) REFERENCES suppliers (supplier_id) ON DELETE CASCADE
);

CREATE TABLE product_images (
  image_id      INTEGER       NOT NULL AUTO_INCREMENT,
  product_id    INTEGER       NOT NULL,
  image_title   VARCHAR(50)   NULL,
  image_width   INTEGER       NOT NULL,
  image_height  INTEGER       NOT NULL,
  content_type  VARCHAR(50)   NOT NULL,
  image_data    BLOB          NULL,
  PRIMARY KEY (image_id),
  FOREIGN KEY (product_id) REFERENCES products (product_id) ON DELETE CASCADE
);

CREATE TABLE order_items (
  item_id       INTEGER       NOT NULL AUTO_INCREMENT,
  order_id      INTEGER       NOT NULL,
  product_id    INTEGER       NOT NULL,
  quantity      INTEGER       NOT NULL,
  PRIMARY KEY (item_id),
  FOREIGN KEY (order_id) REFERENCES orders (order_id) ON DELETE CASCADE,
  FOREIGN KEY (product_id) REFERENCES products (product_id) ON DELETE CASCADE
);