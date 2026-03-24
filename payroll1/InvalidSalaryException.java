// Exception Handling
package payroll;
public class InvalidSalaryException extends Exception 
{
    public InvalidSalaryException(String message) 
	{
        	super(message);
    	}
}