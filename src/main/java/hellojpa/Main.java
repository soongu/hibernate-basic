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

            Department dept = new Department();
            dept.setName("BUSINESS");
            em.persist(dept);

            Employee emp = new Employee();
            emp.setName("김말똥");
            emp.setDepartment(dept);

            em.persist(emp);

            em.flush(); // 영속상태를 만들어줘야 select쿼리를 볼 수 있다
            em.clear();

            Employee findEmp = em.find(Employee.class, emp.getId());
            System.out.println("\ndepartment name: " + findEmp.getDepartment().getName());

            findEmp.getDepartment().getEmployees().forEach(employee -> {
                System.out.println("emp name: " + employee.getName());
            });

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        }



        em.close();
        emf.close();
    }
}