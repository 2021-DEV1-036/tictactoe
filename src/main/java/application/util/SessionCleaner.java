package application.util;

import application.domain.GameBoard;
import application.validator.RuleValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class SessionCleaner {

    @Autowired
    private RuleValidator ruleValidator;
    @Autowired
    private BoardCleanup boardCleanup;

    public void cleanIfNeeded(Map<String, GameBoard> games) {
        for(Map.Entry<String, GameBoard> entry : games.entrySet()) {
            boolean isGameOver = isGameOver(entry.getValue());
            if (isGameOver) {
                games.remove(entry.getValue().getGameId());
            }
        }
    }

    private boolean isGameOver(GameBoard gameBoard) {
        return ruleValidator.completedFirstRow(gameBoard, Constants.X) ||
                        ruleValidator.completedSecondRow(gameBoard, Constants.X) ||
                        ruleValidator.completedThirdRow(gameBoard, Constants.X) ||
                        ruleValidator.completedFirstColumn(gameBoard, Constants.X) ||
                        ruleValidator.completedThirdColumn(gameBoard, Constants.X) ||
                        ruleValidator.completedFirstDiagonal(gameBoard, Constants.X) ||
                        ruleValidator.completedSecondDiagonal(gameBoard, Constants.X) ||
                        ruleValidator.completedFirstRow(gameBoard, Constants.O) ||
                        ruleValidator.completedSecondRow(gameBoard, Constants.O) ||
                        ruleValidator.completedThirdRow(gameBoard, Constants.O) ||
                        ruleValidator.completedFirstColumn(gameBoard, Constants.O) ||
                        ruleValidator.completedThirdColumn(gameBoard, Constants.O) ||
                        ruleValidator.completedFirstDiagonal(gameBoard, Constants.O) ||
                        ruleValidator.completedSecondDiagonal(gameBoard, Constants.O) ||
                        boardCleanup.isFull(gameBoard);
    }
}
