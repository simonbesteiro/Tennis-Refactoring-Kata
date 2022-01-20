import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class TennisTest2 {

    private int player1Score;
    private int player2Score;
    private String player1Name;
    private String player2Name;
    private String expectedScore;

    public TennisTest2(int player1Score, int player2Score, String player1Name, String player2Name, String expectedScore) {
        this.player1Score = player1Score;
        this.player2Score = player2Score;
        this.expectedScore = expectedScore;
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    @Parameters(name = "{0}:{1}:{3}:{4} = {2}")
    public static Collection<Object[]> getAllScores() {
        return Arrays.asList(new Object[][] {
                { 0, 0,  "player1", "player2",  "Love-All" },
                { 1, 1,  "player1", "player2",  "Fifteen-All" },
                { 2, 2,  "player1", "player2",  "Thirty-All"},
                { 3, 3,  "player1", "player2",  "Deuce"},
                { 4, 4,  "player1", "player2",  "Deuce"},

                { 1, 0,  "player1", "player2",  "Fifteen-Love"},
                { 0, 1,  "player1", "player2",  "Love-Fifteen"},
                { 2, 0,  "player1", "player2",  "Thirty-Love"},
                { 0, 2,  "player1", "player2",  "Love-Thirty"},
                { 3, 0,  "player1", "player2",  "Forty-Love"},
                { 0, 3,  "player1", "player2",  "Love-Forty"},
                { 4, 0,  "player1", "player2",  "Win for player1"},
                { 0, 4,  "player1", "player2",  "Win for player2"},

                { 2, 1,  "player1", "player2",  "Thirty-Fifteen"},
                { 1, 2,  "player1", "player2",  "Fifteen-Thirty"},
                { 3, 1,  "player1", "player2",  "Forty-Fifteen"},
                { 1, 3,  "player1", "player2",  "Fifteen-Forty"},
                { 4, 1,  "player1", "player2",  "Win for player1"},
                { 1, 4,  "player1", "player2",  "Win for player2"},

                { 3, 2,  "player1", "player2",  "Forty-Thirty"},
                { 2, 3,  "player1", "player2",  "Thirty-Forty"},
                { 4, 2,  "player1", "player2",  "Win for player1"},
                { 2, 4,  "player1", "player2",  "Win for player2"},

                { 4, 3,  "player1", "player2",  "Advantage player1"},
                { 3, 4,  "player1", "player2",  "Advantage player2"},
                { 5, 4,  "player1", "player2",  "Advantage player1"},
                { 4, 5,  "player1", "player2",  "Advantage player2"},
                { 15, 14,  "player1", "player2",  "Advantage player1"},
                { 14, 15,  "player1", "player2",  "Advantage player2"},

                { 6, 4,  "player1", "player2",  "Win for player1"},
                { 4, 6,  "player1", "player2",  "Win for player2"},
                { 16, 14,  "player1", "player2",  "Win for player1"},
                { 14, 16,  "player1", "player2",  "Win for player2"},
                { 16, 14,  "playerA", "playerB",  "Win for playerA"},
                { 14, 16,  "playerA", "playerB",  "Win for playerB"}
        });
    }

    public void checkAllScores(TennisGame game) {
        int highestScore = Math.max(this.player1Score, this.player2Score);
        for (int i = 0; i < highestScore; i++) {
            if (i < this.player1Score)
                game.wonPoint(this.player1Name);
            if (i < this.player2Score)
                game.wonPoint(this.player2Name);
        }
        assertEquals(this.expectedScore, game.getScore());
    }

    @Test
    public void checkAllScoresTennisGame2() {
        TennisGame2 game = new TennisGame2(this.player1Name, this.player2Name);
        checkAllScores(game);
    }


}