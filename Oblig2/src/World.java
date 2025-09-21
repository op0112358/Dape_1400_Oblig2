public class World {
    private boolean isRaining;
    private int day;// 1 er Mandag, 2 er Tirsdag, ..., 7 for Søndag, 8 er Mandag...

    public World(int day, boolean isRaining) {
        this.day = day;
        if (day <= 0){
            throw new IllegalArgumentException("Dag kan ikke være 0 eller negativ");
        }
        this.isRaining = isRaining;
    }

    public boolean isSunday() {
        return this.day % 7 == 0;
    }

    public boolean getIsRaining() {
        return this.isRaining;
    }
    public void setRainingStatus(boolean isRaining){
        this.isRaining = isRaining;
    }
    public int getDay() {
        return day;
    }

    public void setDay(int day){
        this.day = day;
    }
}
