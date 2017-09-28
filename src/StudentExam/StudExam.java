package StudentExam;

import java.util.Arrays;

public class StudExam {

    private static final String DEFAULT_FAMILY_NAME = "Unknown";
    private static final String DEFAULT_NAME = DEFAULT_FAMILY_NAME;
    private static final String DEFAULT_PATRONYMIC = DEFAULT_FAMILY_NAME;
    private static final String DEFAULT_GROUP = "Unknown group";
    private static final String DEFAULT_GROUP_FOR_STIPEND = "Unknown group";
    private static final int[] DEFAULT_MARKS = {0};

    private String familyName;
    private String name;
    private String patronymic;
    private String group;
    private String groupForStipend;

    private int[] marks;


    StudExam() {
        this(DEFAULT_FAMILY_NAME, DEFAULT_NAME, DEFAULT_PATRONYMIC, DEFAULT_GROUP);
    }

    StudExam(String familyName) {
        this(familyName, DEFAULT_NAME, DEFAULT_PATRONYMIC, DEFAULT_GROUP);
    }

    StudExam(String familyName, String name) {
        this(familyName, name, DEFAULT_PATRONYMIC, DEFAULT_GROUP);
    }

    StudExam(String familyName, String name, String patronymic) {
        this(familyName, name, patronymic, DEFAULT_GROUP);
    }

    StudExam(String familyName, String name, String patronymic, String group) {
        setFamilyName(familyName);
        setName(name);
        setPatronymic(patronymic);
        setGroup(group);
        this.marks = DEFAULT_MARKS;
    }


    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName == null ? DEFAULT_FAMILY_NAME : familyName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? DEFAULT_NAME : name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic == null ? DEFAULT_PATRONYMIC : patronymic;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group == null ? DEFAULT_GROUP : group;
    }

    public String getGroupForStipend() {
        return groupForStipend;
    }

    public void setGroupForStipend(String groupForStipend) {
        this.groupForStipend = groupForStipend == null ? DEFAULT_GROUP_FOR_STIPEND : groupForStipend;
    }

    public int[] getMarks() {
        return marks.clone();
    }

    public void setMarks(int[] marks) {
        int[] temp = marksAfterCheck(marks);

        while (true) {
            if (temp.length == 1) {
                System.out.println("Marks inputed not correctly.");
                this.marks = DEFAULT_MARKS;
                break;
            } else {
                this.marks = temp.clone();
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
                    result = DEFAULT_MARKS;
                    break;
                } else {
                    result = marks;
                }
            }
        } else {
            System.out.println("Quantity of marks can be from 3 to 5.");
            result = DEFAULT_MARKS;
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
//обновленная версия
}


