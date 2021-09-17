package HotelReservationSystem;

import java.time.LocalDate;

public interface HotelReservationIF 
{
	public void addHotel(String hotelName,int weekDayRate, int weekEndRate, int rating, int rewardWeekDayRate, int rewardWeekEndRate);
	public Hotel findCheapestHotel(LocalDate startDate,LocalDate lastDate,CustomerType customerType);
	public Hotel findCheapestAndBestRatedHotel(LocalDate startDate,LocalDate lastDate,CustomerType customerType);
	public Hotel findBestRatedHotel(LocalDate startDate,LocalDate lastDate);
}
