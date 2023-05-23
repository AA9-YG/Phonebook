package phonebook;

import java.util.*;

public class PhoneBook {

    private final Map<String, Long> contactList = new HashMap();

    public void addContact(String name, long number) {
        contactList.put(name, number);
    }

    public long getNumber(String name) {
        return contactList.get(name);
    }

    public Set<String> getAllNames() {
        return contactList.keySet();
    }

    public void removeContact(String name) {
        contactList.remove(name);
    }

    public void run() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome to the BLIT phonebook");

        while (true) {

            System.out.println("Choose an option: ");
            System.out.println("1 - Add a contact");
            System.out.println("2 - Get a number");
            System.out.println("3 - Remove a contact");
            System.out.println("4 - View all contacts");
            System.out.println("5 - Exit");

            int input = 0;

            try {
                input = scan.nextInt();
            } catch (Exception e) {
                System.out.println("Please enter a number that matches an option");
            }

            scan.nextLine(); // Consume newline character

            switch (input) {
                case 0 -> System.out.println();
                case 1 -> {
                    System.out.println("Enter a name: ");
                    String name = scan.nextLine();
                    System.out.println("Enter a number: ");
                    long number = scan.nextLong();

                    addContact(name, number);
                }
                case 2 -> {
                    System.out.println("Enter a name: ");
                    String name = scan.nextLine();

                    if (contactList.containsKey(name)) {
                        System.out.println("Name: " + name + "\t Number: " + getNumber(name));
                    } else System.out.println("Name cannot be found in the phonebook");

                }
                case 3 -> {
                    System.out.println("Enter a name: ");
                    String name = scan.nextLine();

                    if (contactList.containsKey(name)) {
                        removeContact(name);
                        System.out.println(name + " was successfully removed from the phonebook");
                    } else System.out.println("Name cannot be found in the phonebook");
                }
                case 4 -> {
                    if (contactList.isEmpty())
                        System.out.println("Phonebook is empty");
                    else {
                        HashSet<String> names = new HashSet<>(getAllNames());
                        System.out.println("All names in the phonebook:");

                        for (String name : names) {
                            System.out.println(name);
                        }
                    }
                }
                case 5 -> System.exit(0);
                default -> System.out.println("Number doesn't match any of the options. Try again");
            }
        }
    }

    public static void main(String[] args) {
        PhoneBook book = new PhoneBook();

        book.run();
    }
}
