package HotelReservationSystem;

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
}
