package com.code.factory.domain.etc.service;

import com.code.factory.global.exceptionHandler.CustomNotFoundException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import project.dto.ReservationStatusDTO;
import project.dto.ReservationStatusRequestDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ReservationService {
    private static final List<ReservationStatusDTO> data = List.of(
            ReservationStatusDTO.builder().id(1).customer_name("hi").build(),
            ReservationStatusDTO.builder().id(2).customer_name("hello").build()
    );
    private final ObjectMapper objectMapper = new ObjectMapper();


    public List<ReservationStatusDTO> selectReservationStatus(ReservationStatusRequestDTO request) {
        // validation
        if (request.getCustomerName() == null) {
            throw new CustomNotFoundException("customerName");
        }

        // filter data
        List<ReservationStatusDTO> responses = new ArrayList<>();
        if (request.getCustomerName().equals("all")) {
            responses = data;
        } else {
            responses = data.stream()
                    .filter(reservationStatusDTO -> reservationStatusDTO.getCustomer_name()
                            .startsWith(request.getCustomerName()))
                    .collect(Collectors.toList());
        }

        // response
        return responses;
    }
}
