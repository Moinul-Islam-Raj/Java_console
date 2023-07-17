import java.util.Scanner;

public class  Quiz {
    private static int totalQuestion = 0;
    private static int gotRight = 0;
    //Getters and Setters
    public static int getGotRight() {
        return gotRight;
    }
    public static void setGotRight(int gotRight) {
        Quiz.gotRight = gotRight;
    }
    public static int getTotalQuestion() {
        return totalQuestion;
    }
    public static void setTotalQuestion(int totalQuestion) {
        Quiz.totalQuestion = totalQuestion;
    }
    
    private String[] options;
    
    private String question;
    private char answer;
    private int questionNumber;
    Scanner scanner = new Scanner(System.in);
    
    public Quiz(String question, String[] options, char answer) {
        this.questionNumber = ++totalQuestion;
        this.question = question;
        this.options = options;
        this.answer = answer;
    }
    public void showDetails(){
        System.out.println(questionNumber +") "+ question);
        for (int i = 0; i < 4; i++) {
            System.out.println("\t"+ (char)((int)('A'+i)) + ") "+ options[i]);
        }
    }
    public void getAnswerAndCheck() {
        System.out.println();
        System.out.println("Enter a option: ");
        String in = "";
        do{
        in = scanner.nextLine();
        }while(in.equals(""));
        char option = in.charAt(0);
        if(checkAnswer(option)) gotRight++;
    }

    public boolean checkAnswer(char ans){
        return Character.toUpperCase(answer) == Character.toUpperCase(ans);
    }
}
