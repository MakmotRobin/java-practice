-- The filtering exercises from the `where` repository, normalised so every
-- query targets the schema in schema.sql. The original file mixed
-- MEALS/INGREDIENTS and lactose_free/CONTAINS_LACTOSE spellings.

-- 1. Cheap meals
SELECT * FROM meals WHERE price < 15;

-- 2. Vegetarian ingredients
SELECT * FROM ingredients WHERE vegetarian = TRUE;

-- 3. Energy-dense meals
SELECT * FROM meals WHERE calories > 500;

-- 4. Meals in the 15-16 price band
SELECT * FROM meals WHERE price BETWEEN 15 AND 16;

-- 5. Lactose-free and gluten-free ingredients
SELECT * FROM ingredients WHERE contains_lactose = FALSE AND gluten_free = TRUE;

-- 6. Cheap or high-calorie meals
SELECT * FROM meals WHERE price < 15 OR calories > 600;

-- 7. Vegan or gluten-free ingredients
SELECT * FROM ingredients WHERE vegan = TRUE OR gluten_free = TRUE;

-- 8. An exact meal by name
SELECT * FROM meals WHERE name = 'Pesto Pasta';

-- 9. Ingredients without lactose
SELECT * FROM ingredients WHERE contains_lactose = FALSE;

-- 10. Expensive but light meals
SELECT * FROM meals WHERE price > 20 AND calories < 800;
