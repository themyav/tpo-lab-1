package task3;

public enum RodentType {
    MICE("мышь"),
    HAMSTER("хомяк"),
    CAPYBARA("капибара");


    public final String name;
    RodentType(String name) {
        this.name = name;
    }
}
