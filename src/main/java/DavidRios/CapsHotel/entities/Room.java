package DavidRios.CapsHotel.entities;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
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
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "room")
    private List<Booking> bookings;

    public Room(RoomType roomType, int roomNumber, int capacity) {
        this.roomType = roomType;
        this.roomNumber = roomNumber;
        this.capacity = capacity;
    }

    public boolean isRoomAvailable(int occupants, LocalDate checkInDate, LocalDate checkOutDate) {
       List <Booking> bookings = this.getBookings();
        for (Booking booking : bookings) {
            if (booking.isOverlap(checkInDate, checkOutDate)) return false;
        }
        return this.getCapacity() >= occupants;
    }

    public void addBooking(Booking booking) {
        this.bookings.add(booking);
    }
}
