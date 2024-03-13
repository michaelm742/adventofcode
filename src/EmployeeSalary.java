public class EmployeeSalary {

    public static double calculateSalary(double hoursPerWeek,
                                            double amountPerHour) {
        if (hoursPerWeek < 0 || amountPerHour < 0) {
            return 0;
        }

        else {

            return hoursPerWeek * amountPerHour * 52;
        }
    }

    public static void main(String[] args) {
        double employee1sSalary = calculateSalary(40, 20);
        System.out.println("Employee 1's annual salary is:");
        System.out.println(employee1sSalary);

        double employee2sSalary = calculateSalary(85.5, 35);
        System.out.println("Employee 2's annual salary is:");
        System.out.println(employee2sSalary);

        double employee3sSalary = calculateSalary(0, 35);
        System.out.println("Employee 3's annual salary is:");
        System.out.println(employee3sSalary);

        double employee4sSalary = calculateSalary(85.5, -3);
        System.out.println("Employee 4's annual salary is:");
        System.out.println(employee4sSalary);
    }
}
