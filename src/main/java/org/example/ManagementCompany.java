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
        this.plot = new Plot(MGMT_DEPTH,MGMT_WIDTH,0,0);
    }

    public ManagementCompany(String name, String taxId, double mgmFee) {
        this.name = name;
        this.taxId = taxId;
        this.mgmFee = mgmFee;
        this.properties = new ArrayList<>();
        this.plot = new Plot(MGMT_DEPTH,MGMT_WIDTH,0,0);
    }

    public ManagementCompany(String name, String taxId, double mgmFee, int x, int y, int width, int depth) {
        this.name = name;
        this.taxId = taxId;
        this.mgmFee = mgmFee;
        this.properties = new ArrayList<>();
        this.plot = new Plot(depth,width,x,y);
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
       for (Property p : properties) {
           properties.add(new Property(p));
       }
        return 0;
    }

    public int addProperty(String name, String city, double rent, String owner, int x, int y, int width, int depth) {
       for(Property p : properties){
           properties.add(new Property(p));
       }
        return 0;
    }
    public int addProperty(){

        return properties.get(p);
    }
    // Note:
    @Override
    public String toString() {
        return "ManagementCompany{" +
                "name='" + name + '\'' +
                ", taxId='" + taxId + '\'' +
                ", mgmFee=" + mgmFee +
                ", properties=" + properties +
                ", plot=" + plot +
                '}';
    }


}
