package DavidRios.CapsHotel.entities;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "bookings")
@NoArgsConstructor
@Getter
@Setter
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private long id;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToOne
    @JoinColumn(name = "room_id")
    private Room room;
    private LocalDate checkIn;
    private LocalDate checkOut;
    private String specialRequests;
    private boolean prepaid;

    public Booking(User user, Room room, LocalDate checkIn, LocalDate checkOut, String specialRequests, boolean prepaid) {
        this.user = user;
        this.room = room;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.specialRequests = specialRequests;
        this.prepaid = prepaid;
    }

    public boolean isOverlap(LocalDate checkInDate, LocalDate checkOutDate) {
        return this.getCheckOut().isAfter(checkInDate) && this.getCheckIn().isBefore(checkOutDate);
    }
}
