package lk.waste_managment_system.view.tableView;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class WasteTableView {
    private SimpleStringProperty wasteID;
    private SimpleStringProperty typeOfWaste;
    private SimpleStringProperty object;
    private SimpleIntegerProperty typeOfContainer;
    private SimpleIntegerProperty wastePerDay;

    public WasteTableView(String wasteID, String typeOfWaste, String object, int typeOfContainer, int wastePerDay) {
        this.wasteID = new SimpleStringProperty(wasteID);
        this.typeOfWaste = new SimpleStringProperty(typeOfWaste);
        this.object = new SimpleStringProperty(object);
        this.typeOfContainer = new SimpleIntegerProperty(typeOfContainer);
        this.wastePerDay = new SimpleIntegerProperty(wastePerDay);
    }

    public String getWasteID() {
        return wasteID.get();
    }

    public SimpleStringProperty wasteIDProperty() {
        return wasteID;
    }

    public void setWasteID(String wasteID) {
        this.wasteID.set(wasteID);
    }

    public String getTypeOfWaste() {
        return typeOfWaste.get();
    }

    public SimpleStringProperty typeOfWasteProperty() {
        return typeOfWaste;
    }

    public void setTypeOfWaste(String typeOfWaste) {
        this.typeOfWaste.set(typeOfWaste);
    }

    public String getObject() {
        return object.get();
    }

    public SimpleStringProperty objectProperty() {
        return object;
    }

    public void setObject(String object) {
        this.object.set(object);
    }

    public int getTypeOfContainer() {
        return typeOfContainer.get();
    }

    public SimpleIntegerProperty typeOfContainerProperty() {
        return typeOfContainer;
    }

    public void setTypeOfContainer(int typeOfContainer) {
        this.typeOfContainer.set(typeOfContainer);
    }

    public int getWastePerDay() {
        return wastePerDay.get();
    }

    public SimpleIntegerProperty wastePerDayProperty() {
        return wastePerDay;
    }

    public void setWastePerDay(int wastePerDay) {
        this.wastePerDay.set(wastePerDay);
    }
}
