INSERT INTO books (title, author, genre, publishing_date, copies_sold)
VALUES ('Clean Code', 'Robert Cecil Martin', 'Computer & Technology', DATE '2008-08-01', 1000);
INSERT INTO books (title, author, genre, publishing_date, copies_sold)
VALUES ('Dune', 'Frank Herbert', 'Sci-Fi', DATE '2008-08-01', 25000);
INSERT INTO books (title, author, genre, publishing_date, copies_sold)
VALUES ('The Great Gatsby', 'F. Scott Fitzgerald', 'Tragedy', DATE '1925-04-25', 28000);
INSERT INTO books (title, author, genre, publishing_date, copies_sold)
VALUES ('20,000 Leagues Under the Sea', 'Jules Verne', 'Adventure', DATE '1869-03-11', 18550);
INSERT INTO books (title, author, genre, publishing_date, copies_sold)
VALUES ('Guns, Germs, and Steel', 'Jared Diamond', 'Nonfiction', DATE '1997-01-01', 13550);

INSERT INTO filters (id, name)
VALUES (100000000, 'My Filter 1');
INSERT INTO filters (id, name)
VALUES (200000000, 'My Filter 2');

INSERT INTO filter_criteria (filter_option, condition, search_value, filter_id)
VALUES ('TITLE', 'STARTS_WITH', 'The Great', 100000000);
INSERT INTO filter_criteria (filter_option, condition, search_value, filter_id)
VALUES ('AMOUNT', 'MORE', '20000', 200000000);
INSERT INTO filter_criteria (filter_option, condition, search_value, filter_id)
VALUES ('DATE', 'LESS', '1990-01-01', 200000000);


