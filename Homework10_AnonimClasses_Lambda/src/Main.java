import java.util.Arrays;
import java.util.Random;

public class Main {
    public static Random random = new Random();

    public static void main(String[] args) {
        int[] testArray = new int[random.nextInt(30)];
        for (int i = 0; i < testArray.length; i++) {
            testArray[i] = random.nextInt(1000);
        }
        System.out.println("Произвольный тестируемый массив :");
        System.out.println(Arrays.toString(testArray));

        checkEvenNumbers(testArray);
        isSummOfDigitNumbersEven(testArray);
        digitsOfAElementProperty(testArray);
        checkPolindromPropertyOfElement(testArray);
        //второй вариант решения метода  проверки цифр элемента на четность  digitsOfAElementProperty(testArray):
        // элемент  разбить на символы, символы распарсить и проверить на четность.

    }

    private static void checkEvenNumbers(int[] testArray) {
        System.out.println("\n****************************************");
        System.out.println("Начинается работа метода checkEvenNumbers ");
        System.out.println("Cписок четных чисел тестируемого массива : ");
        int[] result = Sequence.filter(testArray, x -> x % 2 == 0);
        for (int i = 0; i < result.length; i++) {
            if (result[i] == 0 && testArray[i] != 0) continue;// проверка, является ли ноль пришедшим из параметров.
            System.out.print(result[i] + " ");
        }

    }

    private static void isSummOfDigitNumbersEven(int[] testArray) {
        System.out.println("\n****************************************");
        System.out.println("Начинается работа метода isSummOfDigitNumbersEven ");
        int[] result = Sequence.filter(testArray, x -> {
            int sum = 0;
            while (x != 0) {
                sum += x % 10;
                x = x / 10;
                if (x < 10) {
                    sum += x;
                    break;
                }
            }
            return sum % 2 == 0;
        });
        for (int i = 0; i < result.length; i++) {
            if (testArray[i] == 0) {
                System.out.println("Сумма чисел тестируемого элемента равна 0, соответственно, четное число! ");
            } else if (result[i] == 0) {
                System.out.format("Сумма чисел тестируемого элемента %d является нечетным числом ", testArray[i]);
                System.out.println();
            } else {
                System.out.format("Сумма чисел тестируемого элемента %d является четным числом ", testArray[i]);
                System.out.println();
            }
        }
        System.out.println("****************************************");
    }


    private static void digitsOfAElementProperty(int[] testArray) {
        System.out.println("\n****************************************");
        System.out.println("Начинается работа метода isNumberOfDigitEven ");
        int[] result = Sequence.filter(testArray, x -> true);// не понимаю, как в данной ситуации предать логику,
        // решил логику записать в самом методе, массив подаваемый параметром в метод, просто перезаписать.
        for (int j : result) {
            System.out.printf("Разбор четности цифр числа %d: \n", j);
            while (j != 0) {
                int y;
                if (j < 10) {
                    System.out.printf("Число %d %s ", j, j % 2 == 0 ? " четное\n" : " нечетное \n");
                    System.out.println();
                    break;
                }
                y = j % 10;
                String s = y % 2 == 0 ? " четное" : " нечетное ";
                System.out.println("Число " + y + s);
                j = j / 10;
            }
        }
    }

    private static void checkPolindromPropertyOfElement(int[] testArray) {
        System.out.println("\n****************************************");
        System.out.println("Начинается работа метода checkPolindromPropertyOfElement ");
        int[] result = Sequence.filter(testArray, x -> {
            Integer number = x;
            char[] chars = number.toString().toCharArray();
            int j = -1;
            for (int i = 0; i <= chars.length / 2; i++) {
                if (chars[i] != chars[chars.length + j]) break;
                j--;
                if (i == chars.length / 2) return true;
            }
            return false;
        });
        boolean flag = true;
        for (int test : result) {
            if (test != 0) {
                System.out.printf("Число %d является полиндромом!\n", test);
                flag = false;
            }

        }
        if (flag) System.out.println("В данном массиве полиндромов нет!");


    }


}
