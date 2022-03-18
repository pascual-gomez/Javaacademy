package com.mockitotutorial.happyhotel.booking;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.function.Executable;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;
import static org.mockito.ArgumentMatchers.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class Test06Matches {

    private BookingService bookingService;
    private PaymentService paymentServiceMock;
    private RoomService roomServiceMock;
    private BookingDAO bookingDAOMock;
    private MailSender mailSenderMock;

    @BeforeAll
    void setup() {

        this.paymentServiceMock = mock(PaymentService.class);
        this.roomServiceMock = mock(RoomService.class);
        this.bookingDAOMock = mock(BookingDAO.class);
        this.mailSenderMock = mock(MailSender.class);

        this.bookingService = new BookingService(paymentServiceMock, roomServiceMock,
                bookingDAOMock, mailSenderMock);
    }

    @Test
    void should_NotCompleteBooking_When_PriceTooHigh() {
        //given
        BookingRequest bookingRequest = new BookingRequest("2", LocalDate.of(2020, 01, 01),
                LocalDate.of(2020, 01, 05), 2, true);
        when(this.paymentServiceMock.pay(any(BookingRequest.class), eq(400.0)))
                .thenThrow(BusinessException.class);
        //when
        Executable executable = () -> bookingService.makeBooking(bookingRequest);

        //then
        assertThrows(BusinessException.class, executable);
    }
}
