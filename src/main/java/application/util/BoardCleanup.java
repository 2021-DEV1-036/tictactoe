package application.util;

import application.domain.GameBoard;
import org.springframework.stereotype.Component;

@Component
public class BoardCleanup {

    public void empty(GameBoard currentGame) {
        currentGame.setTopLeft(Constants.EMPTY);
        currentGame.setTopRight(Constants.EMPTY);
        currentGame.setTop(Constants.EMPTY);
        currentGame.setLeft(Constants.EMPTY);
        currentGame.setMiddle(Constants.EMPTY);
        currentGame.setRight(Constants.EMPTY);
        currentGame.setBottomLeft(Constants.EMPTY);
        currentGame.setBottom(Constants.EMPTY);
        currentGame.setBottomRight(Constants.EMPTY);
    }

    public boolean isFull(GameBoard currentGame) {
        return !currentGame.getTopLeft().isEmpty() &&
                !currentGame.getTop().isEmpty() &&
                !currentGame.getTopRight().isEmpty() &&
                !currentGame.getLeft().isEmpty() &&
                !currentGame.getMiddle().isEmpty() &&
                !currentGame.getRight().isEmpty() &&
                !currentGame.getBottomLeft().isEmpty() &&
                !currentGame.getBottom().isEmpty() &&
                !currentGame.getBottomRight().isEmpty();
    }
}
