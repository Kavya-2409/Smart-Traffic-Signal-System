public class TrafficSystem {

    private final Road[] roads;

    public TrafficSystem(Road[] roads) {
        this.roads = roads;
    }

    // Display all roads
    public void displayRoads() {

        System.out.println("\n========== TRAFFIC DETAILS ==========");

        for (Road road : roads) {
            road.display();
        }
    }

    // Highest priority road
    public int highestPriorityRoad() {

        int max = roads[0].getVehicleCount();
        int index = 0;

        for (int i = 1; i < roads.length; i++) {

            if (roads[i].getVehicleCount() > max) {

                max = roads[i].getVehicleCount();
                index = i;

            }

        }

        return index;

    }

    // Next priority road
    public int nextPriorityRoad(int firstRoad) {

        int second = -1;

        for (int i = 0; i < roads.length; i++) {

            if (i == firstRoad)
                continue;

            if (second == -1 ||
                    roads[i].getVehicleCount() > roads[second].getVehicleCount()) {

                second = i;

            }

        }

        return second;

    }

    // Traffic Level
    public String trafficLevel(int count) {

        if (count <= 20)
            return "Low";

        else if (count <= 50)
            return "Medium";

        else
            return "High";

    }

    // Green Signal Timing
    public int greenSignalTime(int count) {

        if (count <= 20)
            return 20;

        else if (count <= 50)
            return 40;

        else
            return 60;

    }

    // Normal Traffic
    public void normalSignal() {

        int first = highestPriorityRoad();
        int second = nextPriorityRoad(first);

        System.out.println("\n========== SIGNAL STATUS ==========");

        for (int i = 0; i < roads.length; i++) {

            if (i == first)
                System.out.println(roads[i].getRoadName() + " --> GREEN");
            else
                System.out.println(roads[i].getRoadName() + " --> RED");

        }

        System.out.println("\nHighest Priority : " + roads[first].getRoadName());
        System.out.println("Next Priority    : " + roads[second].getRoadName());
        System.out.println("Green Time       : " + greenSignalTime(roads[first].getVehicleCount()) + " seconds");
        System.out.println("Traffic Level    : " + trafficLevel(roads[first].getVehicleCount()));

    }

    // Emergency Mode
    public void emergencySignal(int road) {

        int next = nextPriorityRoad(road);

        System.out.println("\n========== EMERGENCY MODE ==========");

        for (int i = 0; i < roads.length; i++) {

            if (i == road)
                System.out.println(roads[i].getRoadName() + " --> GREEN");
            else
                System.out.println(roads[i].getRoadName() + " --> RED");

        }

        System.out.println("\nEmergency Vehicle Detected");
        System.out.println("Highest Priority : " + roads[road].getRoadName());
        System.out.println("Next Priority    : " + roads[next].getRoadName());
        System.out.println("Green Time       : Immediate");

    }

}