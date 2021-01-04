package application.validator;

import application.domain.GameBoard;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.NotReadablePropertyException;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class SelectionValidatorTest {

    public static final String EMPTY = "";
    public static final String X = "x";
    private GameBoard gameBoard = new GameBoard();
    private final String TOPLEFT = EMPTY;

    private SelectionValidator selectionValidator = new SelectionValidator();
    private boolean validationResult;

    @Test
    void cantSelectAnAlreadySelectedPosition() throws Exception {
        gameBoard.setTopLeft(X);
        gameBoard.setSelection(TOPLEFT);
        validationResult = selectionValidator.alreadySelected(gameBoard);
        assertThat(validationResult).isTrue();
    }

    @Test
    void canSelectAPositionThatWasNeverSelected() throws Exception {
        gameBoard.setSelection(TOPLEFT);
        validationResult = selectionValidator.alreadySelected(gameBoard);
        assertThat(validationResult).isTrue();
    }

    @Test
    void selectAWrongPosition() throws Exception {
        gameBoard.setTopLeft(X);
        gameBoard.setSelection("aaa");
        Assertions.assertThrows(NotReadablePropertyException.class, () -> {
            selectionValidator.alreadySelected(gameBoard) ;
        });
    }
}