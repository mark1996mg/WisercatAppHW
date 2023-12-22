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


