package line2.line2_back2.reservation.model;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.util.Date;

@Getter
@ToString
@Builder
public class ReservationDtoInput {
    private Long reservationId;
    private Date checkIn;
    private Date checkOut;
}
