package animals;

public class Dog extends Animal {

    private static final int MAX_OBSTACLE_DOG_RUN_LENGTH = 500;
    private static final int MAX_OBSTACLE_DOG_SWIM_LENGTH = 10;

    public Dog(String name) {
        super(name);
    }

    @Override
    public void run(int obstacleLength) {
        if ( obstacleLength <= MAX_OBSTACLE_DOG_RUN_LENGTH )
        {
            super.run(obstacleLength);
        }
        else
        {
            System.out.println("Dog can't run such a distance");
        }
    }

    @Override
    public void swim(int obstacleLength) {
        if ( obstacleLength <= MAX_OBSTACLE_DOG_SWIM_LENGTH )
        {
        super.swim(obstacleLength);
        }
        else
        {
            System.out.println("Dog can't swim such a distance");
        }
    }
}
