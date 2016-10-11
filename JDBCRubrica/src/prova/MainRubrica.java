package prova;

import model.Rubrica;
import model.Voce;
import dao.RubricaDao;
import dao.VoceDao;

public class MainRubrica {

	public static void main(String[] args) {
		/*RubricaDao rDao=new RubricaDao();
		rDao.creaRubrica("Viviana");
		Rubrica r=rDao.leggiRubrica(1);
		System.out.println(r.getNome()+" "+r.getId_rubrica());
		rDao.modificaRubrica(1," paki");
		rDao.modificaRubrica(2, "vivi");
		rDao.rimuoviRubrica(3);
		*/
		
		VoceDao vDao=new VoceDao();
		vDao.creaVoce("Viviana","Vacirca","8888888");
		Voce v=vDao.leggiVoce(1);
		System.out.println(v.getId_voce()+" "+v.getNome()+" "+v.getCognome()+" "+v.getTelefono()+" "+v.getId_rubrica());
		vDao.aggiornaVoce(1, "paki", "paki", "5555");
	}

}
