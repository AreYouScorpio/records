package schoolrecords;

public class StudyResultByName {
  String name;
  double average;


    public StudyResultByName(String name, double average) {
        this.name = name;
        this.average = average;
    }

    public double getStudyAverage(){
      return average;
  }

  public String getStudentName(){
      return name;
  }

}
