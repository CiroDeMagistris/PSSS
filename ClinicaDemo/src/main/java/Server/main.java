package Server;

import java.sql.Timestamp;

public class main {

	public static void main(String[] args) {

		Ambulatorio A = new Ambulatorio();
		Prenotazione P = A.RicercaPrenotazione(5);
		
		Medico M = new Medico();
		M.setId(8);
		
		Paziente Paz = new Paziente();
		Paz.setCodiceFiscale("POLLO");
		
		A.setCodice("H");
		
		Timestamp T = Timestamp.valueOf("2020-12-2 14:22:00");
		
		
		A.AggiungiPrenotazione(T, "Psicosi", Paz, M);
		
	}

}
