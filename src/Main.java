import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Colton Judy's Genealogy Program");

        Tree familyTree = null;

        boolean flag = true;


        System.out.print("Would you like to create a family tree? [Y/N]: ");
        char userChoice = scanner.nextLine().charAt(0);

        switch (userChoice) {
            case 'Y' -> {
                System.out.print("What is the name of the first person? ");
                String name = scanner.nextLine();
                Person rootPerson = new Person(name);
                familyTree = new Tree(rootPerson);
            }
            case 'N' -> {
                System.out.println("Quitting Program");
                System.exit(0);
            }
            default -> System.out.println("Invalid choice");
        }

        while(flag) {
            System.out.println("[1] - Add Person");
            System.out.println("[2] - Remove Person");
            System.out.println("[3] - Display People & Relationships");
            System.out.println("[4] - Quit");

            int userChoice_ = scanner.nextInt();
            scanner.nextLine();

            switch(userChoice_) {
                case 1:
                    System.out.print("What is the name of the person? ");
                    String name = scanner.nextLine();
                    Person person = new Person(name);

                    System.out.println("\nWhat is the name of a sibling, parent, or spouse of this person?");
                    String relativeName = scanner.nextLine();
                    Person relative = familyTree.findPersonByName(relativeName);

                    if(relative == null)
                        break;

                    System.out.println("How are they related? | " + relativeName + " is the _____ of " + name);
                    System.out.println("[1] - Child");
                    System.out.println("[2] - Parent");
                    System.out.println("[3] - Spouse");

                    int choice = scanner.nextInt();

                    RelationshipType relationshipType;

                    switch (choice) {
                        case 1 -> relationshipType = RelationshipType.CHILD;
                        case 2 -> relationshipType = RelationshipType.PARENT;
                        case 3 -> relationshipType = RelationshipType.SPOUSE;
                        default -> relationshipType = null;
                    }

                    System.out.println("Adding Person...");
                    familyTree.addPerson(person, relative, relationshipType);
                    System.out.println("Person successfully added!");
                    break;
                case 2:
                    break;
                case 3:
                    familyTree.displayPeople();
                    break;
                case 4:
                    flag = false;
                    break;
                default:
                    System.out.println("Invalid choice");
                    break;
            }
        }
    }
}
