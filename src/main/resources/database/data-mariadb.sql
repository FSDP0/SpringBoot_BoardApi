-- Sample User Data
INSERT INTO users.user(user_id, user_name, user_password, user_tel, created_date) VALUES ("Tester 1", "John", "123456", "010-2341-1231", "2023-06-20 09:49:01");
INSERT INTO users.user(user_id, user_name, user_password, user_tel, created_date) VALUES ("Tester 2", "Merry", "123456", "010-1412-1531", "2023-06-20 09:49:02");
INSERT INTO users.user(user_id, user_name, user_password, user_tel, created_date) VALUES ("Tester 3", "Ray", "123456", "010-2857-1233", "2023-06-20 09:49:03");
INSERT INTO users.user(user_id, user_name, user_password, user_tel, created_date) VALUES ("Tester 4", "Thonny", "123456", "010-5422-2792", "2023-06-20 09:49:04");
INSERT INTO users.user(user_id, user_name, user_password, user_tel, created_date) VALUES ("Tester 5", "Christian", "123456", "010-2534-2563", "2023-06-20 09:49:05");
INSERT INTO users.user(user_id, user_name, user_password, user_tel, created_date) VALUES ("Tester 6", "Chris", "123456", "010-4523-4310", "2023-06-20 09:49:06");
INSERT INTO users.user(user_id, user_name, user_password, user_tel, created_date) VALUES ("Tester 7", "Sam", "123456", "010-7401-1239", "2023-06-20 09:49:07");
INSERT INTO users.user(user_id, user_name, user_password, user_tel, created_date) VALUES ("Tester 8", "Anthon", "123456", "010-5459-4100", "2023-06-20 09:49:08");
INSERT INTO users.user(user_id, user_name, user_password, user_tel, created_date) VALUES ("Tester 9", "Thomas", "123456", "010-5295-4329", "2023-06-20 09:49:09");
INSERT INTO users.user(user_id, user_name, user_password, user_tel, created_date) VALUES ("Tester 10", "Sopia", "123456", "010-3602-2340", "2023-06-20 09:49:10");

-- Sample User Zipcode
INSERT INTO users.address(user_id, user_address, address_zipcode) VALUES ("Tester 1", "150, Jamwon-ro, Seocho-gu, Seoul, Republic of Korea", "06518");
INSERT INTO users.address(user_id, user_address, address_zipcode) VALUES ("Tester 2", "20, Jamwon-ro 8-gil, Seocho-gu, Seoul, Republic of Korea", "06519");
INSERT INTO users.address(user_id, user_address, address_zipcode) VALUES ("Tester 3", "310-6, Banpo-daero, Seocho-gu, Seoul, Republic of Korea", "06509");
INSERT INTO users.address(user_id, user_address, address_zipcode) VALUES ("Tester 4", "23, Seorae-ro, Seocho-gu, Seoul, Republic of Korea", "06576");
INSERT INTO users.address(user_id, user_address, address_zipcode) VALUES ("Tester 5", "212, Seoun-ro, Seocho-gu, Seoul, Republic of Korea", "06610");
INSERT INTO users.address(user_id, user_address, address_zipcode) VALUES ("Tester 6", "29, Bangbae-ro 33-gil, Seocho-gu, Seoul, Republic of Korea", "06562");
INSERT INTO users.address(user_id, user_address, address_zipcode) VALUES ("Tester 7", "10, Seocho-daero 71-gil, Seocho-gu, Seoul, Republic of Korea", "06616");
INSERT INTO users.address(user_id, user_address, address_zipcode) VALUES ("Tester 8", "103-13, Bangbae-ro 32-gil, Seocho-gu, Seoul, Republic of Korea", "06587");
INSERT INTO users.address(user_id, user_address, address_zipcode) VALUES ("Tester 9", "104, Seoun-ro, Seocho-gu, Seoul, Republic of Korea", "06625");
INSERT INTO users.address(user_id, user_address, address_zipcode) VALUES ("Tester 10", "220, Seochojungang-ro, Seocho-gu, Seoul, Republic of Korea", "06599");

