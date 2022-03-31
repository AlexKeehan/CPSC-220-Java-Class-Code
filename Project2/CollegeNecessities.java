import java.util.Scanner;

/**
 * Write a description of class CollegeNecessities here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class CollegeNecessities
{
    /**
     * 
     */
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        System.out.println("How many food bins are available? ");
        int numFood = input.nextInt();
        System.out.println("How many clothes bins are available? " );
        int numClothes = input.nextInt();
        System.out.println("How many texbook bins are available? ");
        int numTextbooks = input.nextInt();
        System.out.println("How many entertainment bins are available? ");
        int numEntertainment = input.nextInt();

        System.out.println("Available number of bins: ");
        System.out.println("Food: " + numFood);
        System.out.println("Clothes: " + numClothes);
        System.out.println("Textbooks: " + numTextbooks);
        System.out.println("Entertainment: " + numEntertainment);
        
        int food = 0;
        int clothes = 0;
        int textbooks = 0;
        int entertainment = 0;
        
        int limit = 20;
        if (numFood >= 0 && numFood < 21) {
            food = numFood;
            limit = limit - food;
            if (numClothes > limit) {
                numClothes = limit;
                clothes = numClothes;
                limit = limit - numClothes;
            }
            else if (numClothes <= limit) {
                clothes = numClothes;
                limit = limit - numClothes;
            }
            if (numTextbooks > limit) {
                numTextbooks = limit;
                textbooks = numTextbooks;
                limit = limit - numTextbooks;
            }
            else if (numTextbooks <= limit) {
                textbooks = numTextbooks;
                limit = limit - numTextbooks;
            }
            if (numEntertainment > limit) {
                numEntertainment = limit;
                entertainment = numEntertainment;
                limit = limit - numEntertainment;
            }
            else if (numEntertainment <= limit) {
                entertainment = numEntertainment;
                limit = limit - numEntertainment;
            }
        }
        
        System.out.println("You should purchase " + food + " food, " + clothes + " clothes, " + textbooks + " textbooks, " + entertainment + " entertainment.");
        
        
    }
}
