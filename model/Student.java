package studentHelper.model;

/**
 * Created by Evgeny on 4/9/17.
 */
public class Student {
    private int id;
    private String firstName;
    private String secondName;
    private double avgMark;
    private int groupNumber;

    public Student() {
    }

    public Student(String firstName, String secondName, double avgMark, int groupNumber) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.avgMark = avgMark;
        this.groupNumber = groupNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public double getAvgMark() {
        return avgMark;
    }

    public void setAvgMark(double avgMark) {
        this.avgMark = avgMark;
    }

    public int getGroupNumber() {
        return groupNumber;
    }

    public void setGroupNumber(int groupNumber) {
        this.groupNumber = groupNumber;
    }

    @Override
    public String toString() {
        return "student " + firstName + " " + secondName + " " + avgMark + " " + groupNumber;
    }
}
