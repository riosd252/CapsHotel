package DavidRios.CapsHotel.entities;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "rooms")
@NoArgsConstructor
@Getter
@Setter
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Setter(AccessLevel.NONE)
    private long id;
    @ManyToOne
    @JoinColumn(name = "room_type_id")
    private RoomType roomType;
    private int roomNumber;
    private int capacity;
    @OneToMany(mappedBy = "room")
    private List<Booking> bookings;

    public Room(RoomType roomType, int roomNumber, int capacity) {
        this.roomType = roomType;
        this.roomNumber = roomNumber;
        this.capacity = capacity;
    }
}
