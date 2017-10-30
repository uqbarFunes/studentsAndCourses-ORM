package model;

import java.util.HashSet;
import javax.persistence.JoinColumn;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Table(name="STUDENTS")
public class Student
{
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id ;

    private String name ;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Course> courses ;

    public Student(String myName)
    {
        this.name = myName ;
        courses = new HashSet<Course>() ;
    }

    public void addCourse(Course myCourse)
    {
        this.courses.add(myCourse) ;
    }


    @Column(name="STUDENT_ID", unique=true, nullable=false)
    public int getStudent_id()
    {
        return this.id ;
    }


    @JoinTable(name = "STUDENT_COURSE", joinColumns = {
            @JoinColumn(name = "STUDENT_ID", nullable = false, updatable = false) },
            inverseJoinColumns = { @JoinColumn(name = "COURSE_ID",
                    nullable = false, updatable = false) }
                )
    public Set<Course> getCourses()
    {
        return this.courses ;
    }

    @Column(name="STUDENT_NAME")
    public String getStudent_name()
    {
        return this.name ;
    }

}
