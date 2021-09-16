package HotelReservationSystem;

import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.Test;


public class HotelReservationTest 
{
	@Test
	public void givenDetails_WhenCorrect_ShoulReturnTrue()
	{
		HotelReservation hotelReservation = new HotelReservation();
		boolean isValidHotel = hotelReservation.addHotel("Lakewood", 3000);
		Assert.assertTrue(isValidHotel);
	}
	
	@Test
	public void givenDateRangeDetails_WhenCorrect_ShoulReturnTrue()
	{
		HotelReservation hotelReservation = new HotelReservation();
		Hotel isValidHotel = hotelReservation.findCheapestHotel("12-1-21","14-1-21");
		assertEquals(isValidHotel.getHotelName(),"Lakewood");
	}
}
