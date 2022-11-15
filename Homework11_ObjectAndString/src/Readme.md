### 11. Object and String

Создать класс **Human** у которого будут поля:

* private String name;
* private String lastName;
* private String patronymic;
* private String city;
* private String street;
* private String house;
* private String flat;
* private String numberPassport;

Переопределить три метода: **toString()**, **hashCode()**, **equals**

Метод **toString** должен выводить информацию таким образом (пример):

Пупкин Вася Варфаламеевич \
Паспорт:\
Серия: 98 22 Номер: 897643\
Город Джава, ул. Программистов, дом 15, квартира 54

Метод **equals()** должен сравнивать людей по номеру паспорта
