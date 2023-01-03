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

            for (int i = 0; i < 100; i++) {
                Student st = new Student();
                st.setUsername("김빡빡");
                st.setAge(30 + i);
                em.persist(st);
            }
            em.flush();
            em.clear();

            List<Student> students = em.createQuery("select s from Student s order by s.age desc", Student.class)
                    .setFirstResult(0)
                    .setMaxResults(10)
                    .getResultList();

            for (Student s : students) {
                System.out.println("s = " + s);
            }


            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        }



        em.close();
        emf.close();
    }
}
