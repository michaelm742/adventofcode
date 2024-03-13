import java.util.Scanner;

public class HelloWorld {

    public static double calculateMealPrice(double listedPrice,
                                          double tipRate,
                                          double taxRate) {
        double tip = tipRate * listedPrice;
        double tax = taxRate * listedPrice;
        double result = tip + tax + listedPrice;
        return result;
    }

    public static void main(String[] args) {
        System.out.println("Order 1");
        double groupTotalMealCost = calculateMealPrice(100, 0.2, 0.08);
        System.out.println(groupTotalMealCost);

        double individualMealCost = groupTotalMealCost / 5;
        System.out.println(individualMealCost);

    }
}
