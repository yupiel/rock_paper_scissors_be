package rock_paper_scissors_be;

import static org.junit.Assert.*;
import org.junit.Test;

public class RockPaperScissorsTest {

    RockPaperScissors RockPaperScissors = new RockPaperScissors();

    @Test
    public void compareDecision_bothDecisionsAreEqual_should_ReturnDraw(){
        String expectedResult = "Draw";
        String actualResult = RockPaperScissors.compareDecision("Rock", "Rock");
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void compareDecision_playerOneDecisionRock_playerTwoDecisionScissors_should_ReturnPlayerOneWin(){
        String expectedResult = "Player 1";
        String actualResult = RockPaperScissors.compareDecision("Rock", "Scissors");
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void compareDecision_playerOneDecisionPaper_playerTwoDecisionRock_should_ReturnPlayerOneWin(){
        String expectedResult = "Player 1";
        String actualResult = RockPaperScissors.compareDecision("Paper", "Rock");
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void compareDecision_playerOneDecisionScissors_playerTwoDecisionPaper_should_ReturnPlayerOneWin(){
        String expectedResult = "Player 1";
        String actualResult = RockPaperScissors.compareDecision("Scissors", "Paper");
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void compareDecision_playerOneDecisionRock_playerTwoDecisionScissors_should_ReturnPlayerTwoWin(){
        String expectedResult = "Player 2";
        String actualResult = RockPaperScissors.compareDecision("Scissors", "Rock");
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void compareDecision_playerOneDecisionPaper_playerTwoDecisionRock_should_ReturnPlayerTwoWin(){
        String expectedResult = "Player 2";
        String actualResult = RockPaperScissors.compareDecision("Rock", "Paper");
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void compareDecision_playerOneDecisionScissors_playerTwoDecisionPaper_should_ReturnPlayerTwoWin(){
        String expectedResult = "Player 2";
        String actualResult = RockPaperScissors.compareDecision("Paper", "Scissors");
        assertEquals(expectedResult, actualResult);
    }
}
