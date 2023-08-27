package mappevurdering;

import java.util.ArrayList;
import java.util.Objects;

public class ItemRegister {

  final ArrayList<Item> items;

  public ItemRegister() {
    this.items = new ArrayList<>();
  }

  public Item registerItem(String itemNumber, String description, int price, String brand, double weight, double length, double height, String color, int quantity, int category) {
    Item newItem = new Item(itemNumber, description, price, brand, weight, length, height, color, quantity, category);
    if (items.contains(newItem)) {
      throw new IllegalArgumentException("Already registered");
    }
    items.add(newItem);
    return newItem;
  }

  public Item findItem(String itemNumber, String description) {
    for (Item i : items) {
      if (Objects.equals(i.getItemNumber(), itemNumber) || Objects.equals(i.getDescription(), description)) {
        return new Item(i);
      }
    }
    return null;
  }

  public Item findChangeableItem(String itemNumber, String description) {
    for (Item i : items) {
      if (Objects.equals(i.getItemNumber(), itemNumber) || Objects.equals(i.getDescription(), description)) {
        return i;
      }
    }
    return null;
  }

  public int updateQuantity(int quantity, String itemNumber, String description) {
    Item item = findItem(itemNumber, description);
    int newQuantity = item.getQuantity();
    newQuantity += quantity;
    item.setQuantity(newQuantity);
    return item.getQuantity();
  }

  public boolean removeItem(String itemNumber, String description) {
    return items.remove(findItem(itemNumber, description));
  }

  @Override
  public String toString() {
    StringBuilder allItems = new StringBuilder();
    for (Item i : items) {
      allItems.append(i).append("\n");
    }
    return String.valueOf(allItems);
  }
}
