-- Sample data used by queries.sql and by SqlScriptTest.

INSERT INTO ingredients (id, name, contains_lactose, vegetarian, vegan, gluten_free) VALUES
    (1, 'Eggs',       FALSE, TRUE,  FALSE, TRUE),
    (2, 'Bread',      FALSE, TRUE,  TRUE,  FALSE),
    (3, 'Beef Patty', FALSE, FALSE, FALSE, TRUE),
    (4, 'Lettuce',    FALSE, TRUE,  TRUE,  TRUE),
    (5, 'Yoghurt',    TRUE,  TRUE,  FALSE, TRUE);

INSERT INTO meals (id, name, price, calories) VALUES
    (1, 'Pesto Pasta',      12.50, 650),
    (2, 'Margherita Pizza',  9.90, 800),
    (3, 'Grilled Salmon',   22.00, 520),
    (4, 'Beef Burger',      15.50, 900),
    (5, 'Caesar Salad',     15.00, 380),
    (6, 'Veggie Bowl',      13.20, 450);
