package rock_paper_scissors_be.game_list;

public class Game {
    private int gameID;
    private String decisionPlayerOne = "",decisionPlayerTwo = "";

    public Game(int gameID){
        this.gameID = gameID;
    }

    public int getGameID(){
        return  this.gameID;
    }

    public String getPlayerDecision(int playerID) {
        if(playerID == 1)
            return this.decisionPlayerOne;
        else if (playerID == 2)
            return this.decisionPlayerTwo;

        return "";
    }
    public void setPlayerDecision(int playerID, String playerDecision) {
        if(playerID == 1)
            this.decisionPlayerOne = playerDecision;
        else if (playerID == 2)
            this.decisionPlayerTwo = playerDecision;
    }
}
