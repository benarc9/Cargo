import java.util.ArrayList;

public class Cargo {
    int time;
    String name;
    Site source;
    Site destination;
    int weight;
    CargoState state = CargoState.New;

    public Cargo(int time, String name, Site source, Site destination, int weight){
        this.time = time;
        this.name = name;
        this.source = source;
        this.destination = destination;
        this.weight = weight;
    }

    public String toString(){
        if (!(source == null) && !(destination == null)) {
            String output = "";
            output += String.format("%-5s%-18s%-10s%-10s%5s%-10s", time, name, source.name, destination.name, weight, state.name());
            return output;
        }
        return "Failed to print Cargo";
    }

    public enum CargoState{
        WaitingForPickup, Travelling, ReachedDestination, New;

    }
}
