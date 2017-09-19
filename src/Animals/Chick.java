package Animals;

public class Chick extends Animal {
    Chick(){
        super("Default Chick");
    }

    Chick(String animalName){
        super(animalName);
    }

    public void doSound(){
        System.out.println("peep peep");
    }
}
