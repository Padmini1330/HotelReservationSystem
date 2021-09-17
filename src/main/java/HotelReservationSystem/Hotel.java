package HotelReservationSystem;

public class Hotel 
{
	public String hotelName;
	public int weekDayRate;
	public int weekEndRate;
	public int rating;
	public int rewardWeekDayRate;
	public int rewardWeekEndRate;
	
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
	public void setRating(int rating) 
	{
		this.rating = rating;
	}
	
	public int getPriceForRegularCustomers(int numberOfWeekdays, int numberOfWeekends) 
	{
		return weekDayRate*numberOfWeekdays + weekEndRate*numberOfWeekends;
	}
	
	public int getPriceForRewardCustomers(int numberOfWeekdays, int numberOfWeekends) 
	{
		return rewardWeekDayRate*numberOfWeekdays +rewardWeekEndRate*numberOfWeekends;
	}
	@Override
	public String toString() 
	{
		return "Hotel [hotelName=" + hotelName + ", weekDayRate=" + weekDayRate + ", weekEndRate=" + weekEndRate
				+ ", rating=" + rating + ", rewardWeekDayRate=" + rewardWeekDayRate + ", rewardWeekEndRate="
				+ rewardWeekEndRate + "]";
	}
}
