package DavidRios.CapsHotel.entities;

import java.time.LocalDate;

public class Rate {
    private long id;
    private RoomType roomType;
    private LocalDate startDate;
    private LocalDate endDate;
    private double nightlyRate;

    public Rate(RoomType roomType, LocalDate startDate, LocalDate endDate, double nightlyRate) {
        this.roomType = roomType;
        this.startDate = startDate;
        this.endDate = endDate;
        this.nightlyRate = nightlyRate;
    }
}
