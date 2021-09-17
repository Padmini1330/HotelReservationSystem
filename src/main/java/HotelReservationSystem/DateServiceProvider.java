package HotelReservationSystem;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import HotelReservationSystem.HotelReservationException.ExceptionType;

public class DateServiceProvider 
{
	public boolean validateDate(String date) 
	{
		try 
		{
			if(date.length() == 0)
				throw new HotelReservationException(ExceptionType.ENTERED_EMPTY, "Date Is EMPTY");
			String dateRegEx = "^[0-9]{4}/(0[0-9]||1[0-2])/([0-2][0-9]||3[0-1])$";
			return date.matches(dateRegEx);
		}
		catch(NullPointerException e) 
		{
			throw new HotelReservationException(ExceptionType.ENTERED_NULL, "Date is Null. Null values not allowed!");
		}
	}
	
	public List<LocalDate> getNumberOfWeekEnds(LocalDate startDate,LocalDate lastDate)
	{
		Predicate<LocalDate> isWeekend = date -> date.getDayOfWeek() == DayOfWeek.SATURDAY || date.getDayOfWeek() == DayOfWeek.SUNDAY;
		List<LocalDate> weekEnds= Stream.iterate(startDate, date -> date.plusDays(1))
				.limit(getDaysBetween(startDate, lastDate))
	            .filter((isWeekend))
	            .collect(Collectors.toList());
		return weekEnds;	
	}
	
	public long getDaysBetween(LocalDate startDate,LocalDate lastDate)
	{
		long daysBetween = ChronoUnit.DAYS.between(startDate, lastDate);
		return daysBetween;
	}
}
