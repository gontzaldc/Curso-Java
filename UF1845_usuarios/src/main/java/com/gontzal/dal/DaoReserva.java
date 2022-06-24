package com.gontzal.dal;

import com.gontzal.modelos.Reserva;

public interface DaoReserva extends Dao<Reserva> {

	Iterable<Reserva> obtenerPorEmail(String email);
}
