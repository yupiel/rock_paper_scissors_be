package rock_paper_scissors_be.game_list;

import java.util.ArrayList;

public class GameListings {
    ArrayList<Game> gameList = new ArrayList<Game>();

    public boolean addGameToList(Game game){
        return gameList.add(game);
    }

    public Game getGameByGameID(int gameID){
        for (Game game: gameList) {
            if(game.getGameID() == gameID)
                return game;
        }
        return null;
    }

    public boolean removeGameFromList(int gameID){
        for (Game game: gameList) {
            if(game.getGameID() == gameID)
                return gameList.remove(game);
        }
        return false;
    }
}
