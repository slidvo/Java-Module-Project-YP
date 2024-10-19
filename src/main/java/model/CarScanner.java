package model;

import java.util.ArrayList;
import java.util.Scanner;

public class CarScanner {
    public final Scanner scanner = new Scanner(System.in);

    public ArrayList<Car> scanThreeCarsForRace() {
        System.out.println("- Введите данные трёх  автомобилей");
        int count = 0;
        ArrayList<Car> cars = new ArrayList<>();
        while (count < 3) {
            var carNumber = count + 1;
            cars.add(getCar(carNumber));
            count++;
        }
        return cars;
    }

    private Car getCar(int carNumber) {
        return new Car(getCarName(carNumber), getCarSpeed(carNumber));
    }

    private String getCarName(int carNumber) {
        System.out.println("- Введите название машины " + carNumber + ":");
        return scanner.nextLine();
    }

    private Double getCarSpeed(int carNumber) {
        while (true) {
            System.out.println("- Введите скорость машины " + carNumber + ":");
            Double carSpeed = convertCarSpeedType(scanner.nextLine());
            if (carSpeed == null || isSpeedWrong(carSpeed)) continue;
            return carSpeed;
        }
    }

    private static Double convertCarSpeedType(String carSpeed) {
        try {
            return Double.parseDouble(carSpeed);
        } catch (NumberFormatException e) {
            System.out.println("Ошибка: неверно введена скорость");
            return null;
        }
    }

    private static boolean isSpeedWrong(Double speed) {
        var checkSpeedResult = speed < 0 || speed >= 250;
        if (checkSpeedResult) System.out.println("Ошибка: Введена неправильная сокрость");
        return checkSpeedResult;
    }
}

