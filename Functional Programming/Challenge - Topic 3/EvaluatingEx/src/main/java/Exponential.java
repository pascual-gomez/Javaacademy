import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.*;
import java.util.stream.Collectors;

public class Exponential {

    public static void main(String[] args) {
        final double x = 20.000;
        final int n = 10;

        System.out.println("No Currying method: e^" + x + " = " + exponential.apply(x, n-1));
        System.out.println("Currying method: e^" + x + " = " + curryingExponential.apply(x).apply(n-1));
        System.out.println("************************");

        List<Double> numbers = new ArrayList<>(Arrays.asList(20.000, 5.000, 0.500, -0.500));

        System.out.println("e^x for: " + numbers.toString() + "\n" +
                "is equal to: " + Exponential.evaluatingEuler.apply(numbers).toString());
    }

    // Exponential function without currying
    public static final BiFunction<Double, Integer, Double> exponential = (x, n) -> {
        return (n == 0) ? 1.000 : (Math.pow(x, n)/Exponential.factorial.apply(n)) + Exponential.exponential.apply(x, n-1);
    };

    // Exponential currying function
    public static final Function<Double, Function<Integer, Double>> curryingExponential = (x) -> {
        return (n) -> {
            return (n == 0) ? 1.000 : (Math.pow(x, n) / Exponential.factorial.apply(n)) + Exponential.exponential.apply(x, n - 1);
        };
    };

    // Factorial function
    public static final Function<Integer, Integer> factorial = (x) -> {
        return (x == 1) ? 1 : x * Exponential.factorial.apply(x-1);
    };

    // Exponential method with a list of doubles as argument
    public static final Function<List<Double>, List<Double>> evaluatingEuler = (numbers) -> {
        return numbers.stream().map(item -> Exponential.curryingExponential.apply(item).apply(9)).collect(Collectors.toList());
    };
}
