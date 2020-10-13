package rock_paper_scissors_be.web;

import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.handler.AbstractHandler;
import org.json.JSONObject;
import rock_paper_scissors_be.RockPaperScissors;
import rock_paper_scissors_be.game_list.GameManager;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RockPaperScissorsEndpoint extends AbstractHandler {
    private final RockPaperScissors rockPaperScissors;
    private final GameManager gameManager;

    public RockPaperScissorsEndpoint(RockPaperScissors rockPaperScissors, GameManager gameManager){
        this.rockPaperScissors = rockPaperScissors;
        this.gameManager = gameManager;
    }

    @Override
    public void handle(String target, Request baseRequest, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        int gameID = 0;
        int playerID = 0;
        String playerDecision = "";

        String decisionPlayerOne = "";
        String decisionPlayerTwo = "";
        String gameResolution = "";

        if(request.getParameter("gameID") != null)
            gameID = Integer.parseInt(request.getParameter("gameID"));
        if(request.getParameter("playerID") != null)
            playerID = Integer.parseInt(request.getParameter("playerID"));
        if(request.getParameter("playerDecision") != null)
            playerDecision = request.getParameter("playerDecision");

        if(gameID != 0 && !gameManager.gameExists(gameID)){
            gameManager.createGame(gameID);
        }

        if (    gameID != 0
                && gameManager.gameExists(gameID) &&
                playerID != 0 &&
                playerDecision != ""){
                gameManager.addDecisionToPlayerInGame(gameID, playerID, playerDecision);
        }
        else{
            throw new IOException("GameManager data request failed");
        }

        if(gameManager.allPlayerDecisionsPresent(gameID)){
            String[] gamePlayerDecisions = gameManager.getGameDecisions(gameID);
            decisionPlayerOne = gamePlayerDecisions[0];
            decisionPlayerTwo = gamePlayerDecisions[1];

            gameResolution = rockPaperScissors.compareDecision(decisionPlayerOne, decisionPlayerTwo);
        }

        JSONObject gameData = new JSONObject();
        gameData.put("winner", gameResolution);
        gameData.put("playerOne", decisionPlayerOne);
        gameData.put("playerTwo", decisionPlayerTwo);

        response.getWriter().print(gameData);

        baseRequest.setHandled(true);
    }
}
