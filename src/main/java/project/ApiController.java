package project;

import com.code.factory.global.response.DataResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import project.dto.ReservationStatusDTO;
import project.dto.ReservationStatusRequestDTO;
import com.code.factory.domain.etc.service.ReservationService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class ApiController {
    private final ReservationService reservationService;

    @GetMapping("/reservation/search")
    @ResponseStatus(HttpStatus.OK)
    public DataResponse<List<ReservationStatusDTO>> getReservationStatus(@RequestParam ReservationStatusRequestDTO request) {
        List<ReservationStatusDTO> responses = reservationService.selectReservationStatus(request);
        return DataResponse.of(responses);
    }
}
