package javasummer2017.filewritingreading;

import java.util.Arrays;

public class Student {
    private static final String DEFAULT_FIRST_NAME = "Unknown";
    private static final String DEFAULT_LAST_NAME = "Unknown";
    private static final int[] DEFAULT_MARKS = {0};

    private String _firstName;
    private String _lastName;
    private int[] _marks;

    public Student() {
        this(DEFAULT_FIRST_NAME, DEFAULT_LAST_NAME);
    }

    public Student(String firstName, String lastName) {
        _firstName = firstName;
        _lastName = lastName;
    }

    public String getFirstName() {
        return _firstName;
    }

    public void setFirstName(String firstName) {

        _firstName = firstName == null ? DEFAULT_FIRST_NAME : firstName;
    }

    public String getLastName() {
        return _lastName;
    }

    public void setLastName(String lastName) {
        _lastName = lastName == null ? DEFAULT_LAST_NAME : lastName;
    }

    public int[] getMarks() {
        return _marks.clone();
    }

    public void setMarks(int[] marks) {
        if (!checkMarks(marks)) {
            _marks = DEFAULT_MARKS;
            return;
        } else {
            _marks = marks.clone();
        }

    }

    private boolean checkMarks(int[] marks) {

        for (int mark : marks) {
            if (mark <= 0 || mark > 12) {
                System.out.println("The mark must be from 1 to 12.");
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Student student = (Student) o;

        if (_firstName != null ? !_firstName.equals(student._firstName) : student._firstName != null) return false;
        if (_lastName != null ? !_lastName.equals(student._lastName) : student._lastName != null) return false;
        return Arrays.equals(_marks, student._marks);
    }

    @Override
    public int hashCode() {
        int result = _firstName != null ? _firstName.hashCode() : 0;
        result = 31 * result + (_lastName != null ? _lastName.hashCode() : 0);
        result = 31 * result + Arrays.hashCode(_marks);
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(getFirstName() + " ");
        sb.append(getLastName() + " ");
        for (int mark : getMarks()) {
            sb.append(mark + " ");
        }

        return sb.toString();
    }
}
