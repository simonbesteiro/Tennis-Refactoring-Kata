import java.util.Map;
import java.util.Objects;

public class TennisGame1 implements TennisGame {

    public static final String ADVANTAGE = "Advantage ";
    public static final String WIN_FOR = "Win for ";
    private int player1Score = 0;
    private int player2Score = 0;
    private final String player1Name;
    private final String player2Name;

    private final Map<Integer, String> pointsTranslation = Map.of(0,"Love", 1, "Fifteen", 2, "Thirty", 3,"Forty" );

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
            
            if (pointDifference > 0) return getPlayerStatus(pointDifference, player1Name);
            return getPlayerStatus(Math.abs(pointDifference), player2Name);
        }

        return getDefaultScore(player1Score) + "-" + getDefaultScore(player2Score);
    }

    private String getPlayerStatus(int pointsDiff, String playerName){
        if (pointsDiff == 1) return ADVANTAGE+playerName;
        return  WIN_FOR+ playerName;
    }

    private boolean scoreIsEqual() {
        return player1Score == player2Score;
    }

    private String getDefaultScore(int tempScore) {
       return pointsTranslation.get(tempScore);
    }

    private String getScoreWhenEqual() {
        if(player1Score <= 2) {
            return pointsTranslation.get(player1Score)+"-All";
        }

        return "Deuce";
    }
}
