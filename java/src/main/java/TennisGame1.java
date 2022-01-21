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
        if (scoreIsEqual()) {
            return getScoreWhenEqual();
        }

        if (player1Score >= 4 || player2Score >= 4) {
            int pointDifference = player1Score - player2Score;

            if (pointDifference == 1) return "Advantage " + player1Name;
            else if (pointDifference == -1) return "Advantage " + player2Name;
            else if (pointDifference >= 2) return "Win for " + player1Name;
            else return "Win for " + player2Name;
        }

        return getDefaultScore(player1Score) + "-" + getDefaultScore(player2Score);
    }

    private boolean scoreIsEqual() {
        return player1Score == player2Score;
    }

    private String getDefaultScore(int tempScore) {
        switch (tempScore) {
            case 0:
                return "Love";
            case 1:
                return "Fifteen";
            case 2:
                return "Thirty";
            default:
                return "Forty";
        }
    }

    private String getScoreWhenEqual() {
        switch (player1Score) {
            case 0:
                return "Love-All";
            case 1:
                return "Fifteen-All";
            case 2:
                return "Thirty-All";
            default:
                return "Deuce";
        }
    }
}
