import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(" Enter LRU Cache Capacity: ");
        int capacity = scanner.nextInt();
        scanner.nextLine();

        LRU<String, String> cache = new LRU<>(capacity);

        while (true) {
            System.out.println("\n LRU Cache CLI Menu:");
            System.out.println("1  Put (key, value)");
            System.out.println("2  Get (key)");
            System.out.println("3   Display Cache");
            System.out.println("4   Exit");
            System.out.print(" Enter choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print(" Enter key: ");
                    String key = scanner.nextLine();
                    System.out.print(" Enter value: ");
                    String value = scanner.nextLine();
                    cache.put(key, value);
                    break;
                case 2:
                    System.out.print(" Enter key to retrieve: ");
                    String getKey = scanner.nextLine();
                    String retrievedValue = cache.get(getKey);
                    if (retrievedValue != null) {
                        System.out.println("Value: " + retrievedValue);
                    }
                    break;
                case 3:
                    cache.display();
                    break;
                case 4:
                    System.out.println(" Exiting... Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println(" Invalid choice! Please try again.");
            }
        }
    }
}
