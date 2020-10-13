package rock_paper_scissors_be.game_list;

public class GameManager {
    GameListings gameListings = new GameListings();

    public void createGame(int gameID){
        Game game = new Game(gameID);
        gameListings.addGameToList(game);
    }

    public boolean gameExists(int gameID){
        return gameListings.getGameByGameID(gameID) != null;
    }

    public String[] getGameDecisions(int gameID){
        Game game = gameListings.getGameByGameID(gameID);
        return new String[] {game.getPlayerDecision(1), game.getPlayerDecision(2)};
    }

    public void addDecisionToPlayerInGame(int gameID, int playerID, String playerDecision){
        Game game = gameListings.getGameByGameID(gameID);
        if(game.getPlayerDecision(playerID) == "")
            game.setPlayerDecision(playerID, playerDecision);
    }

    public boolean allPlayerDecisionsPresent(int gameID){
        Game game = gameListings.getGameByGameID(gameID);

        if(game.getPlayerDecision(1) != ""
        && game.getPlayerDecision(2) != ""){
            return true;
        }

        return false;
    }
}
