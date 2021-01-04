package application.util;

import application.domain.GameBoard;
import application.validator.RuleValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static java.lang.Integer.valueOf;

@Component
public class Score {

    @Autowired
    private RuleValidator ruleValidator;

    public boolean isWinner(GameBoard currentGame) {
        if(ruleValidator.completedFirstRow(currentGame, Constants.X) ||
                ruleValidator.completedSecondRow(currentGame, Constants.X) ||
                ruleValidator.completedThirdRow(currentGame, Constants.X) ||
                ruleValidator.completedFirstColumn(currentGame, Constants.X) ||
                ruleValidator.completedSecondColumn(currentGame, Constants.X) ||
                ruleValidator.completedThirdColumn(currentGame, Constants.X) ||
                ruleValidator.completedFirstDiagonal(currentGame, Constants.X) ||
                ruleValidator.completedSecondDiagonal(currentGame, Constants.X)) {
            increasePlayer1Score(currentGame);
            return true;
        }
        else if(ruleValidator.completedFirstRow(currentGame, Constants.O) ||
                ruleValidator.completedSecondRow(currentGame, Constants.O) ||
                ruleValidator.completedThirdRow(currentGame, Constants.O) ||
                ruleValidator.completedFirstColumn(currentGame, Constants.O) ||
                ruleValidator.completedSecondColumn(currentGame, Constants.O) ||
                ruleValidator.completedThirdColumn(currentGame, Constants.O) ||
                ruleValidator.completedFirstDiagonal(currentGame, Constants.O) ||
                ruleValidator.completedSecondDiagonal(currentGame, Constants.O)) {
            increasePlayer2Score(currentGame);
            return true;
        }
        return false;
    }

    private void increasePlayer1Score(GameBoard gameBoard) {
        gameBoard.setPlayer1((valueOf(gameBoard.getPlayer1()) + 1) + Constants.EMPTY);
    }

    private void increasePlayer2Score(GameBoard gameBoard) {
        gameBoard.setPlayer2((valueOf(gameBoard.getPlayer2()) + 1) + Constants.EMPTY);
    }

}
