public class EmergencyVehicle {

    private final boolean emergency;
    private final int roadNumber;

    public EmergencyVehicle(boolean emergency, int roadNumber) {
        this.emergency = emergency;
        this.roadNumber = roadNumber;
    }

    public boolean isEmergency() {
        return emergency;
    }

    public int getRoadNumber() {
        return roadNumber;
    }
}