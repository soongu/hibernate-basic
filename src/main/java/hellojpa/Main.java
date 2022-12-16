package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // 여기서 hello는 persistence.xml에서 정한 unit name
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {

//            List<Member> resultList = em.createQuery("select m from Member as m", Member.class)
//                    .setFirstResult(5)
//                    .setMaxResults(10)
//                    .getResultList();
//
//            resultList.forEach(System.out::println);

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        }



        em.close();
        emf.close();
    }
}