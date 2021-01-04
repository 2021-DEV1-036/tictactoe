package application.service;

import application.domain.GameBoard;
import application.model.GameBoardDto;
import application.util.BoardCleanup;
import application.util.Player;
import application.util.Score;
import application.util.SessionCleaner;
import application.validator.SelectionValidator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

@ExtendWith(MockitoExtension.class)
class GameBoardServiceTest {

    @Mock
    private Player player;
    @Mock
    private BoardCleanup boardCleanup;
    @Mock
    private Score score;
    @Mock
    private SessionCleaner sessionCleaner;
    @Mock
    private SelectionValidator selectionValidator;
    @InjectMocks
    private GameBoardService gameBoardService;

    private GameBoardDto gameBoardDto;
    private GameBoard result;
    private GameBoard gameBoard;


    @Test
    void updatesBoard() throws Exception {
        gameBoardDto = new GameBoardDto();
        gameBoardDto.setSelection("top");
        result = gameBoardService.updateBoard(gameBoardDto);

        player = new Player();
        player.playerPosition(result);

        assertThat(result.getTop()).isNotEmpty();
    }


}