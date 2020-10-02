package rock_paper_scissors_be;

import java.util.Random;

public class RockPaperScissors {
    public String compareDecision(String playerOneDecision, String playerTwoDecision){

        if(playerOneDecision.equals(playerTwoDecision))
            return "Draw";

        switch(playerOneDecision){
            case "Rock":
                if(playerTwoDecision.equals("Paper"))
                    return "Player 2";
                else
                    return "Player 1";
            case "Paper":
                if(playerTwoDecision.equals("Rock"))
                    return "Player 1";
                else
                    return "Player 2";
            case "Scissors":
                if(playerTwoDecision.equals("Rock"))
                    return "Player 2";
                else
                    return "Player 1";
            default:
                return "ERROR";
        }
    }

    private static final String[] decisionsArray = {
            "Rock",
            "Paper",
            "Scissors"
    };

    public String randomDecision(){
        Random random = new Random();
        return decisionsArray[random.nextInt(3)];
    }
}
