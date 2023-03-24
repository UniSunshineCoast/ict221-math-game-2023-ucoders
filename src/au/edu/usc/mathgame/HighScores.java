package au.edu.usc.mathgame;

public class HighScores {
    private int highScore;

    public void setHighScore(int score) {
        if (highScore < score) {
            highScore = score;
        }
    }

    public int getHighScore() {
        return highScore;
    }
}
