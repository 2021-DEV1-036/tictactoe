package application.util;

import application.domain.GameBoard;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

class PlayerTest {

    private GameBoard gameBoard = new GameBoard();
    private Player player = new Player();

    @Test
    void resolvesGame() throws Exception {
        gameBoard.setSelection("left");
        player.playerPosition(gameBoard);

        gameBoard.setSelection("top");
        player.playerPosition(gameBoard);

        assertThat(gameBoard.getTop()).isEqualTo("o");
    }

}