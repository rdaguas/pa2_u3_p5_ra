package com.uce.edu.ventas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.ventas.repository.IHotelRepository;
import com.uce.edu.ventas.repository.modelo.Hotel;
@Service
public class HotelServiceImpl implements IHotelService {

	
	@Autowired
	private IHotelRepository hotelRepository;
	
	@Override
	public void guardar(Hotel hotel) {
		// TODO Auto-generated method stub
		this.hotelRepository.insertar(hotel);
	}

	@Override
	public List<Hotel> buscarHotelInnerJoin() {
		// TODO Auto-generated method stub
		return this.hotelRepository.seleccionarHotelInnerJoin();
	}

	@Override
	public List<Hotel> buscarHotelRightJoin() {
		// TODO Auto-generated method stub
		return this.hotelRepository.seleccionarHotelRightJoin();
	}

	@Override
	public List<Hotel> buscarHotelLeftJoin() {
		// TODO Auto-generated method stub
		return this.hotelRepository.seleccionarHotelLeftJoin();
	}

	@Override
	public List<Hotel> buscarHotelFullJoin() {
		// TODO Auto-generated method stub
		return this.hotelRepository.seleccionarHotelFullJoin();
	}

	@Override
	public List<Hotel> buacarHotelFetchJoin() {
		// TODO Auto-generated method stub
		return this.hotelRepository.seleccionarHotelFetchJoin();
	}

}
