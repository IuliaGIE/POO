class ClockTime{
    private int hour, minute;

    public ClockTime(int h, int m){
        this.hour = h;
        this.minute = m;
    }

    public int getH(){
        return hour;
    }

    public int getM(){
        return minute;
    }

    public int comp(ClockTime c){
        if(hour > c.hour)
            return 1;
        else if(hour < c.hour)
            return -1;
        else if(minute > c.minute)
            return 1;
        else if(minute < c.minute)
            return -1;
        return 0;
    }
}

class Schedule{
    private ClockTime departure, arrival;

    public Schedule(ClockTime d, ClockTime a){
        this.departure = d;
        this.arrival = a;
    }

    public int durata(){
        int x = departure.getH()*60 + departure.getM();
        int y = arrival.getH()*60 + arrival.getM();
        if(x < y)
            return y - x;
        return (24 * 60 - x) + y;
    }
}

class Route{
    private String origin, destination;

    public Route(String o, String d){
        this.origin = o;
        this.destination = d;
    }

    public boolean verif(Route r){
        if(origin.equals(r.destination) && destination.equals(r.origin))
            return true;
        return false;
    }
}

public class Train {
    private Route r;
    private Schedule s;
    private boolean local;

    public Train(Route route, Schedule schedule, boolean local) {
        this.r = route;
        this.s = schedule;
        this.local = local;
    }

    public int pret(){
        int X = 2;
        if(local == true)
            X = 1;
        return X * s.durata();
    }

    public static void main(String[] args){
        ClockTime time1 = new ClockTime(9, 35);
        ClockTime time2 = new ClockTime(12, 2);
        ClockTime time3 = new ClockTime(5, 45);
        ClockTime time4 = new ClockTime(12, 49);
        ClockTime time5 = new ClockTime(23, 45);
        ClockTime time6 = new ClockTime(17, 0);

        Route route1 = new Route("Bucuresti Nord", "Constanta");
        Route route2 = new Route("Bucuresti Nord", "Iasi");
        Route route3 = new Route("Bucuresti Nord", "Sofia");
        Route route4 = new Route("Constanta", "Bucuresti Nord");

        Schedule schedule1 = new Schedule(time1, time2);
        Schedule schedule2 = new Schedule(time3, time4);
        Schedule schedule3 = new Schedule(time5, time6);

        Train train1 = new Train(route1, schedule1, true); // Local
        Train train2 = new Train(route2, schedule2, true); // Local
        Train train3 = new Train(route3, schedule3, false); // International

        int ticketPrice1 = train1.pret();
        int ticketPrice2 = train2.pret();
        int ticketPrice3 = train3.pret();

        System.out.println("Ticket price for train 1: " + ticketPrice1); // 147
        System.out.println("Ticket price for train 2: " + ticketPrice2); // 184
        System.out.println("Ticket price for train 3: " + ticketPrice3); // 198

        System.out.println("Route 1 is round trip: " + route1.verif(route1)); // false
        System.out.println("Route 2 is round trip: " + route2.verif(route2)); // false
        System.out.println("Route 3 is round trip: " + route3.verif(route3)); // false
        System.out.println("Route 1 and Route 4 are round trip: " + route1.verif(route4)); // true
    }
}
