import java.util.Arrays;

public class Robot {
    // gi robotten 4 attributter: name, batteryLevel, distancetoPark og botType
    private String name, botType;
    private float batteryLevel;
    private int distancetoPark;
    private double[] position;

    public Robot (String name, String botType, float batteryLevel, int distancetoPark, double positionX,double positionY){
        this.name = name;
        this.botType = botType;
        this.batteryLevel = batteryLevel;
        this.distancetoPark = distancetoPark;
        this.position = new double[]{positionX, positionY};
    }

    public String reportStatus() {
        return "ROBOT STATUS" + "\n"
        + "Navn: " + this.name + "\n"
        + "Bot type: " + this.botType + "\n"
        + "Batteri kapasitet: " + this.batteryLevel + "%" + "\n"
        + "Distanse fra park: " + this.distancetoPark + " Meter" + "\n";}

    public boolean canWalkToThePark(World world) {
        System.out.println(name + " sjekker om det er mulig å gå til parken...");
        if (world.getIsRaining()) {
            System.out.println("FEILMELDING" + "\n" + "Det regner. Robotten kan ikke brukes.");
            return false;
        }
        if (!World.isSunday()){
            System.out.println("FEILMELDING" + "\n" + "Det er ikke søndag. Robotten Kan bare gå til parken på søndager.");
            return false;
        }
        if ((float) this.distancetoPark /100 > this.batteryLevel){
            System.out.println("FEILMELDING" + "\n" + "Det er ikke nok batterinivå. Robotten kan ikke gå til parken.");
            return false;
        }
        return true;
    }

    public boolean canDanceAtClub(World world){
        if (!botType.equals("B-Bot")){
            System.out.println("FEILMELDING" + "\n" + "Feil bot type: " + this.botType +  ", Robotten kan ikke være med på danseklubben.");
            return false;
        }
        if (this.batteryLevel < 50){
            System.out.println("FEILMELDING" + "\n" + "Det er ikke nok batterinivå, 50%+. Robotten kan ikke være med på danseklubben.");
            return false;
        }
        if (world.getDay()%7 != 1){
            System.out.println("FEILMELDING" + "\n" + "Det kan ikke være mandag. Danseklubben er stengt.");
            return false;
        }
        if (world.getIsRaining()) {
            System.out.println("FEILMELDING" + "\n" + "Det regner. Robotten kan ikke gå til danseklubben.");
            return false;
        }
        return true;
    }

    public void setDistanceToPark(Park park){
        double[] parkPosition = park.getPosition();
        int y = 1;
        int x = 0;
        this.distancetoPark = (int) Math.sqrt(Math.pow(parkPosition[x] - this.position[x],2) + Math.pow(parkPosition[y] - this.position[y],2));
        System.out.println("Distanse til park: " + this.distancetoPark);
    }

    public void WalkToPark(World world, Park park){
        setDistanceToPark(park);
        if (canWalkToThePark(world)){
            System.out.println("Går til park nå.");
            this.position = park.getPosition();
            this.batteryLevel -= (float) this.distancetoPark /100;
            this.distancetoPark = 0;
            System.out.println(
                    "Ankommet park: " + park.getParkName() + "\n" +
                    "Ny posisjon: " + Arrays.toString(this.position) + "\n" +
                    "Nytt batterinivå: " + this.batteryLevel + "%" + "\n"
            );
        }
    }
}
