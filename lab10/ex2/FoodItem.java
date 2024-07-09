

public class FoodItem {
    private String description;
    private FoodType type;

    public FoodItem(String description, FoodType type) {
        this.description = description;
        this.type = type;
    }

    public FoodType getFoodType() {
        return type;
    }

    public String getDescription() {
        return description;
    }
}
