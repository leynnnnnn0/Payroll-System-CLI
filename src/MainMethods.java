import java.io.*;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public interface MainMethods {
    // I used hashmap for employees data to avoid using loops to improve time complexity
    HashMap<String, EmployeeModel> employees = getAllEmployees();

    static HashMap<String, EmployeeModel> getAllEmployees() {
        HashMap<String, EmployeeModel> employees = new HashMap<>();
        try {
            BufferedReader file = new BufferedReader(new FileReader("employeesDB.txt"));
            // To start readings file from the second line
            file.readLine();
            String line;
            // while line is not equals to null or empty line the loop will continue
            while((line = file.readLine()) != null) {
                // Converting the string to array
                String[] data = line.split("\\|");
                // Creating an employee model object
                employees.put(data[0].trim(), new EmployeeModel(data[0], Long.parseLong(data[1].trim())));
            }
        }catch(IOException e) {
            System.out.println(e.getMessage());
        }
        // Returning an array of employee model by using toArray method
        return employees;
    }
    // Function to add employee info to employeesDB.txt
    static void inputNewEmployeeToDatabase(EmployeeModel emp) {
        try {
            // Writing a text to a file
            BufferedWriter file = new BufferedWriter(new FileWriter("employeesDB.txt", true));
            // Writing a file with this format
            file.write(
                    emp.getFullName() + " | " +
                            emp.getPhoneNumber() + " | " +
                            0 + " | " +
                            0 + " | " +
                            0 + " | " +
                            0 + " | " +
                            0 +
                            "\n"
            );
            file.close();
            System.out.println("Added!");
        }catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    // Function to check if the user already exist on the database
    static boolean isExisting(String fullName) {
        return employees.containsKey(fullName);
    }

    static void setHours() {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter your full name: ");
        String fullName = in.nextLine().trim();
        if(!MainMethods.isExisting(fullName)) {
            System.out.println("No data found.");
        }
        EmployeeModel emp = employees.get(fullName);
        try {
            System.out.print("Enter your hours worked: ");
            emp.setHoursWorked(in.nextInt());
            updateEmployeesDatabase();
        }catch(InputMismatchException e) {
            System.out.println("Input a valid number. ");
        }
    }

    static void updateEmployeesDatabase() {
        try {
            BufferedWriter file = new BufferedWriter(new FileWriter("employeesDB.txt"));
            file.write("FULL NAME | PHONE NUMBER | HOURS WORKED | OVERTIME HOURS | GROSS PAY | DEDUCTIONS | NET PAY\n");
            for(Map.Entry<String, EmployeeModel> employee : employees.entrySet()) {
                file.append(employee.getValue().getFullName()).append(" | ")
                        .append(String.valueOf(employee.getValue().getPhoneNumber()))
                        .append(" | ").append(String.valueOf(employee.getValue().getHoursWorked()))
                        .append(" | ").append(String.valueOf(employee.getValue().getHoursOvertime()))
                        .append(" | ").append(String.valueOf(employee.getValue().getGrossPay()))
                        .append(" | ").append(String.valueOf(employee.getValue().getGovernmentDeductions()))
                        .append(" | ").append(String.valueOf(employee.getValue().getNetPay()))
                        .append("\n");
            }
            file.close();
            System.out.println("Database updated.");
        } catch(IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
