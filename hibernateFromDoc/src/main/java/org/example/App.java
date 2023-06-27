package org.example;


import org.example.entity.*;
import org.example.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

      /* Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        SessionFactory sessionFactory = configuration.buildSessionFactory(); */

        App app = new App();

        HibernateUtil sessionFactory = new HibernateUtil("hibernate.cfg.xml");
        Session session = sessionFactory.getSessionFactory().openSession();

        app.findCourse(session);


    }

    public void findCourse(Session session){
        Course course = session.find(Course.class, 3);
        List<Student> students = course.getStudents();
        for (Student student: students){
            System.out.println(student);

        }

    }


    public void addStudent(Session session){
        Student newStudent = new Student("Ali", "Memmedov");
        Student newStudent02 = new Student("Jalal", "Xelilli");
        Course courseFromDB = session.find(Course.class, 3);
        courseFromDB.addStudent(newStudent);
        courseFromDB.addStudent(newStudent02);

        session.getTransaction().begin();
        session.merge(courseFromDB);
        session.getTransaction().commit();






    }



    public void deleteCourse(Session session){
        session.beginTransaction();
        Course courseFromDB = session.find(Course.class, 4);
        session.remove(courseFromDB);
        session.getTransaction().commit();
        System.out.printf("Deleted course: %s%n", courseFromDB);
    }

    public void getCourseReview(Session session){
        Course course = session.find(Course.class, 1);
        System.out.println(course.getReviews());
    }

    public void addReview(Session session){
        Course getCourseFromDB = session.find(Course.class, 4);
        Review newReview = new Review("Cool course");
        getCourseFromDB.addReview(newReview);
        session.beginTransaction();
        session.merge(getCourseFromDB);
        session.getTransaction().commit();
        System.out.println("New Review: " + newReview);
    }


    /*  REGION 01   */

    public void getInstructorByIdHQ(Session session){
        Query<Instructor> query = session.createQuery("select i from Instructor i "+
                                                        "JOIN FETCH i.course where i.id=:instructorId", Instructor.class);
        query.setParameter("instructorId",3);
        Instructor instructorFromDB = query.getSingleResult();
        System.out.println(instructorFromDB);
    }


    public void fetchInstructorById(Session session){
        System.out.println("Fetch Instructor By Id: ");
        Instructor instructorFromDB = session.find(Instructor.class, 3);
        session.close();
        System.out.println(instructorFromDB.getCourse()); // if Instructor -> Course is lazy. This line will be exception otherwise that mean is eager it is OK
    }

    public void addCourse(Session session){
        Instructor instructorFromDB = session.find(Instructor.class, 4);
        Course course = new Course("Java EE", instructorFromDB);

        session.beginTransaction();
        session.merge(course);
        session.getTransaction().commit();
    }


    public void addInstructor(Session session){
        System.out.println("Adding Instructor...");
        session.beginTransaction();

        InstructorDetail newInstructorDetail = new InstructorDetail("http://youtube.com/murad", "Coding");
        Instructor newInstructor = new Instructor("Murad", "Guliyev", newInstructorDetail);
        session.merge(newInstructor);
        session.getTransaction().commit();

        System.out.println("Added: " + newInstructor);

    }

    public void fethAllInstructors(Session session){
        System.out.println("Fetching Instructors...");
        List<Instructor> allInstructorsFromDB = session.createQuery("from Instructor").list();
        System.out.println(allInstructorsFromDB);
        System.out.println("Fetched");

    }



    /*  END - REGION 01     */



    public void addLesson(Session session){
        Student student = session.get(Student.class, 5);
        Lesson lesson = new Lesson("mathematics");
        lesson.setStudent(student);

        session.beginTransaction();
        session.save(lesson);
        session.getTransaction().commit();


    }



    public void fetchAll(Session session){
        List<Student> listStudentFromDB = session.createQuery("from Student").list();

        System.out.println("Students: ");
        for(Student student: listStudentFromDB){
            System.out.println(student);
        }

//        System.out.println(listStudentFromDB);
    }

    public void add(Session session){
        Student student = new Student("Anar", "Memmedov");
        session.beginTransaction();
        session.save(student);
        session.getTransaction().commit();
    }
}
