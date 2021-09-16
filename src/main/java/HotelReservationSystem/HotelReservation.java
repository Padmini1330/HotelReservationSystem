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
	public boolean addHotel(String hotelName,int rate)
	{
		Scanner scanner=new Scanner(System.in);
		Hotel hotel=new Hotel("A",2000);
		hotels.add(hotel);
		return true;
	}
	
	public Hotel findCheapestHotel(String startRange,String endRange)
	{

		DateFormat date=new SimpleDateFormat("dd-mm-yy",Locale.ENGLISH);
		LocalDate startDate=LocalDate.parse(startRange);
		LocalDate endDate=LocalDate.parse(endRange);
		
		Hotel cheapestHotel=hotels.stream()
				.min((n1,n2)->n1.getRateForRegularCustomer()-n2.getRateForRegularCustomer())
				.orElse(null);
		
		long noOfDaysBetween = ChronoUnit.DAYS.between(startDate, endDate);
		long cheapestRate=noOfDaysBetween* cheapestHotel.getRateForRegularCustomer();
		System.out.println(cheapestRate);
		return cheapestHotel;
		
	}
}
