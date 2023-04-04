package au.edu.usc.mathgame;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * A simple console-based maths quiz for primary school children.
 *
 * @author Author1
 * @author Author2
 */
public class Main {
    private HighScores highScore = new HighScores();

    public static void main(String[] args) {
        Main main = new Main();
        main.playMultipleGames();
    }

    public void playGame() {
        Random rand = new Random();
        Scanner input = new Scanner(System.in);
        ArrayList<Question> questions = new ArrayList<Question>();
        int score = 0;

        // Generate 10 random questions and store them in a list
        for (int i = 0; i < 9; i++) {
            MathQuestion q = new MathQuestion(rand);
            questions.add(q);
        }

        JokeQuestion jq = new JokeQuestion("How many Polacks does it take to change a light bulb?", 3);
        questions.add(jq);

        // now ask each question from the list.
        for (int i = 0; i < questions.size(); i++) {
            System.out.printf("Your current score is %2d\n", score);
            Question q = questions.get(i);
            q.showQuestion();
            int response = input.nextInt();

            boolean good = q.checkAnswer(response);
            if (good) {
                score++;
            } else {
                questions.add(q);
            }
        }

        highScore.setHighScore(score);

        System.out.printf("You have answered %2d out of 10 questions correctly.\n", score);
        if (score <= 4) {
            System.out.println("Good start. You can practice more to improve your score.");
        } else if (score <= 7) {
            System.out.println("Good result. It is recommended to practice more to improve your score.");
        } else {
            System.out.println("Congratulations!");
        }

        System.out.println("Your highest score in all past plays is " + highScore.getHighScore());
    }

    public void playMultipleGames() {
        String playing = "Y";
        Scanner input = new Scanner(System.in);


        while (playing.equals("Y")) {
            playGame();

            System.out.print("Do you want to play another game? Please answer Y or N: ");
            playing = input.next();
            System.out.println("playing is " + playing);
        }
    }
}