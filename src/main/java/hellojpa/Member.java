package hellojpa;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="MEMBER")
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Member {

    @Id
    private Long id;
    private String name;



}
