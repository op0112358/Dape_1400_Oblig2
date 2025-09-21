public class World {
    private boolean isRaining;
    private static int day;// 1 er Mandag, 2 er Tirsdag, ..., 7 for Søndag, 8 er Mandag...

    public World(int day, boolean isRaining) {
        this.day = day;
        if (day <= 0){
            throw new IllegalArgumentException("Day cannot be 0 or negative");
        }
        this.isRaining = isRaining;
    }

    public static boolean isSunday() {
        if (day % 7 == 0){
            return true;
        }
        return false;
    }

    public boolean getIsRaining() {return this.isRaining;}
    public int getDay() {return day;}
}
