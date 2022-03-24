package line2.line2_back2.reservation.controller;

import line2.line2_back2.reservation.model.Reservation;

import java.util.List;

public interface ReservationController {
    Reservation add(Reservation reservation);

    Reservation edit(Reservation reservation);

    Reservation findById(Long id);

    void deleteById(Long id);

    List<Reservation> findByGuestId(Long id);

    List<Reservation> findByGuestIdBeforeCheckIn(Long id);

    List<Reservation> findByGuestIdBeforeCheckOut(Long id);

    List<Reservation> findByGuestIdAfterCheckOut(Long id);
}
