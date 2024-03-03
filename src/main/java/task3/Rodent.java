package task3;

public class Rodent extends Animal implements Flyable{
    public RodentType type;

    public Rodent(RodentType type) {
        this.type = type;
    }

    @Override
    public void fly(double z) {
        this.move(0, 0, z);
        System.out.println("Грызуны летят на высоте " + z);
    }
}
