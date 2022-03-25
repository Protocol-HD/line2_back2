package line2.line2_back2.reservation.service;

import line2.line2_back2.reservation.model.Reservation;
import line2.line2_back2.reservation.model.ReservationDtoInput;
import line2.line2_back2.systemMessage.SystemMessage;

import java.util.List;

public interface ReservationService {
    SystemMessage add(Reservation reservation);

    SystemMessage edit(Reservation reservation);

    Reservation findById(Long id);

    SystemMessage deleteById(Long id);

    List<Reservation> findByUserId(Long id);

    List<Reservation> findByUserIdCheckInOut(Long id, boolean checkInStatus, boolean checkOutStatus);

    SystemMessage changeReservationStatus(Long id, boolean checkInStatus, boolean checkOutStatus);

    SystemMessage denyReservation(ReservationDtoInput reservationDtoInput);
}
