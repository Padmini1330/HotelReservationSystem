package HotelReservationSystem;

public class Hotel 
{
	String hotelName;
	int weekDayRate;
	int weekEndRate;
	int rating;
	public Hotel(String hotelName, int weekDayRate, int weekEndRate, int rating) 
	{
		super();
		this.hotelName = hotelName;
		this.weekDayRate = weekDayRate;
		this.weekEndRate = weekEndRate;
		this.rating = rating;
	}
	public String getHotelName() 
	{
		return hotelName;
	}
	public int getWeekDayRate() 
	{
		return weekDayRate;
	}
	public int getWeekEndRate() 
	{
		return weekEndRate;
	}
	public int getRating() 
	{
		return rating;
	}
	public void setHotelName(String hotelName) 
	{
		this.hotelName = hotelName;
	}
	public void setWeekDayRate(int weekDayRate) 
	{
		this.weekDayRate = weekDayRate;
	}
	public void setWeekEndRate(int weekEndRate) 
	{
		this.weekEndRate = weekEndRate;
	}
	public void setRating(int rating) 
	{
		this.rating = rating;
	}
	public int getPriceForDays(int numberOfWeekdays, int numberOfWeekends) 
	{
		return weekDayRate*numberOfWeekdays + weekEndRate*numberOfWeekends;
	}
	@Override
	public String toString() 
	{
		return "Hotel [hotelName=" + hotelName + ", weekDayRate=" + weekDayRate + ", weekEndRate=" + weekEndRate
				+ ", rating=" + rating + "]";
	}
	
	
}
