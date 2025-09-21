public class Main {
    public static void main(String[] args) {
        // Oppretter en Verden-objekt (omgivelsene)
        //World todaysWorld = new World(122, false);
        //World todaysWorld = new World(7, false);
        World todaysWorld = new World(1, true);

        //Oppretter parker
        Park park1 = new Park("Oslopark",32,32);
        Park park2 = new Park("Oslopark2",-128,-32);

        //Sjekker verden status
        //System.out.println(todaysWorld.getIsRaining());
        //System.out.println(todaysWorld.getDay());

        //Oppretter roboter
        Robot Dancatron4000 = new Robot("Dancatron4000","B-Bot",80,300,0,0);
        Robot SparkE = new Robot("Spark-E","Toaster",40,500,0,0);

        //Sjekker status og dvs.
        //System.out.println(Dancatron4000.reportStatus());
        //System.out.println(SparkE.reportStatus());

        //System.out.println(Dancatron4000.canWalkToThePark(todaysWorld));
        //System.out.println(SparkE.canWalkToThePark(todaysWorld));

        System.out.println(Dancatron4000.canDanceAtClub(todaysWorld));
        System.out.println(SparkE.canDanceAtClub(todaysWorld));

        //Prøver å flytte robbot til park
        //Dancatron4000.WalkToPark(todaysWorld, park1);
        //Dancatron4000.WalkToPark(todaysWorld, park2);
    }
}
