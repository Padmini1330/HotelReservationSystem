package HotelReservationSystem;

import static org.junit.Assert.assertEquals;
import java.time.LocalDate;
import java.time.Month;
import org.junit.Assert;
import org.junit.Test;

public class HotelReservationTest 
{
	HotelReservationImpl hotelReservation = new HotelReservationImpl();
	DateServiceProvider dateServiceProvider=new DateServiceProvider();
	

	@Test
	public void givenDetails_WhenAdded_ListSizeShouldGetIncreased()
	{
		int hotelListSize = hotelReservation.hotels.size();
		hotelReservation.addHotel("Lakewood",110,90,3,80,80);
		assertEquals(hotelListSize + 1, hotelReservation.hotels.size());
		
	}
	@Test
	public void givenDateRangeDetails_WhenCorrect_ShouldReturnProperHotelName()
	{
		hotelReservation.addHotel("Lakewood",110,90,3,80,80);
		hotelReservation.addHotel("Bridgewood",150,50,4,110,50);
		hotelReservation.addHotel("Ridgewood",220,150,5,100,40);;
		LocalDate startDate = LocalDate.of(2021, Month.SEPTEMBER, 10);
	    LocalDate lastDate = LocalDate.of(2021, Month.SEPTEMBER, 24);
		Hotel cheapestHotel = hotelReservation.findCheapestHotel(startDate,lastDate,CustomerType.REGULAR);
		assertEquals("Lakewood",cheapestHotel.getHotelName());
	}
	
	@Test
	public void givenOneHotel_WhenCorrect_ShouldReturnProperHotelName()
	{
		hotelReservation.addHotel("Ridgewood",220,150,5,100,40);
		LocalDate startDate = LocalDate.of(2021, Month.JANUARY, 9);
	    LocalDate lastDate = LocalDate.of(2021, Month.JANUARY, 14);
		Hotel cheapestHotel = hotelReservation.findCheapestHotel(startDate,lastDate,CustomerType.REGULAR);
		assertEquals("Ridgewood",cheapestHotel.getHotelName());
	}
	
	@Test
	public void givenWeekdaysAndWeekends_WhenCorrect_ShouldReturnProperHotelName()
	{
		hotelReservation.addHotel("Lakewood",110,90,3,80,80);
		hotelReservation.addHotel("Bridgewood",150,50,4,110,50);
		hotelReservation.addHotel("Ridgewood",220,150,5,100,40);
		LocalDate startDate = LocalDate.of(2021, Month.JANUARY, 9);
	    LocalDate lastDate = LocalDate.of(2021, Month.JANUARY, 14);
		Hotel cheapestHotel = hotelReservation.findCheapestHotel(startDate,lastDate,CustomerType.REGULAR);
		assertEquals("Lakewood",cheapestHotel.getHotelName());
	}
	
	@Test
	public void givenRating_WhenAddedToHotel_ShouldReturnProperHotelRating()
	{
		hotelReservation.addHotel("Lakewood",110,90,3,80,80);
		hotelReservation.hotels.get(0).setRating(4);
		LocalDate startDate = LocalDate.of(2021, Month.JANUARY, 9);
	    LocalDate lastDate = LocalDate.of(2021, Month.JANUARY, 14);
		Hotel cheapestHotel = hotelReservation.findCheapestHotel(startDate,lastDate,CustomerType.REGULAR);
		assertEquals(4,hotelReservation.hotels.get(0).getRating());
	}
	
	@Test
	public void givenHotelDetails_whenCustomerTypeIsRegular_ShouldReturnCheapestHotelWithBestRating()
	{
		hotelReservation.addHotel("Lakewood",110,90,3,80,80);
		hotelReservation.addHotel("Bridgewood",150,50,4,110,50);
		hotelReservation.addHotel("Ridgewood",220,150,5,100,40);
		LocalDate startDate = LocalDate.of(2021, Month.JANUARY, 9);
	    LocalDate lastDate = LocalDate.of(2021, Month.JANUARY, 14);
	    String startDateInString=startDate.toString();
	    String lastDateInString=lastDate.toString();
	    boolean isValidStartDate = dateServiceProvider.validateDate(startDateInString);
		boolean isValidEndDate = dateServiceProvider.validateDate(lastDateInString);
	    if(isValidStartDate && isValidEndDate)
	    {
	    	Hotel cheapestHotel = hotelReservation.findCheapestAndBestRatedHotel(startDate, lastDate,CustomerType.REGULAR);
		}
	    else
	    {
	    	System.out.println("Enter proper start and end dates!");
	    }
		
		
	}
	
