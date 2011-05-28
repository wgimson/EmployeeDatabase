package personal;
/**
 * Program name: Personal
 * Author: W. H. Gimson
 * Written: 05-26-2011
 */
public class HourlyEmployee extends Employee {

    // Constructor
    public HourlyEmployee(String name, double wage) {
        super(name, wage);
    }

    // Overriden methods
    @Override
    public double computePay(double hours) {
        if (hours > 40) {
            double overTime = hours - 40;
            double timeAndAHalf = this.getWage() * 1.5;
            double pay = (40 * this.getWage()) + (overTime * timeAndAHalf); 
            return pay;
        } else {
            double pay = hours * this.getWage();
            return pay;
        }
    }

    @Override
    public void raisePay(double percentAmount) {
        this.employeeWage +=
                (this.employeeWage * (percentAmount / 100));
    }

    @Override
    public String toString() {
        return this.getName() + " " + "$" + this.getWage() + " /hour";
    }
}
