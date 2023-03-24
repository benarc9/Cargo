public class Delivery {
    Site origin;
    Site destination;
    Cargo cargo;
    int remainingTime;

    public Delivery(Site origin, Site destination, Cargo cargo, int remainingTime){
        this.origin = origin;
        this.destination = destination;
        this.cargo = cargo;
        this.remainingTime = remainingTime;
    }

    public String toString(){
        String output = "";
        output += String.format("%-10s%-10s%-10s%-4s", origin.name, destination.name, cargo.name, remainingTime);
        return output;
    }
}
