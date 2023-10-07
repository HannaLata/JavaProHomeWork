package animals;

public class Cat extends Animal {
    private static final int MAX_OBSTACLE_CAT_RUN_LENGTH = 200;

    public Cat(String name) {
        super(name);
    }

    @Override
    public void run(int obstacleLength) {
        if ( obstacleLength <= MAX_OBSTACLE_CAT_RUN_LENGTH )
        {
            super.run(obstacleLength);
        }
        else
        {
            System.out.println("Cat can't run such a distance");
        }
    }

    @Override
    public void swim(int obstacleLength) {
        System.out.println("Cat can't swim");
    }
}
