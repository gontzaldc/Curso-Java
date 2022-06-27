package com.gontzal.dal;

import java.util.ArrayList;
import java.util.TreeMap;

import com.gontzal.modelos.Reserva;

public class DaoReservaMemoria implements DaoReserva {

	private final static TreeMap<Long, Reserva> reservas = new TreeMap<>();

	@Override
	public Iterable<Reserva> obtenerTodos() {
		return reservas.values();
	}

	@Override
	public Reserva insertar(Reserva reserva) {

		Long id = reservas.size() > 0 ? reservas.lastKey() + 1 : 1L;
		reserva.setId(id);
		return reservas.put(id, reserva);
	}

	@Override
	public Iterable<Reserva> obtenerPorEmail(String email) {
		ArrayList<Reserva> res = new ArrayList<>();
		for (Reserva r : reservas.values()) {
			if (r.getemail().equals(email)) {
				res.add(r);
			}

		}
		return res;
	}

	@Override
	public void borrar(Long id) {
		reservas.remove(id);
	}
	
	

}
