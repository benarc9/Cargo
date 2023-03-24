public class Vehicle {
    VehicleType type;
    Site location;
    String name;
    VehicleState state = VehicleState.Available;
    Delivery currentJob = null;


    public Vehicle(VehicleType type, String name, Site location){
        this.type = type;
        this.name = name;
        this.location = location;
    }

    public enum VehicleType{
        Train, Plane, Ship, Truck;

        public static VehicleType forString(String type){
            return switch(type){
                case "train"    -> VehicleType.Train;
                case "air"      -> VehicleType.Plane;
                case "water"    -> VehicleType.Ship;
                case "road"     -> VehicleType.Truck;
                default -> null;
            };
        }
    }

    public enum VehicleState {
        Available, Enroute;
    }

    public String toString(){
        String output = "";
        output += String.format("%-8s%-16s%-17s%-8s", type.name(), name, location.name, state);
        if (currentJob != null) {
            output += "\t" + currentJob.toString();
        } else {
            output += "\n\t\tNo Jobs";
        }

        return output;
    }
}
