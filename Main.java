package Project_7;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        DataBase database = new DataBase();
        Magazine magazine = new Magazine();
        Freemium free = new Freemium();
        Streaming stream = new Streaming();
        Scanner read = new Scanner(System.in);
        while (true) {
            System.out.println("Project 7: Subscription Management System");
            System.out.println("Select the Number corresponding to the option you wish to do today!!");
            System.out.println("[1] Create a new subscription");
            System.out.println("[2] Update an existing subscription");
            System.out.println("[3] Cancel a subscription");
            System.out.println("[4] View all subscriptions");
            System.out.println("[5] View Status of a Subscription");
            System.out.println("[6] Search Subscription");
            System.out.println("[7] Filter Subscription");
            System.out.println("[8] End the program");

            System.out.print("Enter your choice:  ");
            try {
                int choice = read.nextInt(); read.nextLine();
                switch (choice) {
                    case 1:
                        System.out.println("Creating a new subscription!!");
                        System.out.print("Enter subscription type ( [1]: Magazine, [2]: Streaming, [3]: Freemium): ");
                        int Choice = read.nextInt(); read.nextLine();
                        if (Choice == 1) {
                            magazine.create(database, read);
                        } else if (Choice == 2) {
                            stream.create(database, read);
                        } else if (Choice == 3) {
                            free.create(database, read);
                        } else {
                            System.out.println("Invalid subscription type. Please try again.");
                        }
                        break;
                    case 2:
                        System.out.println("Updating a subscription:");
                        System.out.print("Enter subscription type ( [1]: Magazine, [2]: Streaming, [3]: Freemium): ");
                        Choice = read.nextInt(); read.nextLine();
                        if (Choice == 1) {
                            magazine.update(database, read);
                        } else if (Choice == 2) {
                            stream.update(database, read);
                        } else if (Choice == 3) {
                            free.update(database, read);
                        } else {
                            System.out.println("Could not find that Subscription, Please try again.");
                        }
                        break;
                    case 3:
                        System.out.println("Canceling a subscription:");
                        System.out.print("Enter subscription type which you want to cancel ( [1]: Magazine, [2]: Streaming, [3]: Freemium): ");
                        Choice = read.nextInt(); read.nextLine();
                        if (Choice == 1) {
                            magazine.cancel(database, read);
                        } else if (Choice == 2) {
                            stream.cancel(database, read);
                        } else if (Choice == 3) {
                            free.cancel(database, read);
                        } else {
                            System.out.println("Invalid subscription type. Please try again.");
                        }
                        break;
                    case 4:
                        System.out.println("View all subscriptions:");
                        database.viewAllSubscriptions();
                        break;
                    case 5:
                        System.out.println("Viewing subscription Status:");
                        System.out.print("Enter subscription type ( [1]: Magazine, [2]: Streaming, [3]: Freemium): ");
                        Choice = read.nextInt();
                        read.nextLine();
                        if (Choice == 1) {
                            magazine.status(database, read);
                        } else if (Choice == 2) {
                            stream.status(database, read);
                        } else if (Choice == 3) {
                            free.status(database, read);
                        } else {
                            System.out.println("Invalid subscription type. Please try again.");
                        }
                        break;
                    case 6:
                        System.out.print("Enter type of Subscription: ");
                        String type = read.nextLine();
                        System.out.print("Enter name for searching: ");
                        String search = read.nextLine();
                        if (type.equalsIgnoreCase("Magazine")){
                            List<Magazine> foundMagazine = database.searchMagazines(search);
                            for (Magazine mag : foundMagazine){
                                System.out.println("Found Magazine: " + mag.getName() + "with Status of: " + mag.getStatus());
                            }
                        }
                        else if (type.equalsIgnoreCase("Streaming")){
                            List<Streaming> foundStreamings = database.searchStreaming(search);
                            for (Streaming streams : foundStreamings) {
                                System.out.println("Found Streaming: " + streams.getName() + "with Status of: " + streams.getStatus());
                            }
                        }
                        else if (type.equalsIgnoreCase("Freemium")){
                            List<Freemium> foundFreemium = database.searchFreemiums(search);
                            for (Freemium freemium : foundFreemium){
                                System.out.println("Found Freemium: " + freemium.getName() + "with Status of: " + free.getStatus());
                            }
                        }
                        else {
                            System.out.println("Subscription mentioned not found.");
                        }
                        break;
                    case 7:
                        System.out.print("Enter subscription type: ");
                        String filType = read.nextLine();
                        System.out.print("Enter Status: ");
                        String filStatus = read.nextLine();
                        if (filType.equalsIgnoreCase("Magazine")){
                            List<Magazine> filMagazines = database.filterMagazines(filStatus);
                            for (Magazine mag : filMagazines){
                                System.out.println("Magazine: " + mag.getName() + "with Status of: " + mag.getStatus());
                            }
                        }
                        else if (filType.equalsIgnoreCase("Streaming")){
                            List<Streaming> filStreamings = database.filterStreaming(filStatus);
                            for (Streaming streams : filStreamings) {
                                System.out.println("Streaming: " + streams.getName() + "with Status of: " + streams.getStatus());
                            }
                        }
                        else if (filType.equalsIgnoreCase("Freemium")){
                            List<Freemium> filFreemium = database.filterFreemiums(filStatus);
                            for (Freemium freemium : filFreemium){
                                System.out.println("Freemium: " + freemium.getName() + "with Status of: " + freemium.getStatus());
                            }
                        }
                        else {
                            System.out.println("Subsciption mentioned not found.");
                        }
                        break;
                    case 8:
                        System.out.println("Closing System, Thank you for using our Subscription Management System!");
                        return;
                    default:
                        System.out.println("Invalid option. Please try again.");
                }
            } catch (InputMismatchException choice) {
                System.out.println("Invalid Choice, Please select a choice given on the Prompt"); read.next();
            }
        }
    }
}