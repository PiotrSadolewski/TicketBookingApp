INSERT INTO Movie (DESCRIPTION, DURATION, FILM_DIRECTOR, GENRE, TITLE) VALUES ('A romantic disaster film about the sinking of the RMS Titanic.', INTERVAL '11640' SECOND, 'James Cameron', 'Romance, Drama', 'Titanic');
INSERT INTO Movie (DESCRIPTION, DURATION, FILM_DIRECTOR, GENRE, TITLE) VALUES ('A psychological thriller film directed by Martin Scorsese.', INTERVAL '8280' SECOND, 'Martin Scorsese', 'Mystery, Thriller', 'Shutter Island');
INSERT INTO Movie (DESCRIPTION, DURATION, FILM_DIRECTOR, GENRE, TITLE) VALUES ('A science fiction action film directed by Christopher Nolan.', INTERVAL '8880' SECOND, 'Christopher Nolan', 'Action, Sci-Fi', 'Inception');

INSERT INTO Screening_Room (NUMBER, ROW_QUANTITY, SEATS_PER_ROW) VALUES (1, 5, 8);
INSERT INTO Screening_Room (NUMBER, ROW_QUANTITY, SEATS_PER_ROW) VALUES (2, 4, 6);
INSERT INTO Screening_Room (NUMBER, ROW_QUANTITY, SEATS_PER_ROW) VALUES (3, 5, 5);

INSERT INTO Screening (START_TIME, MOVIE_ID, SCREENING_ROOM_ID) VALUES ('2023-06-08 23:40:00', 2, 1);

