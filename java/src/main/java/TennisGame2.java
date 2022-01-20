
public class TennisGame2 implements TennisGame
{
    public static final String WIN_FOR_PLAYER_2 = "Win for player2";
    public static final String WIN_FOR_PLAYER_1 = "Win for player1";
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

    public String getScore(){
        String score = "";
        if (P1point == P2point && P1point < 4)
        {
            score = getDefaultScore(P1point) + "-All";
        }
        if (P1point == P2point && P1point >= 3){
            score = "Deuce";
        }
        if (P1point > 0 && P2point==0)
        {
            score = getGameScore(P1point, P2point);
        }
        if (P2point > 0 && P1point==0)
        {
            score =  getGameScore(P1point, P2point);
        }
        if (P1point>P2point && P1point < 4)
        {
            score =  getGameScore(P1point, P2point);
        }
        if (P2point>P1point && P2point < 4)
        {
            score =  getGameScore(P1point, P2point);
        }

        if (P1point > P2point && P2point >= 3)
        {
            score = ADVANTAGE_PLAYER_1;
        }

        if (P2point > P1point && P1point >= 3)
        {
            score = ADVANTAGE_PLAYER_2;
        }

        if (P1point>=4 && P2point>=0 && (P1point-P2point)>=2)
        {
            return WIN_FOR_PLAYER_1;
        }
        if (P2point>=4 && P1point>=0 && (P2point-P1point)>=2)
        {
            return WIN_FOR_PLAYER_2;
        }
        return score;
    }

    private static String getGameScore(int playerOnePoints, int playerTwoPoints) {
        return getDefaultScore(playerOnePoints) + "-" + getDefaultScore(playerTwoPoints);
    }

    private static String getDefaultScore(int playerPoints) {
        if (playerPoints==1) return "Fifteen";
        if (playerPoints==2) return "Thirty";
        if (playerPoints==3) return "Forty";
        return "Love";
    }

    public void wonPoint(String player) {
        if (player == "player1")
            P1point++;
        else
            P2point++;
    }
}