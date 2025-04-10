import static org.junit.Assert.*;
import org.example.Property;  // or adjust according to your package

import org.example.ManagementCompany;
import org.junit.Before;
import org.junit.Test;

public class ManagementCompanyTestStudent {
    private ManagementCompany mgmt;

    @Before
    public void setUp() {
        mgmt = new ManagementCompany("Urban Manage", "12345", 10);
    }

    @Test
    public void testAddPropertyValid() {
        int index = mgmt.addProperty(new Property("Rockville", "Tom", "Lakeview", 1800.00, 1, 1, 2, 2));
        assertEquals(0, index);
        assertEquals(1, mgmt.getPropertiesCount());
    }

    @Test
    public void testAddPropertyArrayFull() {
        for (int i = 0; i < ManagementCompany.MAX_PROPERTY; i++) {
            mgmt.addProperty(new Property("City", "Owner", "Prop" + i, 1000, i, 0, 1, 1));
        }
        int result = mgmt.addProperty(new Property("City", "Extra", "ExtraProp", 1000, 10, 0, 1, 1));
        assertEquals(-1, result); // Full
    }

    @Test
    public void testAddPropertyNull() {
        assertEquals(-2, mgmt.addProperty(null));
    }

    @Test
    public void testAddPropertyNotEncompassed() {
        Property p = new Property("TooBig", "Zoe", "BigPlot", 3000, 0, 0, 20, 20);
        assertEquals(-3, mgmt.addProperty(p));
    }

    @Test
    public void testAddPropertyOverlap() {
        Property p1 = new Property("Overlap1", "O1", "P1", 1000, 1, 1, 3, 3);
        Property p2 = new Property("Overlap2", "O2", "P2", 1200, 2, 2, 3, 3); // Overlaps p1
        mgmt.addProperty(p1);
        assertEquals(1, mgmt.addProperty(p2));
    }

    @Test
    public void testGetHighestRentProperty() {
        mgmt.addProperty(new Property("City", "Owner1", "Low", 800, 0, 0, 1, 1));
        mgmt.addProperty(new Property("City", "Owner2", "High", 2000, 2, 2, 1, 1));
        assertEquals("High", mgmt.getHighestRentProperty().getPropertyName());
    }

    @Test
    public void testGetTotalRent() {
        mgmt.addProperty(new Property("City", "Owner1", "Prop1", 1000, 0, 0, 1, 1));
        mgmt.addProperty(new Property("City", "Owner2", "Prop2", 1500, 2, 2, 1, 1));
        assertEquals(2500.0, mgmt.getTotalRent(), 0.01);
    }

    @Test
    public void testIsPropertyFull() {
        for (int i = 0; i < ManagementCompany.MAX_PROPERTY; i++) {
            mgmt.addProperty(new Property("City", "Owner", "Prop" + i, 1000, i, 0, 1, 1));
        }
        assertTrue(mgmt.isPropertyFull());
    }

    @Test
    public void testIsManagementFeeValid() {
        assertTrue(mgmt.isManagementFeeValid());
        ManagementCompany invalid = new ManagementCompany("Invalid", "000", 110.0);
        assertFalse(invalid.isManagementFeeValid());
    }

    @Test
    public void testToString() {
        mgmt.addProperty(new Property("City", "Owner", "Prop1", 1000, 0, 0, 1, 1));
        String output = mgmt.toString();
        assertTrue(output.contains("Prop1"));
        assertTrue(output.contains("Owner"));
    }
}
