

public class Restaurant {
    public static void main(String[] args) {

        Chef sushiChef = new SushiChef();
        Chef pastaChef = new PastaChef();
        Chef burgerChef = new BurgerChef();
        Chef pizzaChef = new PizzaChef();
        Chef dessertChef = new DessertChef();

        sushiChef.setNextChef(pastaChef);
        pastaChef.setNextChef(burgerChef);
        burgerChef.setNextChef(pizzaChef);
        pizzaChef.setNextChef(dessertChef);


        System.out.println("\nCan I please get a veggie burger?");
        FoodItem veggieBurger = new FoodItem("veggie burger", FoodType.BURGER);
        sushiChef.cook(veggieBurger);

        System.out.println("\nCan I please get a Pasta Carbonara?");
        FoodItem pastaCarbonara = new FoodItem("Pasta Carbonara", FoodType.PASTA);
        sushiChef.cook(pastaCarbonara);

        System.out.println("\nCan I please get a PLAIN pizza, no toppings!?");
        FoodItem plainPizza = new FoodItem("PLAIN pizza, no toppings", FoodType.PIZZA);
        sushiChef.cook(plainPizza);

        System.out.println("\nCan I please get a sushi nigiri and sashimi?");
        FoodItem sushi = new FoodItem("sushi nigiri and sashimi", FoodType.SUSHI);
        sushiChef.cook(sushi);

        System.out.println("\nCan I please get a salad with tuna?");
        FoodItem salad = new FoodItem("salad with tuna", FoodType.SALAD);
        sushiChef.cook(salad);

        System.out.println("\nCan I please get a strawberry ice cream and waffles dessert? ");
        FoodItem dessert = new FoodItem("strawberry ice cream and waffles dessert", FoodType.DESSERT);
        sushiChef.cook(dessert);

    }
}
