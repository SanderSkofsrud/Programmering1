package Øving11;

import java.util.Scanner;

public class Client {
    private final Scanner in = new Scanner(System.in);

    public PropertyRegister register = new PropertyRegister();

    public static void main(String[] args) {
        Client o = new Client();
        o.testData();
        while (true) {
            o.showMenu();
        }
    }

    public void testData() {
        register.newProperty(1445, "Gloppen", 77, 631, "" , 1017.6, "Jens Olsen");
        register.newProperty(1445, "Gloppen", 77, 131, "Syningom", 661.3, "Nicolay Madsen");
        register.newProperty(1445, "Gloppen", 75, 19, "Fugletun", 650.6, "Evilyn Jensen");
        register.newProperty(1445, "Gloppen", 74, 188, "", 1457.2,"Karl Ove Bråten");
        register.newProperty(1445, "Gloppen", 69, 47, "Høiberg", 1339.4, "Elsa Indregård");
    }


    public void showMenu() {
        System.out.println("\n***** Property Register Application v0.1 *****\n");
        System.out.println("1. Add property");
        System.out.println("2. List all properties");
        System.out.println("3. Search property");
        System.out.println("4. Calculate average area");
        System.out.println("5. Quit");

        int menuInput = in.nextInt();
        switch (menuInput) {
            case 1 -> System.out.println(newProperty());
            case 2 -> System.out.println(getEveryProperty());
            case 3 -> System.out.println(findProperty());
            case 4 -> System.out.println(averageArea());
            case 5 -> System.exit(0);
            default -> System.out.println("You need to enter a number between 1-5");
        }
    }

    /**
     * Method to create a new property, both with and without a name of the property
     * @return Returns the string returnInfo, which contains either the information of the registered property or an error message
     */
    public String newProperty() {
        String returnInfo = "";

        System.out.println("Register a new property:");
        //in.nextLine();
        System.out.print("Municipality number (101 - 5054): "); int municipalityNumber = in.nextInt();
        System.out.print("Municipality name: "); in.nextLine();
        String municipalityName = in.nextLine();
        System.out.print("Lot number: "); int lotNumber = in.nextInt();
        System.out.print("Section number: "); int sectionNumber = in.nextInt();
        System.out.print("Area in m2: "); double area = in.nextDouble();
        in.nextLine();
        System.out.print("Owner: "); String nameOfOwner = in.nextLine();
        System.out.println("Press 1 to enter a name for the property, press 2 to not enter a name for the property "); int input = in.nextInt();
        if (input == 1) {
            in.nextLine();
            System.out.print("Name of property: "); String name = in.nextLine();
            try {
                returnInfo = register.newProperty(municipalityNumber, municipalityName, lotNumber, sectionNumber, name, area, nameOfOwner);
            } catch (Exception err) {
                err.printStackTrace();
                returnInfo = "Something went wrong, try again";
            }
        } else {
            try {
                returnInfo = register.newProperty(municipalityNumber, municipalityName, lotNumber, sectionNumber, area, nameOfOwner);
            } catch (Exception err) {
                err.printStackTrace();
                returnInfo = "Something went wrong, try again";
            }
        }
        return returnInfo;
    }

    /**
     * Method to get every property
     * @return Returns every property
     */
    public String getEveryProperty() {
        return register.toString();
    }

    /**
     * Method that finds a property given the municipality, lot and section number
     * @return Returns either a specific property that matches with the inputs, or an error message
     */
    public String findProperty() {
        System.out.println("Enter the information for the property you want to find:");
        System.out.print("Municipality number: "); int municipalityNumber = in.nextInt();
        System.out.print("Lot number: "); int lotNumber = in.nextInt();
        System.out.print("Section number: "); int sectionNmuber = in.nextInt();
        if (register.findSpecificProperty(municipalityNumber, lotNumber, sectionNmuber) != null) {
            return register.findSpecificProperty(municipalityNumber, lotNumber, sectionNmuber);
        } else {
            return "Could not find a property that matches with the information you gave";
        }
    }

    /**
     * Method that finds the average area of all properties
     * @return Returns the average area of all properties
     */
    public String averageArea(){
        return ("The average area is " + String.format("%.2f", register.getAverageArea()) + " m2");
    }
}
