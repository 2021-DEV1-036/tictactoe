package application.acceptanceTest;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;
import selenium.GuiSelenium;

import static org.assertj.core.api.Assertions.assertThat;
import static org.openqa.selenium.By.id;

class TicTacToeAcceptaceTest extends GuiSelenium {

    public static final String EMPTY = "";

    @Test
    void theBoardIsEmpty() throws Exception {
        givenUserIsAtTheGamePage();
        whenThePlayerLooksAtTheBoard();
        thenTheBoardIsEmpty();
    }

    @Test
    void player1SelectsPossition() throws Exception {
        givenUserIsAtTheGamePage();
        whenTheUserSelectsAPosition();
        thenJustTheSelectedPositionRemainsSelected();
    }

    private void givenUserIsAtTheGamePage() throws Exception {
        navigateToGame();
    }

    private void whenThePlayerLooksAtTheBoard() throws Exception {
        takeScreenshoot("Board");
    }

    private void whenTheUserSelectsAPosition() throws InterruptedException {
        String position = "top-left";
        interestingGivens.add("Selected Position", position);
        WebElement element = driver.findElement(id(position));
        element.click();
    }

    private void thenTheBoardIsEmpty() throws Exception {
        assertThat(driver.findElement(id("top-left")).getText()).isEqualTo(EMPTY);
        assertThat(driver.findElement(id("top")).getText()).isEqualTo(EMPTY);
        assertThat(driver.findElement(id("top-right")).getText()).isEqualTo(EMPTY);
        assertThat(driver.findElement(id("left")).getText()).isEqualTo(EMPTY);
        assertThat(driver.findElement(id("middle")).getText()).isEqualTo(EMPTY);
        assertThat(driver.findElement(id("right")).getText()).isEqualTo(EMPTY);
        assertThat(driver.findElement(id("bottom-left")).getText()).isEqualTo(EMPTY);
        assertThat(driver.findElement(id("bottom")).getText()).isEqualTo(EMPTY);
        assertThat(driver.findElement(id("bottom-right")).getText()).isEqualTo(EMPTY);
    }

    private void thenJustTheSelectedPositionRemainsSelected() throws Exception {
        takeScreenshoot("Board after player selects position");
        assertThat(driver.findElement(id("top-left")).getText()).isEqualTo("x");
        assertThat(driver.findElement(id("top")).getText()).isEqualTo(EMPTY);
        assertThat(driver.findElement(id("top-right")).getText()).isEqualTo(EMPTY);
        assertThat(driver.findElement(id("left")).getText()).isEqualTo(EMPTY);
        assertThat(driver.findElement(id("middle")).getText()).isEqualTo(EMPTY);
        assertThat(driver.findElement(id("right")).getText()).isEqualTo(EMPTY);
        assertThat(driver.findElement(id("bottom-left")).getText()).isEqualTo(EMPTY);
        assertThat(driver.findElement(id("bottom")).getText()).isEqualTo(EMPTY);
        assertThat(driver.findElement(id("bottom-right")).getText()).isEqualTo(EMPTY);
    }

    private void navigateToGame() throws Exception {
        driver.get("http://localhost:8082");
        takeScreenshoot("Board");
    }
}
