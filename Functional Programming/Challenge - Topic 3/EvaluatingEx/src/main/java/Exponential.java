import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.*;
import java.util.stream.Collectors;

public class Exponential {

    public static void main(String[] args) {
        List<Double> ins = new ArrayList<>();
        final int n = 10;

        Scanner in = new Scanner(System.in);

        int numberOfTests = in.nextInt();
        in.nextLine();

        for (int i = 0; i < numberOfTests; i++) {
            double number = in.nextDouble();
            ins.add(number);
        }

        final double x = 20.000;

        System.out.println("No Currying method: e^" + x + " = " +
                ins.stream().map(item -> exponential.apply(item, n-1)).collect(Collectors.toList()).toString());
        System.out.println("Currying method: e^" + x + " = " +
                ins.stream().map(item -> curryingExponential.apply(x).apply(n-1)).collect(Collectors.toList()).toString());
        System.out.println("************************");

        System.out.println("e^x for: " + ins.toString() + "\n" +
                "is equal to: " + Exponential.evaluatingEuler.apply(ins).toString());
    }

    // Exponential function without currying
    public static final BiFunction<Double, Integer, Double> exponential = (x, n) -> {
        return (n == 0) ? 1.000 : (Math.pow(x, n)/Exponential.factorial.apply(n)) + Exponential.exponential.apply(x, n-1);
    };

    // Exponential currying function
    public static final Function<Double, Function<Integer, Double>> curryingExponential = (x) -> {
        return (n) -> {
            return (n == 0) ? 1.000 : (Math.pow(x, n) / Exponential.factorial.apply(n)) + Exponential.curryingExponential.apply(x).apply(n - 1);
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