INSERT INTO Seat (is_reserved, row_number, seat_number, screening_id) VALUES (FALSE, 1, 1, 1);
INSERT INTO Seat (is_reserved, row_number, seat_number, screening_id) VALUES (FALSE, 1, 2, 1);
INSERT INTO Seat (is_reserved, row_number, seat_number, screening_id) VALUES (FALSE, 1, 3, 1);
INSERT INTO Seat (is_reserved, row_number, seat_number, screening_id) VALUES (FALSE, 1, 4, 1);
INSERT INTO Seat (is_reserved, row_number, seat_number, screening_id) VALUES (FALSE, 1, 5, 1);
INSERT INTO Seat (is_reserved, row_number, seat_number, screening_id) VALUES (FALSE, 1, 6, 1);
INSERT INTO Seat (is_reserved, row_number, seat_number, screening_id) VALUES (FALSE, 1, 7, 1);
INSERT INTO Seat (is_reserved, row_number, seat_number, screening_id) VALUES (FALSE, 1, 8, 1);
INSERT INTO Seat (is_reserved, row_number, seat_number, screening_id) VALUES (FALSE, 2, 1, 1);
INSERT INTO Seat (is_reserved, row_number, seat_number, screening_id) VALUES (FALSE, 2, 2, 1);
INSERT INTO Seat (is_reserved, row_number, seat_number, screening_id) VALUES (FALSE, 2, 3, 1);
INSERT INTO Seat (is_reserved, row_number, seat_number, screening_id) VALUES (FALSE, 2, 4, 1);
INSERT INTO Seat (is_reserved, row_number, seat_number, screening_id) VALUES (FALSE, 2, 5, 1);
INSERT INTO Seat (is_reserved, row_number, seat_number, screening_id) VALUES (FALSE, 2, 6, 1);
INSERT INTO Seat (is_reserved, row_number, seat_number, screening_id) VALUES (FALSE, 2, 7, 1);
INSERT INTO Seat (is_reserved, row_number, seat_number, screening_id) VALUES (FALSE, 2, 8, 1);
INSERT INTO Seat (is_reserved, row_number, seat_number, screening_id) VALUES (FALSE, 3, 1, 1);
INSERT INTO Seat (is_reserved, row_number, seat_number, screening_id) VALUES (FALSE, 3, 2, 1);
INSERT INTO Seat (is_reserved, row_number, seat_number, screening_id) VALUES (FALSE, 3, 3, 1);
INSERT INTO Seat (is_reserved, row_number, seat_number, screening_id) VALUES (FALSE, 3, 4, 1);
INSERT INTO Seat (is_reserved, row_number, seat_number, screening_id) VALUES (FALSE, 3, 5, 1);
INSERT INTO Seat (is_reserved, row_number, seat_number, screening_id) VALUES (FALSE, 3, 6, 1);
INSERT INTO Seat (is_reserved, row_number, seat_number, screening_id) VALUES (FALSE, 3, 7, 1);
INSERT INTO Seat (is_reserved, row_number, seat_number, screening_id) VALUES (FALSE, 3, 8, 1);
INSERT INTO Seat (is_reserved, row_number, seat_number, screening_id) VALUES (FALSE, 4, 1, 1);
INSERT INTO Seat (is_reserved, row_number, seat_number, screening_id) VALUES (FALSE, 4, 2, 1);
INSERT INTO Seat (is_reserved, row_number, seat_number, screening_id) VALUES (FALSE, 4, 3, 1);
INSERT INTO Seat (is_reserved, row_number, seat_number, screening_id) VALUES (FALSE, 4, 4, 1);
INSERT INTO Seat (is_reserved, row_number, seat_number, screening_id) VALUES (FALSE, 4, 5, 1);
INSERT INTO Seat (is_reserved, row_number, seat_number, screening_id) VALUES (FALSE, 4, 6, 1);
INSERT INTO Seat (is_reserved, row_number, seat_number, screening_id) VALUES (FALSE, 4, 7, 1);
INSERT INTO Seat (is_reserved, row_number, seat_number, screening_id) VALUES (FALSE, 4, 8, 1);
INSERT INTO Seat (is_reserved, row_number, seat_number, screening_id) VALUES (FALSE, 5, 1, 1);
INSERT INTO Seat (is_reserved, row_number, seat_number, screening_id) VALUES (FALSE, 5, 2, 1);
INSERT INTO Seat (is_reserved, row_number, seat_number, screening_id) VALUES (FALSE, 5, 3, 1);
INSERT INTO Seat (is_reserved, row_number, seat_number, screening_id) VALUES (FALSE, 5, 4, 1);
INSERT INTO Seat (is_reserved, row_number, seat_number, screening_id) VALUES (FALSE, 5, 5, 1);
INSERT INTO Seat (is_reserved, row_number, seat_number, screening_id) VALUES (FALSE, 5, 6, 1);
INSERT INTO Seat (is_reserved, row_number, seat_number, screening_id) VALUES (FALSE, 5, 7, 1);
INSERT INTO Seat (is_reserved, row_number, seat_number, screening_id) VALUES (FALSE, 5, 8, 1);

INSERT INTO Screening (START_TIME, MOVIE_ID, SCREENING_ROOM_ID) VALUES ('2023-06-08 12:30:00', 3, 1);

