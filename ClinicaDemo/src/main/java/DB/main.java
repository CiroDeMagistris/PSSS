package DB;

import java.util.ArrayList;

public class main {

	public static void main (String[] args) {

		Prenotazione P = new Prenotazione();
		P.DownloadFromDB(1);
		
		Medico M = new Medico();
		
		CalendarioMedico CM = new CalendarioMedico();
		
		Paziente Paz = new Paziente();
		
		CartellaClinica CC = new CartellaClinica();
		
		Ambulatorio A = new Ambulatorio();
		
		
		//System.out.println(P);
		
		//Ambulatorio A = new Ambulatorio();
		//A.setCodice("POLLO");
		//A.setNome("Cartomansia");
		//A.UploadToDB();
		
		ArrayList<Ambulatorio> pre = A.DownloadAmbulatori();
		
		
		for (int i=0;i<pre.size(); i++) {
			System.out.println(pre.get(i));
		}
		
	}

}
