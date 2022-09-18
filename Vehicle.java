public class Vehicle {
    int wheelCnt;
    String licenseNumber;
    boolean isElectric;
    String color;
    String spot_nature;

    public Vehicle(int wheelCnt, String licenseNumber, boolean isElectric, String color, String spot_nature) {
        this.wheelCnt = wheelCnt;
        this.licenseNumber = licenseNumber;
        this.isElectric = isElectric;
        this.color = color;
        this.spot_nature = spot_nature;
    }

    public int getWheelCnt() {
        return wheelCnt;
    }

    public void setWheelCnt(int wheelCnt) {
        this.wheelCnt = wheelCnt;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    public boolean isElectric() {
        return isElectric;
    }

    public void setElectric(boolean electric) {
        isElectric = electric;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getSpot_nature() {
        return spot_nature;
    }

    public void setSpot_nature(String spot_nature) {
        this.spot_nature = spot_nature;
    }
}
