import entities.Student;
import entities.Teacher;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("school");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Teacher teacher = new Teacher("Petrov");
        Student student = new Student("stancho", 1L);
        student.setTeacherId(1);

        em.persist(teacher);
        em.persist(student);

        em.getTransaction().commit();
    }
}
