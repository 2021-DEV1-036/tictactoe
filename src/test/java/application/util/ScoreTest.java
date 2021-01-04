package application.util;

import application.domain.GameBoard;
import application.validator.RuleValidator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
class ScoreTest {

    @Mock
    private RuleValidator ruleValidator;
    @InjectMocks
    private Score score;
    private boolean result;
    private static final String X = "x";
    private static final String O = "o";

    @Test
    void winnerIsFoundPlayerX() throws Exception {
        GameBoard gameBoard = new GameBoard();
        gameBoard.setTopLeft("x");
        gameBoard.setLeft("x");
        gameBoard.setBottomLeft("x");

        when(ruleValidator.completedFirstColumn(gameBoard,X)).thenReturn(true);

        result = score.isWinner(gameBoard);
        assertThat(result).isTrue();
    }

    @Test
    void winnerIsNotFoundPlayerX() throws Exception {
        GameBoard gameBoard = new GameBoard();
        gameBoard.setTopLeft("x");

        when(ruleValidator.completedFirstColumn(gameBoard,X)).thenReturn(false);
        result = score.isWinner(gameBoard);
        assertThat(result).isFalse();
    }

    @Test
    void winnerIsFoundPlayerO() throws Exception {
        GameBoard gameBoard = new GameBoard();
        gameBoard.setTopRight("o");
        gameBoard.setRight("o");
        gameBoard.setBottomRight("o");

        when(ruleValidator.completedThirdColumn(gameBoard,O)).thenReturn(true);

        result = score.isWinner(gameBoard);
        assertThat(result).isTrue();
    }

    @Test
    void winnerIsNotFoundPlayerO() throws Exception {
        GameBoard gameBoard = new GameBoard();
        gameBoard.setRight("o");

        when(ruleValidator.completedThirdColumn(gameBoard,O)).thenReturn(false);
        result = score.isWinner(gameBoard);
        assertThat(result).isFalse();
    }

}