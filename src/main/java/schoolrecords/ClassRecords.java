package schoolrecords;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static java.lang.Math.random;

public class ClassRecords {
    String className;
    Random random;
    List<Student> students;

    public ClassRecords(String className, Random random, List<Student> students) {
        this.className = className;
        this.random = random;
        this.students = students;
    }

    public ClassRecords(String className, Random random) {
        this(className, random, new ArrayList<Student>());
    }

    private boolean hasStudent(String name) {
        for (Student s : students) {
            if (s.getName().equals(name)) return true;
        }
        return false;
    }

    public boolean addStudent(Student student){
        if (hasStudent(student.getName()))
            return false;
        this.students.add(student);
        return true;
    }

    public boolean removeStudent(Student student){
        if (!hasStudent((student.getName()))) return false;
        this.students.remove(student);
        return true;
    }

    public String getClassName() {
        return className;
    }

    public double calculateClassAverage(){
        if (students.size()<1) throw new ArithmeticException("No student in the class, average calculation aborted!");
        double average = 0;
        double sum = 0;
        int count = 0;
        double studentAverage;
        for (Student s : students) {
            studentAverage=s.calculateAverage();
            if (studentAverage==0) throw new ArithmeticException("No marks present, average calculation aborted!");
            count++;
            sum+=studentAverage;
        }
        if (count==0) return   0;
        average=sum/(double)(count);
        return Math.round(average*100.0)/100.0;
    }

    public double calculateClassAverageBySubject(Subject subject){
        if (students.size()<1) throw new ArithmeticException("No student in the class, average calculation aborted!");
        double average = 0;
        double sum = 0;
        int count = 0;
        double studentAverage;
        for (Student s : students) {
            studentAverage=s.calculateSubjectAverage(subject);
            if (studentAverage!=0){
                count++;
                sum+=studentAverage;
            }
        }
        if (count==0) return   0;
        average=sum/(double)(count);
        return Math.round(average*100.0)/100.0;
    }

    public Student findStudentByName(String name){
        if (name.length()==0) throw new IllegalArgumentException("Student name must not be empty!");
        if (students.size()==0) throw new IllegalStateException("No students to search!");
        for (Student student : students) {
            if (student.getName().equals(name)) return student;

        }
        throw new IllegalArgumentException("Student by this name cannot be found! "+name);

    }

    public Student repetition(){
        if (students.size()==0) throw new IllegalStateException("No students to select for repetition!");
        int numberOfStudents = students.size();
        int chosenStudent = this.random.nextInt(numberOfStudents);
        return students.get(chosenStudent);
    }

    public List<StudyResultByName> listStudyResults(){
        List<StudyResultByName> result = new ArrayList<>();
        for (Student s : students) {
            result.add(new StudyResultByName(s.getName(), s.calculateAverage()));
        }
        return result;
    }

    public String listStudentNames(){
        StringBuilder sb = new StringBuilder();
        boolean already=false;
        for (Student s : students) {
            if(already)
                sb.append(", ");
            sb.append(s.getName());
            already=true;
        }
        return sb.toString();
    }


}
