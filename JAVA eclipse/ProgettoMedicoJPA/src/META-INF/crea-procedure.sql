DELIMITER //
CREATE PROCEDURE cercaMedico(
	p_Tipologia varchar(200),
    p_Nominativo varchar(200),
    p_NomeCitta varchar(200)
)
BEGIN
	select 
		m.email
	from 
		medico m inner join medico_has_ambulatorio ma
		on m.email = ma.Medico_email
	where
		1 = 1
		AND m.TIPOLOGIA like concat('%', p_Tipologia, '%')
		AND (
				m.nome LIKE concat('%', p_Nominativo, '%') 
			OR 	m.cognome LIKE concat('%', p_Nominativo, '%')
			)
		AND ma.Ambulatorio_id IN (
			SELECT 
				a.IDAMBULATORIO
			from 
				ambulatorio a inner join citta c
				on a.CITTA_IDCITTA = c.IDCITTA
			where 
				c.NOME like concat('%', p_NomeCitta, '%')
			);
END //
DELIMITER ;
