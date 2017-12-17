package javasummer2017.cardatabase.entities;


import java.awt.*;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Car implements Cloneable {
    private final String _mark;
    private final String _model;
    private Set<Driver> _drivers = new HashSet<>();
    private final Calendar _year;

    private int _distance = 0;
    private Color _color;

    public Car(final String mark,
               final String model,
               final Calendar year,
               final Color color) {

        if (mark == null
                || model == null
                || year == null
                || color == null) {
            throw new IllegalArgumentException("Error creating car. Argument is null");
        }

        _mark = mark;
        _model = model;
        _year = year;
        _color = color;
    }

    public String getMark() {
        return _mark;
    }

    public String getModel() {
        return _model;
    }

    public Set<Driver> getDrivers() {
        return Collections.unmodifiableSet(_drivers);
    }

    public Calendar getYear() {
        return _year;
    }

    public int getDistance() {
        return _distance;
    }

    public void setDistance(final int distance) {
        if (distance < 0) {
            throw new IllegalArgumentException("Distance is < 0");
        }
        _distance = distance;
    }

    public Color getColor() {
        return _color;
    }

    public void setColor(Color color) {
        if (color == null) {
            throw new NullPointerException("Color cannot be null");
        }
        _color = color;
    }

    @Override
    public Car clone() throws CloneNotSupportedException {
        Car carClone = (Car) super.clone();
        //carClone._year = (Calendar) _year.clone();  //нельзя клонировать final переменную
        //carClone._color= (Color)_color.clone();  //не работает, не понимаю причины
        //carClone._distance = (Integer)_distance.clone(); //и тут не понимаю причины

        return carClone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Car car = (Car) o;

        if (getDistance() != car.getDistance()) return false;
        if (!getMark().equals(car.getMark())) return false;
        if (!getModel().equals(car.getModel())) return false;
        if (!getDrivers().equals(car.getDrivers())) return false;
        if (!getYear().equals(car.getYear())) return false;
        return getColor().equals(car.getColor());
    }

    @Override
    public int hashCode() {
        int result = getMark().hashCode();
        result = 31 * result + getModel().hashCode();
        result = 31 * result + getYear().hashCode();
        return result;
    }
}


