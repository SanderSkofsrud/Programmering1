package mappevurdering;

import java.util.Scanner;

public class Main {
  private static final int LIST_ALL_ITEMS = 1;
  private static final int FIND_ITEM = 2;
  private static final int ADD_ITEM = 3;
  private static final int INCREASE_QUANTITY = 4;
  private static final int DECREASE_QUANTITY = 5;
  private static final int DELETE_ITEM = 6;
  private static final int CHANGE = 7;
  private static final int CHANGE_DISCOUNT = 1;
  private static final int CHANGE_PRICE = 2;
  private static final int CHANGE_DESCRIPTION = 3;
  private static final int EXIT = 8;
  static ItemRegister itemRegister = new ItemRegister();
  private static Scanner sc;

  public static void main(String[] args) {
    Main o = new Main();
    sc = new Scanner(System.in);
    fillWithTestData(itemRegister);
    o.start(itemRegister);
  }

  /**
   * Presents the menu for the user, and awaits input from the user. The menu
   * choice selected by the user is being returned.
   *
   * @return the menu choice by the user as a positive number starting from 1.
   * If 0 is returned, the user has entered a wrong value
   */
  private static int showMenu() {
    int menuChoice = 0;
    System.out.println("\n***** Item register application v0.1 *****\n");
    System.out.println("1. List all items");
    System.out.println("2. Find a specific item");
    System.out.println("3. Add a new item");
    System.out.println("4. Increase the quantity of an item");
    System.out.println("5. Decrease the quantity of an item");
    System.out.println("6. Delete an item");
    System.out.println("7. Change something about an item");
    System.out.println("8. Quit");
    System.out.println("\nPlease enter a number between 1 and 8.\n");

    if (sc.hasNextInt()) {
      menuChoice = Integer.parseInt(sc.nextLine());
    } else {
      System.out.println("You must enter a number, not text");
    }
    return menuChoice;
  }


  /**
   * Starts the application. This is the main loop of the application,
   * presenting the menu, retrieving the selected menu choice from the user,
   * and executing the selected functionality.
   */
  public void start(ItemRegister itemRegister) {
    boolean finished = false;
// The while-loop will run as long as the user has not selected
// to quit the application
    while (!finished) {
      int menuChoice = showMenu();
      switch (menuChoice) {
        case LIST_ALL_ITEMS -> System.out.println(itemRegister);
        case FIND_ITEM -> findItem();
        case ADD_ITEM -> addItem();
        case INCREASE_QUANTITY -> increaseQuantity();
        case DECREASE_QUANTITY -> decreaseQuantity();
        case DELETE_ITEM -> deleteItem();
        case CHANGE -> change();
        case EXIT -> {
          System.out.println("Shutting down...\n");
          finished = true;
        }
        default -> System.out.println("Unrecognized menu selected.");
      }
    }
  }

  public static Item findItem() {
    System.out.println("Find item based on either item number or description");
    String itemNumber = getInput("Item Number (Blank if you want to find based on only description)");
    String description = getInput("Description (Blank if you want to find based on only item number");
    Item foundItem = itemRegister.findItem(itemNumber, description);
    if (foundItem == null) {
      System.out.println("Couldn't find item that matches with the inputs: \n Item Number: " + itemNumber + "\n Description: " + description);
    } else {
      System.out.println(foundItem);
    }
    return foundItem;
  }

