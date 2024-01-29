package com.uce.edu.ventas.service;

import java.util.List;

import com.uce.edu.ventas.repository.modelo.Hotel;

public interface IHotelService {
	
	public void guardar(Hotel hotel);
	public List<Hotel> buscarHotelInnerJoin();
	public List<Hotel> buscarHotelRightJoin();
	public List<Hotel> buscarHotelLeftJoin();
	public List<Hotel> buscarHotelFullJoin();
	


}
