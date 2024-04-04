import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

public interface MainMethods {
    HashMap<String, EmployeeModel> employees = getAllEmployees();

    static HashMap<String, EmployeeModel> getAllEmployees() {
        HashMap<String, EmployeeModel> employees = new HashMap<>();
        try {
            BufferedReader file = new BufferedReader(new FileReader("employees.txt"));
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
    // Function to add employee info to employees.txt
    static void inputNewEmployeeToDatabase(EmployeeModel emp) {
        try {
            // Writing a text to a file
            BufferedWriter file = new BufferedWriter(new FileWriter("employees.txt", true));
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
    public static boolean isExisting(String fullName) {
        return employees.containsKey(fullName);
    }
}
