package mappevurdering;

import java.util.Arrays;
import java.util.Optional;

public enum Category {

  FLOOR(1, "Floor"),
  WINDOWS(2, "Windows"),
  DOORS(3, "Doors"),
  LUMBER(4, "Lumber");

  private final int categoryNumber;
  private final String categoryString;

  Category(int categoryNumber, String categoryString) {
    this.categoryNumber = categoryNumber;
    this.categoryString = categoryString;
  }

  public int getCategoryNumber() {
    return categoryNumber;
  }

  public String getCategoryString() {
    return categoryString;
  }


  public static Optional<Category> getCategoryByNumber(int value) {
    return Arrays.stream(Category.values())
            .filter(category -> category.categoryNumber == value)
            .findFirst();
  }
}