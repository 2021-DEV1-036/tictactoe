package application.validator;

import application.domain.GameBoard;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.PropertyAccessorFactory;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class SelectionValidator {

    public boolean alreadySelected(GameBoard currentGame)  {
        if (!currentGame.getSelection().isEmpty()) {
            Object propertyValue = PropertyAccessorFactory
                    .forBeanPropertyAccess(currentGame)
                    .getPropertyValue(currentGame.getSelection());
            if(propertyValue == null) {
                throw new NullPointerException("propertyValue not found in alreadySelected");
            }
            return !propertyValue.toString().isEmpty();
        }
        return true;
    }

}
