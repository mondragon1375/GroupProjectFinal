package com.example.groupprojectfinal;

public class Food {
    private String foodName;
    private double foodCost;

    public Food(String foodname, double foodprice){
        this.foodName = foodname;
        this.foodCost = foodprice;
    }

    public static final Food[] drinksMenu = {
            new Food("Coca Cola", 2.75),
            new Food("Sprite", 2.75),
            new Food("Fanta Orange", 2.75),
            new Food("Ginger Ale", 2.75),
            new Food("Root Beer", 2.75),
            new Food("Apple Juice", 2.50),
            new Food("Orange Juice", 2.50),
            new Food("Fruit Punch", 2.50),
            new Food("Lemonade", 2.00),
            new Food("Iced Tea", 2.00)
    };

    public static final Food[] kidsMenu = {
            new Food("Hot Dog", 5.29),
            new Food("Cheeseburger", 7.49),
            new Food("Grilled Cheese", 6.79),
            new Food("Lasagna", 7.29),
            new Food("Cheese Pizza", 5.79),
            new Food("Chicken Quesadilla", 6.99),
            new Food("Mac and Cheese", 7.49),
            new Food("Chicken Tenders", 6.79),
            new Food("Popcorn Shrimp", 6.79),
            new Food("Fruit Salad", 5.49)
    };

    public static final Food[] adultsMenu = {
            new Food("Asian Stir Fry", 8.49),
            new Food("Country Style Steak", 10.79),
            new Food("Breaded Ravioli", 9.49),
            new Food("Parmesan Chicken", 8.49),
            new Food("Honey Teriyaki Chicken", 10.99),
            new Food("Smoked Brisket", 9.49),
            new Food("Taco Salad", 9.29),
            new Food("Baked Fish", 8.29),
            new Food("Shrimp Fajitas", 10.49),
            new Food("Baby Back Ribs", 11.49),
            new Food("BBQ Baked Beans", 8.49),
            new Food("Broccoli and Cheese Soup", 7.79),
            new Food("Chicken Noodle Soup", 7.79),
            new Food("Caesar Salad", 7.29),
            new Food("Chicken Salad", 7.29)
    };

    public static final Food[] dessertMenu = {
            new Food("Apple Pie", 6.49),
            new Food("Carrot Cake", 6.49),
            new Food("Red Velvet Cake", 6.49),
            new Food("Churros", 5.29),
            new Food("Chocolate Chip Cookies", 4.79),
            new Food("Banana Pudding", 4.29),
            new Food("Orange Sherbet", 5.29),
            new Food("Vanilla Ice Cream", 5.49),
            new Food("Chocolate Ice Cream", 5.49),
            new Food("Cookies and Cream Ice Cream", 5.99)
    };

    public String toString(){
        return foodName + ", $" + foodCost;
    }

    public String getFoodName(){
        return foodName;
    }

    public double getFoodCost(){
        return foodCost;
    }

}
