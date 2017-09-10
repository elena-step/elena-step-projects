package StudentExam;

import java.util.Arrays;

public class StudExam {

    private static final String DEFOULT_FAMILY_NAME = "Unknown";
    private static final String DEFOULT_NAME = DEFOULT_FAMILY_NAME;
    private static final String DEFOULT_PATRONYMIC = DEFOULT_FAMILY_NAME;
    private static final String DEFOULT_GROUP = "Unknown group";
    private static final int[] DEFOULT_MARKS = {0};

    private String familyName;
    private String name;
    private String patronymic;
    private String group;
    private int[] marks;


    StudExam() {
        this(DEFOULT_FAMILY_NAME, DEFOULT_NAME, DEFOULT_PATRONYMIC, DEFOULT_GROUP);
    }

    StudExam(String familyName) {
        this(familyName, DEFOULT_NAME, DEFOULT_PATRONYMIC, DEFOULT_GROUP);
    }

    StudExam(String familyName, String name) {
        this(familyName, name, DEFOULT_PATRONYMIC, DEFOULT_GROUP);
    }

    public StudExam(String familyName, String name, String patronymic) {
        this(familyName, name, patronymic, DEFOULT_GROUP);
    }

    StudExam(String familyName, String name, String patronymic, String group) {
        setFamilyName(familyName);
        setName(name);
        setPatronymic(patronymic);
        setGroup(group);
        this.marks = DEFOULT_MARKS;
    }

    StudExam(String familyName, String name, String patronymic, String group, int[] marks) {
        setFamilyName(familyName);
        setName(name);
        setPatronymic(patronymic);
        setGroup(group);
        setMarks(marks);
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName == null ? DEFOULT_FAMILY_NAME : familyName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? DEFOULT_NAME : name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic == null ? DEFOULT_PATRONYMIC : patronymic;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group == null ? DEFOULT_GROUP : group;
    }

    public int[] getMarks() {
        return marks.clone();
    }

    public void setMarks(int[] marks) {
        int[] temp = marksAfterCheck(marks);

        while (true) {
            if (temp.length == 1) {
                System.out.println("Marks inputed not correctly.");
                this.marks = DEFOULT_MARKS;
                break;
            } else {
                this.marks = temp;   //клонирование произведено в методе marksAfterCheck
                break;
            }

        }

    }


    private int[] marksAfterCheck(int[] marks) {
        int marksLength = 0;
        marksLength = marks.length;

        int[] result = new int[marksLength];
        if (quantityOfMarks(marks)) {
            for (int i = 0; i < marks.length; i++) {
                if (marks[i] <= 0 || marks[i] > 5) {
                    System.out.println("The marks must be from 1 to 5.");
                    result = DEFOULT_MARKS;
                    break;
                } else {
                    result = marks.clone();
                }
            }
        } else {
            System.out.println("Quantity of marks can be from 3 to 5.");
            result = DEFOULT_MARKS;
        }

        return result;
    }

    private boolean quantityOfMarks(int[] marks) {
        return marks.length >= 3 && marks.length <= 5;

    }

    void print() {
        System.out.print(familyName + " " + name + " " + patronymic + "\t" + group + "\t");
        System.out.println(Arrays.toString(marks));
    }

}


