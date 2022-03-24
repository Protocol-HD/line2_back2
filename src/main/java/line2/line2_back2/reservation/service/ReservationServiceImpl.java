package line2.line2_back2.reservation.service;

import line2.line2_back2.reservation.model.Reservation;
import line2.line2_back2.reservation.repository.ReservationRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class ReservationServiceImpl implements ReservationService{
    private final ReservationRepository reservationRepository;

    @Override
    public Reservation add(Reservation reservation) {
        try {
            log.info("ReservationService add Reservation({}) start", reservation);
            return reservationRepository.save(reservation);
        } catch (Exception e) {
            log.error("ReservationService add Reservation failure, error: {}", e.getMessage());
            return null;
        } finally {
            log.info("ReservationService add Reservation end");
        }
    }

    @Override
    public Reservation edit(Reservation reservation) {
        try {
            log.info("ReservationService edit Reservation({}) start", reservation);
            return reservationRepository.save(reservation);
        } catch (Exception e) {
            log.error("ReservationService edit Reservation failure, error: {}", e.getMessage());
            return null;
        } finally {
            log.info("ReservationService edit Reservation end");
        }
    }

    @Override
    public Reservation findById(Long id) {
        try {
            log.info("ReservationService find by id Reservation(id: {}) start", id);
            return reservationRepository.findById(id).get();
        } catch (Exception e) {
            log.error("ReservationService find by id Reservation failure, error: {}", e.getMessage());
            return null;
        } finally {
            log.info("ReservationService find by id Reservation end");
        }
    }

    @Override
    public void deleteById(Long id) {
        try {
            log.info("ReservationService delete by id Reservation(id: {}) start", id);
            reservationRepository.deleteById(id);
        } catch (Exception e) {
            log.error("ReservationService delete by id Reservation failure, error: {}", e.getMessage());
        } finally {
            log.info("ReservationService delete by id Reservation end");
        }
    }

    @Override
    public List<Reservation> findByGuestId(Long id) {
        try {
            log.info("ReservationService find by guest id Reservation(id: {}) start", id);
            return reservationRepository.findByGuestId(id);
        } catch (Exception e) {
            log.error("ReservationService find by guest id Reservation failure, error: {}", e.getMessage());
            return null;
        } finally {
            log.info("ReservationService find by guest id Reservation end");
        }
    }
}
