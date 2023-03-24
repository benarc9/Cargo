import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class RouteMap {
    private HashMap<String, Site> siteMap = new HashMap<>();
    private List<Cargo> cargo = new ArrayList<>();
    private ArrayList<Vehicle> vehicles = new ArrayList<>();
    private Job currentJob;

    public void addSites(Site...sites){
        for (Site site : sites){
            siteMap.put(site.name, site);
        }
    }

    public void addCargo(Cargo cargo){
        this.cargo.add(cargo);
    }

    public Cargo getCargo(int index){
        return this.cargo.get(index);
    }

    public void removeCargo(Cargo cargo){
        this.cargo.remove(cargo);
    }

    public Site getSite(String name)
    {
        return siteMap.get(name);
    }

    public boolean hasSite(String name){
        return siteMap.containsKey(name);
    }

    public void addVehicle(Vehicle vehicle){
        vehicles.add(vehicle);
    }

    public int getRemainingCargoCount(){
        return cargo.size();
    }

    public void addJob(Job job){
        this.currentJob = job;
    }

    public HashMap<Site, Site> getAllRoutes(Site origin, Site destination){
        LinkedList<Site> frontier = new LinkedList<>();
        HashMap<Site, Site> cameFromMap = new HashMap<>();

        Site current = origin;
        frontier.push(current);

        while(!(frontier.isEmpty())){
            current = frontier.pop();
            if (current == destination){
                break;
            }
            System.out.println("Current Site: " + current.toString());
            for (Route route : current.routes){
                System.out.println("Checking Route: " + route.toString());
                if (!cameFromMap.containsKey(route.end)){
                    frontier.push(route.end);
                    System.out.println("Adding to Reached: \n\t" + route.end + " --> " + current);
                    cameFromMap.put(route.end, current);
                }
            }
        }

        return cameFromMap;
    }

    class Connection{
        Site cameFrom = null;
        Site movedTo = null;

        public Connection(Site cameFrom, Site movedTo){
            this.cameFrom = cameFrom;
            this.movedTo = movedTo;
        }
    }

    public String toString(){
        String output = "";

        output += "\n\nSites\n" +
                  "----------------------------------------------------------\n";
        for (Site site : siteMap.values()){
            output += site.toString() + "\n";
        }

        output += "\n\nCargo\n" +
                      "-----------------------------------------------------------------\n" +
                      "\tTime\tName\t\t\t\tSource\t\tDestination\t  Weight\n" +
                      "-----------------------------------------------------------------";

        for (Cargo cgo : cargo){
            output += "\n\t" + cgo.toString();
        }

        output += "\n\nVehicle\n" +
                "-----------------------------------------------------------------\n" +
                "\tType\tName\t\t\tLocation\t\tVehicle State\n" +
                "-----------------------------------------------------------------\n";

        for (Vehicle vehicle : vehicles){
            output += "\t" + vehicle.toString() + "\n";
        }

        return output;
    }
}
