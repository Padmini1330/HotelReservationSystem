package HotelReservationSystem;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import java.time.Month;

import org.junit.Assert;
import org.junit.Test;


public class HotelReservationTest 
{
	HotelReservation hotelReservation = new HotelReservation();
	@Test
	public void givenDetails_WhenCorrect_ShoulReturnTrue()
	{
		boolean isValidHotel = hotelReservation.addHotel("Lakewood", 3000);
		Assert.assertTrue(isValidHotel);
	}
	
	@Test
	public void givenDateRangeDetails_WhenCorrect_ShoulReturnTrue()
	{
		LocalDate startDate = LocalDate.of(2021, Month.SEPTEMBER, 10);
	    LocalDate lastDate = LocalDate.of(2021, Month.SEPTEMBER, 11);
		Hotel isValidHotel = hotelReservation.findCheapestHotel(startDate,lastDate);
		assertEquals("Lakewood",isValidHotel.getHotelName());
	}
}
