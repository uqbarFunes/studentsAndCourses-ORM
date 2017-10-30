package model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="COURSES")
public class Course
{
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id ;

    @Column(name="COURSE_NAME")
    private String courseName ;

    @ManyToMany(targetEntity=Student.class, mappedBy="name", fetch=FetchType.EAGER)
    private Set<Student> students ;


    public Course(String myName)
    {
        this.courseName = myName ;
        this.students = new HashSet<Student> () ;
    }

    public void addStudent(Student myStudent)
    {
        this.students.add(myStudent) ;
    }

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "courses")
    public Set<Student> getCourse_students()
    {
        return this.students ;
    }

    @Column(name="COURSE_ID", unique=true, nullable=false)
    public int getCourse_id()
    {
        return id ;
    }
}