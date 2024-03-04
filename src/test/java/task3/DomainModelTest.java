package task3;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class DomainModelTest {

    static Building.Door door;

    static ArrayList<Human>pusher;

    static Human trillian;
    static Human ford;

    static Human arthur;

    static Human zaford;

    static ArrayList<Rodent> flyingRodents = new ArrayList<>();

    @BeforeAll
    public static void createEntities(){
        Building station = new Building(5, 100);
        trillian = new Human("Триллиан", Gender.FEMALE);
        ford = new Human("Форд", Gender.MALE);
        zaford = new Human("Зафорд", Gender.MALE);
        arthur = new Human("Артур", Gender.MALE);

        flyingRodents.add(new Rodent(RodentType.MICE));
        flyingRodents.add(new Rodent(RodentType.CAPYBARA));
        flyingRodents.add(new Rodent(RodentType.HAMSTER));

        door = station.doorList.get(0);
        pusher = new ArrayList<>();
        pusher.add(ford);
        pusher.add(zaford);

    }

    @Test
    @DisplayName("grab test")
    void grabCheck(){
        assertEquals(trillian.grab(arthur), "Триллиан хватает человек { имя: Артур, пол: мужской }");
    }

    @Test
    @DisplayName("pull test")
    void pullCheck(){
        door.setOpenPower(50);
        assertEquals(trillian.pull(arthur, door), "Триллиан тащит человек { имя: Артур, пол: мужской } в направлении дверь { закрытая, мощность открытия: 50.0 }");
    }

    @Test
    @DisplayName("door not opened test")
    void testDoorNotOpened(){
        ford.setPushPower(20);
        zaford.setPushPower(10);
        door.push(pusher);
        assertEquals(door.push(pusher), "Форд, Зафорд, пытаются открыть дверь с силой 30.0");
        assertFalse(door.isOpen());
        door.setOpen(false);
    }

    @Test
    @DisplayName("door opened test")

    void testDoorOpened(){
        ford.setPushPower(10);
        zaford.setPushPower(91);
        assertEquals(door.push(pusher), "Форд, Зафорд, пытаются открыть дверь с силой 101.0");
        assertTrue(door.isOpen());
        door.setOpen(false);
    }


    @ParameterizedTest
    @DisplayName("fly positive height test")
    @ValueSource(doubles = {1.05, 5, 1000})
    void testFlyPositive(double value){
        Rodent mice = flyingRodents.get(0);
        mice.setX(0);
        mice.setY(0);
        mice.setZ(0);
        assertEquals(mice.fly(value), "мышь летит на высоте " + value);
        assertEquals(value, mice.getZ());
    }

    @ParameterizedTest
    @DisplayName("fly not positive height test")
    @ValueSource(doubles = {0, -1.1, -100})
    void testFlyNotPositive(double value){
        Rodent mice = flyingRodents.get(0);
        mice.setX(0);
        mice.setY(0);
        mice.setZ(0);
        assertEquals(mice.fly(value), "мышь находится на земле");
        assertEquals(mice.getZ(), 0);
    }

    @Test
    @DisplayName("move test")
    void testAnimalMove(){
        arthur.setX(0);
        arthur.setY(0);
        arthur.setZ(0);
        arthur.move(5, 6, 7);
        assertEquals(5, arthur.getX());
        assertEquals(6, arthur.getY());
        assertEquals(7, arthur.getZ());
    }

    @Test
    @DisplayName("mood test")
    void testMood(){
        trillian.setMood(Emotion.DESPAIR);
        assertEquals("разочарование", trillian.getMood().name);
    }

    @Test
    @DisplayName("hypnotyze test")
    void testHypnotyze(){
        Rodent mice = flyingRodents.get(1);
        assertEquals(mice.hypnotize(arthur), "мышь гипнотизирует человек { имя: Артур, пол: мужской }");

    }
}