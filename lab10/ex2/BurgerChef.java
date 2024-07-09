

public class BurgerChef extends Chef {
    private Chef nextChef = null;
    private FoodType specialized = FoodType.BURGER;

    public void cook(FoodItem food) {
        if (canCook(food)) {
            System.out.println(this.getClass().getName() + ": Starting to cook " + food.getDescription() + ". Out in 19 minutes!");
        } else {
            System.out.println(this.getClass().getName() + ": I can't cook that.");
            if (nextChef != null) {
                nextChef.cook(food);
            } else {
                System.out.println("We're sorry but that request can't be satisfied by our service!");
            }
        }
    }

    public void setNextChef(Chef c) {
        this.nextChef = c;
    }

    private boolean canCook(FoodItem food) {
        if (food.getFoodType() == this.specialized)
            return true;
        return false;
    }
}
