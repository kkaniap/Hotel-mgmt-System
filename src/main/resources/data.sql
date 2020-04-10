--Hotel example data
INSERT INTO hotel(hotel_id,hotel_address,hotel_city,hotel_code,hotel_country,hotel_email,hotel_name,hotel_phone_nr,hotel_post_code,hotel_stars) values (1,'Malinowa 22','Tychy','HT01','Poland','hotelTychy@gmail.com','Hotel SPA Tychy','+48677892228','43-100',2)
INSERT INTO hotel(hotel_id,hotel_address,hotel_city,hotel_code,hotel_country,hotel_email,hotel_name,hotel_phone_nr,hotel_post_code,hotel_stars) values (2,'Poziomkowa 2','Kraków','HK01','Poland','krakowSPAHotel@gmail.com','Hotel SPA Kraków','++48532201148','45-550',2)
INSERT INTO hotel(hotel_id,hotel_address,hotel_city,hotel_code,hotel_country,hotel_email,hotel_name,hotel_phone_nr,hotel_post_code,hotel_stars) values (3,'Poziomkowa 10','Kraków','HK02','Poland','krakowExcHotel@gmail.com','Hotel Exclusive Kraków','+48532201125','45-550',5)

--Room type example data
INSERT INTO room_type(room_type_id,description,room_rate,type_name) VALUES (1,'Cheap room',2,'Comfort')
INSERT INTO room_type(room_type_id,description,room_rate,type_name) VALUES (2,'Expensive room',4,'Business')
INSERT INTO room_type(room_type_id,description,room_rate,type_name) VALUES (3,'Very expensive room',5,'Lord')

--Room example data
INSERT INTO room(room_floor,price,room_number,hotel_id,room_type_id) VALUES (10,80.99,101,1,1)
INSERT INTO room(room_floor,price,room_number,hotel_id,room_type_id) VALUES (10,80.99,102,1,1)
INSERT INTO room(room_floor,price,room_number,hotel_id,room_type_id) VALUES (8,150.99,97,1,2)
INSERT INTO room(room_floor,price,room_number,hotel_id,room_type_id) VALUES (12,220.99,151,1,3)
INSERT INTO room(room_floor,price,room_number,hotel_id,room_type_id) VALUES (10,80.99,101,2,1)
INSERT INTO room(room_floor,price,room_number,hotel_id,room_type_id) VALUES (10,80.99,102,2,1)
INSERT INTO room(room_floor,price,room_number,hotel_id,room_type_id) VALUES (8,150.99,97,2,2)
INSERT INTO room(room_floor,price,room_number,hotel_id,room_type_id) VALUES (12,220.99,151,2,3)
INSERT INTO room(room_floor,price,room_number,hotel_id,room_type_id) VALUES (10,80.99,101,3,1)
INSERT INTO room(room_floor,price,room_number,hotel_id,room_type_id) VALUES (10,80.99,102,3,1)
INSERT INTO room(room_floor,price,room_number,hotel_id,room_type_id) VALUES (8,150.99,97,3,2)
INSERT INTO room(room_floor,price,room_number,hotel_id,room_type_id) VALUES (12,220.99,151,3,3)

--Guest example data
INSERT INTO guest(guest_id,additional_info,address,birth_date,city,country,email,first_name,id_number,is_men,last_name,phone_nr,post_code) values (1,'','Baziowa 22/2','1996-03-02','Tychy','Poland','xkaniax@gmail.com','Karol','ABC-231112',1,'Kania','+48856985478','43-100')
INSERT INTO guest(guest_id,additional_info,address,birth_date,city,country,email,first_name,id_number,is_men,last_name,phone_nr,post_code) values (2,'','Malinowa 110','1985-05-12','Katowice','Poland','Karnow@gmail.com','Karol','ABC-523145',1,'Nowak','+48523220120','45-500')
INSERT INTO guest(guest_id,additional_info,address,birth_date,city,country,email,first_name,id_number,is_men,last_name,phone_nr,post_code) values (3,'','Kwadratowa 20','2000-10-22','Wrocław','Poland','karolina.kowalska@gmail.com','Karolina','ABC-552147',0,'Kowalska','+48523214789','22-589')

