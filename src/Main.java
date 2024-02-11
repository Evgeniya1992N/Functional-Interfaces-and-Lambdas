import java.util.Random;
import java.util.function.Predicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {

        //Task 1 Проверка положительных чисел через анонимный класс,
        Predicate<Integer> predicate = new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {
                boolean b = integer < 0;
                return b;
            }
        };
        // Проверка
        System.out.println(predicate.test(4));
        System.out.println(predicate.test(-5));

        // Task 1 Проверка положительных чисел через лямбду.
        Predicate<Integer> isPositive = number -> number > 0;

        // Проверка
        System.out.println(isPositive.test(5));  // true
        System.out.println(isPositive.test(-3)); // false
        System.out.println(isPositive.test(0));  // false

        // Task 2 Анонимный класс
        Consumer<String> greetingConsumer = new Consumer<String>() {
            @Override
            public void accept(String name) {
                System.out.println("Привет, " + name + "!");
            }
        };

        greetingConsumer.accept("Иван");

        // Task 2 Лямбда-выражение
        Consumer<String> greetingLambda = name -> System.out.println("Привет, " + name + "!");

        greetingLambda.accept("Мария");

        // Task 3 Анонимный класс
        Function<Double, Long> roundFunction = new Function<Double, Long>() {
            @Override
            public Long apply(Double number) {
                return Math.round(number);
            }
        };
        System.out.println("Анонимный класс: " + roundFunction.apply(5.8));
        // Task 3 Лямбда-выражение

        Function<Double, Long> roundLambda = number -> Math.round(number);
        System.out.println("Лямбда-выражение: " + roundLambda.apply(2.9));

        // Task 4 Анонимный класс

        Supplier<Integer> randomSupplier = new Supplier<Integer>() {
            Random random = new Random();

            @Override
            public Integer get() {
                return random.nextInt(101);
            }
        };
        System.out.println("Анонимный класс: " + randomSupplier.get());
        // Task 4 Лямбда-выражение
        Supplier<Integer> randomLambda = () -> new Random().nextInt(101);
        System.out.println("Лямбда-выражение: " + randomLambda.get());

        // Task 5
        Predicate<Integer> condition = num -> num % 2 == 0;
        Function<Integer, String> isTrue = number -> "even";
        Function<Integer, String> isFalse = number -> "odd";

        Function<Integer, String> resultFunction = ternaryOperator(condition, isTrue, isFalse);
        System.out.println(resultFunction.apply(4)); // Выведет "Четное число"
        System.out.println(resultFunction.apply(7)); // Выведет "Нечетное число"

    }

    private static Function<Integer, String> ternaryOperator(Predicate<Integer> condition, Function<Integer, String> isTrue, Function<Integer, String> isFalse) {
        return isTrue;
    }
}

    // public static <T, R> Function<T, R> ternaryOperator(
    //   Predicate<T> condition,
    //    Function<T, R> ifTrue,
    //    Function<T, R> ifFalse) {
    // return condition.test(x) ? isTrue.apply(x) : isFalse.apply(x);
    // }




