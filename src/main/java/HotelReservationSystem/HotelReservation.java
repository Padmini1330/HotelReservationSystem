package HotelReservationSystem;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;


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
		long daysBetween = ChronoUnit.DAYS.between(startDate, lastDate);
		
		Hotel cheapestHotel=hotels.stream()
				.min((n1,n2)->n1.getWeekDayRate()-n2.getWeekDayRate())
				.orElse(null);
		long cheapestRate=(daysBetween+1)* cheapestHotel.getWeekDayRate();
		System.out.println("Cheapest hotel name is :"+cheapestHotel.getHotelName()+ "Total rate is :"+ cheapestRate);
		return cheapestHotel;
		
	}

}
