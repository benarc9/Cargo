import java.util.ArrayList;
import java.util.List;

public class Site {
    String name;
    ArrayList<Route> routes = new ArrayList<Route>();

    public Site(String name){
        this.name = name;
    }

    public void addRoutes(Route...r){
        routes.addAll(List.of(r));
    }

    /*
        Returns a route based on destination and the route type

        Site        destination     the destination site
        RouteType   r               the type of route
     */
    public List<Route> getRoute(Site destination, RouteType type){
        ArrayList<Route> matching = new ArrayList<>();
        for (Route route : routes){
            if (route.end.equals(destination) && route.type == type){
                matching.add(route);
            }
        }
        return matching;
    }

    public String toString(){
        String output = "";
        output += "\t" + name + "\n";
        for (Route route : routes){
            output += "\t\t" + route.toString() + "\n";
        }

        return output;
    }
}
