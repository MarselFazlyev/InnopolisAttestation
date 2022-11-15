## Attestation №2

Создать **schema.sql** файл, который содержит описание таблиц и данных для этих таблиц

Товар
- id
- описание
- стоимость
- количество

Заказчик
- id
- имя/фамилия

Заказ
- id-товара (внешний ключ)
- id-заказчика (внешний ключ)
- дата заказа
- количество товаров

Написать 3-4 запроса на заполнения каждой из этих таблиц.

Пример:

```SQL
CREATE TABLE some_table 
(
	id SERIAL PRIMARY KEY,
	name VARCHAR(255),
	description VARCHAR(255),
);

INSERT INTO some_table(name, description) VALUES("Something1", "Something description1");
INSERT INTO some_table(name, description) VALUES("Something2", "Something description2");
INSERT INTO some_table(name, description) VALUES("Something3", "Something description3");
INSERT INTO some_table(name, description) VALUES("Something4", "Something description4");

#И так для всех таблиц
```

Товар / Заказчик / Заказ - это предложение. Разрешается использовать тему своего итогового проекта (т.е. написать данную схему, которую Вы будете использовать в своем итоговом проекте)
