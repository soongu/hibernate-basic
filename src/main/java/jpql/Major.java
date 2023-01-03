package jpql;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Major {

    @Id @GeneratedValue
    private Long id;

    private String name;

    @OneToMany(mappedBy = "major")
    private List<Student> students = new ArrayList<>();
}
