package org.example;

public class Property implements  Comparable<Property>{
   // Instance variables for property name, city, rental amount, owner, and plot.
   private String propertyName;
   private String city;
   private double rentAmount;
   private String owner;
   private Plot plot;
   /*
   Property(): Creates a new Property using empty strings.
   Property(String propertyName, String city, double rentAmount, String owner): Creates a new Property object using given values.
   Property(String propertyName, String city, double rentAmount, String owner, int x, int y, int width, int depth):Creates a new Property object using given values.
   -> Property(Property otherProperty): Creates a new copy of the given property object.
    */

   public Property() {
   }

   public Property(String city, String owner, String propertyName, double rentAmount) {
      this.city = city;
      this.owner = owner;
      this.propertyName = propertyName;
      this.rentAmount = rentAmount;
      this.plot = new Plot(0,0,1,1);
   }

   public Property(String city, String owner, String propertyName, double rentAmount, int x, int y, int width, int depth) {
      this.city = city;
      this.owner = owner;
      this.propertyName = propertyName;
      this.rentAmount = rentAmount;
      this.plot = new Plot(x,y,width,depth);
   }
   public Property(Property otherProperty){
      this.propertyName = otherProperty.propertyName;
      this.city = otherProperty.city;
      this.rentAmount = otherProperty.rentAmount;
      this.owner = otherProperty.owner;
      this.plot = new Plot(otherProperty.plot);
   }


   public String getCity() {
      return city;
   }

   public String getOwner() {
      return owner;
   }

   public Plot getPlot() {
      return plot;
   }

   public String getPropertyName() {
      return propertyName;
   }

   public double getRentAmount() {
      return rentAmount;
   }

   public void setCity(String city) {
      this.city = city;
   }

   public void setOwner(String owner) {
      this.owner = owner;
   }

   public void setPlot(Plot plot) {
      this.plot = plot;
   }

   public void setPropertyName(String propertyName) {
      this.propertyName = propertyName;
   }

   public void setRentAmount(double rentAmount) {
      this.rentAmount = rentAmount;
   }

   @Override
   public int compareTo(Property other){
      return Double.compare(this.rentAmount, other.rentAmount);
   }

   @Override
   public String toString() {
      return propertyName +", "+ city +", "+ rentAmount +", "+ owner;
   }


}
