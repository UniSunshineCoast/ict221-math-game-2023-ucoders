package au.edu.usc.mathgame;

import java.util.Random;
import java.util.Scanner;

public class Question {
    private int val1;
    private int val2;
    private String operator;
    private int answer;

    public Question(int v1, int v2, String op) {
        this.val1 = v1;
        this.val2 = v2;
        this.operator = op;

        if (op == "+") {
            answer = v1 + v2;
        } else if (op == "-") {
            answer = val1 - val2;
        } else if (op == "*") {
            operator = "*";
            answer = val1 * val2;
        } else if (op == "/") {
            operator = "/";
            answer = val1 / val2;
        }
    }

    public Question(Random rand) {
        this.val1 = rand.nextInt(20);
        this.val2 = rand.nextInt(20);
        int questionType = rand.nextInt(4);

        if (questionType == 0) {
            operator = "+";
            answer = val1 + val2;
        } else if (questionType == 1) {
            operator = "-";
            answer = val1 - val2;
        } else if (questionType == 2) {
            operator = "*";
            answer = val1 * val2;
        } else if (questionType == 3) {
            operator = "/";
            answer = val1 / val2;
        }
    }

    public void showQuestion() {
        System.out.printf("What is %2d %s %2d? ", val1, operator, val2);
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
}