--Meal type example data
INSERT INTO meal_type(meal_type_id,description,meal_type) VALUES (1,'Only breakfast','Basic')
INSERT INTO meal_type(meal_type_id,description,meal_type) VALUES (2,'Breakfast, lunch and diner included','Full')

--Employee example data
INSERT INTO employee(employee_id,address,birth_date,city,country,email,first_name,hire_date,is_men,last_name,phone_nr,post_code,role,hotel_id,reports_to) VALUES (1,'Maja 10','1999-09-11','Tychy','Poland','dawidkocur@gmail.com','Dawid','2015-10-10',1,'Kocur','+48556552547','43-100','Szef',1,1)
INSERT INTO employee(employee_id,address,birth_date,city,country,email,first_name,hire_date,is_men,last_name,phone_nr,post_code,role,hotel_id,reports_to) VALUES (2,'Wyzwolenia 112','2002-09-25','Tychy','Poland','marlenanowak@gmail.com','Marlena','2019-10-01',0,'Nowak','+48523852147','43-100','Recepcjonista',1,1)
INSERT INTO employee(employee_id,address,birth_date,city,country,email,first_name,hire_date,is_men,last_name,phone_nr,post_code,role,hotel_id,reports_to) VALUES (3,'Kamienna 2','1985-10-02','Kraków','Poland','wiolettabaran@gmail.com','Wioletta','2000-01-15',0,'Baran','+48789512546','45-550','Szef',2,3)
INSERT INTO employee(employee_id,address,birth_date,city,country,email,first_name,hire_date,is_men,last_name,phone_nr,post_code,role,hotel_id,reports_to) VALUES (4,'Marcowa 2','1978-02-15','Kraków','Poland','marcinkowalski@gmail.com','Marcon','2000-01-15',1,'Kowalski','+48565898523','45-550','Recepcjonista',2,3)
INSERT INTO employee(employee_id,address,birth_date,city,country,email,first_name,hire_date,is_men,last_name,phone_nr,post_code,role,hotel_id,reports_to) VALUES (5,'Wieczna 22/3','1985-04-10','Kraków','Poland','marcinnowak@gmail.com','Marcin','2004-01-15',1,'Nowak','+48753698521','45-550','Szef',3,5)
INSERT INTO employee(employee_id,address,birth_date,city,country,email,first_name,hire_date,is_men,last_name,phone_nr,post_code,role,hotel_id,reports_to) VALUES (6,'Marcowa 15','1975-01-10','Kraków','Poland','marzenabak@gmail.com','Marzena','2004-01-15',0,'Bąk','+48125478951','45-550','Recepcjonista',3,5)

--Reservation example data
INSERT INTO reservation(reservation_id,adults,children,date_from,date_to,reservation_date,employee_id,guest_id,meal_type_id) VALUES (1,2,0,'2020-04-08','2020-04-16','2020-03-02',2,1,1)
INSERT INTO reservation(reservation_id,adults,children,date_from,date_to,reservation_date,employee_id,guest_id,meal_type_id) VALUES (2,2,2,'2020-05-01','2020-05-05','2020-03-10',4,2,2)
INSERT INTO reservation(reservation_id,adults,children,date_from,date_to,reservation_date,employee_id,guest_id,meal_type_id) VALUES (3,2,0,'2020-04-09','2020-04-16','2020-03-02',6,3,2)

--Rooms_reservations example data
INSERT INTO rooms_reservations(reservation_id,room_id) VALUES (1,4)
INSERT INTO rooms_reservations(reservation_id,room_id) VALUES (2,10)
INSERT INTO rooms_reservations(reservation_id,room_id) VALUES (3,1)