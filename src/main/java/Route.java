public class Route {
    int id;
    Site start;
    Site end;
    int cost;
    int time;
    RouteType type;

    public Route(int id, Site start, Site end, int cost, int time, RouteType routeType){
        this.id = id;
        this.start = start;
        this.end = end;
        this.cost = cost;
        this.time = time;
        this.type = routeType;
    }

    public String toString(){
        String output = "";
        output = String.format("%-5s%-10s%-10s%-5s%-5s%-5s", id, start.name, end.name, String.valueOf(cost), String.valueOf(time), type.toString());
        return output;
    }
}
