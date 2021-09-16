package HotelReservationSystem;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import HotelReservationSystem.HotelReservationException.ExceptionType;


public class HotelReservation 
{
	List<Hotel> hotels=new ArrayList<Hotel>();
	long cheapestRate;
	int numberOfWeekDays;
	int numberOfWeekEnds;
	
	public List<Hotel> getHotelList() 
	{
		return hotels;
	}
	
	public void addHotel(String hotelName,int weekDayRate, int weekEndRate, int rating, int rewardWeekDayRate, int rewardWeekEndRate)
	{
		Hotel hotel=new Hotel(hotelName, weekDayRate, weekEndRate, rating, rewardWeekDayRate, rewardWeekEndRate);
		hotels.add(hotel);
		System.out.println(hotel);
	}
	
	public Hotel findCheapestHotel(LocalDate startDate,LocalDate lastDate,String customerType)
	{
		try 
		{
			if(customerType.length() == 0)
				throw new HotelReservationException(ExceptionType.ENTERED_EMPTY, "EMPTY values not allowed!!");
			
			Predicate<LocalDate> isWeekend = date -> date.getDayOfWeek() == DayOfWeek.SATURDAY
		            || date.getDayOfWeek() == DayOfWeek.SUNDAY;
			
			long daysBetween = ChronoUnit.DAYS.between(startDate, lastDate);

		    List<LocalDate> weekEnds= Stream.iterate(startDate, date -> date.plusDays(1))
		            .limit(daysBetween)
		            .filter((isWeekend))
		            .collect(Collectors.toList());
		    
		    numberOfWeekEnds=weekEnds.size();
		    numberOfWeekDays=(int) (daysBetween+1)  - numberOfWeekEnds;
		    System.out.println("number of weekdays:"+ numberOfWeekDays);
		    System.out.println("number of weekends:"+ numberOfWeekEnds);
		    
		    if(customerType.equalsIgnoreCase("reward"))
		    {
		    	 Hotel cheapestHotel = hotels.stream()
		 				.min((h1,h2) -> h1.getPriceForRewardCustomers(numberOfWeekDays,numberOfWeekEnds) - (h2.getPriceForRewardCustomers(numberOfWeekDays,numberOfWeekEnds)))
		 				.orElse(null);
		 	
		 		cheapestRate=(daysBetween+1)* cheapestHotel.getPriceForRewardCustomers(numberOfWeekDays, numberOfWeekEnds);
		 		System.out.println("Cheapest hotel name is :"+cheapestHotel.getHotelName()+ "Total rate is :"+ cheapestRate);
		 		return cheapestHotel;
		    }
		    else
		    {
		    	Hotel cheapestHotel = hotels.stream()
		 				.min((h1,h2) -> h1.getPriceForRegularCustomers(numberOfWeekDays,numberOfWeekEnds) - (h2.getPriceForRegularCustomers(numberOfWeekDays,numberOfWeekEnds)))
		 				.orElse(null);
		 	
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
	
	public Hotel findCheapestAndBestRatedHotel(LocalDate startDate,LocalDate lastDate,String customerType)
	{
		try 
		{
			if(customerType.length() == 0)
				
				throw new HotelReservationException(ExceptionType.ENTERED_EMPTY, "EMPTY values not allowed!!");
			
			Hotel cheapestHotel = findCheapestHotel(startDate,lastDate,customerType);
			if(customerType.equalsIgnoreCase("reward"))
			{
				Predicate<Hotel> isMinimumForRewardType = (hotel) -> (hotel.getPriceForRewardCustomers(numberOfWeekDays,numberOfWeekEnds) == cheapestRate)?true:false;
				List<Hotel> cheapestHotels = hotels.stream()
						 .filter(isMinimumForRewardType)
						 .collect(Collectors.toList());
				return cheapestHotels.stream()
						.max((h1,h2) -> h1.getRating()-h2.getRating())
						.orElse(null);
			}
			else
			{
				Predicate<Hotel> isMinimumForRegularType = (hotel) -> (hotel.getPriceForRegularCustomers(numberOfWeekDays,numberOfWeekEnds) == cheapestRate)?true:false;
				List<Hotel> cheapestHotels = hotels.stream()
						 .filter(isMinimumForRegularType)
						 .collect(Collectors.toList());
				return cheapestHotels.stream()
						.max((h1,h2) -> h1.getRating()-h2.getRating())
						.orElse(null);
			}
		}
		catch(NullPointerException e) 
		{
			throw new HotelReservationException(ExceptionType.ENTERED_NULL, "NULL values not allowed!!");
		}	
		
	}
	
	public Hotel findBestRatedHotel(LocalDate startDate,LocalDate lastDate)
	{		
		Hotel bestRatedHotel = hotels.stream()
				   .max((h1,h2) -> h1.getRating()-h2.getRating())
				   .orElse(null);
		System.out.println("The Best Rated Hotel is : "+bestRatedHotel.getHotelName());
		System.out.println("Price is : "+bestRatedHotel.getPriceForRegularCustomers(numberOfWeekDays,numberOfWeekEnds));
		return bestRatedHotel;
	}

}
