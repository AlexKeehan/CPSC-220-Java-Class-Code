import java.util.Scanner;

/**
 * This is the starting file for Lab 9.
 * 
 * @author Dr. Zeitz 
 * @version CPSC 220
 */
public class Lab9
{
    /**
     * The main method tests all four method definitions.
     * 
     * @param args A string array of input arguments
     */
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        
        /**
         * Method one checks to see if a number is even or odd.
         */
        System.out.println("Testing method one");
        
        // Test with real value
        String ans1 = evenOrOdd(7); // odd
        System.out.println("7 is an " + ans1 + " number.");
        
        // Test with user input
        System.out.println("Please enter an integer: ");
        int num = input.nextInt();
        String ans2 = evenOrOdd(num);
        System.out.println("The integer is an " + ans2 + " number.");

        /**
         * Method two checks to see if either of the strings appears
         * at the very end of the other string, ignoring upper/lower
         * case differences (in other words, the computation should
         * not be "case sensitive").
         */
        System.out.println("\nTesting method two");
        
        // Test with real values
        boolean end1 = endOther("Hiabc", "abc"); // true
        boolean end2 = endOther("AbC", "HiaBc"); // true
        boolean end3 = endOther("abcXYZ", "abcDEF"); // false
        System.out.println("The booleans are: " + end1 + ", " + end2 +
                            ", " + end3);
        
        // Test with user input
        System.out.println();
        System.out.println("Please enter the first string: ");
        String first = input.next();
        System.out.println("Please enter the second string: ");
        String second = input.next();
        
        boolean end4 = endOther(first, second);
        if (end4) {
            System.out.println("\nOne of the strings appears at the end of the other string.");
        } else {
            System.out.println("\nNeither of the strings appears at the end of the other string.");
        }

        /**
         * These two methods utilize method overloading, meaning you
         * will write two methods with the same name, but different
         * input parameters. Notice the different input parameter types
         * for the first three method calls compared to the last two
         * method calls. Each method should return the sum of
         * three numbers. However, if one of the numbers is 13 then
         * it does not count toward the sum and the parameters to its
         * right do not count either. So, if the second number is 13,
         * then the second and the third number do not count toward
         * the sum.
         */
        
        System.out.println("\nTesting method three");
        
        // Test with real values
        int sum1 = luckySum(4, 2, 3); // 9
        int sum2 = luckySum(13, 2, 9); // 0
        int sum3 = luckySum(9, 4, 13); // 13
        double sum4 = luckySum(7.2, 3.4, 13.0); //10.6
        double sum5 = luckySum(6.57, 13.0, 10.1); // 6.57
        
        System.out.println("The lucky sums are: " + sum1 + ", " + sum2 +
                            ", " + sum3 + ", " + sum4 + ", " + sum5);
        // Test with user input
        System.out.println("\nPlease enter the first number:");
        int num1 = input.nextInt();
        System.out.println("Please enter the second number:");
        int num2 = input.nextInt();
        System.out.println("Please enter the third number:");
        int num3 = input.nextInt();
        
        int lucky = luckySum(num1, num2, num3);
        System.out.println("The lucky sum is " + lucky);
        
    }
    
    // Please write your methods here. Include JavaDoc method headers.
    /**
     * @param checks to see if ans1 is odd or even
     * @return odd or even
     */
    public static String evenOrOdd(int ans1)
    {
        String answer = "";
        if ((ans1 % 2) == 0) {
            answer = "even";
        } else {
            answer = "odd";
        }
        return answer;
    }
    
    /**
     * @param takes in end1, end2, end3 and end4
     * @return true or false
     */
    public static boolean endOther(String a, String b)
    {
        a = a.toLowerCase();
        b = b.toLowerCase();
        boolean answer = false;
        int length = b.length();
        int length1 = a.length();
        if (a.substring(0, 3).equals(b.substring(length-3, length))) {
            answer = true;
        } else if (a.substring(length1-3, length1).equals(b.substring(0, 3))) {
            answer = true;
        } else if (a.substring(length1-3, length1).equals(b.substring(length-3, length))) {
            answer = true;
        }
        return answer;
    }
    
    /**
     * @param takes in sum1, sum2, and sum3 and adds them together except if there is a 13
     * @return the sum of the numbers
     */
    public static int luckySum(int a, int b, int c)
    {
        int answer = 0;
            if (a == 13) {
            answer = 0;
        } else if (b == 13) {
            answer = a;
        } else if (c == 13) {
            answer = a + b;
        } else {
            answer = a + b + c;
        }
        return answer;
    }
    
    /**
     * @param takes in sum4 and sum5 and does the same thing as the other luckySum, but with doubles
     * @return the sum of the numbers
     */
    public static double luckySum(double a, double b, double c)
    {
        double answer = 0;
        if (a == 13.0) {
            answer = 0;
        } else if (b == 13) {
            answer = a;
        } else if (c == 13) {
            answer = a + b;
        }else {
            answer = a + b + c;
        }
        return answer;
    }
}
