import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.Car;
import model.IncorrectSpeedException;
import model.Race;

public class Main {
    public static void main(String[] args) {
        final var scanner = new Scanner(System.in);
        final var race = new Race();
        int count = 0;
        List<Car> cars = new ArrayList<>();
        System.out.println("- Введите данные трёх  автомобилей");
        while (count < 3) {
            var carNumber = count+1;
            System.out.println("- Введите название машины " + carNumber + ":");
            String carName = scanner.nextLine();
            System.out.println("- Введите скорость машины " + carNumber + ":");
            String carSpeed = scanner.nextLine();
            if (!checkCarSpeedFormat(carSpeed)) continue;
            cars.add(new Car(carName, Double.parseDouble(carSpeed)));
            count++;
        }

        for (Car car : cars) {
            race.calculateLeader(car);
        }

        System.out.println("- Самая быстрая машина: ".concat(race.getLeader().name()));
    }

    private static boolean checkCarSpeedFormat(String carSpeed) {

        try {
            var speed = Double.parseDouble(carSpeed);
            if (speed < 0 || speed >= 250) throw new IncorrectSpeedException();

        } catch (IncorrectSpeedException e) {
            System.out.println("Ошибка: Скорость должна быть от 0 до 250 км");
            return false;
        } catch (NumberFormatException e) {
            System.out.println("Ошибка: неверно введена скорость");
            return false;
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
