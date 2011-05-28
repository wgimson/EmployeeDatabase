package personal;
/**
 * Program name: Personal
 * Author: W. H. Gimson
 * Written: 05-26-2011
 */
public class SalariedEmployee extends Employee {

    // Instance variables
    private double annualSalary;
    private double wage;
    private String name;

    // Constructor
    public SalariedEmployee(String name, double wage, double salary) {
        super(name, wage);
        this.annualSalary = salary;
        this.wage = this.annualSalary / 2000;
    }

    // Getter method
    public double getAnnualSalary() {
        return this.annualSalary;
    }

    // Setter method
    public void setAnnualSalary(double salary) {
        this.annualSalary = salary;
    }

    // Overriden methods
    @Override
    public double computePay(double hours) {
        double pay = (this.wage) * hours;
        return pay;
    }

    @Override
    public void raisePay(double percentAmount) {
        this.annualSalary +=
                (this.annualSalary * (percentAmount / 100));
        this.wage = this.annualSalary / 2000;
    }

    @Override
    public String toString() {
        return this.getName() + " " + "$" +
                this.getAnnualSalary() + " / year";
    }
}
