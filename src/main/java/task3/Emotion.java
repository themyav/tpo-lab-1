package task3;

public enum Emotion {
    DESPAIR("разочарование"),
    SHOCK("шок"),
    DEADLIKE("как труп");

    final String name;
    Emotion(String name) {
        this.name = name;
    }
}
