package personal;
/**
 * Program name: Personal
 * Author: W. H. Gimson
 * Written: 05-26-2011
 * 
 */
public abstract class Employee {
    // Instance variables
    protected String employeeName;
    protected double employeeWage;

    // Constructor
    public Employee(String name, double wage) {
        this.employeeName = name;
        this.employeeWage = wage;
    }

    // Getter methods
    public String getName() {
        return employeeName;
    }

    public double getWage() {
        return employeeWage;
    }

    // Setter methods
    public void setName(String name) {
        employeeName = name;
    }

    public void setWage(double wage) {
        employeeWage = wage;
    }

    public void increaseWage(double percent) {
        employeeWage += employeeWage * (percent / 100);
    }

    // Abstract methods
    public abstract double computePay(double hours);

    public abstract void raisePay(double percentAmount);
}
