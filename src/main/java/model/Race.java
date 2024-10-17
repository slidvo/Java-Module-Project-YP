package model;

public class Race {
    private Car leader;

    public Car getLeader() {
        return leader;
    }

    public void calculateLeader(Car car) {
        leader = leader == null || leader.speed() < car.speed() ? car : leader;
    }
}
