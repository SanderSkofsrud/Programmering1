package Øving11;

public class Property {

    private final int municipalityNumber, lotNumber, sectionNumber;
    private final double area;
    private final String municipalityName;
    private final String name;
    private String nameOfOwner;

    /**
     * @param municipalityNumber Parameter that contains the municipality number of the municipality where the property is located
     * @param municipalityName Parameter that contains the name of the municipality where the property is located
     * @param lotNumber Parameter that contains the lot number of the property
     * @param sectionNumber Parameter that contains the number of the section where the property is located
     * @param name Parameter that contains the name of the property
     * @param area Parameter that contains the area of the property
     * @param nameOfOwner Parameter that contains the name of the owner
     */
    public Property(int municipalityNumber, String municipalityName, int lotNumber, int sectionNumber, String name, double area, String nameOfOwner) {
        if (municipalityNumber < 101 || municipalityNumber > 5054) {
            throw new IllegalArgumentException("The municipality number must be between 101 and 5054");
        }
        if (lotNumber < 0 || sectionNumber < 0 || area < 0) {
            throw new IllegalArgumentException("The lot number, section number and area must be greater than 0");
        }
        this.municipalityNumber = municipalityNumber;
        this.municipalityName = municipalityName;
        this.lotNumber = lotNumber;
        this.sectionNumber = sectionNumber;
        this.name = name;
        this.area = area;
        this.nameOfOwner = nameOfOwner;
    }

    /**
     * @param municipalityNumber Parameter that contains the municipality number of the municipality where the property is located
     * @param municipalityName Parameter that contains the name of the municipality where the property is located
     * @param lotNumber Parameter that contains the lot number of the property
     * @param sectionNumber Parameter that contains the number of the section where the property is located
     * @param area Parameter that contains the area of the property
     * @param nameOfOwner Parameter that contains the name of the owner
     */
    public Property(int municipalityNumber, String municipalityName, int lotNumber, int sectionNumber, double area, String nameOfOwner) {
        if (municipalityNumber < 101 || municipalityNumber > 5054) {
            throw new IllegalArgumentException("The municipality number must be between 101 and 5054");
        }
        if (lotNumber < 0 || sectionNumber < 0 || area < 0) {
            throw new IllegalArgumentException("The lot number, section number and area must be greater than 0");
        }
        this.municipalityNumber = municipalityNumber;
        this.municipalityName = municipalityName;
        this.lotNumber = lotNumber;
        this.sectionNumber = sectionNumber;
        this.name = "";
        this.area = area;
        this.nameOfOwner = nameOfOwner;
    }

    /**
     * @return Returns the number of the municipality where the property is located
     */
    public int getMunicipalityNumber() {
        return municipalityNumber;
    }

    /**
     * @return Returns the name of the municipality where the property is located
     */
    public String getMunicipalityName() {
        return municipalityName;
    }

    /**
     * @return Returns the lot number of the property
     */
    public int getLotNumber() {
        return lotNumber;
    }

    /**
     * @return Returns the number of the section where the property is located
     */
    public int getSectionNumber() {
        return sectionNumber;
    }

    /**
     * @return Returns the name of the property
     */
    public String getName() {
        return name;
    }

    /**
     * @return Returns the area of the property
     */
    public double getArea() {
        return area;
    }

    /**
     * @return Returns the name of the owner
     */
    public String getNameOfOwner() {
        return nameOfOwner;
    }

    /**
     * @return Returns the id of a property formulated in the correct way
     */
    public String getId() {
        return this.getMunicipalityNumber() + "-" + this.getLotNumber() + "/" + this.getSectionNumber();
    }

    /**
     * Set the name of owner
     * Need mutator method because a person can move/sell their property to another person
     * @param newOwner Parameter that contains the name of the new owner
     */
    void setNameOfOwner(String newOwner) {
        this.nameOfOwner = newOwner;
    }

    /**
     * Method that formats all needed info to a string, both with and without the name of the property
     * @return Returns all the info formatted to a string
     */
    public String toString() {
        if (this.getName().equals("")) {
            return "Municipality: " + this.getMunicipalityName() + ", id: " + this.getId() + ", area: " + this.getArea() + " m2, owner: " + this.getNameOfOwner();
        } else {
            return "Municipality: " + this.getMunicipalityName() + ", name: " + this.getName() + ", id: " + this.getId() + ", area: " + this.getArea() + " m2, owner: " + this.getNameOfOwner();
        }
    }
}