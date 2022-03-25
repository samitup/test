INSERT INTO product(id,name, standard_price) VALUES(100,'Laptop', 1400.00) ON CONFLICT DO NOTHING;
INSERT INTO product(id,name, standard_price) VALUES(200,'Office chair', 42.50) ON CONFLICT DO NOTHING;
INSERT INTO product(id,name, standard_price) VALUES(300,'White board', 99.99) ON CONFLICT DO NOTHING;
INSERT INTO product(id,name, standard_price) VALUES(400,'Desk', 60.00) ON CONFLICT DO NOTHING;
INSERT INTO customer(id,name, rebate_type) VALUES(300,'BestOfficeFurnitures Oy', 'LONGTERMCUSTOMER')ON CONFLICT DO NOTHING;
INSERT INTO customer(id,name, rebate_type) VALUES(400,'Tradesk Oy', 'NEWCUSTOMER')ON CONFLICT DO NOTHING;
INSERT INTO customer(id,name, rebate_type) VALUES(500,'Retailh Oy', 'FIXED_LAPTOP')ON CONFLICT DO NOTHING;
INSERT INTO customer(id,name, rebate_type) VALUES(600,'Salers Oy', 'NONE')ON CONFLICT DO NOTHING;