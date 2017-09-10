package StudentExam;

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

        StudExam s3 = new StudExam("Sidorov");
        int[] m3 = {4, 4, 4};
        s3.setMarks(m3);

        StudExam s4 = new StudExam("Grishin");
        int[] m4 = {4, 4, 4, 5, 5};
        s4.setMarks(m3);

        StudExam s5 = new StudExam("Voloshin");
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


        StudExam[] stNotAssigned = new StudExam[1];
        StudExam[] stPlus100 = new StudExam[1];
        StudExam[] stPlus50 = new StudExam[1];
        StudExam[] stPlus25 = new StudExam[1];
        StudExam[] stipend = new StudExam[1];


        checkForStipend(s1, stNotAssigned, stPlus100, stPlus50, stPlus25, stipend);
       /* checkForStipend(s2, stNotAssigned, stPlus100, stPlus50, stPlus25, stipend);
        checkForStipend(s3, stNotAssigned, stPlus100, stPlus50, stPlus25, stipend);
        checkForStipend(s4, stNotAssigned, stPlus100, stPlus50, stPlus25, stipend);
        checkForStipend(s5, stNotAssigned, stPlus100, stPlus50, stPlus25, stipend);
        checkForStipend(s6, stNotAssigned, stPlus100, stPlus50, stPlus25, stipend);
        checkForStipend(s7, stNotAssigned, stPlus100, stPlus50, stPlus25, stipend);
        checkForStipend(s8, stNotAssigned, stPlus100, stPlus50, stPlus25, stipend);
        checkForStipend(s9, stNotAssigned, stPlus100, stPlus50, stPlus25, stipend);*/
        checkForStipend(s10, stNotAssigned, stPlus100, stPlus50, stPlus25, stipend);


        System.out.println("Stipend plus 100%: ");
        sortStudExam(stPlus100, SORT_FAMILY_NAMES);
        printGroupResForStipend(stPlus100);

        System.out.println("Stipend plus 50%: ");
        sortStudExam(stPlus50, SORT_FAMILY_NAMES);
        printGroupResForStipend(stPlus50);

        System.out.println("Stipend plus 25%: ");
        sortStudExam(stPlus25, SORT_FAMILY_NAMES);
        printGroupResForStipend(stPlus25);

        System.out.println("Stipend : ");
        sortStudExam(stipend, SORT_FAMILY_NAMES);
        printGroupResForStipend(stipend);

        System.out.println("Stipend not assigned: ");
        sortStudExam(stNotAssigned, SORT_FAMILY_NAMES);
        printGroupResForStipend(stNotAssigned);
    }

    private static void checkForStipend(StudExam student, StudExam[] stNotAssigned,
                                        StudExam[] stPlus100, StudExam[] stPlus50,
                                        StudExam[] stPlus25, StudExam[] stipend) {
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
        System.out.println("Кол-во 3 и 5: " + count3 + " " + count5);      //1
        if (count3 >= 3) {
            stNotAssigned = fillResForStipend(student, stNotAssigned);  //здесь размер массива увеличен на 1
            System.out.println("lengs_check = " + stNotAssigned.length);   //1
            System.out.print("Из check: ");                                //1
            printGroupResForStipend(stNotAssigned);                        //1


        } else if (count3 < 3 && count3 != 0) {
            stipend = fillResForStipend(student, stipend);

        } else if (count5 == marks.length) {
            stPlus100 = fillResForStipend(student, stPlus100);

        } else if (count5 != 0 && count3 == 0) {
            stPlus50 = fillResForStipend(student, stPlus50);

        } else {
            stPlus25 = fillResForStipend(student, stPlus25);
        }

    }


    private static StudExam[] fillResForStipend(StudExam student, StudExam[] groupResForStipend) {
        groupResForStipend[groupResForStipend.length - 1] = student;
        System.out.println(student.getFamilyName());                                            //1
        System.out.println(groupResForStipend[groupResForStipend.length - 1].getFamilyName());  //1
        System.out.println("lengs1 = " + groupResForStipend.length);                          //1
        StudExam[] temp = new StudExam[groupResForStipend.length + 1];
        System.arraycopy(groupResForStipend, 0, temp, 0, groupResForStipend.length);
        groupResForStipend = temp;
        System.out.print("Из fill: ");                                  //1
        printGroupResForStipend(groupResForStipend);                                  //1
        System.out.println("lengs2 = " + groupResForStipend.length);                     //1
        return groupResForStipend;
    }

    private static void sortStudExam(StudExam[] groupResForStipend, int sortParameter) {
        int n = groupResForStipend.length - 1;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < n - i; j++) {
                if (compareStudExam(groupResForStipend[j - 1], groupResForStipend[j], sortParameter)) {
                    StudExam temp = groupResForStipend[j - 1];
                    groupResForStipend[j - 1] = groupResForStipend[j];
                    groupResForStipend[j] = temp;
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

    private static void printGroupResForStipend(StudExam[] groupResForStipend) {
        int n = groupResForStipend.length - 1;
        for (int i = 0; i < n; i++) {
            groupResForStipend[i].print();
        }
    }


}
