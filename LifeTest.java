import org.junit.Test;
import static org.junit.Assert.*;

public class LifeTest {
    
    @Test
    public void createNewCell() {
        
        // Arrange: drei lebende Zellen
        Life l = new Life();
        l.setAlive(0, 0);
        l.setAlive(0, 1);
        l.setAlive(0, 2);

        // Act: Berechnung der Folgegeneration
        ILife nextGen = l.nextGeneration();

        // Assert: Rasterpunkt mit drei Nachbarn sollte jetzt leben
        assertTrue(nextGen.isAlive(1, 1));
    }


    @Test
    public void destroyLonelyCell() {
        
        // Arrange: eine lebende Zelle
        Life l = new Life();
        l.setAlive(1, 1);

        // Act: Berechnung der Folgegeneration
        ILife nextGen = l.nextGeneration();

        // Assert: Rasterpunkt ohne Nachbarn sollte jetzt tot sein
        assertFalse(nextGen.isAlive(1, 1));

    }


    @Test
    public void keepAliveCell() {
    }


    @Test
    public void destroyCrowdedCell() {
    }


}
