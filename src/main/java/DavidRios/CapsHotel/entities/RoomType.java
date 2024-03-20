package DavidRios.CapsHotel.entities;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

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
    @OneToMany(mappedBy = "roomType")
    private List<RoomTypePhoto> photos;
    @ManyToMany
    @JoinTable(
            name = "room_type_amenity",
            joinColumns = @JoinColumn(name = "room_type_id"),
            inverseJoinColumns = @JoinColumn(name = "amenity_id")
    )
    private List<Amenity> amenities;
    @OneToMany(mappedBy = "roomType")
    private List<Rate> rates;
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "roomType")
    private List<Room> rooms;

    public RoomType(String denomination, String description) {
        this.denomination = denomination;
        this.description = description;
    }

    public boolean isRoomTypeAvailable(int occupants, LocalDate checkInDate, LocalDate checkOutDate) {

        List<Room> rooms = this.getRooms();


        for (Room room : rooms) {
            if (room.isRoomAvailable(occupants, checkInDate, checkOutDate)) {
                return true;
            }
        }
        return false;
    }
}
