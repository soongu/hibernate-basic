package hellojpa;

import jpashop.entity.Member;
import jpashop.entity.Order;
import jpashop.entity.OrderItem;

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

            Department dep = new Department();
            dep.setName("business");
            em.persist(dep);

            Employee emp = new Employee();
            emp.setName("kim");
            emp.setDepartment(dep);

            em.persist(emp);

            em.flush();
            em.clear();

            Employee findEmp = em.find(Employee.class, emp.getId());
            System.out.println("findEmp.getName() = " + findEmp.getName());
            System.out.println("findEmp.getDepartment().getName() = " + findEmp.getDepartment().getName());


            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        }



        em.close();
        emf.close();
    }
}