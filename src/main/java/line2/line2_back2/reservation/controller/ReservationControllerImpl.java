package line2.line2_back2.reservation.controller;

import line2.line2_back2.reservation.model.Reservation;
import line2.line2_back2.reservation.service.ReservationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/reservation")
@RequiredArgsConstructor
@CrossOrigin
public class ReservationControllerImpl implements ReservationController{
    private final ReservationService reservationService;

    @Override
    @PostMapping("/v1/reservation")
    public Reservation add(@RequestBody Reservation reservation) {
        try {
            log.info("ReservationController add Reservation({}) start", reservation);
            return reservationService.add(reservation);
        } catch (Exception e) {
            log.error("ReservationController add Reservation failure, error: {}", e.getMessage());
            return null;
        } finally {
            log.info("ReservationController add Reservation end");
        }
    }

    @Override
    @PutMapping("/v1/reservation")
    public Reservation edit(@RequestBody Reservation reservation) {
        try {
            log.info("ReservationController edit Reservation({}) start", reservation);
            return reservationService.edit(reservation);
        } catch (Exception e) {
            log.error("ReservationController edit Reservation failure, error: {}", e.getMessage());
            return null;
        } finally {
            log.info("ReservationController edit Reservation end");
        }
    }

    @Override
    @GetMapping("/v1/reservation/{id}")
    public Reservation findById(@PathVariable Long id) {
        try {
            log.info("ReservationController find by id Reservation(id: {}) start", id);
            return reservationService.findById(id);
        } catch (Exception e) {
            log.error("ReservationController find by id Reservation failure, error: {}", e.getMessage());
            return null;
        } finally {
            log.info("ReservationController find by id Reservation end");
        }
    }

    @Override
    @DeleteMapping("/v1/reservation/{id}")
    public void deleteById(@PathVariable Long id) {
        try {
            log.info("ReservationController delete by id Reservation(id: {}) start", id);
            reservationService.deleteById(id);
        } catch (Exception e) {
            log.error("ReservationController delete by id Reservation failure, error: {}", e.getMessage());
        } finally {
            log.info("ReservationController delete by id Reservation end");
        }
    }

    @Override
    @GetMapping("/v1/reservation/guest/{id}")
    public List<Reservation> findByGuestId(@PathVariable Long id) {
        try {
            log.info("ReservationController find by guest id Reservation(id: {}) start", id);
            return reservationService.findByGuestId(id);
        } catch (Exception e) {
            log.error("ReservationController find by guest id Reservation failure, error: {}", e.getMessage());
            return null;
        } finally {
            log.info("ReservationController find by guest id Reservation end");
        }
    }

    @Override
    @GetMapping("/v1/reservation/guest/before_check_in/{id}")
    public List<Reservation> findByGuestIdBeforeCheckIn(@PathVariable Long id) {
        try {
            log.info("ReservationController find by guest before check in Reservation(id: {}) start", id);
            return reservationService.findByGuestIdCheckInOut(id, false, false);
        } catch (Exception e) {
            log.error("ReservationController find by guest before check in Reservation failure, error: {}", e.getMessage());
            return null;
        } finally {
            log.info("ReservationController find by guest before check in Reservation end");
        }
    }

    @Override
    @GetMapping("/v1/reservation/guest/before_check_out/{id}")
    public List<Reservation> findByGuestIdBeforeCheckOut(@PathVariable Long id) {
        try {
            log.info("ReservationController find by guest before check out Reservation(id: {}) start", id);
            return reservationService.findByGuestIdCheckInOut(id, true, false);
        } catch (Exception e) {
            log.error("ReservationController find by guest before check out Reservation failure, error: {}", e.getMessage());
            return null;
        } finally {
            log.info("ReservationController find by guest before check out Reservation end");
        }
    }

    @Override
    @GetMapping("/v1/reservation/guest/after_check_out/{id}")
    public List<Reservation> findByGuestIdAfterCheckOut(@PathVariable Long id) {
        try {
            log.info("ReservationController find by guest after check out Reservation(id: {}) start", id);
            return reservationService.findByGuestIdCheckInOut(id, true, true);
        } catch (Exception e) {
            log.error("ReservationController find by guest after check out Reservation failure, error: {}", e.getMessage());
            return null;
        } finally {
            log.info("ReservationController find by guest after check out Reservation end");
        }
    }
}
