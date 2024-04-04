import java.io.*;
import java.util.ArrayList;

public interface MainMethods {
    EmployeeModel[] employees = getAllEmployees();

    static EmployeeModel[] getAllEmployees() {
        ArrayList<EmployeeModel> employees = new ArrayList<>();
        try {
            BufferedReader file = new BufferedReader(new FileReader("employees.txt"));
            file.readLine();
            String line;
            while((line = file.readLine()) != null) {
                String[] data = line.split("\\|");
            }
        }catch(IOException e) {
            System.out.println(e.getMessage());
        }
        return employees.toArray(new EmployeeModel[0]);
    }
    // Function to add employee info to employees.txt
    static void inputNewEmployeeToDatabase(EmployeeModel emp) {
        try {
            // Writing a text to a file
            BufferedWriter file = new BufferedWriter(new FileWriter("employees.txt", true));
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
        try {
            BufferedReader file = new BufferedReader(new FileReader("employees.txt"));
            String line;
            // Checking if the file line is not null
            while((line = file.readLine()) != null) {
                // Converting the line file line to an array and separating by |
                String[] data = line.split("\\|");
                if(data[0].trim().equalsIgnoreCase(fullName)) {
                    file.close();
                    return true;
                }
            }
        }catch(IOException e) {
            System.out.println("error");
        }
        return false;
    }
}
