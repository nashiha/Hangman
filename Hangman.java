//---------------------------------------------------------------------------------------------------------------------
/* Hangman Individual HW Hangman class: I combined all of the pieces that the groups made and fixed errors. More details
 * on errors are in document in zip file. 
 * @author: Nashiha Ahmed
 * @version: 1; 17/ 02/ 15
 */
//---------------------------------------------------------------------------------------------------------------------

/**
 * Section 1-piece 05
 * Ömer Berk Uçar 
 * Ertan Aday
 * Kazým Sanlav
 * Mehmet Nuri Yumuþak
 * Ömer Faruk Doðru
 */
public class Hangman
{
    //properties
    private StringBuffer secretWord;
    private StringBuffer allLetters;
    private StringBuffer usedLetters;
    private StringBuffer knownSoFar;
    private int maxAllowedIncorrectTries;
    private int numberOfIncorrectTries;
    private String[] wordList;
    
    /* HW01- Hangman Homework
     * Section 1- Piece 02
     * Description: Constructor for Hangman game
     * @authors: Ali Osman Cetin, Burcu Doyuran, Cholpon Mambetova, Nashiha Ahmed, Omer Farooq Ahmed
     * @version: 1.00; 07/02/2015 
     */
    
    //constructor
    public Hangman()
    {
        //variables
        int i; 
        
        //program code
        //1. Set all letters to English alphabet
        allLetters = new StringBuffer("abcdefghijklmnopqrstuvwxyz");
        
        //2. Set used letters to empty set 
        usedLetters = new StringBuffer();
        
        //3. Set secret word to result of calling choose secret word method
        secretWord =  new StringBuffer (chooseSecretWord());
        
        //4. Set knowsofar to null and to StringBuffer of same length as secret word, but all characters are stars ('*') 
        knownSoFar = new StringBuffer();
        for( i = 0 ; i < secretWord.length() ; i++ )
            knownSoFar = knownSoFar.append("* ");
        //5. Set max allowed incorrect tries to 6 
        maxAllowedIncorrectTries = 6;
        
        //6. Set no of incorrect tries to 0  
        numberOfIncorrectTries = 0;  
        
        //end of code
    }
    
    //methods
    //getAllLetters method
    public String getAllLetters() 
    {
        return allLetters.toString();
    }
    
    //getSecretWord method
    public String getSecretWord() 
    {
        return secretWord.toString();
    }
    
    //getUsedLetters methos
    public String getUsedLetters() 
    {
        return usedLetters.toString();
    }
    
    //getNumOfIncorrectTries method
    public int getNumOfIncorrectTries() 
    {
        return numberOfIncorrectTries;
    }
    
    //getMaxAllowedIncorrectTries method
    public int getMaxAllowedIncorrectTries() 
    {
        return maxAllowedIncorrectTries;
    }
    
    //ChooseSecretWord Method- Unknown Group? Section?
    //Give your word list in the parameter brackets if you have one,
    //if you don't have a word list, just don't pass anything in the function to use the default list.
    public String chooseSecretWord( String[] wordList)
    {
        int randomNo;
        randomNo = (int)(Math.random() * wordList.length);
        return wordList[ randomNo];
    }
    
    public String chooseSecretWord(){
        String[] defaultWordList = new String[ 11];
        defaultWordList = new String[ 11];
        //list of words
        defaultWordList[ 0] = "car";
        defaultWordList[ 1] = "plane";
        defaultWordList[ 2] = "nothing";
        defaultWordList[ 3] = "something";
        defaultWordList[ 4] = "galaxy";
        defaultWordList[ 5] = "universe";
        defaultWordList[ 6] = "dog";
        defaultWordList[ 7] = "pool";
        defaultWordList[ 8] = "food";
        defaultWordList[ 9] = "hangman";
        defaultWordList[ 10] = "jungle";
        
        //randomNumber generater to choose words
        int randomNo;
        randomNo=( int)( Math.random() * defaultWordList.length);
        
        return defaultWordList[ randomNo];
    }
    
    //getKnownSoFar method
    public String getKnownSoFar() 
    {
        return knownSoFar.toString();
    }
    
    //isGameOver method
    public boolean isGameOver()
    {
        if( numberOfIncorrectTries >= maxAllowedIncorrectTries || knownSoFar.toString().equals( secretWord.toString()))
            return true;
        else
            return false;
    }
    
    //hasLost method
    public boolean hasLost() 
    {
        if( numberOfIncorrectTries >= maxAllowedIncorrectTries )
            return true;
        else
            return false;
    }
    
    // Group Homework-tryThis method- Section one, piece 03b
    // Yasin Tepeli
    // Ýzel Gürbüz
    // Abdürrezak Efe
    // Musatafa Seven
    // Enes Kavak  
    public int tryThis( char letter)
    {
        //1. Check whether the letter is between A and Z or not
        int check = -1;
        for( int i = 0; i < allLetters.length(); i++)
        {
            if( letter == allLetters.toString().charAt(i))
                check = 0;
        }
        if( check == -1)
            return -1;
        
        //2. Check whether the letter used before or not
        for( int i = 0; i < usedLetters.length(); i++)
        {
            if( letter == usedLetters.toString().charAt(i))
                return -2;
        }
        
        //3. If word includes the letter add it
        int no = 0;
        for( int i=0; i < secretWord.length(); i++)
        {
            if( letter == secretWord.toString().charAt(i))
            {
                knownSoFar.setCharAt( i, letter);
                no++;
            }
        }
        
        //4. Add letter to used list
        usedLetters.append( letter + ", ");  
        
        //5.If no letter added then it is not correct letter
        if( no <= 0)
            numberOfIncorrectTries++;
        
        if( isGameOver() == true)
            return -3;
        
        return no;
    }
}
//end of Hangman class