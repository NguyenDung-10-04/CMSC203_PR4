package org.example;

import java.util.ArrayList;
import java.util.Collections;

public class ManagementCompany {
    public static final int MAX_PROPERTY = 5;
    public static final int MGMT_DEPTH = 10;
    public static final int MGMT_WIDTH = 10;
    private String name;
    private String taxId;
    private double mgmFee;
    private ArrayList<Property> properties;
    private Plot plot;


    public ManagementCompany() {
        this.name = "";
        this.taxId = "";
        this.mgmFee = 0.0;
        this.properties = new ArrayList<>();
        // default Plot with maximum width and depth
        this.plot = new Plot(0,0,MGMT_WIDTH,MGMT_DEPTH );
    }

    public ManagementCompany(String name, String taxId, double mgmFee) {
        this.name = name;
        this.taxId = taxId;
        this.mgmFee = mgmFee;
        this.properties = new ArrayList<>();
        this.plot = new Plot(0,0,MGMT_WIDTH,MGMT_DEPTH);
    }

    public ManagementCompany(String name, String taxId, double mgmFee, int x, int y, int width, int depth) {
        this.name = name;
        this.taxId = taxId;
        this.mgmFee = mgmFee;
        this.properties = new ArrayList<>();
        this.plot = new Plot(x,y,width,depth);
    }

    public ManagementCompany(ManagementCompany otherCompany){
        this.name = otherCompany.name;
        this.taxId = otherCompany.taxId;
        this.mgmFee = otherCompany.mgmFee;
        this.plot = new Plot(otherCompany.plot);

        this.properties = new ArrayList<>(); // properties => []
        // Dùng 1 vòng for để copy: otherCompany: 5 object:
        // object => properties (1 array 5 phần tử)
        for(Property p : otherCompany.properties){
            this.properties.add(new Property(p));
        }
    }

    public String getName() {
        return name;
    }

    public String getTaxId() {
        return taxId;
    }

    public double getMgmFee() {
        return mgmFee;
    }

    public ArrayList<Property> getProperties() {
        return properties;
    }

    public Plot getPlot() {
        return plot;
    }
    // Property: getHighestRentPropperty()
    //Gets the property in the array with the maximum amount of rent
    public Property getHighestRentProperty(){
        if(properties.isEmpty()) return null;
        Collections.sort(properties); //  arrrayList . get để lấy index []
        return properties.get(properties.size() -1);
    }

    // getTotalRent(): Returns the total rent of the properties in the properties array
    public double getTotalRent(){
        double sum = 0;
        for (Property p : properties){
            sum += p.getRentAmount();
        }
        return sum;
    }
    /*

int: addProperty(String name, String city, double rent, String owner)
Adds a new property to the properties array, this method should call an appropriate existing overloaded method.
int
addProperty(String name, String city, double rent, String owner, int x, int y, int width, int depth)
Adds a new property to the properties array, this method should call an appropriate existing overloaded method.
int
addProperty(Property property)
Creates a property object by copying from another property and adds it to the properties array.
     */

    public int addProperty(String name, String city, double rent, String owner){
        // ArrayList<Property> property = new ArrayList<>();
        // properties : 5 phần tử
        // 10 phần tử (
        // add 1 cái mới: không cần phải cho vào vòng for
        Property p = new Property(city, owner, name , rent );
        properties.add(p);
        return 0;
    }

    public int addProperty(String name, String city, double rent, String owner, int x, int y, int width, int depth) {
        Property p = new Property(city,owner,name,rent,x,y,width,depth);
        properties.add(p);
        return 0;
    }
    /*
    2.4.3.	addProperty methods  will return the index of the array where the property is added. one of the following values depending on success or failure of the adding the property:
•	If there is a problem adding the property, this method will return
•o	-1 If the array is full, it will return -1
•o	-2 If the property is null, it will return -2
o	-3 If the plot for the property is not encompassed by the management company plot, it will return -3
o	-4 iIf the plot for the property overlaps any other property’s plot, it will return -4.
•	Otherwise if the property is successfully added, it will return the index of the array where the property was added
        0 2 3 4 5 ( 5)
        0 1 2 3 4
        0 2 3 4 5 9
                  =>

        0 2 3 (3)
        0 2 3 [9] (4)
       index:  3
     */
    public int addProperty(Property property){
        if(properties.size()>= MAX_PROPERTY)
            return -1;
        else if (property == null)
            return -2;
        else if(!this.plot.encompasses(property.getPlot()))
            return -3;
        for (Property existing : properties) {
            if (existing.getPlot().overlaps(property.getPlot())) {
                return -4;
            }
        }
        properties.add(property); // 4
        // int:
        return properties.size() - 1 ;
    }

    public void removeLastProperty(){
        for (Property p : properties){
            if(p != null){
                properties.remove(properties.size()-1);
            }
        }
    }

    /*7.	Method isPropertiesFull - Checks if the properties array has reached the maximum capacity
     */
    public boolean isPropertyFull(){
        for (Property p : properties) {
            if (p == null)
                return false;
        }
        return true;
    }

    public boolean isManagementFeeValid(){
        return mgmFee >= 0 && mgmFee <= 100;
    }
    public int getPropertiesCount(){
        int count = 0;
        for(Property p : properties){
            if(p != null) {
                count++;
            }
        }
        return count;
    }
    // Note:
    public String toString() {
        StringBuilder result = new StringBuilder();

        // Add the header with the company name and tax ID
        result.append("List of the properties for ").append(name)
                .append(", taxID: ").append(taxId).append("\n");
        result.append("______________________________________________________\n");

        // Loop through the properties list and display each property information
        for (Property p : properties) {
            if (p != null) {
                result.append("Property Name: ").append(p.getPropertyName()).append("\n");
                result.append(" Located in ").append(p.getCity()).append("\n"); // Fix to display city
                result.append(" Belonging to: ").append(p.getOwner()).append("\n");
                result.append(" Rent Amount: ").append(p.getRentAmount()).append("\n");
                result.append("______________________________________________________\n");
            }
        }

        // Add the total management fee at the end
        double totalManagementFee = getTotalRent() * mgmFee / 100;  // Assuming fee is a percentage of rent
        result.append("\ntotal management Fee: ").append(totalManagementFee).append("\n");

        return result.toString();
    }




}
