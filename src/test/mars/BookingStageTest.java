package test.mars;

import dev.mars.Trade;
import dev.mars.BookingStage;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BookingStageTest {

    @Test
    public void testTradeBooked() {
        Trade trade = new Trade("TRADE123", "ABC", 100.0);
        trade.setStatus("PAID");
        BookingStage stage = new BookingStage();
        stage.process(trade);
        assertEquals("BOOKED", trade.getStatus());
    }

    @Test
    public void testBookingFailed() {
        Trade order = new Trade("TRADE456", "XYZ",100.0);
        order.setStatus("VALID");
        BookingStage stage = new BookingStage();
        stage.process(order);
        assertEquals("NOT_BOOKED", order.getStatus());
    }
}