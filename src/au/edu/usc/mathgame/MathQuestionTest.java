package au.edu.usc.mathgame;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MathQuestionTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
        System.setErr(originalErr);
    }

    @Test
    public void testConstructor() {
        MathQuestion q = new MathQuestion(3, 5, "+");
        assertEquals(3, q.getVal1());
        assertEquals(5, q.getVal2());
        assertEquals("+", q.getOperator());
        assertEquals(8, q.getAnswer());

        q = new MathQuestion(10, 2, "-");
        assertEquals(10, q.getVal1());
        assertEquals(2, q.getVal2());
        assertEquals("-", q.getOperator());
        assertEquals(8, q.getAnswer());

        q = new MathQuestion(4, 6, "*");
        assertEquals(4, q.getVal1());
        assertEquals(6, q.getVal2());
        assertEquals("*", q.getOperator());
        assertEquals(24, q.getAnswer());

        q = new MathQuestion(20, 5, "/");
        assertEquals(20, q.getVal1());
        assertEquals(5, q.getVal2());
        assertEquals("/", q.getOperator());
        assertEquals(4, q.getAnswer());
    }

    @Test
    public void testRandomConstructor() {
        Random rand = new Random();
        MathQuestion q = new MathQuestion(rand);

        int expectedAnswer;
        if (q.getOperator().equals("+")) {
            expectedAnswer = q.getVal1() + q.getVal2();
        } else if (q.getOperator().equals("-")) {
            expectedAnswer = q.getVal1() - q.getVal2();
        } else if (q.getOperator().equals("*")) {
            expectedAnswer = q.getVal1() * q.getVal2();
        } else {
            expectedAnswer = q.getVal1() / q.getVal2();
        }

        assertEquals(expectedAnswer, q.getAnswer());
    }

    @Test
    public void testShowQuestion() {
        MathQuestion q = new MathQuestion(3, 5, "+");
        q.showQuestion();
        assertEquals("What is  3 +  5? ", outContent.toString());
        outContent.reset();

        q = new MathQuestion(10, 2, "-");
        q.showQuestion();
        assertEquals("What is 10 -  2? ", outContent.toString());
        outContent.reset();

        q = new MathQuestion(4, 6, "*");
        q.showQuestion();
        assertEquals("What is  4 *  6? ", outContent.toString());
        outContent.reset();

        q = new MathQuestion(20, 5, "/");
        q.showQuestion();
        assertEquals("What is 20 /  5? ", outContent.toString());
        outContent.reset();
    }

    @Test
    public void testCheckAnswer() {
        MathQuestion q = new MathQuestion(3, 5, "+");
        assertEquals(true, q.checkAnswer(8));
        assertEquals(false, q.checkAnswer(7));

        q = new MathQuestion(10, 2, "-");
        assertEquals(true, q.checkAnswer(8));
        assertEquals(false, q.checkAnswer(9));

        q = new MathQuestion(4, 6, "*");
        assertEquals(true, q.checkAnswer(24));
        assertEquals(false, q.checkAnswer(23));

        q = new MathQuestion(20, 5, "/");
        assertEquals(true, q.checkAnswer(4));
        assertEquals(false, q.checkAnswer(3));
    }
}