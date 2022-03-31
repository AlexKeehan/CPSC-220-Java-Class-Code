import java.util.Scanner;
/**
 * Write a description of class Lab6 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Lab6
{
    /**
     * 
     */
    public static void main(String[] args)   
    {
        Scanner input = new Scanner(System.in);
        String end = "y";
        String var = "y";
        double sum = 0;
        while (var.equals(end)) {
            System.out.println("Enter a number: ");
            double num = input.nextDouble();
            System.out.println("Do you want to add to the sum (y/n): ");
            var = input.next();
            sum = sum + num;
        }
        
        System.out.println("The sum is " + sum);
    }
    
}
