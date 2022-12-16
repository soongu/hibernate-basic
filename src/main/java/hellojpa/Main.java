package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        // 여기서 hello는 persistence.xml에서 정한 unit name
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            Member findMember = em.find(Member.class, 1L);
            System.out.println("findMember = " + findMember);

            findMember.setName("Modi33");
            em.persist(findMember);
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        }



        em.close();
        emf.close();
    }
}