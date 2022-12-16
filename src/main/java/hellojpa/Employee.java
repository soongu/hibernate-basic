package hellojpa;

import javax.persistence.*;

@Entity
public class Employee {

    @Id @GeneratedValue
    @Column(name = "emp_id")
    private Long id;
    private String name;
//    private Long deptId;

    // EAGER는 조인문이나가고 LAZY는 쿼리를 둘로쪼갠다
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dept_id")
    private Department department;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
