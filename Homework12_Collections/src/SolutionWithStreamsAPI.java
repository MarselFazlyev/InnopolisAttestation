import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SolutionWithStreamsAPI {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        duplicateСount();
    }


    private static void duplicateСount() {
        System.out.println("Введите строку\n>");
        String[] parts = scanner.nextLine().split(" ");
        System.out.println(" Исходный массив слов из строки: \n" + Arrays.toString(parts));
        Map<String, Long> result = Arrays.stream(parts).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(result);
    }
}
