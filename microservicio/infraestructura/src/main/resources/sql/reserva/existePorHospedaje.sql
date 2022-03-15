select count(1) from reserva
where id_hospedaje = :idHospedaje
and activo = 'SI';