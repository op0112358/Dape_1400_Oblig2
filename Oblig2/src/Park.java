public class Park {
    private String parkName;
    private double positionX,positionY;
    private double[] position;

    public Park (String parkName, double positionX, double positionY){
        this.parkName = parkName;
        this.position = new double[]{positionX, positionY};
    }

    public double[] getPosition(){
        return position;
    }

    public String getParkName(){
        return this.parkName;
    }
}
