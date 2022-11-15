### 13. JDBC

Создать приложение "База данных населения города Телемилитряндии".

Нужны классы:

**Human** - c полями (такие же поля должны быть в таблице бд human):

* private int id;
* private String name;
* private String lastName;
* private String patronymic;
* private String city;
* private String street;
* private String house;
* private String flat;
* private String numberPassport;

Интерфейс **CrudHuman** - c методами:

* List<Human> getAllHumans(); //Возвращает список всех людей из базы данных
* Human getHumanById(int id); //Возвращает конкретного человека, у которого определенный id
* void createHuman(Human human); //Создает человека и записывает его в БД
* void updateHuman(Human human); //Обновляет данные по конкретному человеку
* void deleteHuman(Human human); //Удаляет конкретного человека

Пример работы программы:


```JAVA
class Main {
	public static void main(String[] args) {
		CrudHuman crudHuman = new CrudHumanImpl();
		List<Human> humans = crudHuman.getAllHumans(); //теперь в humans весь список людей из бд
		Human human = crudHuman.getHumanById(3); //теперь в human находится конкретный человек (если такого id нет, то решение проблемы - на Ваше усмотрение)
		human.setName("Mitrofan");
		crudHuman.updateHuman(human); // теперь значения у данного человека в бд должно измениться
		crudHuman.deleteHuman(human); //после выполнения данной команды - данный человек должен удалиться из бд
	}
}
```
