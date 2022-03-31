import java.util.Scanner;

/**
 * Write a description of class WrapPresents here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class WrapPresents
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        System.out.println("How many identical presents do you need to wrap?");
        double presents = input.nextDouble();
        System.out.println("Enter the length in inches: ");
        double length = input.nextDouble();
        System.out.println("Enter the width in inches: ");
        double width = input.nextDouble();
        System.out.println("Enter the height in inches: ");
        double height = input.nextDouble();
        //getting all the measurements
        
        double math = 2.000000*(length * width + length * height + width * height);
        //surface area calculation
        
        double total = math * presents;
        //total presents surface area
        
        double rolls = 96 * 30;
        //1 roll surface area
        
        double totalrolls = total / rolls;
        //unrounded how many rolls needed
        
        double totalrollsneeded = (Math.ceil(totalrolls));        
        //rounded how many rolls needed
        
        int Inttotalrollsneeded = (int)totalrollsneeded;
        //change double to int for rolls needed
        
        double rollcost = 3.50;
        //cost of rolls
        
        double totalrollcost = rollcost * totalrollsneeded;
        //total cost of rolls
        
        System.out.println("To wrap " + total + " inches of surface area, you should purchase " + Inttotalrollsneeded + " roll(s) for $ " + totalrollcost);
        //final print of all information
    }
        
}
