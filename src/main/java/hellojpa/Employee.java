package hellojpa;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Employee {

    @Id @GeneratedValue
    @Column(name = "emp_id")
    private Long id;
    private String name;

    // Period
//    private LocalDateTime startDate;
//    private LocalDateTime endDate;

    // 임베디드 타입은 여러 엔터티에서 공유하면 위험!!!
    @Embedded  // 안넣어도 자동 적용
    private Period period;


    // Address
//    private String city;
//    private String street;
//    private String zipcode;


    @Embedded
    private Address homeAddress;


    @Embedded
    @AttributeOverrides({
            @AttributeOverride(
                    name="city", column = @Column(name = "work_city")
            ),
            @AttributeOverride(
                    name="street", column = @Column(name = "work_street")
            ),
            @AttributeOverride(
                    name="zipcode", column = @Column(name = "work_zipcode")
            )
    })
    private Address workAddress;


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

    public Period getPeriod() {
        return period;
    }

    public void setPeriod(Period period) {
        this.period = period;
    }

    public Address getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(Address homeAddress) {
        this.homeAddress = homeAddress;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
