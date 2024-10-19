package model;

import java.util.List;

public class Race {
    private Car leader;

    public void calculateLeader(List<Car> cars) {
        for (Car car : cars) {
            leader = leader == null || leader.speed() < car.speed() ? car : leader;
        }
    }

    public void printLeader() {
        System.out.println("- Самая быстрая машина: ".concat(leader.name()));
    }

}
