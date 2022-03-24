package line2.line2_back2.reservation.repository;

import line2.line2_back2.reservation.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    List<Reservation> findByGuestId(Long id);
}
