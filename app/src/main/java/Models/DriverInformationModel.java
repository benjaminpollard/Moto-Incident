package Models;

import io.realm.RealmObject;

/**
 * Created by Ben on 05/01/2017.
 */

public class DriverInformationModel extends RealmObject {
    private String fullName;
    private String registrationPlateNumber;
    private String vehicleManufacture;
    private String vehicleRange;
    private String vehichleModel;

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getRegistrationPlateNumber() {
        return registrationPlateNumber;
    }

    public void setRegistrationPlateNumber(String registrationPlateNumber) {
        this.registrationPlateNumber = registrationPlateNumber;
    }

    public String getVehicleManufacture() {
        return vehicleManufacture;
    }

    public void setVehicleManufacture(String vehicleManufacture) {
        this.vehicleManufacture = vehicleManufacture;
    }

    public String getVehicleRange() {
        return vehicleRange;
    }

    public void setVehicleRange(String vehicleRange) {
        this.vehicleRange = vehicleRange;
    }

    public String getVehichleModel() {
        return vehichleModel;
    }

    public void setVehichleModel(String vehichleModel) {
        this.vehichleModel = vehichleModel;
    }

    public String getAdditionalInformation() {
        return additionalInformation;
    }

    public void setAdditionalInformation(String additionalInformation) {
        this.additionalInformation = additionalInformation;
    }

    private String additionalInformation;


}
