import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

class Main
{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int min = 1; 
        boolean playAgain = true;
        while (playAgain) {
            int guesses = 0;
            int guess = 0;
            int max = getInt("Enter maximum value > 1:  ", scanner);
            int number = random.nextInt(min, max+1);
            while (number != guess) {
                guess = getInt("Enter your Guess from "+ min +"-"+ max, scanner);
                guesses++;
                if(guess > number){
                    System.out.println("\tGuess is greater than number.");
                }else if(guess < number){
                    System.out.println("\tGuess is less than number.");
                }
            }
            double MaxNumberOfGuesses = Math.ceil(Math.log(max)/Math.log(2));
                        // log_a(b) = log(b)/log(a)
            if(MaxNumberOfGuesses < guesses){
                System.out.println("You LOST!!! It should've taken at most "+ (int)MaxNumberOfGuesses +" tries.");
            }else{
                System.out.println("You WON!!! max guesses: "+(int)MaxNumberOfGuesses);
            }
            System.out.println("\tGuesses "+ guesses);

            System.out.println("\nDo you want to play again? (Y/N): ");
            if(!scanner.nextLine().toUpperCase().equals("Y")){
                playAgain = false;
            }

        }
        scanner.close();
    }
    
    private static int getInt(String str, Scanner scanner) {
        int number = 0;
        do{
            System.out.println(str);
            try{
                number = scanner.nextInt(); // (**)
                scanner.nextLine(); // (*)
            }
            catch(InputMismatchException e){
                System.out.println("You had to enter a NUMBER!!!");
                scanner.nextLine(); // beacause (*) doesnt execute if an exception happens in (**)
            }
        }while(number < 1);
        return number;
    }
}