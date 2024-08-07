import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class PeacockFeathers {
    private Queue<String> feathers;

    public PeacockFeathers() {
        feathers = new LinkedList<>();
    }

    // Method to add a feather to the stack
    public void buy(String color) {
        feathers.add(color);
    }

    // Method to fetch the bottom feather and move it to the top
    public void fetch() {
        if (feathers.isEmpty()) {
            System.out.println("No feathers to fetch.");
            return;
        }

        // Remove the bottom feather (which is the first element in the queue)
        String bottomFeather = feathers.poll();
        System.out.println(bottomFeather);

        // Add the removed feather to the top of the stack
        feathers.add(bottomFeather);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PeacockFeathers peacock = new PeacockFeathers();

        // Read the number of queries
        int numberOfQueries = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        // Read all the queries
        String[] queries = scanner.nextLine().split(", ");

        // Process each query
        for (String query : queries) {
            if (query.startsWith("buy_")) {
                String color = query.substring(4);
                peacock.buy(color);
            } else if (query.equals("fetch")) {
                peacock.fetch();
            }
        }

        scanner.close();
    }
}
