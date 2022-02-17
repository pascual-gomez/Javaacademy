import java.util.*;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

public class PasswordCracker {

    public static void main(String[] args) {
        List<String> solutions = new ArrayList<String>();

        Scanner in = new Scanner(System.in);
        System.out.println("Program has started: Enter values");

        //read number of tests
        int countTests = in.nextInt();

        for (int i = 0; i < countTests; i++) {
            String loginAttempt;

            //number of passwords
            int numberPasswords = in.nextInt();
            in.nextLine();
            List<String> passwords;

            //read passwords
            String tempString = in.nextLine();
            passwords = Arrays.asList(tempString.toLowerCase().split("\\s+"));

            //read login attempt
            loginAttempt = in.nextLine().toLowerCase();

            String answer = PasswordCracker.checkPassword.apply(loginAttempt, passwords);
            solutions.add(answer);
        }

        System.out.println();
        System.out.println("Answer: ");
        System.out.println();

        for (int i = 0; i < solutions.size(); i++) {
            boolean wrongPass = solutions.get(i).endsWith("WRONG PASSWORD");

            System.out.println((wrongPass) ? "WRONG PASSWORD" : solutions.get(i));
        }
    }

    public static final BiFunction<String, List<String>, String> checkPassword = (loginAttempt, passwords) -> {
        if (loginAttempt.isEmpty()) return "";
        List<String> correctWords = passwords.stream().filter(item -> loginAttempt.startsWith(item)).collect(Collectors.toList());
        return (!correctWords.isEmpty()) ?
                correctWords.get(0) + PasswordCracker.checkPassword.apply(loginAttempt.substring(correctWords.get(0).length()), passwords) :
                "WRONG PASSWORD";
    };

}
