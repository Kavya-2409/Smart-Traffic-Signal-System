import java.util.InputMismatchException;
import java.util.Scanner;

public class SmartTrafficSignal {

    public static void main(String[] args) {

        try (Scanner sc = new Scanner(System.in)) {

            Road[] roads = new Road[4];

            System.out.println("========== SMART TRAFFIC SIGNAL SYSTEM ==========");

            for (int i = 0; i < 4; i++) {

                System.out.print("Enter vehicle count for Road " + (char) ('A' + i) + " : ");

                int count = sc.nextInt();

                if (count < 0) {

                    throw new TrafficException("Vehicle count cannot be negative.");

                }

                roads[i] = new Road("Road " + (char) ('A' + i), count);

            }

            TrafficSystem system = new TrafficSystem(roads);

            system.displayRoads();

            System.out.print("\nIs there an Emergency Vehicle? (true/false): ");

            boolean emergency = sc.nextBoolean();

            if (emergency) {

                System.out.print("Enter Emergency Road (1-4): ");

                int road = sc.nextInt();

                if (road < 1 || road > 4) {

                    throw new TrafficException("Invalid Road Number.");

                }

                EmergencyVehicle ev = new EmergencyVehicle(true, road);

                if (ev.isEmergency()) {

                    system.emergencySignal(ev.getRoadNumber() - 1);

                }

            } else {

                system.normalSignal();

            }

        }

        catch (InputMismatchException e) {

            System.out.println("\nInvalid Input! Please enter numbers only.");

        }

        catch (TrafficException e) {

            System.out.println("\n" + e.getMessage());

        }

        catch (Exception e) {

            System.out.println("\nUnexpected Error : " + e.getMessage());

        }

        finally {

            System.out.println("\n==========================================");
            System.out.println("      PROGRAM EXECUTED SUCCESSFULLY");
            System.out.println("==========================================");

        }

    }

}