package javasummer2017.filewritingreading;

import java.io.*;

public class MainWritingReading {
    public static void main(String[] args) {

        Student s1 = new Student("Ivan", "Ivanov");
        Student s2 = new Student("Petr", "Petrov");

        int[] marks1 = {11, 11, 11};
        s1.setMarks(marks1);

        int[] marks2 = {10, 10, 10};
        s2.setMarks(marks2);


        try (Writer writer = new FileWriter("Students.txt")) {
            writer.write(s1 + System.lineSeparator());
            writer.write(s2 + System.lineSeparator());
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (Reader reader = new FileReader("Students.txt")) {
            BufferedReader bufferedReader = new BufferedReader(reader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
