// Required Business Logic & Collections
package payroll;
import java.util.ArrayList;
public class PayrollService 
{
    private ArrayList<Employee> employees;
    public PayrollService()
	{
        	employees = new ArrayList<Employee>();
    	}
    public void addEmployee(Employee emp) 
	{
        	employees.add(emp);
    	}
    public ArrayList<Employee> getEmployees() 
	{
        	return employees;
    	}
    public double getTotalPayroll() 
	{
        	double total = 0;
        	for(Employee emp : employees) 
		{
            		total = total + emp.calculateSalary();
        	}
        return total;
    	}
}