package DavidRios.CapsHotel.components;

import DavidRios.CapsHotel.entities.RoomType;
import DavidRios.CapsHotel.repositories.RoomTypeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoomTypeService {

    @Autowired
    private RoomTypeRepo roomTypeRepo;

    public List<RoomType> getRoomTypes() {
        return this.roomTypeRepo.findAll();
    }

    public Page<RoomType> getAvailableRoomTypes(int occupants, LocalDate checkInDate, LocalDate checkOutDate, int page, int size) {

        List<RoomType> allRoomTypes = this.getRoomTypes();

       List<RoomType> availableRoomTypes = allRoomTypes.stream().filter(roomType -> roomType.isRoomTypeAvailable(occupants, checkInDate, checkOutDate))
                .collect(Collectors.toList());

        int start = page * size;
        int end = Math.min(start + size, availableRoomTypes.size());

        return new PageImpl<>(availableRoomTypes.subList(start, end), PageRequest.of(page, size), availableRoomTypes.size());
    }

}
