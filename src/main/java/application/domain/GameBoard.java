package application.domain;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class GameBoard implements Serializable {

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

    public GameBoard() {
        this.player1 = "0";
        this.player2 = "0";
        this.topLeft = "";
        this.top = "";
        this.topRight = "";
        this.left = "";
        this.middle = "";
        this.right = "";
        this.bottomLeft = "";
        this.bottom = "";
        this.bottomRight = "";
    }

}
