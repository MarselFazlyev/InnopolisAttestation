import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MainClassic {
    public static void main(String[] args) {
        duplicateСount();
    }

    private static void duplicateСount() {
        System.out.println("Введите строку\n>");
        String[] parts = SolutionWithStreamsAPI.scanner.nextLine().split(" ");
        System.out.println(" Исходный массив слов из строки: \n" + Arrays.toString(parts));
        Map<String, Integer> wordsCountStorage = new HashMap<>();
        int count = 1;
        for (String part : parts) {
            if (wordsCountStorage.containsKey(part))
                count++;
            else {
                count = 1;
                wordsCountStorage.put(part, count);
            }
            System.out.println(wordsCountStorage);
        }
    }

}
