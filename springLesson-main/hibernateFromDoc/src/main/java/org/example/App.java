package org.example;

import org.example.entity.Lesson;
import org.example.entity.Student;
import org.example.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

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

        /*  Methods  */

//        app.add(session);
//        app.fetchAll(session);

        app.addLesson(session);

        /* End - Method */


    }

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
