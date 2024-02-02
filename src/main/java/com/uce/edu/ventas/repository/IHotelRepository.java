package com.uce.edu.ventas.repository;

import java.util.List;

import com.uce.edu.ventas.repository.modelo.Hotel;

public interface IHotelRepository {

	public void insertar(Hotel hotel);
	public List<Hotel> seleccionarHotelInnerJoin();
	public List<Hotel> seleccionarHotelRightJoin();
	public List<Hotel> seleccionarHotelLeftJoin();
	public List<Hotel> seleccionarHotelFullJoin();
	public List<Hotel> seleccionarHotelFetchJoin();

}
