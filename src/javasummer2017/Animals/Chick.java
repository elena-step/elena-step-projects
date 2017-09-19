package javasummer2017.Animals;

public class Chick extends Animal {
    Chick() {
        super("Default Chick");
    }

    Chick(String animalName) {
        super(animalName);
    }

    @Override
    public void doSound() {
        System.out.println("peep peep");
    }
}
