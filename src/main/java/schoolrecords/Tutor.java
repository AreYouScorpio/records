package schoolrecords;

import java.util.List;

public class Tutor {
    String name;
    List<Subject> taughtSubjects;

    public String getName() {
        return name;
    }

    public List<Subject> getTaughtSubjects() {
        return taughtSubjects;
    }

    public Tutor(String name, List<Subject> taughtSubjects) {
        this.name = name;
        this.taughtSubjects = taughtSubjects;
    }

    public boolean tutorTeachingSubject(Subject subject){
        for (Subject s : taughtSubjects) {
            if (s.getSubjectName().equals(subject.getSubjectName())) {
                return true;
            }
        }
        return false;
    }

}
