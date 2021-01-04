package application.service;

import application.domain.GameBoard;
import application.model.GameBoardDto;
import application.util.BoardCleanup;
import application.util.Player;
import application.util.Score;
import application.util.SessionCleaner;
import application.validator.SelectionValidator;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class GameBoardService {

    @Autowired
    private SelectionValidator selectionValidator;
    @Autowired
    private Score score;
    @Autowired
    private BoardCleanup boardCleanup;
    @Autowired
    private Player player;
    @Autowired
    private SessionCleaner sessionCleaner;

    private Map<String,GameBoard> games = new HashMap<>();

    public GameBoard updateBoard(GameBoardDto gameBoardDto) {
        ModelMapper modelMapper = new ModelMapper();
        GameBoard gameBoard = modelMapper.map(gameBoardDto, GameBoard.class);
        GameBoard currentGame = getCurrentGame(gameBoard);

        if(!selectionValidator.alreadySelected(currentGame)) {
            player.playerPosition(currentGame);
            if(score.isWinner(currentGame) || boardCleanup.isFull(currentGame)) {
                boardCleanup.empty(currentGame);
            }
        }
        return currentGame;
    }

    protected GameBoard getCurrentGame(GameBoard game) {
        GameBoard currentGame = null;

        if(game != null) {
            sessionCleaner.cleanIfNeeded(games);
            currentGame = games.get(game.getGameId());

            if(currentGame == null) {
                games.put(game.getGameId(), game);
            }

            currentGame = games.get(game.getGameId());
            currentGame.setSelection(game.getSelection());
        }
        return currentGame;
    }

}
