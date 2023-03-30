package au.edu.usc.mathgame;

public class Question {
    int answer;

    public void showQuestion() {
        System.out.println("This is the content of the question");
    }

    public boolean checkAnswer(int response) {
        if (answer == response) {
            System.out.printf("  Yes!\n");
            return true;
        } else {
            System.out.printf("  No, the answer is incorrect.\n");
            return false;
        }
    }

    public int getAnswer() {
        return answer;
    }

}
