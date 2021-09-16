package HotelReservationSystem;

public class Hotel 
{
	String hotelName;
	int weekDayRate;
	int weekEndRate;
	int rating;
	int rewardWeekDayRate;
	int rewardWeekEndRate;
	
	public Hotel(String hotelName, int weekDayRate, int weekEndRate, int rating, int rewardWeekDayRate,
			int rewardWeekEndRate) 
	{
		super();
		this.hotelName = hotelName;
		this.weekDayRate = weekDayRate;
		this.weekEndRate = weekEndRate;
		this.rating = rating;
		this.rewardWeekDayRate = rewardWeekDayRate;
		this.rewardWeekEndRate = rewardWeekEndRate;
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
	public int getRewardWeekDayRate() 
	{
		return rewardWeekDayRate;
	}
	public int getRewardWeekEndRate() 
	{
		return rewardWeekEndRate;
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
	public void setRewardWeekDayRate(int rewardWeekDayRate) 
	{
		this.rewardWeekDayRate = rewardWeekDayRate;
	}
	public void setRewardWeekEndRate(int rewardWeekEndRate) 
	{
		this.rewardWeekEndRate = rewardWeekEndRate;
	}
	@Override
	public String toString() 
	{
		return "Hotel [hotelName=" + hotelName + ", weekDayRate=" + weekDayRate + ", weekEndRate=" + weekEndRate
				+ ", rating=" + rating + ", rewardWeekDayRate=" + rewardWeekDayRate + ", rewardWeekEndRate="
				+ rewardWeekEndRate + "]";
	}
	
	public int getPriceForDays(int numberOfWeekdays, int numberOfWeekends) 
	{
		return weekDayRate*numberOfWeekdays + weekEndRate*numberOfWeekends;
	}
	
}
