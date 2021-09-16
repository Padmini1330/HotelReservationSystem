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
	public void givenDetails_WhenAdded_ListSizeShouldGetIncreased()
	{
		int hotelListSize = hotelReservation.getHotelList().size();
		
		hotelReservation.addHotel("Lakewood", 110,90,3);
		assertEquals(hotelListSize + 1, hotelReservation.getHotelList().size());
		
	}
	
	@Test
	public void givenDateRangeDetails_WhenCorrect_ShoulReturnProperHotelName()
	{
		hotelReservation.addHotel("Lakewood",110,90,3);
		hotelReservation.addHotel("Bridgewood",150,50,4);
		hotelReservation.addHotel("Ridgewood",220,150,5);
		LocalDate startDate = LocalDate.of(2021, Month.SEPTEMBER, 10);
	    LocalDate lastDate = LocalDate.of(2021, Month.SEPTEMBER, 24);
		Hotel cheapestHotel = hotelReservation.findCheapestHotel(startDate,lastDate);
		assertEquals("Lakewood",cheapestHotel.getHotelName());
	}
	
	@Test
	public void givenOneHotel_WhenCorrect_ShoulReturnProperHotelName()
	{
		hotelReservation.addHotel("Ridgewood",220,150,5);
		LocalDate startDate = LocalDate.of(2021, Month.JANUARY, 9);
	    LocalDate lastDate = LocalDate.of(2021, Month.JANUARY, 14);
		Hotel cheapestHotel = hotelReservation.findCheapestHotel(startDate,lastDate);
		assertEquals("Ridgewood",cheapestHotel.getHotelName());
	}
	
	@Test
	public void givenWeekdaysAndWeekends_WhenCorrect_ShoulReturnProperHotelName()
	{
		hotelReservation.addHotel("Lakewood",110,90,3);
		hotelReservation.addHotel("Bridgewood",150,50,4);
		hotelReservation.addHotel("Ridgewood",220,150,5);
		LocalDate startDate = LocalDate.of(2021, Month.JANUARY, 9);
	    LocalDate lastDate = LocalDate.of(2021, Month.JANUARY, 14);
		Hotel cheapestHotel = hotelReservation.findCheapestHotel(startDate,lastDate);
		assertEquals("Lakewood",cheapestHotel.getHotelName());
	}
}