-- Sample Board Data
INSERT INTO boards.board(board_title, user_id, board_content, created_date) VALUES ("Test Title 1.0", "Tester 1", "Test Content 1", "2023-06-20 09:47:01");
INSERT INTO boards.board(board_title, user_id, board_content, created_date) VALUES ("Test Title 1.1", "Tester 1", "Test Content 1", "2023-06-20 09:47:01");
INSERT INTO boards.board(board_title, user_id, board_content, created_date) VALUES ("Test Title 1.2", "Tester 1", "Test Content 1", "2023-06-20 09:47:01");
INSERT INTO boards.board(board_title, user_id, board_content, created_date) VALUES ("Test Title 1.3", "Tester 1", "Test Content 1", "2023-06-20 09:47:01");
INSERT INTO boards.board(board_title, user_id, board_content, created_date) VALUES ("Test Title 1.4", "Tester 1", "Test Content 1", "2023-06-20 09:47:01");
INSERT INTO boards.board(board_title, user_id, board_content, created_date) VALUES ("Test Title 2.0", "Tester 2", "Test Content 2", "2023-06-20 09:47:02");
INSERT INTO boards.board(board_title, user_id, board_content, created_date) VALUES ("Test Title 2.1", "Tester 2", "Test Content 2", "2023-06-20 09:47:02");
INSERT INTO boards.board(board_title, user_id, board_content, created_date) VALUES ("Test Title 2.2", "Tester 2", "Test Content 2", "2023-06-20 09:47:02");
INSERT INTO boards.board(board_title, user_id, board_content, created_date) VALUES ("Test Title 2.3", "Tester 2", "Test Content 2", "2023-06-20 09:47:02");
INSERT INTO boards.board(board_title, user_id, board_content, created_date) VALUES ("Test Title 2.4", "Tester 2", "Test Content 2", "2023-06-20 09:47:02");
INSERT INTO boards.board(board_title, user_id, board_content, created_date) VALUES ("Test Title 3.0", "Tester 3", "Test Content 3", "2023-06-20 09:47:03");
INSERT INTO boards.board(board_title, user_id, board_content, created_date) VALUES ("Test Title 3.1", "Tester 3", "Test Content 3", "2023-06-20 09:47:03");
INSERT INTO boards.board(board_title, user_id, board_content, created_date) VALUES ("Test Title 3.2", "Tester 3", "Test Content 3", "2023-06-20 09:47:03");
INSERT INTO boards.board(board_title, user_id, board_content, created_date) VALUES ("Test Title 3.3", "Tester 3", "Test Content 3", "2023-06-20 09:47:03");
INSERT INTO boards.board(board_title, user_id, board_content, created_date) VALUES ("Test Title 3.4", "Tester 3", "Test Content 3", "2023-06-20 09:47:03");
INSERT INTO boards.board(board_title, user_id, board_content, created_date) VALUES ("Test Title 4.0", "Tester 4", "Test Content 4", "2023-06-20 09:47:04");
INSERT INTO boards.board(board_title, user_id, board_content, created_date) VALUES ("Test Title 4.1", "Tester 4", "Test Content 4", "2023-06-20 09:47:04");
INSERT INTO boards.board(board_title, user_id, board_content, created_date) VALUES ("Test Title 4.2", "Tester 4", "Test Content 4", "2023-06-20 09:47:04");
INSERT INTO boards.board(board_title, user_id, board_content, created_date) VALUES ("Test Title 4.3", "Tester 4", "Test Content 4", "2023-06-20 09:47:04");
INSERT INTO boards.board(board_title, user_id, board_content, created_date) VALUES ("Test Title 4.4", "Tester 4", "Test Content 4", "2023-06-20 09:47:04");
INSERT INTO boards.board(board_title, user_id, board_content, created_date) VALUES ("Test Title 5.0", "Tester 5", "Test Content 5", "2023-06-20 09:47:05");
INSERT INTO boards.board(board_title, user_id, board_content, created_date) VALUES ("Test Title 5.1", "Tester 5", "Test Content 5", "2023-06-20 09:47:05");
INSERT INTO boards.board(board_title, user_id, board_content, created_date) VALUES ("Test Title 5.2", "Tester 5", "Test Content 5", "2023-06-20 09:47:05");
INSERT INTO boards.board(board_title, user_id, board_content, created_date) VALUES ("Test Title 5.3", "Tester 5", "Test Content 5", "2023-06-20 09:47:05");
INSERT INTO boards.board(board_title, user_id, board_content, created_date) VALUES ("Test Title 5.4", "Tester 5", "Test Content 5", "2023-06-20 09:47:05");
INSERT INTO boards.board(board_title, user_id, board_content, created_date) VALUES ("Test Title 6.0", "Tester 6", "Test Content 6", "2023-06-20 09:47:06");
INSERT INTO boards.board(board_title, user_id, board_content, created_date) VALUES ("Test Title 6.1", "Tester 6", "Test Content 6", "2023-06-20 09:47:06");
INSERT INTO boards.board(board_title, user_id, board_content, created_date) VALUES ("Test Title 6.2", "Tester 6", "Test Content 6", "2023-06-20 09:47:06");
INSERT INTO boards.board(board_title, user_id, board_content, created_date) VALUES ("Test Title 6.3", "Tester 6", "Test Content 6", "2023-06-20 09:47:06");
INSERT INTO boards.board(board_title, user_id, board_content, created_date) VALUES ("Test Title 6.4", "Tester 6", "Test Content 6", "2023-06-20 09:47:06");
INSERT INTO boards.board(board_title, user_id, board_content, created_date) VALUES ("Test Title 7.0", "Tester 7", "Test Content 7", "2023-06-20 09:47:07");
INSERT INTO boards.board(board_title, user_id, board_content, created_date) VALUES ("Test Title 7.1", "Tester 7", "Test Content 7", "2023-06-20 09:47:07");
INSERT INTO boards.board(board_title, user_id, board_content, created_date) VALUES ("Test Title 7.2", "Tester 7", "Test Content 7", "2023-06-20 09:47:07");
INSERT INTO boards.board(board_title, user_id, board_content, created_date) VALUES ("Test Title 7.3", "Tester 7", "Test Content 7", "2023-06-20 09:47:07");
INSERT INTO boards.board(board_title, user_id, board_content, created_date) VALUES ("Test Title 7.4", "Tester 7", "Test Content 7", "2023-06-20 09:47:07");
INSERT INTO boards.board(board_title, user_id, board_content, created_date) VALUES ("Test Title 8.0", "Tester 8", "Test Content 8", "2023-06-20 09:47:08");
INSERT INTO boards.board(board_title, user_id, board_content, created_date) VALUES ("Test Title 8.1", "Tester 8", "Test Content 8", "2023-06-20 09:47:08");
INSERT INTO boards.board(board_title, user_id, board_content, created_date) VALUES ("Test Title 8.2", "Tester 8", "Test Content 8", "2023-06-20 09:47:08");
INSERT INTO boards.board(board_title, user_id, board_content, created_date) VALUES ("Test Title 8.3", "Tester 8", "Test Content 8", "2023-06-20 09:47:08");
INSERT INTO boards.board(board_title, user_id, board_content, created_date) VALUES ("Test Title 8.4", "Tester 8", "Test Content 8", "2023-06-20 09:47:08");
INSERT INTO boards.board(board_title, user_id, board_content, created_date) VALUES ("Test Title 9.0", "Tester 9", "Test Content 9", "2023-06-20 09:47:09");
INSERT INTO boards.board(board_title, user_id, board_content, created_date) VALUES ("Test Title 9.1", "Tester 9", "Test Content 9", "2023-06-20 09:47:09");
INSERT INTO boards.board(board_title, user_id, board_content, created_date) VALUES ("Test Title 9.2", "Tester 9", "Test Content 9", "2023-06-20 09:47:09");
INSERT INTO boards.board(board_title, user_id, board_content, created_date) VALUES ("Test Title 9.3", "Tester 9", "Test Content 9", "2023-06-20 09:47:09");
INSERT INTO boards.board(board_title, user_id, board_content, created_date) VALUES ("Test Title 9.4", "Tester 9", "Test Content 9", "2023-06-20 09:47:09");
INSERT INTO boards.board(board_title, user_id, board_content, created_date) VALUES ("Test Title 10.0", "Tester 10", "Test Content 10", "2023-06-20 09:47:10");
INSERT INTO boards.board(board_title, user_id, board_content, created_date) VALUES ("Test Title 10.1", "Tester 10", "Test Content 10", "2023-06-20 09:47:10");
INSERT INTO boards.board(board_title, user_id, board_content, created_date) VALUES ("Test Title 10.2", "Tester 10", "Test Content 10", "2023-06-20 09:47:10");
INSERT INTO boards.board(board_title, user_id, board_content, created_date) VALUES ("Test Title 10.3", "Tester 10", "Test Content 10", "2023-06-20 09:47:10");
INSERT INTO boards.board(board_title, user_id, board_content, created_date) VALUES ("Test Title 10.4", "Tester 10", "Test Content 10", "2023-06-20 09:47:10");

