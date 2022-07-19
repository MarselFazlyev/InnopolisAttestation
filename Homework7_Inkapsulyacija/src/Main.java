import java.util.Arrays;
import java.util.Random;

public class Main {
    public static Random random = new Random();

    public static void main(String[] args) {
        Human[] humans = new Human[random.nextInt(10) + 1];//для читабельности верхняя граница рандома взята равной 10
//        for (Human human : humans) {
//            human = createNewHuman();
//            System.out.println(human);
//        }
//        System.out.println(Arrays.toString(humans));
        for (int i = 0; i < humans.length; i++) {
            humans[i] = createNewHuman();
        }
        System.out.println(Arrays.toString(humans));
        System.out.println("*************************************");
        System.out.println("ВЫВОД МАССИВА ЛЮДЕЙ ПОСЛЕ СОРТИРОВКИ ПО ВОЗРАСТУ:");
        Arrays.sort(humans, new ComparatorByAge());
        System.out.println(Arrays.toString(humans));
    }

    private static Human createNewHuman() {
        String[] names = {"Маша", "Даша", "Оля", "Петя", "Юра", "Сергей", "Афанасий", "Михаил", "Екатерина", "Олег"};
        String[] lastNames = {"Сайко", "джордан", "Пеннивайз", "Крушизуб", "Трамп", "Нурулло", "Саакян", "Спица", "Сачко", "Джексон"};
        int age = random.nextInt(60);
        return new Human(names[random.nextInt(names.length - 1)], lastNames[random.nextInt(names.length - 1)], age);
    }
}
