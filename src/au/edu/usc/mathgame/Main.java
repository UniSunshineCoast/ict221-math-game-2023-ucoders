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

        // now ask some random addition questions.
        for (int i = 0; i < 10; i++) {
            int a = rand.nextInt(20);
            int b = rand.nextInt(20);
            int correct = a + b;
            System.out.printf("What is %2d + %2d? ", a, b);
            int response = input.nextInt();
            if (response == correct) {
                System.out.printf("  Yes!\n");
            } else {
                System.out.printf("  No, the answer is %d.\n", correct);
            }
        }
    }
}