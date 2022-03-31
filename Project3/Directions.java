import java.util.Scanner;
import java.io.FileInputStream;
import java.io.PrintWriter;
import java.io.FileOutputStream;
import java.io.IOException;
/**
 * Write a description of class Directions here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Directions
{
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter the name of the text file: ");
        String fileName = input.next();
        // get the file name
        System.out.println("What is the price per gallon of gas?");
        double gasPrice = input.nextDouble();
        // get the price of gas
        System.out.println("What is your vehicle's ful efficiency in miles per gallon?");
        double fuelEff = input.nextDouble();
        //get the fuel efficiency
                
        int count = 0;
        FileInputStream fileIn = new FileInputStream(fileName);
        Scanner inputInFile = new Scanner(fileIn);
        // opening input file
        while(inputInFile.hasNextLine()) {
             String temp = inputInFile.nextLine();
             count++;
        } 
        //read how many lines are in the file, so that I can create an array
        fileIn.close();
        String[] tempDirec = new String[count];
        // make the array to store the original version of the file
        String[] directions = new String[count];
        // make the array to store the reversed version of the file
        int i = 0;
        FileInputStream fileIn2 = new FileInputStream(fileName);
        Scanner inputInFile2 = new Scanner(fileIn2);
        while (inputInFile2.hasNextLine()) {
             String temp = inputInFile2.nextLine();
             tempDirec[i] = temp;    
             i++;
        }
        // read the file into the tempDirec array
        fileIn2.close();
        int j = count;
        for (int p = 0; p < count; p++) {
            directions[j-1] = tempDirec[p];
            j = j-1;
        }
        // reverse the array and store it into the directions array
        
        String[] finalDirec = new String[count];
        // create the final array that will store the data to output to the output file
        String right = "";
        String left = "";
        String right1 = "";
        String left1 = "";
        int index = 0;
        int index1 = 0;
        int indexFinal = 0;
        String lower = "";
        String substring = "";
        String substring1 = "";
        String substringRest = "";
        String substringRest1 = "";
        String done = "";
        String done1 = "";
        String mileage = "";
        double doubleMileage = 0;
        double finalMileage = 0;
        int indexMileage = 0;
        int indexMiles = 0;
        String firstlineindex = "";
        // just declaring a lot of variables before the for loop to expand their scope
        if (directions[0].contains("Right")) {
            firstlineindex = "Left";
        } else if (directions[0].contains("Left")) {
            firstlineindex = "Right";
        }
        // finding out on which side the destination is and reversing for the output file
        int indexfirstLine = directions[0].indexOf("is");
        // finding index of "is" so I can locate the name of the destination
        final String firstLine = "Start at " + directions[0].substring(0,indexfirstLine);
        // creating a new first line for the output file that takes the destination
        //name from the original file and changes it to be the starting place for the output file
        for (int l = 1; l < count; l++) {
            // big for loop that changes all the directions
            index = directions[l].indexOf("R");
            index1 = directions[l].indexOf("L");
            // finding the indices of the directions
            indexFinal = directions[l].indexOf(")");
            // finding the index of the end of the lines
            
            indexMileage = directions[l].indexOf("(");
            // finding the index of the mileage on each line
            if (directions[l].contains("(")) {
                String test = directions[l].substring(indexMileage+1, indexMileage+5);
                if (test.contains(".")) {
                    mileage = test;
                    doubleMileage = Double.valueOf(mileage);
                    // changing the string mileage to double mileage
                } else if (!test.contains(".")) {
                    mileage = directions[l].substring(indexMileage+1, indexMileage+3);
                    doubleMileage = Double.valueOf(mileage);
                    // changing the string mileage to double mileage
                }
            }
            // if statement to find out if the mileage has a decimal place or not
            
                    if (directions[l].substring(0,4).equals("R on")) {
                        // checking to see if a line starts with a R
                        // I did it this way because if I just used R
                        // it would overlap with Right because they both have R's
                        substring = directions[l].substring(0, index+1);
                        // isolating the R in the line
                        substringRest = directions[l].substring(index+1, indexFinal+1);
                        // isolating the rest of the line
                        substring = "L";
                        // changing the R to an L
                        done = substring + substringRest;
                        // combining the changed direction back to the rest of the line
                        finalDirec[l+1] = done;
                        // appending finalDirec with the updated line
                    }
                    if (directions[l].contains("Right")) {
                        // checking to see if a line has Right in it
                        done = directions[l].replaceFirst("Right", "L");
                        // replacing the first Right with an L
                        finalDirec[l+1] = done;
                        // appending finalDirec with the updated line
                    }
                    if (directions[l].substring(0,4).equals("L on")) {
                        // checking to see if a line starts with a L
                        substring = directions[l].substring(0, index1+1);
                        // isolating the index of the L
                        substringRest = directions[l].substring(index+2, indexFinal+1);
                        // isolating the rest of the string
                        substring = "R";
                        // changing the direction to an R
                        done = substring + substringRest;
                        // adding the changed direction back to the rest of the line
                        finalDirec[l+1] = done;
                        // appending finalDirec with the updated direction
                    }
                    if (directions[l].contains("Left")) {
                        // checking to see if a line contains Left
                        done = directions[l].replaceFirst("Left", "R");
                        // changing the first Left to an R
                        finalDirec[l+1] = done;
                        // appending finalDirec with the updated direction
                    }
            }
            finalMileage += doubleMileage;
            // adding up the mileage of each line
        
    
        finalMileage = finalMileage * 2;
        // accounting for the round trip
        int indexlastLine = directions[count-2].indexOf("at");
        // isolating the name of the starting place in the original file
        String destination = directions[count-2].substring(indexlastLine+3);
        // isolating everything after "at" in the second to last line in the original file
        // or isolating the name of the starting place in the original file
        String lastLine = indexlastLine + firstlineindex;
        // adding the name of the destination in the new file with the side of the road its gonna be on
        double price = finalMileage / fuelEff;
        price = price * gasPrice;
        // cost of the trip calculation
        FileOutputStream fileOut = new FileOutputStream("reverse_directions.txt");
        PrintWriter outtoFile = new PrintWriter(fileOut);
        // creating the output to the new file
        finalDirec[0] = firstLine;
        // making the first line in the new file to be Start at -- the destination in the old file
        finalDirec[count-1] = "Your " + (String.format("%.1f", finalMileage) + "-mile round trip will cost about $"+ String.format("%.1f", price));
        // adding the last line of the new file to be the summary report line
        finalDirec[count-2] = destination + " is on the " + firstlineindex;
        // adding the new destination and what side it is on to the new file
        for (int a = 0; a < count; a++) {
            outtoFile.println(finalDirec[a]);
        }
        // for loop to add the rest of finalDirec to the new file
        outtoFile.flush();
        fileOut.close();
        // flush and close the file and I am done
        // this is probably way overcomplicated, but its just how I thought through the problem
        // hope its legible! Sorry in advance if its not!
    }
}