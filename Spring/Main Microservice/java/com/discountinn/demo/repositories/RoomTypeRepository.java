package com.discountinn.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.discountinn.demo.models.RoomType;

public interface RoomTypeRepository extends JpaRepository<RoomType, Integer> {
	public RoomType findByRoomType(String roomType);
}
