package project;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import project.dto.ReservationStatusDTO;
import project.dto.ReservationStatusRequestDTO;
import com.code.factory.domain.etc.service.ReservationService;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class ApiControllerTest {
    private MockMvc mockMvc;

    @Mock
    private ReservationService reservationService;

    @InjectMocks
    private ApiController apiController;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(apiController).build();
    }

    @Test
    void getReservationStatus_shouldReturnReservationStatusList() throws Exception {
        ReservationStatusRequestDTO request = ReservationStatusRequestDTO.builder().CustomerName("hi").build();
        List<ReservationStatusDTO> mockResponse = List.of(
                ReservationStatusDTO.builder().id(1).customer_name("hi").build()
        );

        when(reservationService.selectReservationStatus(request)).thenReturn(mockResponse);

        // When & Then
        mockMvc.perform(get("/api/reservation/search")
                        .param("customerName", "all")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("id").value(1))
                .andExpect(jsonPath("customer_name").value("hi"));
    }
}