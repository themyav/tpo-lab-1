package task3;

public enum Gender {
    MALE("мужской"),
    FEMALE("женский"),
    UNKNOWN("неизвестно");

    final String name;
    Gender(String name) {
        this.name = name;
    }
}
