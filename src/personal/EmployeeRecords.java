package personal;
import personal.jpb.*;
/**
 * Program name: Personal
 * Author: W. H. Gimson
 * Written: 05-26-2011
 */
public class EmployeeRecords {
    public static void main(String[] args) {
        // Introduction
        System.out.println("Hello and welcome to the employee registry. You"
                + " \nwill be prompted to enter one of the following..."
                + " \n'n' - to enter a new employee into the registry"
                + " \n'p' - to compute the weekly paycheck of an employee"
                + " \n'r' - to increase the wage of an employee in the registry"
                + " \n'q' - to quit.");

        // Variables and employee array
        String command = null;
        Employee[] employeeRecords = new Employee[1];
        int employeeNumber = 0;

        while (true) {
            // Initial prompt
            SimpleIO.prompt("\nCommands: n - New employee \n          "
                    + "p - Compute paychecks \n          r - Raise wages"
                    + "\n          q - Quit \n");
            command = SimpleIO.readLine();

            // Prompt validation loop
            while(!(command.equalsIgnoreCase("n") || 
                    command.equalsIgnoreCase("p") ||
                    command.equalsIgnoreCase("r") ||
                    command.equalsIgnoreCase("q"))) {
                System.err.println("Command was not recognized; "
                        + "please try again.");
                SimpleIO.prompt("\nCommands: n - New employee \n          "
                        + "p - Compute paychecks \n          r - Raise wages "
                        + "\n          q - Quit\n");
                command = SimpleIO.readLine();
            }

            if (command.equalsIgnoreCase("n")) {

                // Check employee type
                String employeeName = checkEmployeeName();
                String hourlyOrSalaried = checkHourlyOrSalaried();
                double employeePay = checkEmployeeWage(hourlyOrSalaried);

                // Create new hourly or salaried employee object in employee
                //array and increase array size, if necessary
                if (hourlyOrSalaried.equalsIgnoreCase("h")) {
                    employeeRecords = resizeEmployeeArray
                            (employeeRecords, employeeNumber);
                    employeeRecords[employeeNumber] =
                            new HourlyEmployee(employeeName,
                            employeePay);
                    employeeNumber++;

                } else {
                    employeeRecords = resizeEmployeeArray
                            (employeeRecords, employeeNumber);
                    employeeRecords[employeeNumber] =
                            new SalariedEmployee(employeeName,
                            (employeePay / 2000), employeePay);
                    employeeNumber++;
                }
            } else if (command.equalsIgnoreCase("p")) {
                for (int i = (employeeNumber - 1); i >= 0; i--) {
                    while (true) {
                        SimpleIO.prompt("Enter the number of hours worked by "
                                + employeeRecords[i].getName() + ": ");
                        String usersInput = SimpleIO.readLine();
                        try {
                            double employeeHours =
                                    Double.parseDouble(usersInput);
                            System.out.println(employeeRecords[i].
                                    computePay(employeeHours));
                            break;
                        } catch (NumberFormatException e) {
                            System.err.println("Input was not a number; "
                                    + "please try again.");
                        }
                    }
                }
            } else if (command.equalsIgnoreCase("r")) {
                while (true) {
                    SimpleIO.prompt("Enter percentage increase: ");
                    String usersInput = SimpleIO.readLine();
                    try {
                        double percentageIncrease  =
                                Double.parseDouble(usersInput);
                        System.out.println("\nNew Wages");
                        System.out.println("----------");
                        for (int i = (employeeNumber - 1); i >= 0; i--) {
                            employeeRecords[i].raisePay(percentageIncrease);
                            System.out.println(employeeRecords[i].toString());
                            }
                        break;
                    } catch (NumberFormatException e) {
                        System.err.println("Input was not a number;"
                                + " please try again.");
                    }
                }
            } else {
                return;
            }
        }
     }

    ////////////////////////////////////////////////////////////////////////////
    // NAME:       checkEmployeeName
    // BEHAVIOR:   Prompt the user for and reads a name for an Employee object
    // PARAMETERS: None
    // RETURNS:    A string representing the name of an Employee object
    ////////////////////////////////////////////////////////////////////////////
     private static String checkEmployeeName() {
         // Initial prompt
         SimpleIO.prompt("Please enter the name of new employee: ");
         String employeeName = SimpleIO.readLine();
         return employeeName;
     }

     ///////////////////////////////////////////////////////////////////////////
     // NAME:       checkHourlyOrSalaried
     // BEHAVIOR:   Prompts the user to enter 'h' or 's', depending upon whether
     //             the Employee object in question is a SalariedEmployee or
     //             an HourlyEmployee. Checks validity of input.
     // PARAMETERS: None
     // RETURNS:    A string 's' or 'h'
     ///////////////////////////////////////////////////////////////////////////
     private static String checkHourlyOrSalaried() {
         // Class method variable
         String hourlyOrSalaried;

         // Initial prompt
         SimpleIO.prompt("Hourly (h) or salaried (s): ");
         hourlyOrSalaried = SimpleIO.readLine();

         // Prompt validation loop
         while (!(hourlyOrSalaried.equalsIgnoreCase("h") ||
                 hourlyOrSalaried.equalsIgnoreCase("s"))) {
             System.err.println("Input was not 'h' or 's'; please try again.");
             SimpleIO.prompt("Hourly (h) or salaried (s): ");
             hourlyOrSalaried = SimpleIO.readLine();
         }
         return hourlyOrSalaried;
     }

     ///////////////////////////////////////////////////////////////////////////
     // NAME:       checkEmployeeWage
     // BEHAVIOR:   Prompts the user for, validates and reads an employee's
     //             hourly wage or annual salary
     // PARAMETERS: A string of either 'h' or 's', depending upon whether the
     //             Employee object in question is paid hourly or salaried
     // RETURNS:    A double representing the employee objects pay
     ///////////////////////////////////////////////////////////////////////////
     private static double checkEmployeeWage(String payType) {
         while(true) {
             if (payType.equalsIgnoreCase("h")) {
                 SimpleIO.prompt("Enter hourly wage: ");
                 String usersInput = SimpleIO.readLine();
                 try {
                     double employeePay = Double.parseDouble(usersInput);
                     return employeePay;
                 }  catch (NumberFormatException e) {
                     System.err.println("Input was not a number; "
                             + "please try again.");
                 }
             } else {
                 SimpleIO.prompt("Enter annual salary: ");
                 String usersInput = SimpleIO.readLine();
                 try {
                     double employeePay = Double.parseDouble(usersInput);
                     return employeePay;
                 }  catch (NumberFormatException e) {
                     System.err.println("Input was not a number; "
                             + "please try again.");
                 }
             }
         }
     }

     ///////////////////////////////////////////////////////////////////////////
     // NAME:       resizeEmployeeArray
     // BEHAVIOR:   Doubles the size of the array used to store Employee objects
     //             if full
     // PARAMETERS: An Employee array and an int primitive representing the
     //             number of Employee objects in the array
     // RETURNS:    An array of Employee objects double the length of the
     //             original
     ///////////////////////////////////////////////////////////////////////////
     private static Employee[] resizeEmployeeArray
             (Employee[] oldEmployeeArray, int arrayNumber) {
         if (arrayNumber == oldEmployeeArray.length) {
             Employee[] tempArray = new Employee[oldEmployeeArray.length*2];
             for (int i = 0; i < oldEmployeeArray.length; i++) {
                 tempArray[i] = oldEmployeeArray[i];
             }
             oldEmployeeArray = tempArray;
             return oldEmployeeArray;
         }
         else return oldEmployeeArray;
     }
}



