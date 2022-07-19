import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[] array = {20, 0, 34, 5,0,123,34,0,0, 7, 12, 0, 1, 0, 2345, 9, 2, 0}; // ввел массив, не стал применять консоль для введения
        int number = 2345; // инициализировал контрольное число
        System.out.println(functionCheckIndex(array, number)); // вызвал и вывел на консоль functionCheckIndex
        procedureSortArrayvalues(array);
        System.out.println(Arrays.toString(array)); // вывел на консоль преобразованный массив array.

    }

    private static int functionCheckIndex(int[] array, int number) {
        for (int i = 0; i < array.length; i++) {
            if (number == array[i]) {
                return i;
            }
        }
        return -1;
    }

    private static void procedureSortArrayvalues(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 0) {
                for (int j = i + 1; j < array.length; j++) {
                    if (array[j] != 0) {
                        array[i] = array[j];
                        array[j] = 0;
                        break;
                    }
                }
            }


        }


    }

}
