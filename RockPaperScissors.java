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
        ran = new Random(1);
    }

    /*
     * Print 2 blank lines to the console and then prompt the user for an input
     * Q1d.
     */
    public void printPrompt() 
   {
        System.out.println();
        System.out.println();
        System.out.print("Enter your choice, paper, rock or scissors > " );
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
        int randomNumber = ran.nextInt(4);
        String computersMove = "";

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
     * Determine a the winner of the round by comparing string values 
     * Increment the winners score 
     * Return the winner as a string
     * Q1g.
     */
    public String findWinner(String yourChoice, String computerChoice) 
   {        
        // If the user input is not valid the computer wins
        if (!yourChoice.equals("rock") && 
            !yourChoice.equals("paper") && 
            !yourChoice.equals("scissors")) 
        {
            computerScore++;
            return "computer";
        }

        // If both both players give the same choice its a draw
        if (yourChoice.equals(computerChoice)) {
            return "draw";
        } 

        // If input is valid and the game is not a draw use nested if loops
        // to determine a winner and increment score

        // If user chooses rock ...
        if (yourChoice.equals("rock")) {
            if (computerChoice.equals("scissors")) {
                yourScore++;
                return "you";
            } else if (computerChoice.equals("paper")) {
                computerScore++;
                return "computer";
            }
        // If user chooses paper...
        } else if (yourChoice.equals("paper")) {
            if (computerChoice.equals("rock")) {
                yourScore++;
                return "you";
            } else if (computerChoice.equals("scissors")) {
                computerScore++;
                return "computer";
            }
        // If user chooses scissors...
        } else if (yourChoice.equals("scissors")) {
            if (computerChoice.equals("paper")) {
                yourScore++;
                return "you";
            } else if (computerChoice.equals("rock")) {
                computerScore++;
                return "computer";
            }
        }
        return "";
    }
    
    /**
     * Start the game of rock, paper, scissors. 
     * Collect inputs and generate computers move.
     * Print out winner to console
     * Q1h.
     */
     public void playRound() 
     {
        // promt the user for an input 
        printPrompt();

        // Store user input in the yourChoice variable and initialize the computers choice in the compChoice var
        String yourChoice = userChoice();
        String compChoice = computerChoice();

        //Print the users choice and the comp choice to the terminal
        System.out.println("\n" + "You have chosen " + yourChoice + " and the computer has chosen " + compChoice);

        //Find the winner of the round and increment the scores
        //Print the winner to the console
        String winner = findWinner(yourChoice, compChoice);
        String winningString = "";

        switch (winner) {
            case "you": winningString = "You are the winner";
                 break;
            case "computer": winningString = "The computer is the winner";
                break;
            case "draw": winningString = "This game is a draw";
                break;
        }
        System.out.println(winningString);
        System.out.println("You have " + yourScore + " and the computer has " + computerScore);
     }
}
