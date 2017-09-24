package javasummer2017.Animals;

public class Rooster extends Animal {
    Rooster(){
        super("Default Rooster");
    }

    Rooster(String animalName){
        super(animalName);
    }

    @Override
    public void doSound(){
        System.out.println("cock-a-doodle-doo");
    }
}
