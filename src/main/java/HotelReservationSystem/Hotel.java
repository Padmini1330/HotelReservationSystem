package HotelReservationSystem;

public class Hotel 
{
	String hotelName;
	int rateForRegularCustomer;
	public Hotel(String hotelName, int rateForRegularCustomer) 
	{
		super();
		this.hotelName = hotelName;
		this.rateForRegularCustomer = rateForRegularCustomer;
	}
	public String getHotelName() 
	{
		return hotelName;
	}
	public int getRateForRegularCustomer() 
	{
		return rateForRegularCustomer;
	}
	public void setHotelName(String hotelName) 
	{
		this.hotelName = hotelName;
	}
	public void setRateForRegularCustomer(int rateForRegularCustomer) 
	{
		this.rateForRegularCustomer = rateForRegularCustomer;
	}
	@Override
	public String toString() {
		return "Hotel [hotelName=" + hotelName + ", rateForRegularCustomer=" + rateForRegularCustomer + "]";
	}
	
}
