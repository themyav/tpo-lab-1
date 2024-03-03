package task3;

import java.util.ArrayList;

public class Building extends Entity{

    public ArrayList<Entity> entityList;
    public ArrayList<Door> doorList;

    public int doorsNumber;

    public Building(int doorsNumber, double doorsPower) {
        this.entityList = new ArrayList<>();
        this.doorList = new ArrayList<>();
        this.doorsNumber = doorsNumber;
        for(int i = 0; i < doorsNumber; i++){
            doorList.add(new Door(false, doorsPower));
        }
    }

    class Door{

        public Door(boolean open, double openPower) {
            this.open = open;
            this.openPower = openPower;
            this.grabList = new ArrayList<>();
        }

        boolean open;
        public double openPower;

        public ArrayList<Human>grabList;

        public void grab(Human human){
            grabList.add(human);
        }

        public void release(Human human){
            grabList.remove(human);
        }
        public String push(ArrayList<Human> pushList) {
            double totalPower = 0;
            StringBuilder names = new StringBuilder();
            for (Human human : pushList) {
                totalPower += human.getPushPower();
                names.append(human.getName()).append(", ");
            }
            names.append("пытаются открыть дверь с силой ").append(totalPower);
            System.out.println(names);
            if (totalPower >= openPower) {
                open = true;
            }
            return names.toString();
        }




    }
}
