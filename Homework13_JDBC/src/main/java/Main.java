import java.util.List;

class Main {
    public static void main(String[] args) {
        CrudHuman crudHuman = new CrudHumanImpl();

        crudHuman.createHuman(new Human(
                "Tatiana", "Ivanova", "Valerevna", "Moscow", "BakerStreet", "1",
                "23", "9302 344556"));
        crudHuman.createHuman(new Human(
                "Igor", "Petrov", "Valentinovich", "Riga", "Solnechnaya", "34",
                "172", "9545 112345"));
        crudHuman.createHuman(new Human(
                "Sultan", "Sidorov", "Izecelevich", "Karaganda", "Nursultanovaya", "67",
                "91", "6789 34561"));

        List<Human> humans = crudHuman.getAllHumans(); //теперь в humans весь список людей из бд
        Human human = crudHuman.getHumanById(3); //теперь в human находится конкретный человек (если такого id нет, то решение проблемы - на Ваше усмотрение)
        human.setName("Mitrofan");
        crudHuman.updateHuman(human); // теперь значения у данного человека в бд должно измениться
        crudHuman.deleteHuman(human);//после выполнения данной команды - данный человек должен удалиться из бд
        System.out.println("Итоговый список базы данных: \n" + crudHuman.getAllHumans());
    }


}

