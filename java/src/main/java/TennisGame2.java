
public class TennisGame2 implements TennisGame {
    public static final String ADVANTAGE_PLAYER_1 = "Advantage player1";
    public static final String ADVANTAGE_PLAYER_2 = "Advantage player2";
    public int P1point = 0;
    public int P2point = 0;
    public String player1Name;
    public String player2Name;

    // TODO Refactor test to remove the players name if need it
    public TennisGame2(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public String getScore() {

        if (P1point >= 4 && P2point >= 0 && (P1point - P2point) >= 2) {
            return "Win for " + player1Name;
        }
        if (P2point >= 4 && P1point >= 0 && (P2point - P1point) >= 2) {
            return "Win for " + player2Name;
        }
        if (hasAdvantageOver(P1point, P2point)) {
            return ADVANTAGE_PLAYER_1;
        }
        if (hasAdvantageOver(P2point, P1point)) {
            return ADVANTAGE_PLAYER_2;
        }
        if (P1point == P2point && P1point >= 3) {
            return "Deuce";
        }
        if (P1point == P2point && P1point < 4) {
            return getDefaultScore(P1point) + "-All";
        }
        return getGameScore(P1point, P2point);
    }

    private static boolean hasAdvantageOver(int playerAPoints, int playerBPoints) {
        //player A have more or equals than 3 points
        boolean isAOverThresshold = playerAPoints >= 3;
        //player b have more or equals than 3 points
        boolean isBOverThresshold = playerBPoints >= 3;
        //player a has one point more player b
        boolean isAOneOver = playerAPoints - playerBPoints == 1;

        return isAOverThresshold && isBOverThresshold && isAOneOver;
    }

    private static String getGameScore(int playerOnePoints, int playerTwoPoints) {
        return getDefaultScore(playerOnePoints) + "-" + getDefaultScore(playerTwoPoints);
    }

    private static String getDefaultScore(int playerPoints) {
        if (playerPoints == 1) return "Fifteen";
        if (playerPoints == 2) return "Thirty";
        if (playerPoints == 3) return "Forty";
        return "Love";
    }

    public void wonPoint(String player) {
        if (player == player1Name)
            P1point++;
        else
            P2point++;
    }
}