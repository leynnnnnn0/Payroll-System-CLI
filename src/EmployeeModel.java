import java.util.InputMismatchException;
import java.util.Scanner;

public class EmployeeModel implements MainMethods {
    private String fullName;
    private long phoneNumber;
    private int hoursWorked;
    private int hoursOvertime;
    private double salaryRate;
    private double grossPay;
    private double governmentDeductions;
    private double netPay;

    public EmployeeModel(String fullName, long phoneNumber) {
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;

    }

    public EmployeeModel(String fullName, long phoneNumber, int hoursWorked, int hoursOvertime, double salaryRate, double grossPay, double governmentDeductions, double netPay) {
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.hoursWorked = hoursWorked;
        this.hoursOvertime = hoursOvertime;
        this.salaryRate = salaryRate;
        this.grossPay = grossPay;
        this.governmentDeductions = governmentDeductions;
        this.netPay = netPay;
    }

    public double getSalaryRate() {
        return salaryRate;
    }

    public void setSalaryRate(double salaryRate) {
        this.salaryRate = salaryRate;
    }

    public int getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(int hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    public int getHoursOvertime() {
        return hoursOvertime;
    }

    public void setHoursOvertime(int hoursOvertime) {
        this.hoursOvertime = hoursOvertime;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public double getGrossPay() {
        return grossPay;
    }

    public void setGrossPay(double grossPay) {
        this.grossPay = grossPay;
    }

    public double getGovernmentDeductions() {
        return governmentDeductions;
    }

    public void setGovernmentDeductions(double governmentDeductions) {
        this.governmentDeductions = governmentDeductions;
    }

    public double getNetPay() {
        return netPay;
    }

    public void setNetPay(double netPay) {
        this.netPay = netPay;
    }

    public static EmployeeModel addEmployee() {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the full name: ");
        String fullName = in.nextLine().trim();
        if(MainMethods.isExisting(fullName)) {
            System.out.println("Employee already exist.");
            return null;
        }
        long phoneNumber;
        // While loop to continue while the user is not putting a correct value
        while(true) {
            // Created a try and catch block to catch error if the user put a string instead of a number
            try {
                System.out.print("Enter the phone number: ");
                phoneNumber = in.nextLong();
                // Checking if the phone number is valid
                if(String.valueOf(phoneNumber).startsWith("9") && String.valueOf(phoneNumber).length() == 10) {
                    break;
                }
                System.out.println("Please input a correct phone number.");
            }catch (InputMismatchException e) {
                System.out.println("Please input a correct phone number.");
            }finally {
                // To make sure that the line will be used
                in.nextLine();
            }
        }
        // Returning an object of employee
        return new EmployeeModel(fullName, phoneNumber);
    }
}

//2882
//email support@gcash
// 0272139999 8 to 5 sunday