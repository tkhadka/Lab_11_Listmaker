import java.util.ArrayList;
import java.util.Scanner;

public class MenuDrivenProgram {

    public static void main(String[] args) {
        ArrayList<String> itemList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            displayMenu();
            String choice = SafeInput.getRegExString(scanner, "Enter your choice: ", "[AaDdPpQq]");
            switch (choice.toUpperCase()) {
                case "A":
                    addItem(itemList, scanner);
                    break;
                case "D":
                    deleteItem(itemList, scanner);
                    break;
                case "P":
                    printList(itemList);
                    break;
                case "Q":
                    if (confirmQuit(scanner)) {
                        System.out.println("Exiting program...");
                        return;
                    }
                    break;
            }
        }
    }

    /**
     * Displays the menu options.
     */
    private static void displayMenu() {
        System.out.println("Menu:");
        System.out.println("A - Add an item to the list");
        System.out.println("D - Delete an item from the list");
        System.out.println("P - Print the list");
        System.out.println("Q - Quit the program");
    }

    /**
     * Adds an item to the list.
     * @param list The list to add the item to.
     * @param scanner The Scanner object to get user input.
     */
    private static void addItem(ArrayList<String> list, Scanner scanner) {
        System.out.println("Enter the item to add:");
        String item = scanner.nextLine();
        list.add(item);
        System.out.println("Item added successfully.");
    }

    /**
     * Deletes an item from the list.
     * @param list The list to delete the item from.
     * @param scanner The Scanner object to get user input.
     */
    private static void deleteItem(ArrayList<String> list, Scanner scanner) {
        if (list.isEmpty()) {
            System.out.println("List is empty. Nothing to delete.");
            return;
        }

        System.out.println("Select the number of the item to delete:");
        printNumberedList(list);
        int index = SafeInput.getRangedInt(scanner, "Enter item number: ", 1, list.size());
        String deletedItem = list.remove(index - 1);
        System.out.println("Item \"" + deletedItem + "\" deleted successfully.");
    }

    /**
     * Prints the items in the list.
     * @param list The list to print.
     */
    private static void printList(ArrayList<String> list) {
        if (list.isEmpty()) {
            System.out.println("List is empty.");
        } else {
            System.out.println("Items in the list:");
            for (int i = 0; i < list.size(); i++) {
                System.out.println((i + 1) + ". " + list.get(i));
            }
        }
    }

    /**
     * Confirms if the user wants to quit the program.
     * @param scanner The Scanner object to get user input.
     * @return True if the user confirms to quit, false otherwise.
     */
    private static boolean confirmQuit(Scanner scanner) {
        return SafeInput.getYNConfirm(scanner, "Are you sure you want to quit? (Y/N): ");
    }

    /**
     * Prints a numbered list of items.
     * @param list The list to print.
     */
    private static void printNumberedList(ArrayList<String> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.println((i + 1) + ". " + list.get(i));
        }
    }
}
