import java.util.Scanner;
import java.io.FileInputStream;
import java.io.PrintWriter;
import java.io.FileOutputStream;
import java.io.IOException;
/**
 * Write a description of class Lab7 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Lab7
{
    public static void main(String[] args) throws IOException {
        FileInputStream fileIn = new FileInputStream("haikuFun.txt");       
        Scanner input = new Scanner(fileIn);
        String[] words = new String[6];
        int length = words.length;
        
        for (int i = 0; i <= length-1; i++) {
            String Lines = input.nextLine();
            words[i] = Lines;
        }
        fileIn.close();
        
        FileOutputStream fileOut = new FileOutputStream("reverse.txt");
        PrintWriter outtoFile = new PrintWriter(fileOut);
        
        for (int i = length-1; i >= 0; i--) {
            outtoFile.println(words[i]);
        }
        
        outtoFile.flush();
        fileOut.close();
    }
}
