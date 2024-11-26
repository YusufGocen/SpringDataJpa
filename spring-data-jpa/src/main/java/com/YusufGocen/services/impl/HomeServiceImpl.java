package com.YusufGocen.services.impl;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.YusufGocen.Dto.DtoHome;
import com.YusufGocen.Dto.DtoRoom;
import com.YusufGocen.Repository.HomeRepository;
import com.YusufGocen.entites.Home;
import com.YusufGocen.entites.Room;
import com.YusufGocen.services.IHomeService;

@Service
public class HomeServiceImpl implements IHomeService{

	@Autowired
	private HomeRepository homeRepository;
	
	@Override
	public DtoHome findHomeById(Long id) {
		DtoHome dtoHome=new DtoHome();
		Optional<Home>optinal= homeRepository.findById(id);
		
		if (optinal.isEmpty()) {
			return null;
		}
		Home home=optinal.get();
		List<Room>dbRooms=optinal.get().getRooms();
		
		BeanUtils.copyProperties(home,dtoHome);
		
		if (dbRooms!=null && !dbRooms.isEmpty()) {
			for (Room room : dbRooms) {
				DtoRoom dtoRoom=new DtoRoom();
				BeanUtils.copyProperties(room, dtoRoom);
				dtoHome.getRooms().add(dtoRoom);
			}
		}
		
		
		
		return dtoHome;
	}

}
