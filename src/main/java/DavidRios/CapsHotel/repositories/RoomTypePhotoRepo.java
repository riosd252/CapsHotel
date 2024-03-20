package DavidRios.CapsHotel.repositories;

import DavidRios.CapsHotel.entities.RoomTypePhoto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomTypePhotoRepo extends JpaRepository<RoomTypePhoto, Long> {
}
