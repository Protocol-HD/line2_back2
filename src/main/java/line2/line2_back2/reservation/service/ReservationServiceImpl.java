package line2.line2_back2.reservation.service;

import line2.line2_back2.reservation.model.Reservation;
import line2.line2_back2.reservation.model.ReservationDenyInput;
import line2.line2_back2.reservation.model.ReservationDtoInput;
import line2.line2_back2.reservation.repository.ReservationRepository;
import line2.line2_back2.systemMessage.SystemMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class ReservationServiceImpl implements ReservationService {
    private final ReservationRepository reservationRepository;

    @Override
    public SystemMessage add(Reservation reservation) {
        try {
            log.info("ReservationService add Reservation({}) start", reservation);
            reservationRepository.save(reservation);
            return SystemMessage.builder()
                    .code(1)
                    .message("예약 성공")
                    .build();
        } catch (Exception e) {
            log.error("ReservationService add Reservation failure, error: {}", e.getMessage());
            return SystemMessage.builder()
                    .code(2)
                    .message("예약 실패")
                    .build();
        } finally {
            log.info("ReservationService add Reservation end");
        }
    }

    @Override
    public SystemMessage edit(ReservationDtoInput reservationDtoInput) {
        try {
            log.info("ReservationService edit Reservation({}) start", reservationDtoInput);
            Reservation reservation = reservationRepository.findById(reservationDtoInput.getReservationId()).get();
            reservation.setCheckIn(reservationDtoInput.getCheckIn());
            reservation.setCheckOut(reservationDtoInput.getCheckOut());
            reservationRepository.save(reservation);
            return SystemMessage.builder()
                    .code(1)
                    .message("예약 변경 성공")
                    .build();
        } catch (Exception e) {
            log.error("ReservationService edit Reservation failure, error: {}", e.getMessage());
            return SystemMessage.builder()
                    .code(2)
                    .message("예약 변경 실패")
                    .build();
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
    public SystemMessage deleteById(Long id) {
        try {
            log.info("ReservationService delete by id Reservation(id: {}) start", id);
            reservationRepository.deleteById(id);
            return SystemMessage.builder()
                    .code(1)
                    .message("예약 삭제 성공")
                    .build();
        } catch (Exception e) {
            log.error("ReservationService delete by id Reservation failure, error: {}", e.getMessage());
            return SystemMessage.builder()
                    .code(2)
                    .message("예약 삭제 실패")
                    .build();
        } finally {
            log.info("ReservationService delete by id Reservation end");
        }
    }

    @Override
    public List<Reservation> findByUserId(Long id) {
        try {
            log.info("ReservationService find by user id Reservation(id: {}) start", id);
            return reservationRepository.findByUserId(id);
        } catch (Exception e) {
            log.error("ReservationService find by user id Reservation failure, error: {}", e.getMessage());
            return null;
        } finally {
            log.info("ReservationService find by user id Reservation end");
        }
    }

    @Override
    public List<Reservation> findByHomeId(Long id) {
        try {
            log.info("ReservationService find by home id Reservation(id: {}) start", id);
            return reservationRepository.findByHomeId(id);
        } catch (Exception e) {
            log.error("ReservationService find by home id Reservation failure, error: {}", e.getMessage());
            return null;
        } finally {
            log.info("ReservationService find by home id Reservation end");
        }
    }

    @Override
    public List<Reservation> findByUserIdCheckInOut(Long id, boolean checkInStatus, boolean checkOutStatus, boolean denyStatus) {
        try {
            log.info("ReservationService find by user check in, out status Reservation(id: {}) start", id);
            return reservationRepository.findByUserIdAndCheckInStatusAndCheckOutStatusAndDenyStatus(id, checkInStatus, checkOutStatus, denyStatus);
        } catch (Exception e) {
            log.error("ReservationService find by user check in, out status Reservation failure, error: {}", e.getMessage());
            return null;
        } finally {
            log.info("ReservationService find by user check in, out status Reservation end");
        }
    }

    @Override
    public SystemMessage changeReservationStatus(Long id, boolean checkInStatus, boolean checkOutStatus) {
        try {
            log.info("ReservationService change reservation status Reservation(id: {}) start", id);
            Reservation reservation = reservationRepository.findById(id).get();
            reservation.setCheckInStatus(checkInStatus);
            reservation.setCheckOutStatus(checkOutStatus);
            reservationRepository.save(reservation);
            return SystemMessage.builder()
                    .code(1)
                    .message("예약 상태 변경 성공")
                    .build();
        } catch (Exception e) {
            log.error("ReservationService change reservation status Reservation failure, error: {}", e.getMessage());
            return SystemMessage.builder()
                    .code(2)
                    .message("예약 상태 변경 실패")
                    .build();
        } finally {
            log.info("ReservationService change reservation status Reservation end");
        }
    }

    @Override
    public SystemMessage denyReservation(ReservationDenyInput reservationDenyInput) {
        try {
            log.info("ReservationService deny Reservation({}) start", reservationDenyInput);
            Reservation reservation = reservationRepository.findById(reservationDenyInput.getReservationId()).get();
            reservation.setHostToGuest(reservationDenyInput.getHostToGuest());
            reservation.setDenyStatus(true);
            reservationRepository.save(reservation);
            return SystemMessage.builder()
                    .code(1)
                    .message("예약 거절 성공")
                    .build();
        } catch (Exception e) {
            log.error("ReservationService deny Reservation failure, error: {}", e.getMessage());
            return SystemMessage.builder()
                    .code(2)
                    .message("예약 거절 실패")
                    .build();
        } finally {
            log.info("ReservationService deny Reservation end");
        }
    }
}
