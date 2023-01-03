package jpql;

import hellojpa.Employee;

import javax.persistence.*;
import java.util.List;

public class JpqlMain {
    public static void main(String[] args) {
        // 여기서 hello는 persistence.xml에서 정한 unit name
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {

            Student st = new Student();
            st.setUsername("김빡빡");
            st.setAge(30);

            em.persist(st);

            TypedQuery<Student> query1 = em.createQuery("select s from Student s", Student.class);
//            TypedQuery<String> query2 = em.createQuery("select s.username from Student s", String.class);
//            Query query3 = em.createQuery("select s.username, s.age from Student s");

            List<Student> students = query1.getResultList();

            Student student = em.createQuery("select s from Student s where s.username = :username", Student.class)
                    .setParameter("username", "김빡빡")
                    .getSingleResult();


            StudentDTO studentDTO = em.createQuery("select new jpql.StudentDTO(s.username, s.age) from Student s", StudentDTO.class)
                    .getSingleResult();


            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        }



        em.close();
        emf.close();
    }
}
