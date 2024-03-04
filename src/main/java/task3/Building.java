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

    class Door extends Entity{

        @Override
        public String toString() {
            return "дверь { " + (this.open ? "открытая" : "закрытая") + ", мощность открытия: " + this.openPower + " }";
        }

        public Door(boolean open, double openPower) {
            this.open = open;
            this.openPower = openPower;
            this.grabList = new ArrayList<>();
        }

        public boolean isOpen() {
            return open;
        }

        public void setOpen(boolean open) {
            this.open = open;
        }

        boolean open;
        public double openPower;

        public double getOpenPower() {
            return openPower;
        }

        public void setOpenPower(double openPower) {
            this.openPower = openPower;
        }

        public ArrayList<Human>grabList;

        public String push(ArrayList<Human> pushList) {
            double totalPower = 0;
            StringBuilder names = new StringBuilder();
            for (Human human : pushList) {
                totalPower += human.getPushPower();
                names.append(human.getName()).append(", ");
            }
            names.append("пытаются открыть дверь с силой ").append(totalPower);
            if (totalPower >= openPower) {
                open = true;
            }
            return names.toString();
        }



    }
}
