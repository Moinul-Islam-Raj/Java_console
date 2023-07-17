class Main
{
    public static void main(String[] args) {
        String[][] quizDatabase = Data.getQuizes();
        Quiz[] quizs = new Quiz[quizDatabase.length];
        for(int i=0; i<quizDatabase.length; i++){
            quizs[i] = new Quiz(quizDatabase[i][4], quizDatabase[i], String.valueOf(quizDatabase[i][5]).charAt(0));
        }

        for (Quiz quiz : quizs) {
            quiz.showDetails();
            quiz.getAnswerAndCheck();
        }

        System.out.println();
        System.out.println("You got "+ Quiz.getGotRight() +" Answers Right out of "+ Quiz.getTotalQuestion() +" Questions.");
        System.out.println("Score: "+ ((Quiz.getGotRight()*100)/Quiz.getTotalQuestion()) +"%");
        System.out.println("Answers: ");
        for (int i = 0; i < quizDatabase.length - 1; i++) {
            System.out.print(quizDatabase[i][5]+", ");
        }
        System.out.println(quizDatabase[quizDatabase.length - 1][5]);
    }
}