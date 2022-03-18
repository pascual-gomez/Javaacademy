package com.mockitotutorial.happyhotel.booking;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.function.Executable;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class Test05ThrowingExceptions {

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
    void should_ThrowException_When_NoRoomAvailable() {
        //given
        BookingRequest bookingRequest = new BookingRequest("1", LocalDate.of(2020, 01, 01),
                LocalDate.of(2020, 01, 05), 2, false);
        when(this.roomServiceMock.findAvailableRoomId(bookingRequest))
                .thenThrow(BusinessException.class);

        //when
        Executable executable = () -> bookingService.makeBooking(bookingRequest);

        //then
        assertThrows(BusinessException.class, executable);
    }
}
