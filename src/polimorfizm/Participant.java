package polimorfizm;

public abstract class Participant {
    private int maxLength;
    private int maxHeight;
    private String name;

    public Participant(int maxLength, int maxHeight, String name) {
        this.maxLength = maxLength;
        this.maxHeight = maxHeight;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getMaxLength() {
        return maxLength;
    }

    public int getMaxHeight() {
        return maxHeight;
    }

    public void jump() {
        System.out.println("jumping");
    }
    public void run() {
        System.out.println("running");
    }
}
