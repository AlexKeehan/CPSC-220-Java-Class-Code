
 

import java.io.*;
import java.util.*;

public class TestCaseProcessor {

    public String classname = "akeehan";
    public String filename = "testCases.txt";

    private UnoPlayer thePlayer;

    public static void main(String args[]) {
     try {
         new TestCaseProcessor().doIt();
     }
     catch (Exception e) {
         e.printStackTrace();
     }
    }

    private TestCaseProcessor() throws Exception {
        thePlayer = (UnoPlayer) Class.forName(classname + "_UnoPlayer").newInstance();
    }

    private void doIt() throws Exception {
        int numHandsTested = 0;
        BufferedReader br = new BufferedReader(new FileReader(filename));
        String handLine = br.readLine();
        while (handLine != null) {
            Scanner handLineScanner = new Scanner(handLine).
                useDelimiter(",");
            ArrayList<Card> hand = new ArrayList<Card>();
            while (handLineScanner.hasNext()) {
                String cardString = handLineScanner.next();
                Scanner cardStringScanner = new Scanner(cardString);
                Card card = new Card(
                    UnoPlayer.Color.valueOf(cardStringScanner.next()),
                    UnoPlayer.Rank.valueOf(cardStringScanner.next()),
                    cardStringScanner.nextInt());
                hand.add(card);
            }

            String upCardLine = br.readLine();
            Scanner upCardLineScanner = new Scanner(upCardLine);
            Card upCard = new Card(
                UnoPlayer.Color.valueOf(upCardLineScanner.next()),
                UnoPlayer.Rank.valueOf(upCardLineScanner.next()),
                upCardLineScanner.nextInt());
            
            String calledColorLine = br.readLine();
            UnoPlayer.Color calledColor = UnoPlayer.Color.valueOf(calledColorLine);

            ArrayList<Integer> validPlays = new ArrayList<Integer>();
            String validPlaysLine = br.readLine();
            Scanner validPlaysScanner =
                new Scanner(validPlaysLine).useDelimiter(",");
            while (validPlaysScanner.hasNextInt()) {
                validPlays.add(new Integer(validPlaysScanner.nextInt()));
            }
            
            testHand(hand,upCard,calledColor,validPlays);
            numHandsTested++;

            if (numHandsTested < 100  ||  numHandsTested % 100 == 0) {
                System.out.println(numHandsTested + " test hands passed!");
            }

            br.readLine(); // consume --------- delimiter

            handLine = br.readLine();
        }
    }

    private void testHand(
        List<Card> hand, Card upCard, 
        UnoPlayer.Color calledColor,
        ArrayList<Integer> validPlays) throws Exception {

        GameState currentGameState = new GameState();
            
        int cardPlayed = 
            thePlayer.play(hand, upCard, calledColor, currentGameState);

        if (!validPlays.contains(new Integer(cardPlayed))) {
            System.out.println("Whoops -- your play() method has an error!");
            System.out.println("You were given this hand:");
            for (int i=0; i<hand.size(); i++) {
                System.out.println("  " + i + ". " + hand.get(i));
            }

            System.out.println("and the up card was: " + upCard);
            if (upCard.getRank() == UnoPlayer.Rank.WILD ||
                upCard.getRank() == UnoPlayer.Rank.WILD_D4) {
                System.out.println("and the called color was: " + calledColor);
            }
            System.out.println("and you (incorrectly) returned " + 
                cardPlayed + ".");
            System.out.print("Valid plays would have included: ");
            for (int i=0; i<validPlays.size(); i++) {
                System.out.print(validPlays.get(i));
                if (i<validPlays.size()-1) {
                    System.out.print(",");
                }
            }
            System.out.println("\n\nPress enter to quit");
            Scanner s = new Scanner(System.in);
            s.nextLine();
            System.exit(3);
        }

        UnoPlayer.Color color = thePlayer.callColor(hand, currentGameState);

        if (color != UnoPlayer.Color.RED  &&  color != UnoPlayer.Color.BLUE  &&  color !=
            UnoPlayer.Color.GREEN  &&  color != UnoPlayer.Color.YELLOW) {

            System.out.println("Whoops -- your callColor() method has an error!");
            System.out.println("You were given this hand:");
            for (int i=0; i<hand.size(); i++) {
                System.out.println("  " + i + ". " + hand.get(i));
            }

            System.out.println("and the up card was: " + upCard);
            if (upCard.getRank() == UnoPlayer.Rank.WILD ||
                upCard.getRank() == UnoPlayer.Rank.WILD_D4) {
                System.out.println("and the called color was: " + calledColor);
            }
            System.out.println("and you (incorrectly) returned " + color + ".");

            System.out.println("\n\nPress enter to quit");
            Scanner s = new Scanner(System.in);
            s.nextLine();

            System.exit(4);
        }
        
    }
}


