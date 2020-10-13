package rock_paper_scissors_be;

//import java.util.Scanner;

import rock_paper_scissors_be.game_list.GameManager;
import rock_paper_scissors_be.web.WebServer;

public class Main {
    public static void main(String[] args) throws Exception {
        RockPaperScissors rockPaperScissors = new RockPaperScissors();
        GameManager gameManager = new GameManager();

        new WebServer(rockPaperScissors, gameManager).startServer();

        /*
        System.out.println("Write One of the following:\nRock\nPaper\nScissors\n");
        Scanner scanner = new Scanner(System.in);
        String consoleInput = scanner.next();

        String randomPick = RockPaperScissors.randomDecision();
        String result = RockPaperScissors.compareDecision(consoleInput, randomPick);

        System.out.println("\nYou Picked: " + consoleInput + "\nThe Enemy picked: " + randomPick + "\n");

        switch(result){
            case "Draw":
                System.out.print("The result is a Draw.");
                break;
            case "Player 1":
                System.out.println("The Winner is Player 1");
                break;
            case "Player 2":
                System.out.println("The Winner is Player 2");
                break;

            default:
                System.out.println("There was an Error");
        }*/
    }
}
