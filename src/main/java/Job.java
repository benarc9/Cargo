public class Job {
    Vehicle currentVehicle;
    int totalCost;
    Site origin;
    Site destination;

    public Job(Vehicle currentVehicle, int totalCost, Site origin, Site destination){
        this.currentVehicle = currentVehicle;
        this.totalCost = totalCost;
        this.origin = origin;
        this.destination = destination;
    }

    public void addToCost(int cost){
        this.totalCost += cost;
    }

    public String toString(){
        String output = "";
        output += String.format("%-10s%-5s%-12s%-12s", currentVehicle.name, totalCost, origin.name, destination.name);
        return output;
    }
}
