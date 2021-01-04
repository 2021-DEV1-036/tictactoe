package application.validator;

import application.domain.GameBoard;
import org.springframework.stereotype.Component;

@Component
public class RuleValidator {

        public boolean completedSecondDiagonal(GameBoard currentGame, String symbol) {
            return currentGame.getTopRight().equals(symbol) &&
                    currentGame.getMiddle().equals(symbol) &&
                    currentGame.getBottomLeft().equals(symbol);
        }

        public boolean completedFirstDiagonal(GameBoard currentGame, String symbol) {
            return currentGame.getTopLeft().equals(symbol) &&
                    currentGame.getMiddle().equals(symbol) &&
                    currentGame.getBottomRight().equals(symbol);
        }

        public boolean completedThirdColumn(GameBoard currentGame, String symbol) {
            return currentGame.getTopRight().equals(symbol) &&
                    currentGame.getRight().equals(symbol) &&
                    currentGame.getBottomRight().equals(symbol);
        }

        public boolean completedSecondColumn(GameBoard currentGame, String symbol) {
            return currentGame.getTop().equals(symbol) &&
                    currentGame.getMiddle().equals(symbol) &&
                    currentGame.getBottom().equals(symbol);
        }

        public boolean completedFirstColumn(GameBoard currentGame, String symbol) {
            return currentGame.getTopLeft().equals(symbol) &&
                    currentGame.getLeft().equals(symbol) &&
                    currentGame.getBottomLeft().equals(symbol);
        }

        public boolean completedThirdRow(GameBoard currentGame,String symbol) {
            return currentGame.getBottomLeft().equals(symbol) &&
                    currentGame.getBottom().equals(symbol) &&
                    currentGame.getBottomRight().equals(symbol);
        }

        public boolean completedFirstRow(GameBoard currentGame, String symbol) {
            return currentGame.getTopLeft().equals(symbol) &&
                    currentGame.getTop().equals(symbol) &&
                    currentGame.getTopRight().equals(symbol);
        }

        public boolean completedSecondRow(GameBoard currentGame,String symbol) {
            return currentGame.getLeft().equals(symbol) &&
                    currentGame.getMiddle().equals(symbol) &&
                    currentGame.getRight().equals(symbol);
        }

}
