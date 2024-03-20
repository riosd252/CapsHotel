package DavidRios.CapsHotel.entities;

import java.time.LocalDate;

public class Booking {
    private long id;
    private User user;
    private Room room;
    private LocalDate checkIn;
    private LocalDate checkOut;
    private String specialRequests;
    private Boolean prepaid;

    public Booking(User user, Room room, LocalDate checkIn, LocalDate checkOut, String specialRequests, Boolean prepaid) {
        this.user = user;
        this.room = room;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.specialRequests = specialRequests;
        this.prepaid = prepaid;
    }
}
