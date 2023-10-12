package polimorfizm;

public class Wall extends Obstacle {
    private int height;

    public Wall(int height) {
        this.height = height;
    }

    @Override
    public void overcome(Participant participant) {
        if ( participant.getMaxHeight() >= height ) {
            participant.jump();
        } else {
            System.out.println(participant.getName() + " did not overcome the wall");
        }
    }
}
