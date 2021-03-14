package com.discountinn.demo.services;
import java.util.List;
import com.discountinn.demo.models.Hotel;

public interface HotelService {
	
	List<Hotel> findByPinCode(String pinCode);
	
	public List<Hotel> getHotels();
	
	public Hotel getHotel(long id);
	
	public Hotel deleteHotel(long hotelId);
	
	public Hotel updateHotel(Hotel hotel,long hotelId);
	
	public Hotel addHotel(Hotel hotel);
	
	public List<Hotel> findByState(String state);
	
	public List<Hotel> findByCity(String city);
	
	
	int getAvailableRooms(long hotelId);
	
	
	void decreaseAvailableRooms(long hotelId, int available_rooms);
	
	void increaseAvailableRooms(long hotelId, int available_rooms);

}
