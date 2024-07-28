package paws.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "user_role")
public class UserRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Enumerated(EnumType.STRING)
    private RoleType roleType;
    public enum RoleType {
        // может просматривать задачи, в которых является исполнителем
        ROLE_USER,
        // может просматривать задачи, в которых является ответственным (автором)
        // может просматривать задачи, в которых является исполнителем
        ROLE_SUPER_USER // может создавать задачи,
    }
}
