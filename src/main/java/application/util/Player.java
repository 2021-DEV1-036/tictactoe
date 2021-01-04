package application.util;

import application.domain.GameBoard;
import org.springframework.beans.PropertyAccessorFactory;
import org.springframework.stereotype.Component;

@Component
public class Player {

    private String currentSymbol = "x";

    public void playerPosition(GameBoard currentGame) {
        if (!currentGame.getSelection().isEmpty()) {
            PropertyAccessorFactory
                    .forBeanPropertyAccess(currentGame)
                    .setPropertyValue(currentGame.getSelection(), symbol());
        }
    }

    private String symbol() {
        String output = currentSymbol;
        if (currentSymbol.equals(Constants.X)) {
            currentSymbol = Constants.O;
        }
        else {
            currentSymbol = Constants.X;
        }
        return output;
    }
}
