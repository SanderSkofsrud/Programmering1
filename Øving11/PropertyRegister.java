package Øving11;

import java.util.ArrayList;

public class PropertyRegister {

    private ArrayList<Property> properties;

    public PropertyRegister() {
        properties = new ArrayList<Property>();
    }

    /**
     * @param municipalityNumber Parameter that contains the municipality number of the municipality where the property is located
     * @param municipalityName Parameter that contains the name of the municipality where the property is located
     * @param lotNumber Parameter that contains the lot number of the property
     * @param sectionNumber Parameter that contains the number of the section where the property is located
     * @param name Parameter that contains the name of the property
     * @param area Parameter that contains the area of the property
     * @param nameOfOwner Parameter that contains the name of the owner
     * @return Returns the added property formulated according to toString()
     */
    public String newProperty(int municipalityNumber, String municipalityName, int lotNumber, int sectionNumber, String name, double area, String nameOfOwner) {
        Property property = new Property(municipalityNumber, municipalityName, lotNumber, sectionNumber, name, area, nameOfOwner);
        properties.add(property);
        return property.toString();
    }

    /**
     * @param municipalityNumber Parameter that contains the municipality number of the municipality where the property is located
     * @param municipalityName Parameter that contains the name of the municipality where the property is located
     * @param lotNumber Parameter that contains the lot number of the property
     * @param sectionNumber Parameter that contains the number of the section where the property is located
     * @param area Parameter that contains the area of the property
     * @param nameOfOwner Parameter that contains the name of the owner
     * @return Returns the added property formulated according to toString()
     */
    public String newProperty(int municipalityNumber, String municipalityName, int lotNumber, int sectionNumber, double area, String nameOfOwner) {
        Property property = new Property(municipalityNumber, municipalityName, lotNumber, sectionNumber, area, nameOfOwner);
        properties.add(property);
        return property.toString();
    }


    /**
     * Method that gets information about a property and formulates it
     * @param property Parameter that contains all the info about a given property
     * @return Returns information about a property formulated according to toString()
     */
    public String getProperty(Property property){
        return property.toString();
    }

    /**
     * Method that can remove a property where the input matches a property in the array list
     * @param property Parameter that contains all the info about a given property
     * @return Returns either the information about the property that was removed, or null
     */
    public String removeProperty(Property property) {
        for (int i = 0; i < properties.size(); i++) {
            if (properties.get(i) == property) {
                String info = properties.get(i).toString();
                properties.remove(i);
                return info;
            }
        }
        return null;
    }

    /**
     * Method that returns the number of properties
     * @return Returns the number of properties in the array list
     */
    public int numberOfProperties() {
        return properties.size();
    }

    /**
     * Method that finds a specific property where the municipality, lot, and section number matches
     * @param municipalityNumber Parameter that contains the municipality number of the municipality where the property is located
     * @param lotNumber Parameter that contains the lot number of the property
     * @param sectionNumber Parameter that contains the number of the section where the property is located
     * @return Returns either a specific property where all the parameters match, or an error message
     */
    public String findSpecificProperty(int municipalityNumber, int lotNumber, int sectionNumber) {
        for (Property property : properties) {
            if (property.getMunicipalityNumber() == municipalityNumber && property.getLotNumber() == lotNumber && property.getSectionNumber() == sectionNumber) {
                return property.toString();
            }
        }
        return "Could not find the property";
    }

    /**
     * Method that returns the average area of all properties
     * @return Returns the average area of all the properties
     */
    public double getAverageArea(){
        double totArea = 0.0;
        for (Property property : properties) {
            totArea += property.getArea();
        }
        return totArea / properties.size();
    }

    /**
     * Finds all properties with a given lot number
     * @param lotNumber Parameter that contains the lot number of the property
     * @return Returns a list of every property with that lot number
     */
    public String findPropertyWithLotNumber(int lotNumber) {
        StringBuilder lotNumberList = new StringBuilder();
        for (Property property : properties) {
            if (property.getLotNumber() == lotNumber) {
                lotNumberList.append(property.toString()).append("\n");
            }
        }
        return lotNumberList.toString();
    }

    /**
     * Method that returns every property in the array list
     * @return Returns a list of every property
     */
    public String toString() {
        StringBuilder everyProperty = new StringBuilder();
        for (Property property : properties) {
            everyProperty.append(property.toString()).append("\n");
        }
        return everyProperty.toString();
    }
}


