
import java.awt.*;
import java.time.LocalDate;
import java.util.HashMap;

public final class Car {

    /**
     * Get the string value of Color against their color codes, using your custom map.
     * Otherwise, Color.toString() returns String like RGB[255,0,0]
     */
    public static final HashMap<Color,String> colorMap = new HashMap<>();
    static{
        colorMap.put(Color.BLACK,"Black");
        colorMap.put(Color.WHITE,"White");
        colorMap.put(Color.RED,"Red");
    }

    private final Manufacturer model;
    private final int year;
    private final int numberOfPassengers;
    private final LocalDate production;
    private final int distanceTraveled;
    private final Color color;

    public Car(Manufacturer model, int year, int numberOfPassengers, LocalDate production, int distanceTraveled, Color color) {
        this.model = model;
        this.year = year;
        this.numberOfPassengers = numberOfPassengers;
        this.production = production;
        this.distanceTraveled = distanceTraveled;
        this.color = color;
    }

    public Manufacturer getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public int getNumberOfPassengers() {
        return numberOfPassengers;
    }

    public LocalDate getProduction() {
        return production;
    }

    public int getDistanceTraveled() {
        return distanceTraveled;
    }

    public Color getColor() {
        return color;
    }

    public String getColorName(Color color){
        return colorMap.get(color);
    }

    @Override
    public String toString() {
        return "model: " + this.model +
                "\nyear: " + this.year +
                "\nnumber of passenger: " + this.numberOfPassengers +
                "\nproduction: " + this.production +
                "\ndistance traveled in km: " + this.distanceTraveled +
                "\ncolor: " + getColorName(this.color);
    }
}
