package schoolrecords;

import java.util.ArrayList;
import java.util.List;

public class Student {
    String name;
    MarkType markType;
    List<Mark> marks;

    public String getName() {
        return name;
    }

    public Student(String name, MarkType markType , List<Mark> marks) {
        if (name == null || name.length()==0) throw new IllegalArgumentException("Student name must not be empty!");
        if (marks == null) throw new NullPointerException("Mark must not be null!");
        //if (markType == null) throw new NullPointerException("Mark must not be null!");
        this.name = name;
        this.markType = markType;
        this.marks = marks;
    }

    public Student(String name) {
        this(name,null,new ArrayList<Mark>());
    }




    public MarkType getMarkType() {
        return markType;
    }

    public List<Mark> getMarks() {
        return marks;
    }

    public void grading(Mark mark){
        if (mark == null) throw new NullPointerException("Mark must not be null!");
        this.marks.add(mark);
    }




    public double calculateAverage(){
        double average = 0;
        int sum = 0;
        int count = 0;
        for (Mark m : marks) {
            count++;
            sum+=m.getMarkType().i;
        }
        if (count==0) return   0;
        average=sum/(double)(count);
        return Math.round(average*100.0)/100.0;
    }

    public double calculateSubjectAverage(Subject subject){
        double average = 0;
        int sum = 0;
        int count = 0;
        for (Mark m : marks) {
            if (m.getSubject().getSubjectName().equals(subject.getSubjectName())) {
            count++;
            sum+=m.getMarkType().i;
        }}
        if (count==0) return   0;
        average=sum/(double)(count);
        return Math.round(average*100.0)/100.0;
    }

    @Override
    public String toString() {
        String result= name + " marks: ";
        for (Mark m:marks) {
            result+=m.getSubject().getSubjectName()+": "+m.toString();
        }
        System.out.println(result);
        return result;
    }
}
