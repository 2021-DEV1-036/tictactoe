package application.controller;

import application.domain.GameBoard;
import application.model.GameBoardDto;
import application.service.GameBoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

import static org.springframework.http.HttpStatus.OK;

@RestController
public class TicTacToeController {

    @Autowired
    private GameBoardService gameBoardService;

    @PutMapping(value = {"play"}, consumes = "application/json", produces = "application/json")
    public @ResponseBody ResponseEntity<GameBoard> play(HttpSession httpSession, @RequestBody GameBoardDto gameBoardDto) {
        GameBoard gameBoard = gameBoardService.updateBoard(gameBoardDto);
        return new ResponseEntity<>(gameBoard, OK);
    }

}
