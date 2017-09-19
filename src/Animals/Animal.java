package Animals;

public abstract class Animal {
    private static final String DEFAULT_ANIMAL_NAME = "Unknown";

    private String _animalName;

    Animal(String animalName) {
        set_animalName(animalName);
    }

    public String get_animalName() {
        return _animalName;
    }

    public void set_animalName(String animalName) {
        _animalName = animalName == null ? DEFAULT_ANIMAL_NAME : animalName;
    }

    public abstract void doSound();
}
