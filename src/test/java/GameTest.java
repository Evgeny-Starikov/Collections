import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameTest {


    @Test
    public void FirstPlayerWin() {
        Player joe = new Player(46, "Джо", 120);
        Player donald = new Player(45, "Дональд", 100);
        Game game = new Game();

        game.register(joe);
        game.register(donald);
        int actual = game.round("Джо", "Дональд");
        int expected = 1;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void SecondPlayerWin() {
        Player donald = new Player(45, "Дональд", 120);
        Player joe = new Player(46, "Джо", 100);

        Game game = new Game();

        game.register(joe);
        game.register(donald);
        int actual = game.round("Джо", "Дональд");
        int expected = 2;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void StrengthEqual() {
        Player donald = new Player(45, "Дональд", 100);
        Player joe = new Player(46, "Джо", 100);

        Game game = new Game();

        game.register(joe);
        game.register(donald);
        int actual = game.round("Джо", "Дональд");
        int expected = 0;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void FirstPlayerNotRegistered() {

        Player joe = new Player(46, "Джо", 100);
        Game game = new Game();

        game.register(joe);
        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("Вова З.", "Джо")
        );
    }

    @Test
    public void SecondPlayerNotRegistered() {

        Player joe = new Player(46, "Джо", 100);
        Game game = new Game();

        game.register(joe);
        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("Джо", "Вова З.")
        );
    }

}
