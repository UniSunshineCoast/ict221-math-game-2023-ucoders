package au.edu.usc.mathgame;

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
        int score = 0;


        // now ask some random addition questions.
        for (int i = 0; i < 10; i++) {
            System.out.printf("Your current score is %2d\n", score);
            Question q = new Question(rand);
            q.showQuestion();
            int response = input.nextInt();

            boolean good = q.checkAnswer(response);
            if (good) {
                score++;
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