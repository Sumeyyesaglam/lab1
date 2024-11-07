import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

class CapitalQuiz {

    public static boolean startQuiz(Scanner reader) {
        Map<String, String> capitals = new HashMap<>();
        capitals.put("Turkey", "Ankara");
        capitals.put("France", "Paris");
        capitals.put("Germany", "Berlin");
        capitals.put("Japan", "Tokyo");
        capitals.put("Brazil", "Brasilia");
        capitals.put("Canada", "Ottawa");
        capitals.put("Russia", "Moscow");
        capitals.put("Italy", "Rome");
        capitals.put("Egypt", "Cairo");
        capitals.put("India", "New Delhi");

        Random random = new Random();
        List<String> countries = new ArrayList<>(capitals.keySet());
        String country = countries.get(random.nextInt(countries.size()));
        String correctCapital = capitals.get(country);

        System.out.print("What is the capital of " + country + "? ");
        String answer = reader.nextLine().trim();

        if (answer.equalsIgnoreCase(correctCapital)) {
            System.out.println("Correct! You will start the game.");
            return true;
        } else {
            System.out.println("Incorrect! The computer will start the game.");
            return false;
        }
    }
}