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

    public static void main(String[] args) {
        Random rand = new Random();
        Scanner input = new Scanner(System.in);
        int score = 0;

        // now ask some random addition questions.
        for (int i = 0; i < 10; i++) {
            Question q = new Question(rand);
            q.showQuestion();
            int response = input.nextInt();

            boolean good = q.checkAnswer(response);
            if (good) {
                score++;
            }
        }

        System.out.printf("You have answered %2d out of 10 questions correctly.\n", score);
    }
}