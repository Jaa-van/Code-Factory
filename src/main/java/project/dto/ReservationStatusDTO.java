package project.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ReservationStatusDTO {
    private final Integer id;
    private final String customer_name;
    private final String check_in;
    private final String check_out;
    private final String status;
}
