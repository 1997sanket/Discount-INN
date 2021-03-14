package com.discountinn.demo.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.discountinn.demo.models.Hotel;

@Repository
public interface HotelRepository extends JpaRepository<Hotel,Long> {

	public List<Hotel> findByState(String state);
	public List<Hotel> findByCity(String city);
	
	

	@Query(value = "SELECT available_rooms from hotel where hotel_id = ?1", nativeQuery = true)
	int getAvailableRooms(long hotelId);
	
	@Query(value = "select * from hotel where pin_code = ?1", nativeQuery = true)
	List<Hotel> findByPinCode(String pinCode);
	
	@Modifying
	@Transactional
	@Query(value = "update hotel set available_rooms = ?2 where hotel_id = ?1", nativeQuery = true)
	void updateAvailableRooms(long hotelId, int available_rooms);
}
