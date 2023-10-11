package polimorfizm;

public class PolimorfizmMain {
    public static void main(String[] args) {
        Human max = new Human(20, 10, "Max");
        Cat tom = new Cat(3, 1, "Tom");
        Robot tesla = new Robot(200, 50, "Tesla");

        RaceTrack raceTrack = new RaceTrack(25);
        Wall wall = new Wall(5);

        Participant [] participants = {max, tom, tesla};
        Obstacle [] obstacles = {raceTrack, wall};

        for ( Participant participant : participants ) {
            for ( Obstacle obstacle : obstacles ) {
                obstacle.overcome(participant);
            }
        }
    }
}
