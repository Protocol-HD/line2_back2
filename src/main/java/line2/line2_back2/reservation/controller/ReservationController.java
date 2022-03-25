package line2.line2_back2.reservation.controller;

import line2.line2_back2.reservation.model.Reservation;
import line2.line2_back2.reservation.model.ReservationDenyInput;
import line2.line2_back2.reservation.model.ReservationDtoInput;
import line2.line2_back2.systemMessage.SystemMessage;

import java.util.List;

public interface ReservationController {
    SystemMessage add(Reservation reservation);

    SystemMessage edit(ReservationDtoInput reservationDtoInput);

    Reservation findById(Long id);

    SystemMessage deleteById(Long id);

    List<Reservation> findByUserId(Long id);

    List<Reservation> findByHomeId(Long id);

    List<Reservation> findByUserIdBeforeCheckIn(Long id);

    List<Reservation> findByUserIdBeforeCheckOut(Long id);

    List<Reservation> findByUserIdAfterCheckOut(Long id);

    List<Reservation> findByUserDenyReservation(Long id);

    SystemMessage acceptCheckIn(Long id);

    SystemMessage acceptCheckOut(Long id);

    SystemMessage denyReservation(ReservationDenyInput reservationDenyInput);
}
