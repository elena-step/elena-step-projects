package StudentExam;

/**
 * Составить программу для начисления стипендии студентам по результатам экзаменационной сессии.
 * Информация о результатах сессии включает в себя:
 – фамилию;
 – имя;
 – отчество;
 – номер группы;
 – экзаменационные оценки.
 Количество экзаменационных оценок не менее 3 и не более 5.
 Стипендия начисляется студентам, сдавшим все экзамены в сессию, по следующим правилам.
 Студенты, сдавшие все экзамены на "отлично" получают надбавку равную 100%;
 студенты, сдавшие экзамены на "хорошо" и "отлично" – 50%;
 а студенты, сдавшие экзамены на "хорошо", – 25%.
 Стипендия не начисляется студентам, имеющим в сессию более двух удовлетворительных оценок.
 Список студентов каждой группы, получивших стипендию, вывести на экран, упорядочив его по алфавиту.
 */

public class StudExamMarks {
    private static final int SORT_NAMES = 0;
    private static final int SORT_FAMILY_NAMES = 1;
    private static final int SORT_GROUP = 2;


    public static void main(String[] args) {

        StudExam s1 = new StudExam("Ivanov", "Ivan", "Ivanovich");
        int[] m1 = {3, 3, 3, 4};
        s1.setMarks(m1);

        StudExam s2 = new StudExam("Petrov", "Petr", "Petrovich");
        int[] m2 = {3, 3, 4, 5};
        s2.setMarks(m2);

        StudExam s3 = new StudExam("Sidorov", "Vasya");
        int[] m3 = {4, 4, 4};
        s3.setMarks(m3);

        StudExam s4 = new StudExam("Grishin", "Kolya");
        int[] m4 = {4, 4, 4, 5, 5};
        s4.setMarks(m4);

        StudExam s5 = new StudExam("Voloshin", "Misha");
        int[] m5 = {5, 5, 5, 5, 5};
        s5.setMarks(m5);

        StudExam s6 = new StudExam("Ivanova", "Katya", "Ivanovna");
        int[] m6 = {5, 5, 5, 5};
        s6.setMarks(m6);

        StudExam s7 = new StudExam("Petrova", "Sveta", "Petrovna");
        int[] m7 = {4, 4, 5};
        s7.setMarks(m7);

        StudExam s8 = new StudExam("Sidorova");
        int[] m8 = {4, 4, 4, 4};
        s8.setMarks(m8);

        StudExam s9 = new StudExam("Grishina");
        int[] m9 = {3, 4, 4, 5, 5};
        s9.setMarks(m9);

        StudExam s10 = new StudExam("Voloshina");
        int[] m10 = {3, 3, 3, 3, 5};
        s10.setMarks(m10);

        StudExam[] students = {s1, s2, s3, s4, s5, s6, s7, s8, s9, s10};

        int numberOfStudents = students.length;
        for (int i = 0; i < numberOfStudents; i++) {
            checkForStipend(students[i]);
        }

        sortStudExam(students, SORT_FAMILY_NAMES);

        System.out.println("Stipend plus 100%: ");
        String str1 = "stPlus100";
        printGroupResForStipend(students, str1);

        System.out.println("Stipend plus 50%: ");
        String str2 = "stPlus50";
        printGroupResForStipend(students, str2);

        System.out.println("Stipend plus 25%: ");
        String str3 = "stPlus25";
        printGroupResForStipend(students, str3);

        System.out.println("Stipend : ");
        String str4 = "stipend";
        printGroupResForStipend(students, str4);
    }

    private static void checkForStipend(StudExam student) {
        int[] marks = student.getMarks();

        int count3 = 0;
        int count5 = 0;
        for (int i = 0; i < marks.length; i++) {

            if (marks[i] == 3) {
                count3++;
            }
            if (marks[i] == 5) {
                count5++;
            }
        }

        if (count3 >= 3) {
            student.setGroupForStipend("stNotAssigned");

        } else if (count3 < 3 && count3 != 0) {
            student.setGroupForStipend("stipend");

        } else if (count5 == marks.length) {
            student.setGroupForStipend("stPlus100");

        } else if (count5 != 0 && count3 == 0) {
            student.setGroupForStipend("stPlus50");

        } else {
            student.setGroupForStipend("stPlus25");

        }
    }

    private static void sortStudExam(StudExam[] students, int sortParameter) {
        int n = students.length;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < n - i; j++) {
                if (compareStudExam(students[j - 1], students[j], sortParameter)) {
                    StudExam temp = students[j - 1];
                    students[j - 1] = students[j];
                    students[j] = temp;
                }
            }
        }
    }

    private static boolean compareStudExam(StudExam student1, StudExam student2, int sortParameter) {
        switch (sortParameter) {
            case SORT_NAMES:
                return student1.getName().compareTo(student2.getName()) > 0;
            case SORT_FAMILY_NAMES:
                return student1.getFamilyName().compareTo(student2.getFamilyName()) > 0;
            case SORT_GROUP:
                return student1.getGroup().compareTo(student2.getGroup()) > 0;
        }
        return false;
    }


    private static void printGroupResForStipend(StudExam[] students, String str) {
        int n = students.length;
        for (int i = 0; i < n; i++) {
            if (str.equals(students[i].getGroupForStipend()))
                students[i].print();
        }
        System.out.println();
    }
//обновленная версия
}