	@Test
	public void givenHotelDetails_whenProper_ShouldReturnHotelWithBestRating()
	{
		hotelReservation.addHotel("Lakewood",110,90,3,80,80);
		hotelReservation.addHotel("Bridgewood",150,50,4,110,50);
		hotelReservation.addHotel("Ridgewood",220,150,5,100,40);
		LocalDate startDate = LocalDate.of(2021, Month.JANUARY, 9);
	    LocalDate lastDate = LocalDate.of(2021, Month.JANUARY, 14);
		Hotel cheapestHotel = hotelReservation.findBestRatedHotel(startDate, lastDate);
		assertEquals("Ridgewood",cheapestHotel.getHotelName());
	}
	
	@Test
	public void givenHotelDetails_whenCustomerTypeIsReward_ShouldReturnCheapestHotelWithBestRating()
	{
		hotelReservation.addHotel("Lakewood",110,90,3,80,80);
		hotelReservation.addHotel("Bridgewood",150,50,4,110,50);
		hotelReservation.addHotel("Ridgewood",220,150,5,100,40);
		LocalDate startDate = LocalDate.of(2021, Month.JANUARY, 9);
	    LocalDate lastDate = LocalDate.of(2021, Month.JANUARY, 14);
	    String startDateInString=startDate.toString();
	    String lastDateInString=lastDate.toString();
	    boolean isValidStartDate = dateServiceProvider.validateDate(startDateInString);
		boolean isValidEndDate = dateServiceProvider.validateDate(lastDateInString);
	    if(isValidStartDate && isValidEndDate)
	    {
	    	Hotel cheapestHotel = hotelReservation.findCheapestAndBestRatedHotel(startDate, lastDate,CustomerType.REWARDED);
		}
	    else
	    {
	    	System.out.println("Enter proper start and end dates!");
	    }
		
		
	}
	
	@Test
	public void givenHotelDetails_whenStartDateIsNull_ShouldReturnExceptionMessgae()
	{
		hotelReservation.addHotel("Lakewood",110,90,3,80,80);
		hotelReservation.addHotel("Bridgewood",150,50,4,110,50);
		hotelReservation.addHotel("Ridgewood",220,150,5,100,40);
		LocalDate startDate = LocalDate.of(2021, Month.JANUARY, 9);
	    LocalDate lastDate = LocalDate.of(2021, Month.JANUARY, 14);
	    try 
	    {
	    	Hotel cheapestHotel = hotelReservation.findCheapestAndBestRatedHotel(null, lastDate,CustomerType.REWARDED);
		}
		catch(HotelReservationException e) 
	    {
			System.out.println(e.getMessage());
		}
	}
	
	@Test
	public void givenHotelDetails_whenLastDateIsNull_ShouldReturnExceptionMessgae()
	{
		hotelReservation.addHotel("Lakewood",110,90,3,80,80);
		hotelReservation.addHotel("Bridgewood",150,50,4,110,50);
		hotelReservation.addHotel("Ridgewood",220,150,5,100,40);
		LocalDate startDate = LocalDate.of(2021, Month.JANUARY, 9);
	    LocalDate lastDate = LocalDate.of(2021, Month.JANUARY, 14);
	    try 
	    {
	    	Hotel cheapestHotel = hotelReservation.findCheapestAndBestRatedHotel(startDate, null ,CustomerType.REWARDED);
		}
		catch(HotelReservationException e) 
	    {
			System.out.println(e.getMessage());
		}
	}
	
	@Test
	public void givenHotelDetails_whenCustomerTypeIsNull_ShouldReturnExceptionMessgae()
	{
		hotelReservation.addHotel("Lakewood",110,90,3,80,80);
		hotelReservation.addHotel("Bridgewood",150,50,4,110,50);
		hotelReservation.addHotel("Ridgewood",220,150,5,100,40);
		LocalDate startDate = LocalDate.of(2021, Month.JANUARY, 9);
	    LocalDate lastDate = LocalDate.of(2021, Month.JANUARY, 14);
	    try 
	    {
	    	Hotel cheapestHotel = hotelReservation.findCheapestAndBestRatedHotel(startDate, lastDate,null);
		}
		catch(HotelReservationException e) 
	    {
			System.out.println(e.getMessage());
		}
	}
	
	@Test
	public void givenDate_WhenProper_ShouldReturnTrue() 
	{
		
		boolean isValid = dateServiceProvider.validateDate("2021/10/11");
		Assert.assertTrue(isValid);
	}
	
	@Test
	public void givenDate_WhenNotProperWithFormat_ShouldReturnFalse() 
	{
		
		boolean isNotValid = dateServiceProvider.validateDate("20/1/2");
		Assert.assertFalse(isNotValid);
	}
	
	@Test
	public void givenDate_WhenOtherDelimiterUsed_ShouldReturnFalse() 
	{
		
		boolean isNotValid = dateServiceProvider.validateDate("2020-02'11");
		Assert.assertFalse(isNotValid);
	}
	
	@Test
	public void givenDate_WhenContainsAlphabets_ShouldReturnFalse() 
	{
		
		boolean isNotValid = dateServiceProvider.validateDate("2020/12/ab");
		Assert.assertFalse(isNotValid);
	}
}
