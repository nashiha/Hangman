import java.util.*;
//---------------------------------------------------------------------------------------------------------------------
/* Hangman Individual HW, main method: I combined all of the pieces that the groups made and fixed errors. More details
 * on errors are in document in zip file. 
 * @author: Nashiha Ahmed
 * @version: 1; 17/ 02/ 15
 */
//---------------------------------------------------------------------------------------------------------------------

// Section 1-piece 1
/*
 * Mustafa Duymuş
 * Çağdaş Han Yılmaz
 * Utku Oymak
 * Ege YosunKaya
 * Can Seferoğlu
 * Umut Balkan
 */
public class Hang
{    
    public static void main( String[] args)
    {
        Scanner scan = new Scanner( System.in);
        
        // Setting up the game
        Hangman hang = new Hangman();
        System.out.println( "Welcome to the Section 1's hangman game!");
        System.out.println( "You are expected to find the secret word in maximum of 6 mistakes.");
        System.out.println( "The stars indicate how many letters there are in the secret word.");
        System.out.println();
        
        // essential part of the game
        while( !hang.isGameOver())
        {
            // prints the progress of user
            System.out.println( hang.getKnownSoFar());
            System.out.println( "Your mistakes so far: " + hang.getNumOfIncorrectTries()); 
            System.out.println( "Used letters are: " + hang.getUsedLetters());
            System.out.print( "Please enter a letter: "); // ask for a letter
            String str = scan.nextLine();
            while( str.length() != 1)
            {
                System.out.print( "Please enter a letter: ");
                str = scan.nextLine(); // takes the letter as an one character string.
            }
            char c = str.charAt( 0);
            hang.tryThis( c);
            System.out.println(); // some blanks for clearly indicating a new turn.
            System.out.println();
        }
        
        // ending massages according to user's win or loss.
        if( hang.hasLost())
        {
            System.out.println( "You have lost the game. The secret word is: " + hang.getSecretWord());
        }
        else
            System.out.println( "Well done, you won. The secret word is " + hang.getSecretWord()); 
    }
}
//end of main method