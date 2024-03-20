package DavidRios.CapsHotel.entities;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "room_type_photos")
@NoArgsConstructor
@Getter
@Setter
public class RoomTypePhoto {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Setter(AccessLevel.NONE)
    private long id;
    @ManyToOne
    @JoinColumn(name = "room_type_id")
    private RoomType roomType;
    private String photoUrl;

    public RoomTypePhoto(RoomType roomType, String photoUrl) {
        this.roomType = roomType;
        this.photoUrl = photoUrl;
    }
}
