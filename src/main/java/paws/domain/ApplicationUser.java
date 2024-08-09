package paws.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
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

    @NotNull
    private String username;// login | email | phone

    @NotNull
    private String password;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private UserRole userRole;

    @OneToOne
    @JoinColumn(name = "person_id")
    private Person person;

    @Column
    private int active;
}
