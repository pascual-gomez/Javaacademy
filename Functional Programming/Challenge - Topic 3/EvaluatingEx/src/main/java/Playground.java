import java.util.function.*;

public class Playground {
    public static void main(String[] args) {
        System.out.println("Function interface");
        Function<String, String> toUpperCaseFn = (string) -> string.toUpperCase();
        System.out.println(toUpperCaseFn.apply("Jorge"));

        System.out.println("BiFunction interface");
        BiFunction<Integer, String, String> formatValueAndUnit = (number, unit) -> number + " " + unit;
        System.out.println(formatValueAndUnit.apply(7, "km"));

        System.out.println("UnaryOperator interface");
        //Function<Integer, Integer> doubleNum = number -> number * 2;
        UnaryOperator<Integer> doubleNum = number -> number * 2;
        System.out.println(doubleNum.apply(5));

        System.out.println("BinaryOperator interface");
        //BiFunction<Integer, Integer, Integer> addTwoNumbers = (num1, num2) -> num1 + num2;
        BinaryOperator<Integer> addTwoNumbers = (num1, num2) -> num1 + num2;
        System.out.println(addTwoNumbers.apply(5, 3));

        System.out.println("Predicate interface");
        Predicate<Integer> evenNumber = number -> number % 2 == 0;
        System.out.println(evenNumber.test(8));
        System.out.println(evenNumber.test(7));

        System.out.println("BiPredicate interface");
        BiPredicate<Integer, Integer> divisibleBy = (num1, num2) -> num1 % num2 == 0;
        System.out.println(divisibleBy.test(8, 3));
        System.out.println(divisibleBy.test(10, 5));

        System.out.println("Supplier interface");
        Supplier<Integer> generateRandomNumber = () -> (int) Math.floor(Math.random() * 10);
        System.out.println(generateRandomNumber.get());

        System.out.println("Consumer interface");
        Consumer<String> logMessage = (message) -> System.out.println("Logging message: " + message);
        logMessage.accept("Hello, world!");
    }
}
