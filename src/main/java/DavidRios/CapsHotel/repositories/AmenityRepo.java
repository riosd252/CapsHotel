package DavidRios.CapsHotel.repositories;

import DavidRios.CapsHotel.entities.Amenity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AmenityRepo extends JpaRepository<Amenity, Long> {
}
