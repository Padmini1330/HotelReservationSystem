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
		
		hotelReservation.addHotel("Lakewood",110,90,3,80,80);
		assertEquals(hotelListSize + 1, hotelReservation.getHotelList().size());
		
	}
	
	@Test
	public void givenDateRangeDetails_WhenCorrect_ShouldReturnProperHotelName()
	{
		hotelReservation.addHotel("Lakewood",110,90,3,80,80);
		hotelReservation.addHotel("Bridgewood",150,50,4,110,50);
		hotelReservation.addHotel("Ridgewood",220,150,5,100,40);;
		LocalDate startDate = LocalDate.of(2021, Month.SEPTEMBER, 10);
	    LocalDate lastDate = LocalDate.of(2021, Month.SEPTEMBER, 24);
		Hotel cheapestHotel = hotelReservation.findCheapestHotel(startDate,lastDate,"regular");
		assertEquals("Lakewood",cheapestHotel.getHotelName());
	}
	
	@Test
	public void givenOneHotel_WhenCorrect_ShouldReturnProperHotelName()
	{
		hotelReservation.addHotel("Ridgewood",220,150,5,100,40);
		LocalDate startDate = LocalDate.of(2021, Month.JANUARY, 9);
	    LocalDate lastDate = LocalDate.of(2021, Month.JANUARY, 14);
		Hotel cheapestHotel = hotelReservation.findCheapestHotel(startDate,lastDate,"regular");
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
		Hotel cheapestHotel = hotelReservation.findCheapestHotel(startDate,lastDate,"regular");
		assertEquals("Lakewood",cheapestHotel.getHotelName());
	}
	
	@Test
	public void givenRating_WhenAddedToHotel_ShouldReturnProperHotelRating()
	{
		hotelReservation.addHotel("Lakewood",110,90,3,80,80);
		hotelReservation.getHotelList().get(0).setRating(4);
		LocalDate startDate = LocalDate.of(2021, Month.JANUARY, 9);
	    LocalDate lastDate = LocalDate.of(2021, Month.JANUARY, 14);
		Hotel cheapestHotel = hotelReservation.findCheapestHotel(startDate,lastDate,"regular");
		assertEquals(4,hotelReservation.getHotelList().get(0).getRating());
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
	    boolean isValidStartDate = hotelReservation.validateDate(startDateInString);
		boolean isValidEndDate = hotelReservation.validateDate(lastDateInString);
	    if(isValidStartDate && isValidEndDate)
	    {
	    	Hotel cheapestHotel = hotelReservation.findCheapestAndBestRatedHotel(startDate, lastDate,"regular");
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
	    boolean isValidStartDate = hotelReservation.validateDate(startDateInString);
		boolean isValidEndDate = hotelReservation.validateDate(lastDateInString);
	    if(isValidStartDate && isValidEndDate)
	    {
	    	Hotel cheapestHotel = hotelReservation.findCheapestAndBestRatedHotel(startDate, lastDate,"reward");
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
	    	Hotel cheapestHotel = hotelReservation.findCheapestAndBestRatedHotel(null, lastDate,"reward");
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
	    	Hotel cheapestHotel = hotelReservation.findCheapestAndBestRatedHotel(startDate, null ,"reward");
		}
		catch(HotelReservationException e) 
	    {
			System.out.println(e.getMessage());
		}
	}
	
	@Test
	public void givenHotelDetails_whenStringIsEmpty_ShouldReturnExceptionMessgae()
	{
		hotelReservation.addHotel("Lakewood",110,90,3,80,80);
		hotelReservation.addHotel("Bridgewood",150,50,4,110,50);
		hotelReservation.addHotel("Ridgewood",220,150,5,100,40);
		LocalDate startDate = LocalDate.of(2021, Month.JANUARY, 9);
	    LocalDate lastDate = LocalDate.of(2021, Month.JANUARY, 14);
	    try 
	    {
	    	Hotel cheapestHotel = hotelReservation.findCheapestAndBestRatedHotel(startDate, lastDate,"");
		}
		catch(HotelReservationException e) 
	    {
			System.out.println(e.getMessage());
		}
	}
	
	@Test
	public void givenDate_WhenProper_ShouldReturnTrue() 
	{
		
		boolean isValid = hotelReservation.validateDate("2021/10/11");
		Assert.assertTrue(isValid);
	}
	
	@Test
	public void givenDate_WhenNotProperWithFormat_ShouldReturnFalse() 
	{
		
		boolean isNotValid = hotelReservation.validateDate("20/1/2");
		Assert.assertFalse(isNotValid);
	}
	
	@Test
	public void givenDate_WhenOtherDelimiterUsed_ShouldReturnFalse() 
	{
		
		boolean isNotValid = hotelReservation.validateDate("2020-02'11");
		Assert.assertFalse(isNotValid);
	}
	
	@Test
	public void givenDate_WhenContainsAlphabets_ShouldReturnFalse() 
	{
		
		boolean isNotValid = hotelReservation.validateDate("2020/12/ab");
		Assert.assertFalse(isNotValid);
	}
}
