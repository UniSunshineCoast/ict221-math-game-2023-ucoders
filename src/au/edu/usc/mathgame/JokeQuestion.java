package au.edu.usc.mathgame;

public class JokeQuestion extends Question {
    private String question;

    public JokeQuestion(String question, int answer) {
        this.question = question;
        this.answer = answer;
    }

    public void showQuestion() {
        System.out.println(question);
    }


}