  public void addItem() {
    try {
      String itemNumber = getInput("Item Number");
      String description = getInput("Description");
      int price = Integer.parseInt(getInput("Price"));
      String brand = getInput("Brand");
      double weight = Double.parseDouble(getInput("Weight"));
      double length = Double.parseDouble(getInput("Length"));
      double height = Double.parseDouble(getInput("Height"));
      String color = getInput("Color");
      int quantity = Integer.parseInt(getInput("Quantity"));
      int category = Integer.parseInt(getInput("Category (1 = Floor, 2 = Window, 3 = Door, 4 = Lumber)"));

      Item registeredItem;
      registeredItem = itemRegister.registerItem(itemNumber, description, price, brand, weight, length, height, color, quantity, category);

      System.out.println(registeredItem);
    } catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
    }
  }

  public void increaseQuantity() {
    Item foundItem = findChangeableItem();
    int quantity;
    int addedQuantity;
    int newQuantity;
    if (foundItem == null) {
      System.out.println("Couldn't find item that matches with the inputs");
    } else {
      System.out.println(foundItem);
      quantity = foundItem.getQuantity();
      System.out.println("The quantity of the item is: " + quantity + " How much do you want to add " + "to the storage?");
      addedQuantity = Integer.parseInt(getInput("the amount you want to increase the quantity by"));
      if (quantity < 1) {
        System.out.println("The added quantity must be greater than 0");
      } else {
        newQuantity = quantity + addedQuantity;
        foundItem.setQuantity(newQuantity);
        System.out.println("The new quantity of " + foundItem.getItemNumber() + " is " + foundItem.getQuantity());
      }
    }
  }

  public void decreaseQuantity() {
    Item foundItem = findChangeableItem();
    int decreasedQuantity;
    int newQuantity;
    int quantity;
    if (foundItem == null) {
      System.out.println("Couldn't find item that matches with the inputs");
    } else {
      System.out.println(foundItem);
      quantity = foundItem.getQuantity();
      System.out.println("The quantity of the item is: " + quantity + " How much do you want to remove" + "to the storage?");
      decreasedQuantity = Integer.parseInt(getInput("the amount you want to decrease the quantity by"));
      if (quantity < 1) {
        System.out.println("The decreased quantity must be greater than 0");
      } else {
        newQuantity = quantity - decreasedQuantity;
        foundItem.setQuantity(newQuantity);
        System.out.println("The new quantity of " + foundItem.getItemNumber() + " is " + foundItem.getQuantity());
      }
    }
  }

  public void deleteItem() {
    /*System.out.println("Enter the details for the item you want to delete");
    String itemNumber = getInput("Item Number (Blank if you want to find based on only description)");
    String description = getInput("Description (Blank if you want to find based on only item number");
    Item foundItem = itemRegister.findItem(itemNumber, description);*/
    Item foundItem = findItem();
    String itemNumber = foundItem.getItemNumber();
    String description = foundItem.getDescription();
    boolean deletedItem = itemRegister.removeItem(itemNumber, description);
    System.out.println(deletedItem);
  }

  public void change() {
    Item foundItem = findChangeableItem();
    if (foundItem == null) {
      System.out.println("Couldn't find item that matches with the inputs");
    } else {
      System.out.println(foundItem);
      System.out.println("What do you want to change?");
      System.out.println("Press 1 to change the discount");
      System.out.println("Press 2 to change the price");
      System.out.println("Press 3 to change the description");
      int change = 0;
      if (sc.hasNextInt()) {
        change = Integer.parseInt(sc.nextLine());
      } else {
        System.out.println("You must enter a number, not text");
      }
      switch (change) {
        case CHANGE_DISCOUNT -> {
          double discount = 0.0;
          int currentPrice = foundItem.getPrice();
          System.out.println("The current price of the item is: " + currentPrice);
          System.out.println("How many percent do you want to discount the item by?");
          if (sc.hasNextInt()) {
            discount = Integer.parseInt(sc.nextLine());
          } else {
            System.out.println("You must enter a number, not text");
          }
          foundItem.setDiscount(discount);
          System.out.println("The new price of the item is: " + foundItem.getDiscountedPrice());
        }
        case CHANGE_PRICE -> {
          int oldPrice = foundItem.getPrice();
          int newPrice = 0;
          System.out.println("The current price of the item is: " + oldPrice);
          System.out.println("What do you want to set the price to?");
          if (sc.hasNextInt()) {
            newPrice = Integer.parseInt(sc.nextLine());
          } else {
            System.out.println("You must enter a number, not text");
          }
          foundItem.setPrice(newPrice);
          newPrice = foundItem.getPrice();
          System.out.println("The new price of the item is: " + newPrice);
        }
        case CHANGE_DESCRIPTION -> {
          String oldDescription = foundItem.getDescription();
          System.out.println("The current description of the item is: " + oldDescription);
          String newDescription = getInput("What do you want to change the description to?");
          foundItem.setDescription(newDescription);
          System.out.println("The new description of the item is: " + newDescription);
        }
      }
    }
  }

  public Item findChangeableItem() {
    System.out.println("Find item based on either item number or description");
    String itemNumber = getInput("Item Number (Blank if you want to find based on only description)");
    String description = getInput("Description (Blank if you want to find based on only item number");
    return itemRegister.findChangeableItem(itemNumber, description);
  }

  private static void fillWithTestData(ItemRegister itemRegister) {
    itemRegister.registerItem("AQB35", "Korkvinyl Oak Jura Veranatura Eco is an extra comfortable floor panel", 549, "Cortex", 10.5, 1220, 10.5, "Brown", 10, 1);
    itemRegister.registerItem("BAD69", "This is a big window which takes in a lot of sunlight", 1700, "The Window Maker", 17, 2500, 2500, "Clear", 17, 2);
    itemRegister.registerItem("ASD352", "Big door", 3000, "Door company", 250, 1000, 2000, "White", 7, 3);
    itemRegister.registerItem("ASD353", "Small door", 2990, "Door company", 249, 990, 1990, "White", 3, 3);
    itemRegister.registerItem("QWE456", "Big stack of wood", 5000, "Your local lumber-mill", 5000, 3000, 200, "Brown", 30, 4);
    itemRegister.registerItem("YHW96", "Hard wood floor", 699, "Cortex", 12, 1270, 9.3, "White", 4, 1);
  }

  private static String getInput(String name) {
    System.out.println("Please insert " + name);
    return sc.nextLine();
  }
}
