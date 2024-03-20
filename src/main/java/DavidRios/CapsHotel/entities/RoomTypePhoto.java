package DavidRios.CapsHotel.entities;

public class RoomTypePhoto {
    private long id;
    private RoomType roomType;
    private String photoUrl;

    public RoomTypePhoto(RoomType roomType, String photoUrl) {
        this.roomType = roomType;
        this.photoUrl = photoUrl;
    }
}
