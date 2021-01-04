package application.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class GameBoardDto implements Serializable {

    private String gameId;
    private String selection;
    private String player1;
    private String player2;
    private String topLeft;
    private String top;
    private String topRight;
    private String left;
    private String middle;
    private String right;
    private String bottomLeft;
    private String bottom;
    private String bottomRight;

}
