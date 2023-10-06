package animals;

public abstract class Animal {

    private final String name;

    private static int count;

    public Animal(String name) {
        this.name = name;
        count ++;
    }

    public void run(int obstacleLength) {
        System.out.println(name + " run " + obstacleLength);
    }

    public void swim(int obstacleLength) {
        System.out.println(name + " swim " + obstacleLength);
    }

    public static int countAnimals()
    {
        return count;
    }
}
