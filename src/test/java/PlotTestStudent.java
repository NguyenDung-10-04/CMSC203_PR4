import static org.junit.Assert.*;

import org.example.Plot;
import org.junit.Before;
import org.junit.Test;

public class PlotTestStudent {
    private Plot plot1;
    private Plot plot2;

    @Before
    public void setUp() {
        plot1 = new Plot(1, 1, 4, 4);
        plot2 = new Plot(2, 2, 2, 2);
    }

    @Test
    public void testDefaultConstructor() {
        Plot p = new Plot();
        assertEquals(1, p.getWidth());
        assertEquals(1, p.getDepth());
    }

    @Test
    public void testOverlapsTrue() {
        Plot p = new Plot(2, 2, 2, 2); // Overlaps with plot1
        assertFalse(plot1.overlaps(p));
    }

    @Test
    public void testOverlapsFalse() {
        Plot p = new Plot(10, 10, 2, 2); // No overlap
        assertFalse(plot1.overlaps(p));
    }

    @Test
    public void testEncompassesTrue() {
        assertTrue(plot1.encompasses(plot2));
    }

    @Test
    public void testEncompassesFalse() {
        assertFalse(plot2.encompasses(plot1));
    }

    @Test
    public void testToString() {
        assertEquals("1, 1, 4, 4", plot1.toString());
    }
}
