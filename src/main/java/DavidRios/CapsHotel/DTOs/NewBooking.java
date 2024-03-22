package DavidRios.CapsHotel.DTOs;

import java.util.UUID;

public record NewBooking(UUID userId, long roomId, String checkInDate, String checkOutDate, String specialRequests, boolean prepaid) {
}
