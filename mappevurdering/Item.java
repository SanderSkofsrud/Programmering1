package mappevurdering;

import java.util.Objects;
import java.util.Optional;

/**
 * Class that contains the constructor.
 */
public class Item {

  String itemNumber;
  String description;
  String brand;
  String color;
  int price;
  int quantity;
  int category;
  double weight;
  double length;
  double height;
  double discount;

  /**
   * Constructs item containing the given variables.
   *
   * @param itemNumber  The number/ID of the item
   * @param description A description of the item
   * @param price       The price of the item
   * @param brand       The brand of the item
   * @param weight      The weight of the item
   * @param length      The length of the item
   * @param height      The height of the item
   * @param color       The color of the item
   * @param quantity    The amount of the item in stock
   * @param category    The category of the item
   */
  public Item(String itemNumber, String description, int price, String brand, double weight,
              double length, double height, String color, int quantity, int category) {
    if (price < 0) {
      throw new IllegalArgumentException("The price can not be negative");
    }
    if (weight <= 0.0) {
      throw new IllegalArgumentException("The weight can not be negative");
    }
    if (length <= 0.0) {
      throw new IllegalArgumentException("The length can not be negative");
    }
    if (height <= 0.0) {
      throw new IllegalArgumentException("The height can not be negative");
    }
    if (quantity < 0) {
      throw new IllegalArgumentException("The amount of an item must be greater than 0");
    }
    if (category < 1 || category > 4) {
      throw new IllegalArgumentException("You must enter a valid category");
    }
    this.itemNumber = itemNumber;
    this.description = description;
    this.price = price;
    this.brand = brand;
    this.weight = weight;
    this.length = length;
    this.height = height;
    this.color = color;
    this.quantity = quantity;
    this.category = category;
    this.discount = 0;
  }

  /**
   * Deep copy class to prevent unwanted changes.
   *
   * @param item contains all information about any given item
   */
  public Item(Item item) {
    this.itemNumber = item.getItemNumber();
    this.description = item.getDescription();
    this.price = item.getPrice();
    this.brand = item.getBrand();
    this.weight = item.getWeight();
    this.length = item.getLength();
    this.height = item.getHeight();
    this.color = item.getColor();
    this.quantity = item.getQuantity();
    this.category = item.getCategory();
    this.discount = item.getDiscount();
  }

  /**
   * Returns the item number of the given item.
   *
   * @return Returns the item number of the given item
   */
  public String getItemNumber() {
    return itemNumber;
  }

  /**
   * Returns the description of the given item.
   *
   * @return the description of the given item
   */
  public String getDescription() {
    return description;
  }

  /**
   * Returns the price of the given item.
   *
   * @return Returns the price of the given item
   */
  public int getPrice() {
    return price;
  }

  /**
   * Returns the brand of the given item.
   *
   * @return Returns the brand of the given item
   */
  public String getBrand() {
    return brand;
  }

  /**
   * Returns the weight of the given item.
   *
   * @return Returns the weight of the given item
   */
  public double getWeight() {
    return weight;
  }

  /**
   * Returns the length of the given item.
   *
   * @return Returns the length of the given item
   */
  public double getLength() {
    return length;
  }

  /**
   * Returns the height of the given item.
   *
   * @return Returns the height of the given item
   */
  public double getHeight() {
    return height;
  }

  /**
   * Returns the color of the given item.
   *
   * @return Returns the color of the given item
   */
  public String getColor() {
    return color;
  }

  /**
   * Returns the quantity of the given item.
   *
   * @return Returns the quantity of the given item
   */
  public int getQuantity() {
    return quantity;
  }

  /**
   * Returns the number of the category of the given item.
   *
   * @return Returns the category of the given item
   */
  public int getCategory() {
    return category;
  }

  /**
   * Returns the discount of the given item.
   *
   * @return Returns the discount of the given item
   */
  public double getDiscount() {
    return discount;
  }

  /**
   * Returns the price after adding the discount associated with the given item.
   *
   * @return Returns the price after adding the discount associated with the given item
   */
  public int getDiscountedPrice() {
    double discountPercent = 1 - (this.discount / 100);
    return (int) (this.price * discountPercent);
  }

  /**
   * Returns the name of the category of the given item.
   *
   * @return Returns the name of the category of the given item
   */
  public String getCategoryString() {
    Optional<Category> getCategory = Category.getCategoryByNumber(category);
    return getCategory.map(Category::getCategoryString).orElse(null);
  }

  /**
   * Sets the description of a given item.
   *
   * @param description contains the description of the item
   */
  public void setDescription(String description) {
    this.description = description;
  }

  /**
   * Sets the price of a given item.
   *
   * @param price contains the price of the item
   */
  public void setPrice(int price) {
    this.price = price;
  }

  /**
   * Updates the quantity of the stock of a given item.
   *
   * @param quantity Parameter that contains the quantity of the item
   */
  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }

  /**
   * Sets the discount of a given item.
   *
   * @param discount contains the discount of a given item
   */
  public void setDiscount(double discount) {
    this.discount = discount;
  }

  /**
   * Formulates all information about an item into a string.
   *
   * @return Returns the information about an item formulated into a string
   */
  @Override
  public String toString() {
    return "Item Number: " + itemNumber + '\'' + ", Description: " + description + '\''
            + ", Brand: " + brand + '\'' + ", Color: " + color + '\'' + ", Price: " + price
            + ", Quantity: " + quantity + ", Category: " + getCategoryString()
            + ", Weight: " + weight + ", Length: " + length + ", Height: " + height;
  }

  /**
   * Formulates given information about an item into a string.
   *
   * @return Returns the information about an item formulated into a string
   */
  public String toShortString() {
    return "Item Number: " + itemNumber + '\'' + ", Description: " + description;
  }

  /**
   * @param o
   * @return
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Item item = (Item) o;
    return itemNumber.equals(item.itemNumber);
  }

  /**
   * @return
   */
  @Override
  public int hashCode() {
    return Objects.hash(itemNumber);
  }
}
