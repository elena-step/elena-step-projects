package javasummer2017.Animals;

/**
 * Реализовать абстрактный класс Animal
 * с абстрактным методом doSound() - звук конкретного животного.
 * Отнаследовать от него 3 класса конкретных животных
 * и реализовать абстрактный метод.
 * Создать массив различных животных и в цикле вызвать у каждого doSound()
 */

public class Main {

    public static void main(String[] args) {

        int numberAnimalsForExample  = 3;
        Animal[] animals = new Animal[numberAnimalsForExample];

        animals[0] = new Rooster("Cheerful rooster");
        animals[1] = new Chick("Little chicken");
        animals[2] = new Cow();


        for (int i = 0; i < animals.length; i++) {
            System.out.print(animals[i].get_animalName() + " sounds: ");
            animals[i].doSound();
        }
    }
}
