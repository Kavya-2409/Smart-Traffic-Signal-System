public class Road {

    private final String roadName;
    private final int vehicleCount;

    public Road(String roadName, int vehicleCount) {
        this.roadName = roadName;
        this.vehicleCount = vehicleCount;
    }

    public String getRoadName() {
        return roadName;
    }

    public int getVehicleCount() {
        return vehicleCount;
    }

    public void display() {
        System.out.println(roadName + " : " + vehicleCount + " vehicles");
    }
}