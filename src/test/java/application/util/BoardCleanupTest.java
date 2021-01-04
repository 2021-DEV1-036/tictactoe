package application.util;

import application.domain.GameBoard;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
class BoardCleanupTest {

    private GameBoard gameBoard;
    @InjectMocks
    private BoardCleanup boardCleanup;
    private boolean isFull;

    @Test
    void cleansUpBoard() throws Exception {
        givenANonEmptyBoard();
        boardCleanup.empty(gameBoard);
        assertThat(gameBoard.getBottom()).isEmpty();
    }

    @Test
    void boardIsFull() throws Exception {
        givenAFullBoard();
        isFull = boardCleanup.isFull(gameBoard);
        assertThat(isFull).isTrue();
    }

    @Test
    void boardIsNotFull() throws Exception {
        givenANonEmptyBoard();
        isFull = boardCleanup.isFull(gameBoard);
        assertThat(isFull).isFalse();
    }

    private void givenANonEmptyBoard() {
        gameBoard = new GameBoard();
        gameBoard.setBottom("X");
    }

    private void givenAFullBoard() {
        gameBoard = new GameBoard();
        gameBoard.setTopLeft("X");
        gameBoard.setTop("X");
        gameBoard.setTopRight("X");

        gameBoard.setLeft("X");
        gameBoard.setMiddle("X");
        gameBoard.setRight("X");

        gameBoard.setBottomLeft("X");
        gameBoard.setBottom("X");
        gameBoard.setBottomRight("X");
    }

}