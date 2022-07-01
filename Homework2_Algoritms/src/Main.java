import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int minNumber = 0; // инициализируем  минимальное число.
        int countEvenNumbers = 0; // инициализируем счетчик четных чисел
        int countOddNumbers = 0; // инициализируем счетчик четных чисел
        Random random = new Random(); // заводим переменную класса Random для заполнения последовательности
        // в качестве допущения взяты рандомные числа примитивного типа int;
        int n = random.nextInt(30); // инициализируем случайный размер одномерного массива, в качестве наглядности верхняя граница разиера установлена 30.
        System.out.println("Задана случайная последовательность  целых чисел, значение каждого числа  в диапазоне  чисел типа int");
        System.out.println(" Случайный размер одномерного  масcива поcледовательности равен: " + n);
        int[] numbers = new int[n]; // инициализируем одномерный массив numbers, характеризующий случайную последовательность чисел;
        numbers[n - 1] = -1;//  присваиваем последнему  элементу массива значение -1(согласно условию задачи, хотя это избыточное условие);

        for (int number : numbers) { // пробегаемся по всем элементам массива
            number = random.nextInt(); // заполняем массив рандомными числами
            if (minNumber >= number) { // в случае, если  элемент текущей итерации меньше нашего инициализированного минимального числа
                minNumber = number;  //то присваиваем минимальное значение "нашему результирующему числу" minNumber
            }
            System.out.println(number);
            if (number % 2 == 0) { // если элемент текущей итерации четный
                countEvenNumbers++; //, то увеличиваем счетчик countEvenNumbers на +1
            } else { //иначе
                countOddNumbers++; //увеличиваем счетчик countOddNumbers на +1
            }
        }
        // Выводим на экран текущий результат
        System.out.println("минимальное число равно: " + minNumber);
        System.out.println("Количество четных чисел в последовательности  равно: " + countEvenNumbers);
        System.out.println("Количество нечетных чисел в последовательности  равно: " + countOddNumbers);

      



    }

}
