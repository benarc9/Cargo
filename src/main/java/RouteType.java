public enum RouteType {
    Road(5), Water(15), Rail(100), Air(25), All(-1);

    int capacity;

    private RouteType(int cap){
        capacity = cap;
    }

    public static RouteType forString(String type){
        return switch (type) {
            case "road" -> Road;
            case "water" -> Water;
            case "air" -> Air;
            case "train" -> Rail;
            default -> All;
        };
    }

    @Override
    public String toString(){
        return this.name();
    }
}
