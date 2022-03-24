package line2.line2_back2.reservation.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long homeId;
    private Long roomId;
    private Long guestId;
    private Date checkIn;
    private Date checkOut;
    private String memo;
    private boolean isCheckIn;
    private boolean isCheckOut;
}
