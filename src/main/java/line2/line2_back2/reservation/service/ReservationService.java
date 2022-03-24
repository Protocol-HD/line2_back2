package line2.line2_back2.reservation.service;

import line2.line2_back2.reservation.model.Reservation;

import java.util.List;

public interface ReservationService {
    Reservation add(Reservation reservation);

    Reservation edit(Reservation reservation);

    Reservation findById(Long id);

    void deleteById(Long id);

    List<Reservation> findByGuestId(Long id);

    List<Reservation> findByGuestIdCheckInOut(Long id, boolean checkInStatus, boolean checkOutStatus);
}
