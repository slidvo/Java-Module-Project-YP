import java.util.ArrayList;

import model.Car;
import model.CarScanner;
import model.Race;

public class Main {
    public static void main(String[] args) {
        ArrayList<Car> cars;
        final var carScanner = new CarScanner();
        final var race = new Race();
        cars = carScanner.scanThreeCarsForRace();
        race.calculateLeader(cars);
        race.printLeader();

    }
}
