package com.discountinn.demo.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.discountinn.demo.repositories.HotelRepository;
import com.discountinn.demo.models.Hotel;

@Service
public class HotelServiceImpl implements HotelService {
	
	@Autowired
	private HotelRepository hotelrepo;
	
	

	@Override
	public List<Hotel> getHotels() {
		return this.hotelrepo.findAll();
	}

	@Override
	public Hotel getHotel(long id) {
		//return (Hotel)this.hotelrepo.getOne(id);
		return this.hotelrepo.findById(id).get();
	}

	@Override
	public Hotel deleteHotel(long hotelId) {
		Hotel hotel = this.hotelrepo.getOne(hotelId);
		if(hotel!=null) {
			this.hotelrepo.delete(hotel);
		}
		return hotel;
	}

	@Override
	public Hotel updateHotel(Hotel hotel, long hotelId) {
		Hotel checkHotel = this.hotelrepo.getOne(hotelId);
		if(checkHotel!=null) {
			this.hotelrepo.save(hotel);
		}
		return hotel;
	}

	@Override
	public Hotel addHotel(Hotel hotel) {
		this.hotelrepo.save(hotel);
		return hotel;
	}

	@Override
	public List<Hotel> findByState(String state) {
		return this.hotelrepo.findByState(state);
	}

	@Override
	public List<Hotel> findByCity(String city) {
		return this.hotelrepo.findByCity(city);
	}

	
	//Decrease available rooms after checkin
	@Override
	public void decreaseAvailableRooms(long hotelId, int available_rooms) {
		// TODO Auto-generated method stub
		hotelrepo.updateAvailableRooms(hotelId, available_rooms);
	}

	
	//Increase available rooms after checkout
	@Override
	public void increaseAvailableRooms(long hotelId, int available_rooms) {
		// TODO Auto-generated method stub
		hotelrepo.updateAvailableRooms(hotelId, available_rooms);
	}

	@Override
	public int getAvailableRooms(long hotelId) {
		// TODO Auto-generated method stub
		return hotelrepo.getAvailableRooms(hotelId);
	}

	@Override
	public List<Hotel> findByPinCode(String pinCode) {
		// TODO Auto-generated method stub
		return hotelrepo.findByPinCode(pinCode);
	}



}
