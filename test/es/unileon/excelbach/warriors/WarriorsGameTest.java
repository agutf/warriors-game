package es.unileon.excelbach.warriors;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class WarriorsGameTest {

    private WarriorsGame game;

    @Before
    public void setUp() throws WarriorsGameException {
        this.game = new WarriorsGame("Menganito", 20, "Fulanito", 20);
    }

    @Test
    public void testWarriorsGame() {
        assertEquals("Menganito\n" +
                    "********************\n" + 
                    "\n" + 
                    "Fulanito\n" +
                    "********************\n" +
                    "\n", this.game.toString());
    }

    @Test
    public void testGetShift() {
        assertEquals("Menganito", this.game.getShift());
        this.game.addShield();
        assertEquals("Fulanito", this.game.getShift());
    }

    @Test
    public void testAttack() {
        assertEquals("Menganito", this.game.getShift());
        this.game.attack();
        assertEquals("Fulanito", this.game.getShift());
        this.game.attack();
        assertEquals("Menganito", this.game.getShift());
    }

    @Test
    public void testHasWinner() {
        assertFalse(this.game.hasWinner());
        this.game.attack();
        this.game.attack();
        this.game.attack();
        this.game.attack();
        this.game.attack();
        this.game.attack();
        this.game.attack();
        this.game.attack();
        this.game.attack();
        this.game.attack();
        assertTrue(this.game.hasWinner());
    }
}