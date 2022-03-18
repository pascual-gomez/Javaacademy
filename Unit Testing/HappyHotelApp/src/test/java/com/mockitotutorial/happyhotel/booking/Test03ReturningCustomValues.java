package com.mockitotutorial.happyhotel.booking;

import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class Test03ReturningCustomValues {

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

        System.out.println("List returned " + roomServiceMock.getAvailableRooms());
        System.out.println("Object returned " + roomServiceMock.findAvailableRoomId(null));
        System.out.println("Primitie returned " + roomServiceMock.getRoomCount());
    }

    @Test
    void should_CountAvailablePlaces_When_OneRoomAvailable() {
        //given
        when(this.roomServiceMock.getAvailableRooms()).thenReturn(Collections
                .singletonList(new Room("Room 1", 5)));
        int expected = 5;

        //when
        int actual = bookingService.getAvailablePlaceCount();

        //then
        assertEquals(expected, actual);
    }

    @Test
    void should_CountAvailablePlaces_When_MultipleRoomsAvailable() {
        //given
        List<Room> rooms = Arrays.asList(new Room("Room 1", 2), new Room("Room 2", 5));
        when(this.roomServiceMock.getAvailableRooms()).thenReturn((rooms));
        int expected = 7;

        //when
        int actual = bookingService.getAvailablePlaceCount();

        //then
        assertEquals(expected, actual);
    }
}
