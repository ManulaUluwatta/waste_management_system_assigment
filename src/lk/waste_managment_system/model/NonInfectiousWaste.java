package lk.waste_managment_system.model;

public class NonInfectiousWaste {
    private String wasteID;
    private String typeOfWaste;
    private String object;
    private int typeOfContainer;
    private int wastePerDay;

    public NonInfectiousWaste() {
    }

    public NonInfectiousWaste(String wasteID, String typeOfWaste, String object, int typeOfContainer, int wastePerDay) {
        this.wasteID = wasteID;
        this.typeOfWaste = typeOfWaste;
        this.object = object;
        this.typeOfContainer = typeOfContainer;
        this.wastePerDay = wastePerDay;
    }

    public String getWasteID() {
        return wasteID;
    }

    public void setWasteID(String wasteID) {
        this.wasteID = wasteID;
    }

    public String getTypeOfWaste() {
        return typeOfWaste;
    }

    public void setTypeOfWaste(String typeOfWaste) {
        this.typeOfWaste = typeOfWaste;
    }

    public String getObject() {
        return object;
    }

    public void setObject(String object) {
        this.object = object;
    }

    public int getTypeOfContainer() {
        return typeOfContainer;
    }

    public void setTypeOfContainer(int typeOfContainer) {
        this.typeOfContainer = typeOfContainer;
    }

    public int getWastePerDay() {
        return wastePerDay;
    }

    public void setWastePerDay(int wastePerDay) {
        this.wastePerDay = wastePerDay;
    }
}
