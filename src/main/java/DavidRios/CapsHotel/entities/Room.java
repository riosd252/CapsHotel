package DavidRios.CapsHotel.entities;

public class Room {
    private long id;
    private RoomType roomType;
    private int roomNumber;
    private int capacity;

    public Room(RoomType roomType, int roomNumber, int capacity) {
        this.roomType = roomType;
        this.roomNumber = roomNumber;
        this.capacity = capacity;
    }
}
