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


public class HotelReservation 
{
	List<Hotel> hotels=new ArrayList<Hotel>();
	
	public List<Hotel> getHotelList() 
	{
		return hotels;
	}
	
	public void addHotel(String hotelName,int weekDayRate, int weekEndRate, int rating)
	{
		Hotel hotel=new Hotel(hotelName,weekDayRate,weekEndRate,rating);
		hotels.add(hotel);
		System.out.println(hotel);
	}
	
	public Hotel findCheapestHotel(LocalDate startDate,LocalDate lastDate)
	{
		Predicate<LocalDate> isWeekend = date -> date.getDayOfWeek() == DayOfWeek.SATURDAY
	            || date.getDayOfWeek() == DayOfWeek.SUNDAY;
		
		long daysBetween = ChronoUnit.DAYS.between(startDate, lastDate);

	    List<LocalDate> weekEnds= Stream.iterate(startDate, date -> date.plusDays(1))
	            .limit(daysBetween)
	            .filter((isWeekend))
	            .collect(Collectors.toList());
	    
	    int numberOfWeekEnds=weekEnds.size();
	    int numberOfWeekDays=(int) (daysBetween+1)  - numberOfWeekEnds;
	    System.out.println("number of weekdays:"+ numberOfWeekDays);
	    System.out.println("number of weekends:"+ numberOfWeekEnds);
	    
	    Hotel cheapestHotel = hotels.stream()
				.min((h1,h2) -> h1.getPriceForDays(numberOfWeekDays,numberOfWeekEnds) - (h2.getPriceForDays(numberOfWeekDays,numberOfWeekEnds)))
				.orElse(null);
	    
	
		long cheapestRate=(daysBetween+1)* cheapestHotel.getPriceForDays(numberOfWeekDays, numberOfWeekEnds);
		System.out.println("Cheapest hotel name is :"+cheapestHotel.getHotelName()+ "Total rate is :"+ cheapestRate);
		return cheapestHotel;
	
		
	}

}
