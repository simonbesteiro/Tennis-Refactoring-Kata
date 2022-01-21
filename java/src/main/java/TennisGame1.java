import java.util.Objects;

public class TennisGame1 implements TennisGame {

    private int player1Score = 0;
    private int player2Score = 0;
    private final String player1Name;
    private final String player2Name;

    public TennisGame1(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String playerName) {
        if (Objects.equals(playerName, player1Name))
            player1Score += 1;
        else
            player2Score += 1;
    }

    public String getScore() {
        String score = "";

        if (player1Score == player2Score) {
            return getScoreWhenEqual();
        } else if (player1Score >= 4 || player2Score >= 4) {

            int pointDifference = player1Score - player2Score;
            if (pointDifference == 1) score = "Advantage "+ player1Name;
            else if (pointDifference == -1) score = "Advantage "+ player2Name ;
            else if (pointDifference >= 2) score = "Win for "+player1Name;
            else score = "Win for "+ player2Name;

        } else {
           return getDefaultScore("", player1Score) + "-" + getDefaultScore("", player2Score);
        }
        return score;
    }

    private String getDefaultScore(String score, int tempScore) {
        switch (tempScore) {
            case 0:
                score += "Love";
                break;
            case 1:
                score += "Fifteen";
                break;
            case 2:
                score += "Thirty";
                break;
            case 3:
                score += "Forty";
                break;
        }
        return score;
    }

    private String getScoreWhenEqual() {
        String score;
        switch (player1Score) {
            case 0:
                score = "Love-All";
                break;
            case 1:
                score = "Fifteen-All";
                break;
            case 2:
                score = "Thirty-All";
                break;
            default:
                score = "Deuce";
                break;

        }
        return score;
    }
}
