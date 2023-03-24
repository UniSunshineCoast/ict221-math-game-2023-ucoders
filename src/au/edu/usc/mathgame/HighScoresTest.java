package au.edu.usc.mathgame;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HighScoresTest {
    @Test
    public void testSetHighScore() {
        HighScores hs = new HighScores();

        hs.setHighScore(50);
        assertEquals(50, hs.getHighScore());

        hs.setHighScore(30);
        assertEquals(50, hs.getHighScore());

        hs.setHighScore(70);
        assertEquals(70, hs.getHighScore());

        hs.setHighScore(60);
        assertEquals(70, hs.getHighScore());
    }
}
