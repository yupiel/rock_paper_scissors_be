package rock_paper_scissors_be.web;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.ContextHandler;
import org.eclipse.jetty.server.handler.ContextHandlerCollection;
import rock_paper_scissors_be.RockPaperScissors;
import rock_paper_scissors_be.game_list.GameManager;

public class WebServer {
    private final RockPaperScissors rockPaperScissors;
    private final GameManager gameManager;

    public WebServer(RockPaperScissors rockPaperScissors, GameManager gameManager){
        this.rockPaperScissors = rockPaperScissors;
        this.gameManager = gameManager;
    }

    public void startServer() throws Exception{
        final ContextHandler pageHandler = new ContextHandler("/home");
        pageHandler.setAllowNullPathInfo(true);
        pageHandler.setHandler(new RockPaperScissorsEndpoint(this.rockPaperScissors, this.gameManager));

        ContextHandlerCollection handlerCollection = new ContextHandlerCollection(pageHandler);

        String port = System.getenv("PORT");
        if(port == null) port = "8080";
        final Server server = new Server(Integer.parseInt(port));

        server.setHandler(handlerCollection);
        server.start();
        server.join();
    }
}
