package hu.ulyssys.java.course.database.hibernate;

import hu.ulyssys.java.course.database.hibernate.entity.*;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.Date;
import java.util.List;

public class HibernateMain {

    public static void main(String[] args) {

        Aircraft aircraft = new Aircraft();
        aircraft.setName("Szper repcsi");
        aircraft.setCreatedDate(new Date());
        aircraft.setLastModifiedDate(new Date());
        Long id = insertAircraft(aircraft);

        Student student = new Student();
        student.setFirstName("Kis");
        student.setLastName("Pista");
        student.setFriendsNumber(10);
        id = insertStudent(student);
        Student persisStudent = findByIdStudent(id);
        updateStudent(persisStudent);
        findAll(Student.class).forEach(student1 -> {
            System.out.println(student1.getId() + " " + student1.getFirstName() + " " + student1.getLastName());
        });

        Teacher teacher = new Teacher();
        teacher.setFirstName("Nagy");
        teacher.setLastName("István");
        teacher.setCoursesNumber(5);
        id = insertTeacher(teacher);
        Teacher persisTeacher = findByIdTeacher(id);
        updateTeacher(persisTeacher);
        findAllTeacher().forEach(teacher1 -> {
            System.out.println(teacher1.getId() + " " + teacher1.getFirstName() + " " + teacher1.getLastName());
        });

        //Save
        Tank tank = new Tank();
        tank.setName("példa tigris tank");
        tank.setType("tigris tank");
        tank.setCreatedDate(new Date());
        tank.setLastModifiedDate(new Date());
        id = insertTank(tank);
        // find By id
        Tank persisTank = findByIdTank(id);
        // lekérdezzük a tank
        persisTank.setName("test");
        persisTank.setCreatedDate(new Date());
        updateTank(persisTank);
        findAllTank().forEach(tank1 -> {
            System.out.println(tank1.getId() + " " + tank1.getName());
        });
        DatabaseSessionProvider.getInstance().getSessionObj().close();
    }

    private static List<AbstractPerson> findAll(Class aClass){
        return DatabaseSessionProvider.getInstance().getSessionObj().createQuery("select n from " + aClass.getSimpleName() + " n", aClass).getResultList();
    }

    private static List<Student> findAllStudent(){
        Session session = DatabaseSessionProvider.getInstance().getSessionObj();
        Query<Student> query = session.createQuery("select n from Student n", Student.class);
        return query.getResultList();
    }

    private static List<Teacher> findAllTeacher(){
        Session session = DatabaseSessionProvider.getInstance().getSessionObj();
        Query<Teacher> query = session.createQuery("select n from Teacher n", Teacher.class);
        return query.getResultList();
    }

    private static List<Tank> findAllTank() {
        Session session = DatabaseSessionProvider.getInstance().getSessionObj();
        Query<Tank> query = session.createQuery("select n from Tank n", Tank.class);
        return query.getResultList();
    }

    private static void updateTeacher(Teacher teacher){
        Session session = DatabaseSessionProvider.getInstance().getSessionObj();
        session.beginTransaction();
        session.update(teacher);
        session.getTransaction().commit();
    }

    private static void updateStudent(Student student){
        Session session = DatabaseSessionProvider.getInstance().getSessionObj();
        session.beginTransaction();
        session.update(student);
        session.getTransaction().commit();
    }

    private static void updateTank(Tank tank) {
        Session session = DatabaseSessionProvider.getInstance().getSessionObj();

        session.beginTransaction();
        session.update(tank);
        session.getTransaction().commit();
    }

    private static Student findByIdStudent(Long id){
        Session session = DatabaseSessionProvider.getInstance().getSessionObj();
        return session.find(Student.class, id);
    }

    private static Teacher findByIdTeacher(Long id){
        Session session = DatabaseSessionProvider.getInstance().getSessionObj();
        return session.find(Teacher.class, id);
    }

    private static Tank findByIdTank(Long id) {
        Session session = DatabaseSessionProvider.getInstance().getSessionObj();
        return session.find(Tank.class, id);
    }

    private static Long insertStudent(Student student) {
        Session session = DatabaseSessionProvider.getInstance().getSessionObj();
        session.beginTransaction();
        session.save(student);
        session.getTransaction().commit();
        return student.getId();
    }

    private static Long insertTeacher(Teacher teacher) {
        Session session = DatabaseSessionProvider.getInstance().getSessionObj();
        session.beginTransaction();
        session.save(teacher);
        session.getTransaction().commit();
        return teacher.getId();
    }

    private static Long insertAircraft(Aircraft aircraft) {
        Session session = DatabaseSessionProvider.getInstance().getSessionObj();
        session.beginTransaction();
        session.save(aircraft);
        session.getTransaction().commit();
        return aircraft.getId();
    }

    private static Long insertTank(Tank tank) {
        Session session = DatabaseSessionProvider.getInstance().getSessionObj();
        session.beginTransaction();
        session.save(tank);
        session.getTransaction().commit();
        return tank.getId();
    }
}