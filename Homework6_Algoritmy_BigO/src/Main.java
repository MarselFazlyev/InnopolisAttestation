import java.util.*;
import java.util.function.Function;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

public class Main {
    private static int SIZE;
    private static int VALUE;
    private static Random random = new Random();

    public static void main(String[] args) {
        //произвольная последователность
        printMinTimesNumber(fillListByRAndomNumbers());
        // тестовая последовательность
        List<Integer> testList = Arrays.asList(1, 2, 3, 4, 2, 2, 0, -1, -1, 1, 0, 4);
        printMinTimesNumber(testList, testList.size());
    }

    private static void printMinTimesNumber(List<Integer> numbers) {
        Map<Integer, Long> result = numbers.stream().collect(groupingBy(Function.identity(), counting()));
        long ResultValue = Integer.MAX_VALUE;
        int ResultKey = 0;
        for (Map.Entry<Integer, Long> minNumber : result.entrySet()) {
            if (minNumber.getValue() < ResultValue) {
                ResultValue = minNumber.getValue();
                ResultKey = minNumber.getKey();
            }
        }
        System.out.println("В текущей последовательности размером " + SIZE + " ячеек элемент со значением  " + ResultKey + " встретился минимальное количество раз :" + ResultValue);
    }

    private static void printMinTimesNumber(List<Integer> numbers, int size) {
        Map<Integer, Long> result = numbers.stream().collect(groupingBy(Function.identity(), counting()));
        long ResultValue = Integer.MAX_VALUE;
        int ResultKey = 0;
        for (Map.Entry<Integer, Long> minNumber : result.entrySet()) {
            if (minNumber.getValue() < ResultValue) {
                ResultValue = minNumber.getValue();
                ResultKey = minNumber.getKey();
            }
        }
        System.out.println("В тестовой последовательности размером " + size + " ячеек элемент со значением  " + ResultKey + " встретился минимальное количество раз :" + ResultValue);
    }

    private static List<Integer> fillListByRAndomNumbers() {
        List<Integer> numbers = new ArrayList<>(SIZE);
        SIZE = Math.abs(random.nextInt(1_000_000) + 1);
        for (int i = 0; i < SIZE; i++) {
            VALUE = random.nextInt(201) - 100;
            numbers.add(VALUE);
        }
        return numbers;
    }
}
