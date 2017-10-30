package controller;

import javax.persistence.EntityManager;

import db.EntityManagerHelper;
import model.Student;
import model.Course;

public class Main {

    public static void main(String[] args) {

        EntityManager entityManager= EntityManagerHelper.getEntityManager();

        Course course_kK = new Course("K1000") ;
        Course course_mK = new Course("M1000") ;
        Course course_rK = new Course("R1000") ;

        Student student_rick = new Student("Rick") ;
        student_rick.addCourse(course_rK);
        student_rick.addCourse(course_mK);

        Student student_rock = new Student("Rock") ;
        student_rock.addCourse(course_rK);
        student_rock.addCourse(course_kK);

        Student student_jack = new Student("Jack") ;
        student_jack.addCourse(course_mK);
        student_jack.addCourse(course_kK);

        course_kK.addStudent(student_rock);
        course_kK.addStudent(student_jack);
        course_mK.addStudent(student_jack);
        course_mK.addStudent(student_rick);
        course_rK.addStudent(student_rock);
        course_rK.addStudent(student_rick);

        System.out.println("course_rK:id = "+course_rK.getCourse_id());
        System.out.println("course_kK:id = "+course_kK.getCourse_id());
        System.out.println("course_mK:id = "+course_mK.getCourse_id());

        EntityManagerHelper.beginTransaction();

        entityManager.persist(course_rK);
        entityManager.persist(course_kK);
        entityManager.persist(course_mK);

        entityManager.persist(student_rick);
        entityManager.persist(student_rock);
        entityManager.persist(student_jack);

        entityManager.flush();
        EntityManagerHelper.commit();   

        System.out.println("student_jack:id = "+student_jack.getStudent_id());
        System.out.println("student_rock:id = "+student_rock.getStudent_id());
        System.out.println("student_gast:id = "+student_rick.getStudent_id());
    }
}