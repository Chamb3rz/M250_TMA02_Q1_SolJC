import java.util.Random;
import java.util.ArrayList;

/**
 * The rock paper sciccors class leverages user input in the terminal to play a game
 * of rock paper scissors.
 *
 * @author Jake Chambers K5467717
 * @version V1.0 07/02/2022
 * Q1a
 */
public class RockPaperScissors 
{
    //initialise instance variables
    //Q1b
    private InputReader reader;
    private int yourScore;
    private int computerScore;
    private Random ran;

    /**
     * Constructor for objects of class RockPaperScissors
     * Q1c.
     */
    public RockPaperScissors() 
    {
        // Initialise instance variables
        reader = new InputReader();
        yourScore = 0;
        computerScore = 0;
        ran = new Random(3);
    }

    /*
     * Print 2 blank lines to the console and then prompt the user for an input
     * Q1d.
     */
    public void printPrompt() 
    {
        System.out.println();
        System.out.println();
        System.out.print("Enter your choice, paper, rock or scissors > ");
    }

     /*
     * Get the users choice, trim any spaces and make the string lower case
     * Q1e.
     */
    public String userChoice() 
    {
        return reader.getInput().trim().toLowerCase();
    }

    /*
    * generate a random numer between 0 and 2 inclusive, use the number to return a
    * corresponding string value (rock, paper, scissors)
    * Q1f.
    */ 
    public String computerChoice()
    {
        int randomNumber = ran.nextInt();
        String computersMove;

        //set the computers move to the corresponding choice depending on the number
        switch (randomNumber)
        {
            case 0: computersMove = "rock";
                    break;
            case 1: computersMove = "paper";
                    break;
            case 2: computersMove = "scissors";
                    break;
        }
        // return either rock paper or scissors 
        return computersMove;
    }

     /*
     * Get the users choice, trim any spaces and make the string lower case
     * Q1g.
     */
    public String findWinner(String yourChoice, String computerChoice) 
    {

        yourChoice = userChoice();
        computerChoice = computerChoice();
        
        // If the user input is not valid the computer wins
        if (!yourChoice.equals("rock") && 
            !yourChoice.equals("paper") && 
            !yourChoice.equals("scissors")) 
        {
            computerScore++;
            return "computer";
        }

        return "";
    }
}
