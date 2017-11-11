package javasummer2017.filewritingreading;

import java.io.*;
import java.util.Arrays;

public class MainWritingReading {
    private static final int FIRST_NAME_AND_LAST_NAME = 2;

    public static void main(String[] args) {

        Student s1 = new Student("Ivan", "Ivanov");

        int[] marks1 = {11, 11, 11};
        s1.setMarks(marks1);

        System.out.println("Info for writing to file:");
        System.out.println(s1 + System.lineSeparator());


        try (Writer writer = new FileWriter("Students.txt")) {
            writer.write(s1 + System.lineSeparator());
        } catch (IOException e) {
            e.printStackTrace();
        }


        Student student2 = new Student();

        try (Reader reader = new FileReader("Students.txt")) {
            BufferedReader bufferedReader = new BufferedReader(reader);
            String line = bufferedReader.readLine();

            String[] words = line.split(" ");
            student2.setFirstName(words[0]);
            student2.setLastName(words[1]);
            int[] marks = new int[words.length - FIRST_NAME_AND_LAST_NAME];
            for (int i = FIRST_NAME_AND_LAST_NAME; i < words.length; i++) {
                for (int j = 0; j < words.length - FIRST_NAME_AND_LAST_NAME; j++) {
                    int intMark = Integer.parseInt(words[i]);
                    marks[j] = intMark;
                }
            }
            student2.setMarks(marks);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Reading from file:");
        System.out.println(student2);
        System.out.println(student2.getFirstName());
        System.out.println(student2.getLastName());
        System.out.println("Marks: " + Arrays.toString(student2.getMarks()));
    }

}