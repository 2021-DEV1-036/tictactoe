package application.validator;

import application.domain.GameBoard;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

class RuleValidatorTest {

    public static final String X = "x";
    public static final String Y = "y";
    private GameBoard gameBoard =  new GameBoard();
    private RuleValidator ruleValidator = new RuleValidator();
    private boolean result;


    @Test
    void player1WinsInFirstRow() throws Exception {
        gameBoard.setTopLeft(X);
        gameBoard.setTop(X);
        gameBoard.setTopRight(X);
        result = ruleValidator.completedFirstRow(gameBoard, X);
        assertThat(result).isTrue();
    }

    @Test
    void player1WinsInSecondRow() throws Exception {
        gameBoard.setLeft(X);
        gameBoard.setMiddle(X);
        gameBoard.setRight(X);
        result = ruleValidator.completedSecondRow(gameBoard, X);
        assertThat(result).isTrue();
    }

    @Test
    void player1WinsInThirdRow() throws Exception {
        gameBoard.setBottomLeft(X);
        gameBoard.setBottom(X);
        gameBoard.setBottomRight(X);
        result = ruleValidator.completedThirdRow(gameBoard, X);
        assertThat(result).isTrue();
    }

    @Test
    void player1WinsInFirstColumn() throws Exception {
        gameBoard.setTopLeft(X);
        gameBoard.setLeft(X);
        gameBoard.setBottomLeft(X);
        result = ruleValidator.completedFirstColumn(gameBoard, X);
        assertThat(result).isTrue();
    }

    @Test
    void player1WinsInSecondColumn() throws Exception {
        gameBoard.setTop(X);
        gameBoard.setMiddle(X);
        gameBoard.setBottom(X);
        result = ruleValidator.completedSecondColumn(gameBoard, X);
        assertThat(result).isTrue();
    }

    @Test
    void player1WinsInThirdColumn() throws Exception {
        gameBoard.setTopRight(X);
        gameBoard.setRight(X);
        gameBoard.setBottomRight(X);
        result = ruleValidator.completedThirdColumn(gameBoard, X);
        assertThat(result).isTrue();
    }

    @Test
    void player1WinsInFirstDiagonal() throws Exception {
        gameBoard.setTopLeft(X);
        gameBoard.setMiddle(X);
        gameBoard.setBottomRight(X);
        result = ruleValidator.completedFirstDiagonal(gameBoard, X);
        assertThat(result).isTrue();
    }

    @Test
    void player1WinsInSecondDiagonal() throws Exception {
        gameBoard.setTopRight(X);
        gameBoard.setMiddle(X);
        gameBoard.setBottomLeft(X);
        result = ruleValidator.completedSecondDiagonal(gameBoard, X);
        assertThat(result).isTrue();
    }

    @Test
    void player2WinsInFirstRow() throws Exception {
        gameBoard.setTopLeft(Y);
        gameBoard.setTop(Y);
        gameBoard.setTopRight(Y);
        result = ruleValidator.completedFirstRow(gameBoard, Y);
        assertThat(result).isTrue();
    }

    @Test
    void player2WinsInSecondRow() throws Exception {
        gameBoard.setLeft(Y);
        gameBoard.setMiddle(Y);
        gameBoard.setRight(Y);
        result = ruleValidator.completedSecondRow(gameBoard, Y);
        assertThat(result).isTrue();
    }

    @Test
    void player2WinsInThirdRow() throws Exception {
        gameBoard.setBottomLeft(Y);
        gameBoard.setBottom(Y);
        gameBoard.setBottomRight(Y);
        result = ruleValidator.completedThirdRow(gameBoard, Y);
        assertThat(result).isTrue();

    }

    @Test
    void player2WinsInFirstColumn() throws Exception {
        gameBoard.setTopLeft(Y);
        gameBoard.setLeft(Y);
        gameBoard.setBottomLeft(Y);
        result = ruleValidator.completedFirstColumn(gameBoard, Y);
        assertThat(result).isTrue();

    }

    @Test
    void player2WinsInSecondColumn() throws Exception {
        gameBoard.setTop(Y);
        gameBoard.setMiddle(Y);
        gameBoard.setBottom(Y);
        result = ruleValidator.completedSecondColumn(gameBoard, Y);
        assertThat(result).isTrue();

    }

    @Test
    void player2WinsInThirdColumn() throws Exception {
        gameBoard.setTopRight(Y);
        gameBoard.setRight(Y);
        gameBoard.setBottomRight(Y);
        result = ruleValidator.completedThirdColumn(gameBoard, Y);
        assertThat(result).isTrue();
    }

    @Test
    void player2WinsInFirstDiagonal() throws Exception {
        gameBoard.setTopLeft(Y);
        gameBoard.setMiddle(Y);
        gameBoard.setBottomRight(Y);
        result = ruleValidator.completedFirstDiagonal(gameBoard, Y);
        assertThat(result).isTrue();
    }

    @Test
    void player2WinsInSecondDiagonal() throws Exception {
        gameBoard.setTopRight(Y);
        gameBoard.setMiddle(Y);
        gameBoard.setBottomLeft(Y);
        result = ruleValidator.completedSecondDiagonal(gameBoard, Y);
        assertThat(result).isTrue();
    }

}