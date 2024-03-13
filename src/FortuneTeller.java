import java.util.Scanner;

public class FortuneTeller {
    public static void main(String[] args) {
        int chosenNumber = 5;

        System.out.println("Pick a number between 1 and 10");

        Scanner input = new Scanner(System.in);
        chosenNumber = input.nextInt();

        if (chosenNumber < 5) {
            System.out.println("Many lucky wish for him and you!");
        }
        else {
            System.out.println("Me love you long time!");
        }
    }
}
