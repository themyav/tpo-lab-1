package task3;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
    void grabCheck(){
        assertEquals(trillian.grab(arthur), "Триллиан хватает человек { имя: Артур, пол: мужской }");
    }

    @Test
    void doorOpenCheck(){
        ford.setPushPower(20);
        zaford.setPushPower(10);
        door.push(pusher);


    }
}

/*
Триллиан в отчаянии схватила его за руку и потянула к двери, которую Форд и Зафод пытались открыть, но Артур был, как труп -- казалось, надвигающиеся воздухоплавающие грызуны загипнотизировали его.
 */