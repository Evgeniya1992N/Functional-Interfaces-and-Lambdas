import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.stream.Stream;

public class Main2 {
    public static void main(String[] args) {
        // Task 1
        Stream<Integer> stream = Stream.of(5, 3, 9, 1, 7);

        // Пример использования метода findMinMax
        findMinMax(stream, Comparator.naturalOrder(), (min, max) -> {
            System.out.println("Минимальный элемент: " + min);
            System.out.println("Максимальный элемент: " + max);
        });
    }

    public static <T> void findMinMax(Stream<? extends T> stream, Comparator<? super T> order, BiConsumer<? super T, ? super T> minMaxConsumer) {
        // Находим минимальный и максимальный элементы в стриме
        T min = stream.min(order).orElse(null);
        T max = stream.max(order).orElse(null);

        // Передаем найденные элементы в minMaxConsumer
        minMaxConsumer.accept(min, max);

        // Task 2
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        countAndPrintEvenNumbers(numbers);
    }

    public static void countAndPrintEvenNumbers(List<Integer> numbers) {
        long count = numbers.stream()
                .filter(num -> num % 2 == 0) // Фильтруем четные числа
                .peek(System.out::println) // Выводим четные числа в консоль
                .count(); // Подсчитываем количество четных чисел

        System.out.println("Количество четных чисел: " + count);
    }
}

