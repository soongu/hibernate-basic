package hellojpa;

import jpashop.entity.Member;

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

            Employee emp = new Employee();
            emp.setName("김빠빠");
            emp.setHomeAddress(new Address("Seoul", "Digitalro 19", "09890"));
            emp.setPeriod(new Period());

            em.persist(emp);


            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        }



        em.close();
        emf.close();
    }
}