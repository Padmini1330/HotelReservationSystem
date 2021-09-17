package HotelReservationSystem;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;


import HotelReservationSystem.HotelReservationException.ExceptionType;


public class HotelReservationImpl implements HotelReservationIF
{
	List<Hotel> hotels=new ArrayList<Hotel>();
	DateServiceProvider dateServiceProvider=new DateServiceProvider();
	int numberOfWeekDays,numberOfWeekEnds;
	long cheapestRate;
	
	public void addHotel(String hotelName,int weekDayRate, int weekEndRate, int rating, int rewardWeekDayRate, int rewardWeekEndRate)
	{
		Hotel hotel=new Hotel(hotelName, weekDayRate, weekEndRate, rating, rewardWeekDayRate, rewardWeekEndRate);
		hotels.add(hotel);
		System.out.println(hotel);
	}
	
	public Hotel findCheapestHotel(LocalDate startDate,LocalDate lastDate,CustomerType customerType)
	{
		try 
		{			
			long daysBetween=dateServiceProvider.getDaysBetween(startDate, lastDate);
			List<LocalDate> weekEnds=dateServiceProvider.getNumberOfWeekEnds(startDate, lastDate);
		    numberOfWeekEnds=weekEnds.size();
		    numberOfWeekDays=(int) (daysBetween+1)  - numberOfWeekEnds;
		    System.out.println("number of weekdays:"+ numberOfWeekDays);
		    System.out.println("number of weekends:"+ numberOfWeekEnds);
		    
		    if(customerType.equals(CustomerType.REWARDED))
		    {
		    	Hotel cheapestHotel = hotels.stream().min((h1,h2) -> h1.getPriceForRewardCustomers(numberOfWeekDays,numberOfWeekEnds) - (h2.getPriceForRewardCustomers(numberOfWeekDays,numberOfWeekEnds))).orElse(null);
		    	cheapestRate=(daysBetween+1)* cheapestHotel.getPriceForRewardCustomers(numberOfWeekDays, numberOfWeekEnds);
		 		System.out.println("Cheapest hotel name is :"+cheapestHotel.getHotelName()+ "Total rate is :"+ cheapestRate);
		 		return cheapestHotel;
		    }
		    else
		    {
		    	Hotel cheapestHotel = hotels.stream().min((h1,h2) -> h1.getPriceForRegularCustomers(numberOfWeekDays,numberOfWeekEnds) - (h2.getPriceForRegularCustomers(numberOfWeekDays,numberOfWeekEnds))).orElse(null);
		    	cheapestRate=(daysBetween+1)* cheapestHotel.getPriceForRegularCustomers(numberOfWeekDays, numberOfWeekEnds);
		 		System.out.println("Cheapest hotel name is :"+cheapestHotel.getHotelName()+ "Total rate is :"+ cheapestRate);
		 		return cheapestHotel;
		    }
		}
		catch(NullPointerException e) 
		{
			throw new HotelReservationException(ExceptionType.ENTERED_NULL, "NULL values not allowed!!");
		}	   
	}
	
	public Hotel findCheapestAndBestRatedHotel(LocalDate startDate,LocalDate lastDate,CustomerType customerType)
	{
		try 
		{	
			Hotel cheapestHotel = findCheapestHotel(startDate,lastDate,customerType);
			if(customerType.equals(CustomerType.REWARDED))
			{
				Predicate<Hotel> isMinimumForRewardType = (hotel) -> (hotel.getPriceForRewardCustomers(numberOfWeekDays,numberOfWeekEnds) == cheapestRate)? true: false;
				List<Hotel> cheapestHotels = hotels.stream().filter(isMinimumForRewardType).collect(Collectors.toList());
				return cheapestHotels.stream().max((h1,h2) -> h1.getRating()-h2.getRating()).orElse(null);
			}
			else
			{
				Predicate<Hotel> isMinimumForRegularType = (hotel) -> (hotel.getPriceForRegularCustomers(numberOfWeekDays,numberOfWeekEnds) == cheapestRate)? true: false;
				List<Hotel> cheapestHotels = hotels.stream().filter(isMinimumForRegularType).collect(Collectors.toList());
				return cheapestHotels.stream().max((h1,h2) -> h1.getRating()-h2.getRating()).orElse(null);
			}
		}
		catch(NullPointerException e) 
		{
			throw new HotelReservationException(ExceptionType.ENTERED_NULL, "NULL values not allowed!!");
		}	
	}
	
	public Hotel findBestRatedHotel(LocalDate startDate,LocalDate lastDate)
	{		
		Hotel bestRatedHotel = hotels.stream().max((h1,h2) -> h1.getRating()-h2.getRating()).orElse(null);
		System.out.println("The Best Rated Hotel is : "+bestRatedHotel.getHotelName());
		System.out.println("Price is : "+bestRatedHotel.getPriceForRegularCustomers(numberOfWeekDays,numberOfWeekEnds));
		return bestRatedHotel;
	}
}
