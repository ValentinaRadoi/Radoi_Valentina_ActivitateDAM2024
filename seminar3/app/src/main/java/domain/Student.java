package domain;

import java.io.Serializable;
import java.util.Date;

public class Student implements Serializable {
    private String name;
    private Date Enrollment_date;
    private String faculty;
    private StudyType studytype;

    public Student(String name, Date enrollment_date, String faculty, StudyType studytype) {
        this.name = name;
        Enrollment_date = enrollment_date;
        this.faculty = faculty;
        this.studytype = studytype;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getEnrollment_date() {
        return Enrollment_date;
    }

    public void setEnrollment_date(Date enrollment_date) {
        Enrollment_date = enrollment_date;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public StudyType getStudytype() {
        return studytype;
    }

    public void setStudytype(StudyType studytype) {
        this.studytype = studytype;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", Enrollment_date=" + Enrollment_date +
                ", faculty='" + faculty + '\'' +
                ", studytype=" + studytype +
                '}';
    }
}
