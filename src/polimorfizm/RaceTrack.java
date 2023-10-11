package polimorfizm;

public class RaceTrack extends Obstacle {
    private int length;

    public RaceTrack(int length) {
        this.length = length;
    }

    @Override
    public void overcome(Participant participant) {
        if ( participant.getMaxLength() >= length ) {
            participant.run();
        } else {
            System.out.println(participant.getName() + " did not overcome the racetrack");
        }
    }
}
