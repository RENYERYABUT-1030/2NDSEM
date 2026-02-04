import javax.swing.JOptionPane;

public class StudentRecord {

    private String name;
    private String address;
    private int age;
    private double mathGrade;
    private double englishGrade;
    private double scienceGrade;
    private static int studentCount;

    // Constructor
    public StudentRecord() {
        studentCount++;
    }

    public String getName() {
        return name;
    }

    public void setName(String temp) {
        name = temp;
    }

    public double getAverage() {
        return (mathGrade + englishGrade + scienceGrade) / 3;
    }

    public static int getStudentCount() {
        return studentCount;
    }

    // MAIN METHOD
    public static void main(String[] args) {

        StudentRecord annaRecord = new StudentRecord();
        StudentRecord beahRecord = new StudentRecord();
        StudentRecord crisRecord = new StudentRecord();

        annaRecord.setName("Anna");
        beahRecord.setName("Beah");
        crisRecord.setName("Cris");

        // JOptionPane output
        JOptionPane.showMessageDialog(
                null,
                "First student name: " + annaRecord.getName()
                + "\nTotal students: " + StudentRecord.getStudentCount(),
                "Student Record",
                JOptionPane.INFORMATION_MESSAGE
        );
    }
}
