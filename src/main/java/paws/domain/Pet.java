package paws.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "pets")
public class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @NotNull
    @Size(min = 2, max = 20)
    private String name;

    @Column
    private String path;
    //
//    @Column
//    @Lob
//    private byte[] data;

    @ManyToOne
    @JoinColumn(name = "shelter_id", nullable = false)
    private Shelter shelter;

    @Column
    private int active;

}
