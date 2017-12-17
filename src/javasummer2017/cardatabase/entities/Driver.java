package javasummer2017.cardatabase.entities;


public class Driver implements Cloneable {

    // first name, last name mutable cloneable


    private String _firstName;
    private String _lastName;


    public Driver(String firstName, String lastName) {
        setFirstName(firstName);
        setLastName(lastName);
    }


    public String getFirstName() {
        return _firstName;
    }

    public void setFirstName(String firstName) {
        checkArgFirstName(firstName);
        _firstName = firstName;
    }

    public String getLastName() {
        return _lastName;
    }

    public void setLastName(String lastName) {
        checkArgsLastName(lastName);
        _lastName = lastName;
    }


    private void checkArgFirstName(String firstName) {
        if (firstName == null) {
            throw new IllegalArgumentException("Error creating Driver. Argument firstName is null.");
        }
    }

    private void checkArgsLastName(String lastName) {
        if (lastName == null) {
            throw new IllegalArgumentException("Error creating Driver. Argument lastName is null.");
        }
    }

    @Override
    public Driver clone() throws CloneNotSupportedException {
        return (Driver) super.clone();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Driver driver = (Driver) o;

        if (_firstName != null ? !_firstName.equals(driver._firstName) : driver._firstName != null) return false;
        return _lastName != null ? _lastName.equals(driver._lastName) : driver._lastName == null;
    }

    @Override
    public int hashCode() {
        int result = _firstName != null ? _firstName.hashCode() : 0;
        result = 31 * result + (_lastName != null ? _lastName.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return String.format("Driver %s %s%n",
                _firstName, _lastName);
    }
}


