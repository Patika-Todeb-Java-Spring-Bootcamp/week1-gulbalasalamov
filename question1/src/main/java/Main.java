import java.awt.*;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        LocalDate productionDate1 = LocalDate.of(2020, 9, 30);
        LocalDate productionDate2 = LocalDate.of(2018, 11, 20);
        Car mercedes = new Car(Manufacturer.MERCEDES, 2020, 4, productionDate1, 500000, Color.BLACK);
        Car bmw = new Car(Manufacturer.BMW, 2019, 2, productionDate2, 10000, Color.RED);

        System.out.println("----Using immutable POJO object----");
        System.out.println(mercedes);
        System.out.println("------------------------------------");
        System.out.println(bmw);

        /**
         ----Using immutable POJO object----
         model: MERCEDES
         year: 2020
         number of passenger: 4
         production: 2020-09-30
         distance traveled in km: 500000
         color: Black
         ------------------------------------
         model: BMW
         year: 2019
         number of passenger: 2
         production: 2018-11-20
         distance traveled in km: 10000
         color: Red

         Process finished with exit code 0

         */
    }
}
