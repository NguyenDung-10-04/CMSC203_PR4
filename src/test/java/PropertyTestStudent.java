import static org.junit.Assert.*;


import org.example.Plot;
import org.junit.Before;
import org.junit.Test;
import org.example.Property;  // or adjust according to your package


public class PropertyTestStudent {
    private Property property;

    @Before
    public void setUp() {
        property = new Property("Silver Spring", "Alice", "Sunset Villas", 1500.00, 2, 2, 2, 2) {
        };
    }

    @Test
    public void testConstructorAndGetters() {
        assertEquals("Sunset Villas", property.getPropertyName());
        assertEquals("Silver Spring", property.getCity());
        assertEquals("Alice", property.getOwner());
        assertEquals(1500.00, property.getRentAmount(), 0.01);
    }

    @Test
    public void testToString() {
        assertEquals("Sunset Villas, Silver Spring, 1500.0, Alice", property.toString());
    }

    @Test
    public void testCompareTo() {
        Property lower = new Property("Silver Spring", "Bob", "Budget Suites", 1000.00);
        assertTrue(property.compareTo(lower) > 0);
    }

    @Test
    public void testPlotSetAndGet() {
        Plot newPlot = new Plot(1, 1, 1, 1);
        property.setPlot(newPlot);
        assertEquals(newPlot, property.getPlot());
    }
}
