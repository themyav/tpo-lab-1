package task3;

public class Human extends Animal implements Moveable{
    public String name;
    public Gender gender;

    public double pushPower;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPushPower() {
        return pushPower;
    }

    public void setPushPower(double pushPower) {
        this.pushPower = pushPower;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Human(String name, Gender gender) {
        this.name = name;
        this.gender = gender;
    }

    @Override
    public String grab(Entity entity) {
        return this.getName() + " хватает " + entity.toString();
    }

    @Override
    public String toString() {
        return "человек { имя: " + this.getName() + ", пол: " + this.getGender().name + " }";
    }

    @Override
    public String pull(Entity subject, Entity direction){
        return this.getName() + " тащит " + subject.toString() + " в направлении " + direction.toString();
    }
}
