import java.util.Scanner;
import java.io.FileInputStream;
import java.io.PrintWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
/**
 * Write a description of class Directions here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Test
{
    public static void main(String[] args) throws IOException {
    
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter the name of the text file: ");
        String fileName = input.next();
        System.out.println("What is the price per gallon of gas?");
        double gasPrice = input.nextDouble();
        System.out.println("What is your vehicle's ful efficiency in miles per gallon?");
        double fuelEff = input.nextDouble();
        
        int count = 0;
        FileInputStream fileIn = new FileInputStream("carls.txt");
        Scanner inputInFile = new Scanner(fileIn);
        while(inputInFile.hasNextLine()) {
             String temp = inputInFile.nextLine();
             count++;
        } 
        fileIn.close();
        System.out.println(count);
        String[] directions = new String[count];
        int length = directions.length;
        int i = 0;
        FileInputStream fileIn2 = new FileInputStream("carls.txt");
        Scanner inputInFile2 = new Scanner(fileIn2);
        while(inputInFile2.hasNextLine()) {
             String temp = inputInFile2.nextLine();
             directions[i] = temp;
             i++;
        } 
        String stringInstructions = directions[0].substring(0,1); 
        int numInstructions = Integer.valueOf(stringInstructions);
        int index = 0;
        int index1 = 0;
        int index2 = 0;
        int index3 = 0;
        String altered = " ";
        String normal = " ";
        boolean right = false;
        String test = " ";
        for (int o = numInstructions; o >= 0; o--) {
            if (directions[o].contains("Right")
            || (directions[o].contains("R"))) {
                index = directions[o].indexOf("Right");
                index1 = directions[o].indexOf("R");
                if (index >= 0) {
                test = directions[o].substring(index, index+5);
                test = test.replace("Right", "L");
                directions[index] = test;
                // System.out.println("sup" + index);
                // if (directions[o].contains("Right") && (index > 0)) {
                // normal = directions[o].substring(0, index);
                // altered = directions[o].substring(index, index+5);
                
                // } else if (directions[o].contains("Right") && (index == 0)) {
                    // normal = directions[o].substring(index+6);
                // }
                // if (directions[o].contains("R") && (index1 > 0)) {
                // normal = directions[o].substring(0, index);
                // altered = directions[o].substring(index, index+1);
                // } else if (directions[o].equals("R") && (index1 == 0)) {
                    // normal = directions[o].substring(index+1);
                // }
                // // directions[o].replaceAll("Right", "L");
                // // directions[o].replaceAll("R", "L");
                // // directions[o].replaceAll("right", "L");
            // }
            // if (directions[o].contains("Left")
            // || (directions[o].contains("L"))) {
                // index2 = directions[o].indexOf("Left");
                // index3 = directions[o].indexOf("L");
                // if (directions[o].contains("Left") && (index2 > 0)) {
                // normal = directions[o].substring(0, index);
                // altered = directions[o].substring(index, index+5);
                
                // } else if (directions[o].contains("Left") && (index2 == 0)) {
                    // normal = directions[o].substring(index+5);
                // }
                // if (directions[o].contains("L") && (index3 > 0)) {
                // normal = directions[o].substring(0, index);
                // altered = directions[o].substring(index, index+1);
                // } else if (directions[o].contains("L") && (index3 == 0)) {
                    // normal = directions[o].substring(index+1);
                // }
            }
                
                
                
                // directions[o].replaceAll("Left", "R");
                // directions[o].replaceAll("L", "R");
                // directions[o].replaceAll("left", "R");
            System.out.println(altered);
            System.out.println(normal);
            System.out.println(right);
            System.out.println(test);
            System.out.println(directions[o]);
            }
            //System.out.println(directions[o]);
            //System.out.println(index);
        }
        

    }
}