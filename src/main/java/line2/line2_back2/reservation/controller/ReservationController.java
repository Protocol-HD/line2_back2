package line2.line2_back2.reservation.controller;

import line2.line2_back2.reservation.model.Reservation;

public interface ReservationController {
    Reservation add(Reservation reservation);

    Reservation edit(Reservation reservation);

    Reservation findById(Long id);

    void deleteById(Long id);
}
