package task3;

public class Rodent extends Animal implements Flyable {
    public RodentType type;

    public Rodent(RodentType type) {
        this.type = type;
    }

    @Override
    public String fly(double z) {
        if(z <= 0) {
            this.move(0, 0, 0);
            return this.type.name + " находится на земле";
        }
        this.move(0, 0, z);
        return this.type.name + " летит на высоте " + z;
    }

    public String hypnotize(Animal animal) {
        return this.type.name + " гипнотизирует " + animal.toString();
    }
}
