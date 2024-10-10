import javax.swing.JOptionPane;
import java.util.Random;
/**Pseudocode
 *  Start game
 *  Recieve message with the welcoming and instructions to the game
 *   Select a random number
 *   Any number between 100 to 999
 *   Set max guesses (10)
 *   If number is too low display message "Your guess is too low"
 *   If number is too high display message "Your guess is too high"
 *   Repeat until gotten the correct number or run out of guesses
 *   If the user inputs a number below 100 or above 999, display "Error" message.
 *   
 *   Our reasoning for making it 10 guesses is because if you divide the 899 by 2 for 10 times you will finally reach the number of 0.877
 *   so there will be only 1 number that will be possible and it will be guaranteed that it will be that number.
 *   
 * @author (Mateusz Pluta 22354107 and Aleksander Siennicki 22363475) Group 46
 * @version 03 March 2023 15:00
*/
public class GuessingGame {
    private static final Random rand = new Random();
    
    /** Creating the secrent number using the random number generator
     *  Setting the limit of 10 for guesses
     *  Creating all the dialogs
     *  Creating the for loop
     *  If number too low, display message that its too low
     *  If number too high, display message that its too high
     *  Create an error message and exception to that error message so it doesnt stop/crash the game
     *  If number is guesses within 10 tries display message "Congratulations"
     *  If number wasnt guessed within 10 tries display message "Game Over"
     *  
     *  @param Input a number between 100 to 999
      * @return Either the number is correct or its incorrect then you have 9 more 
      * guesses so you continue until you run out or guess the correct number.
     */
    public static void main(String[] args) {
        int secretNumber = rand.nextInt(900) + 100; //Creates and sets the random number
        int maxGuesses = 10; // Setting maximum number of games allowed
        JOptionPane.showMessageDialog(null, "Welcome to the Guessing Game! " +
            "Guess a number between 100 and 999, and you have 10 tries to guess it. " , "Guessing Game Instructions", JOptionPane.INFORMATION_MESSAGE); //Welcome message and Instructions message.
        for (int i = 1; i <= maxGuesses; i++) { 
            String guessStr = JOptionPane.showInputDialog(null, "Guess #" + i + ": Enter a number between 100 and 999:", "Guessing Game", JOptionPane.PLAIN_MESSAGE);// Allows for inputing your guess
            try {
                int guess = Integer.parseInt(guessStr);
                if (guess == secretNumber) {
                    JOptionPane.showMessageDialog(null, "Congratulations! You guessed the number in " + i + " guesses!", "Winner!", JOptionPane.INFORMATION_MESSAGE);
                    return; //If the correct number was guessing displays message congratulations and what number it was.
                } else if (guess < secretNumber) {
                    JOptionPane.showMessageDialog(null, "Your guess is too low. Try again!", "Guess Again", JOptionPane.INFORMATION_MESSAGE); //If the number was too low, displays the message it is too low.
                } else {
                    JOptionPane.showMessageDialog(null, "Your guess is too high. Try again!", "Guess Again", JOptionPane.INFORMATION_MESSAGE);//If the number was too high displays the message it is too high.
                }
                if (guess < 100 || guess > 999) {
                    JOptionPane.showMessageDialog(null, "Invalid input. Please enter a number between 100 and 999.", "Error", JOptionPane.ERROR_MESSAGE);
                    i--;//If the input is invalid such as a number below 100, display's message ERROR.
                    continue;
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Invalid input. Please enter a number between 100 and 999.", "Error", JOptionPane.ERROR_MESSAGE);
                i--; //Create an exception so the game continues to run
                continue;
            }
        }
        JOptionPane.showMessageDialog(null, "You have used up all your guesses. The number was " + secretNumber, "Game Over", JOptionPane.WARNING_MESSAGE); //If the limit of games is used up display message "Game Over".
    }
}
