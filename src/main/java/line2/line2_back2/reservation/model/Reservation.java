package line2.line2_back2.reservation.model;

import lombok.*;
import org.hibernate.annotations.ColumnDefault;

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
    private Long userId;
    private Date checkIn;
    private Date checkOut;
    private String hostToGuest;
    private String guestToHost;
    @ColumnDefault("false")
    private boolean checkInStatus;
    @ColumnDefault("false")
    private boolean checkOutStatus;
    @ColumnDefault("false")
    private boolean denyStatus;
}
