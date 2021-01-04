package application.util;

import application.domain.GameBoard;
import application.validator.RuleValidator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class SessionCleanerTest {

    private Map<String, GameBoard> session = new HashMap<>();

    @Mock
    private RuleValidator ruleValidator;

    @InjectMocks
    private SessionCleaner sessionCleaner;
    private GameBoard gameBoard = new GameBoard();
    private static final String symbol = "x";

    @Test
    void cleansFinishedGamesFromSession() throws Exception {
        gameBoard.setTopLeft("x");
        gameBoard.setLeft("x");
        gameBoard.setBottomLeft("x");

        when(ruleValidator.completedFirstColumn(gameBoard,symbol)).thenReturn(true);

        session.put(gameBoard.getGameId(), gameBoard);
        sessionCleaner.cleanIfNeeded(session);
        assertThat(session.get("1")).isNull();
    }

}