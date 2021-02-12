
package com.kazarian.android.homework_recyclerview_internet_activity.homework_recyclerview_internet_activity_Gsonfiles_cars;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class PouyaheydariCars {

    @SerializedName("vehicles")
    @Expose
    private List<Vehicle> vehicles = null;

    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    public void setVehicles(List<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

}
