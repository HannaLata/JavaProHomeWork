
import animals.Animal;
import animals.Cat;
import animals.Dog;

public class Main {

    public static void main(String[] args) {

        createNewAnimals();
    }

    private static void createNewAnimals() {
        Dog barsik = new Dog("Barsik");
        Cat tom = new Cat("Tom");
        barsik.run(400);
        barsik.swim(400);
        tom.run(150);
        tom.swim(10);
        Cat masya = new Cat("Masya");
        masya.run(200);
        masya.swim(1);

        System.out.println("Number of animals created: " + Animal.countAnimals());
    }
}
