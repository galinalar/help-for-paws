package paws.domain;

import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "application_user")
public class ApplicationUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String username;// login | email | phone

    private String password;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private UserRole userRole;

    @OneToOne
    @JoinColumn(name = "person_id")
    private Person person;
}
