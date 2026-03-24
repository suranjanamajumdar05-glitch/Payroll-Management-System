// Inheritance & Polymorphism
package payroll;
public class PartTimeEmployee extends Employee 
{
    private double hourlyRate;
    private int hoursWorked;
    public PartTimeEmployee(int id, String name, double hourlyRate, int hoursWorked) 
	{
        	super(id, name);
        	this.hourlyRate = hourlyRate;
        	this.hoursWorked = hoursWorked;
    	}
    public double calculateSalary() 
	{
        	return hourlyRate * hoursWorked;
    	}
}