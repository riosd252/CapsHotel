package DavidRios.CapsHotel.entities;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "room_types")
@NoArgsConstructor
@Getter
@Setter
public class RoomType {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Setter(AccessLevel.NONE)
    private long id;
    private String denomination;
    private String description;

    public RoomType(String denomination, String description) {
        this.denomination = denomination;
        this.description = description;
    }
}
