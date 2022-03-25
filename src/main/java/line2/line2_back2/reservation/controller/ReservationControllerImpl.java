package line2.line2_back2.reservation.controller;

import line2.line2_back2.reservation.model.Reservation;
import line2.line2_back2.reservation.model.ReservationDenyInput;
import line2.line2_back2.reservation.model.ReservationDtoInput;
import line2.line2_back2.reservation.service.ReservationService;
import line2.line2_back2.systemMessage.SystemMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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
    public SystemMessage add(@RequestBody Reservation reservation) {
        try {
            log.info("ReservationController add Reservation({}) start", reservation);
            return reservationService.add(reservation);
        } catch (Exception e) {
            log.error("ReservationController add Reservation failure, error: {}", e.getMessage());
            return SystemMessage.builder()
                    .code(2)
                    .message("예약 실패")
                    .build();
        } finally {
            log.info("ReservationController add Reservation end");
        }
    }

    @Override
    @PutMapping("/v1/reservation")
    public SystemMessage edit(@RequestBody ReservationDtoInput reservationDtoInput) {
        try {
            log.info("ReservationController edit Reservation({}) start", reservationDtoInput);
            return reservationService.edit(reservationDtoInput);
        } catch (Exception e) {
            log.error("ReservationController edit Reservation failure, error: {}", e.getMessage());
            return SystemMessage.builder()
                    .code(2)
                    .message("예약 변경 실패")
                    .build();
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
    public SystemMessage deleteById(@PathVariable Long id) {
        try {
            log.info("ReservationController delete by id Reservation(id: {}) start", id);
            return reservationService.deleteById(id);
        } catch (Exception e) {
            log.error("ReservationController delete by id Reservation failure, error: {}", e.getMessage());
            return SystemMessage.builder()
                    .code(2)
                    .message("예약 삭제 실패")
                    .build();
        } finally {
            log.info("ReservationController delete by id Reservation end");
        }
    }

    @Override
    @GetMapping("/v1/reservation/user/{id}")
    public List<Reservation> findByUserId(@PathVariable Long id) {
        try {
            log.info("ReservationController find by user id Reservation(id: {}) start", id);
            return reservationService.findByUserId(id);
        } catch (Exception e) {
            log.error("ReservationController find by user id Reservation failure, error: {}", e.getMessage());
            return null;
        } finally {
            log.info("ReservationController find by user id Reservation end");
        }
    }

    @Override
    @GetMapping("/v1/reservation/user/before_check_in/{id}")
    public List<Reservation> findByUserIdBeforeCheckIn(@PathVariable Long id) {
        try {
            log.info("ReservationController find by user before check in Reservation(id: {}) start", id);
            List<Reservation> reservations = new ArrayList<>();
            reservations.addAll(reservationService.findByUserIdCheckInOut(id, false, false, false));
            reservations.addAll(reservationService.findByUserIdCheckInOut(id, false, false, true));
            return reservations;
        } catch (Exception e) {
            log.error("ReservationController find by user before check in Reservation failure, error: {}", e.getMessage());
            return null;
        } finally {
            log.info("ReservationController find by user before check in Reservation end");
        }
    }

    @Override
    @GetMapping("/v1/reservation/user/before_check_out/{id}")
    public List<Reservation> findByUserIdBeforeCheckOut(@PathVariable Long id) {
        try {
            log.info("ReservationController find by user before check out Reservation(id: {}) start", id);
            return reservationService.findByUserIdCheckInOut(id, true, false, false);
        } catch (Exception e) {
            log.error("ReservationController find by user before check out Reservation failure, error: {}", e.getMessage());
            return null;
        } finally {
            log.info("ReservationController find by user before check out Reservation end");
        }
    }

    @Override
    @GetMapping("/v1/reservation/user/after_check_out/{id}")
    public List<Reservation> findByUserIdAfterCheckOut(@PathVariable Long id) {
        try {
            log.info("ReservationController find by user after check out Reservation(id: {}) start", id);
            return reservationService.findByUserIdCheckInOut(id, true, true, false);
        } catch (Exception e) {
            log.error("ReservationController find by user after check out Reservation failure, error: {}", e.getMessage());
            return null;
        } finally {
            log.info("ReservationController find by user after check out Reservation end");
        }
    }

    @Override
    public List<Reservation> findByUserDenyReservation(Long id) {
        try {
            log.info("ReservationController find by user after check out Reservation(id: {}) start", id);
            return reservationService.findByUserIdCheckInOut(id, true, true, false);
        } catch (Exception e) {
            log.error("ReservationController find by user after check out Reservation failure, error: {}", e.getMessage());
            return null;
        } finally {
            log.info("ReservationController find by user after check out Reservation end");
        }
    }

    @Override
    @PutMapping("/v1/reservation/accept_check_in/{id}")
    public SystemMessage acceptCheckIn(@PathVariable Long id) {
        try {
            log.info("ReservationController accept check in Reservation(id: {}) start", id);
            return reservationService.changeReservationStatus(id, true, false);
        } catch (Exception e) {
            log.error("ReservationController accept check in Reservation failure, error: {}", e.getMessage());
            return SystemMessage.builder()
                    .code(2)
                    .message("체크인 실패")
                    .build();
        } finally {
            log.info("ReservationController accept check in Reservation end");
        }
    }

    @Override
    @PutMapping("/v1/reservation/accept_check_out/{id}")
    public SystemMessage acceptCheckOut(@PathVariable Long id) {
        try {
            log.info("ReservationController accept check out Reservation(id: {}) start", id);
            return reservationService.changeReservationStatus(id, true, true);
        } catch (Exception e) {
            log.error("ReservationController accept check out Reservation failure, error: {}", e.getMessage());
            return SystemMessage.builder()
                    .code(2)
                    .message("체크아웃 실패")
                    .build();
        } finally {
            log.info("ReservationController accept check out Reservation end");
        }
    }

    @Override
    @PutMapping("/v1/reservation/deny")
    public SystemMessage denyReservation(@RequestBody ReservationDenyInput reservationDenyInput) {
        try {
            log.info("ReservationController deny Reservation({}) start", reservationDenyInput);
            return reservationService.denyReservation(reservationDenyInput);
        } catch (Exception e) {
            log.error("ReservationController deny Reservation failure, error: {}", e.getMessage());
            return SystemMessage.builder()
                    .code(2)
                    .message("예약 거절 실패")
                    .build();
        } finally {
            log.info("ReservationController deny Reservation end");
        }
    }
}
