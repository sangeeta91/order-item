DROP TABLE IF EXISTS Order_Items;
 
CREATE TABLE Order_Items (
  order_id INT NOT NULL,
  product_code INT NOT NULL,
  product_name VARCHAR(250) NOT NULL,
  quantity INT NOT NULL,
  PRIMARY KEY(order_id,product_code)
   
);