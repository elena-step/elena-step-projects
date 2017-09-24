package javasummer2017.Animals;

public class Cow extends Animal {
    Cow(){
        super("Default Cow");
    }
    Cow(String animalName){
        super(animalName);
    }
    @Override
    public void doSound(){
        System.out.println("moo moo");
    }
}
