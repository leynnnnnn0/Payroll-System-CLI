import java.util.Scanner;

public class Main implements MainMethods {
    public static void main(String[] args) {
        EmployeeModel emp = EmployeeModel.addEmployee();
        if(emp != null) {
            MainMethods.inputNewEmployeeToDatabase(emp);
        }
    }

    public static void setHours() {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter your full name: ");
        String fullName = in.nextLine();
        if(!MainMethods.isExisting(fullName)) {
            System.out.println("No data found.");
        }

    }
}