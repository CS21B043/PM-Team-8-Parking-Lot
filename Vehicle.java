public class Vehicle {
    protected String name;
    protected int wheelCnt;
    protected String licenseNumber;
    protected boolean isElectric;
    protected String color;
    protected boolean isHandicapped;

    public Vehicle(String name, int wheelCnt, String licenseNumber, boolean isElectric, String color, boolean isHandicapped) {
        this.name = name;
        this.wheelCnt = wheelCnt;
        this.licenseNumber = licenseNumber;
        this.isElectric = isElectric;
        this.color = color;
        this.isHandicapped = isHandicapped;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isHandicapped() {
        return isHandicapped;
    }

    public void setHandicapped(boolean handicapped) {
        this.isHandicapped = handicapped;
    }
}