INSERT INTO Seat (is_reserved, row_number, seat_number, screening_id) VALUES (FALSE, 1, 1, 2);
INSERT INTO Seat (is_reserved, row_number, seat_number, screening_id) VALUES (FALSE, 1, 2, 2);
INSERT INTO Seat (is_reserved, row_number, seat_number, screening_id) VALUES (FALSE, 1, 3, 2);
INSERT INTO Seat (is_reserved, row_number, seat_number, screening_id) VALUES (FALSE, 1, 4, 2);
INSERT INTO Seat (is_reserved, row_number, seat_number, screening_id) VALUES (FALSE, 1, 5, 2);
INSERT INTO Seat (is_reserved, row_number, seat_number, screening_id) VALUES (FALSE, 1, 6, 2);
INSERT INTO Seat (is_reserved, row_number, seat_number, screening_id) VALUES (FALSE, 1, 7, 2);
INSERT INTO Seat (is_reserved, row_number, seat_number, screening_id) VALUES (FALSE, 1, 8, 2);
INSERT INTO Seat (is_reserved, row_number, seat_number, screening_id) VALUES (FALSE, 2, 1, 2);
INSERT INTO Seat (is_reserved, row_number, seat_number, screening_id) VALUES (FALSE, 2, 2, 2);
INSERT INTO Seat (is_reserved, row_number, seat_number, screening_id) VALUES (FALSE, 2, 3, 2);
INSERT INTO Seat (is_reserved, row_number, seat_number, screening_id) VALUES (FALSE, 2, 4, 2);
INSERT INTO Seat (is_reserved, row_number, seat_number, screening_id) VALUES (FALSE, 2, 5, 2);
INSERT INTO Seat (is_reserved, row_number, seat_number, screening_id) VALUES (FALSE, 2, 6, 2);
INSERT INTO Seat (is_reserved, row_number, seat_number, screening_id) VALUES (FALSE, 2, 7, 2);
INSERT INTO Seat (is_reserved, row_number, seat_number, screening_id) VALUES (FALSE, 2, 8, 2);
INSERT INTO Seat (is_reserved, row_number, seat_number, screening_id) VALUES (FALSE, 3, 1, 2);
INSERT INTO Seat (is_reserved, row_number, seat_number, screening_id) VALUES (FALSE, 3, 2, 2);
INSERT INTO Seat (is_reserved, row_number, seat_number, screening_id) VALUES (FALSE, 3, 3, 2);
INSERT INTO Seat (is_reserved, row_number, seat_number, screening_id) VALUES (FALSE, 3, 4, 2);
INSERT INTO Seat (is_reserved, row_number, seat_number, screening_id) VALUES (FALSE, 3, 5, 2);
INSERT INTO Seat (is_reserved, row_number, seat_number, screening_id) VALUES (FALSE, 3, 6, 2);
INSERT INTO Seat (is_reserved, row_number, seat_number, screening_id) VALUES (FALSE, 3, 7, 2);
INSERT INTO Seat (is_reserved, row_number, seat_number, screening_id) VALUES (FALSE, 3, 8, 2);
INSERT INTO Seat (is_reserved, row_number, seat_number, screening_id) VALUES (FALSE, 4, 1, 2);
INSERT INTO Seat (is_reserved, row_number, seat_number, screening_id) VALUES (FALSE, 4, 2, 2);
INSERT INTO Seat (is_reserved, row_number, seat_number, screening_id) VALUES (FALSE, 4, 3, 2);
INSERT INTO Seat (is_reserved, row_number, seat_number, screening_id) VALUES (FALSE, 4, 4, 2);
INSERT INTO Seat (is_reserved, row_number, seat_number, screening_id) VALUES (FALSE, 4, 5, 2);
INSERT INTO Seat (is_reserved, row_number, seat_number, screening_id) VALUES (FALSE, 4, 6, 2);
INSERT INTO Seat (is_reserved, row_number, seat_number, screening_id) VALUES (FALSE, 4, 7, 2);
INSERT INTO Seat (is_reserved, row_number, seat_number, screening_id) VALUES (FALSE, 4, 8, 2);
INSERT INTO Seat (is_reserved, row_number, seat_number, screening_id) VALUES (FALSE, 5, 1, 2);
INSERT INTO Seat (is_reserved, row_number, seat_number, screening_id) VALUES (FALSE, 5, 2, 2);
INSERT INTO Seat (is_reserved, row_number, seat_number, screening_id) VALUES (FALSE, 5, 3, 2);
INSERT INTO Seat (is_reserved, row_number, seat_number, screening_id) VALUES (FALSE, 5, 4, 2);
INSERT INTO Seat (is_reserved, row_number, seat_number, screening_id) VALUES (FALSE, 5, 5, 2);
INSERT INTO Seat (is_reserved, row_number, seat_number, screening_id) VALUES (FALSE, 5, 6, 2);
INSERT INTO Seat (is_reserved, row_number, seat_number, screening_id) VALUES (FALSE, 5, 7, 2);
INSERT INTO Seat (is_reserved, row_number, seat_number, screening_id) VALUES (FALSE, 5, 8, 2);