package prova;

import servizi.ServiziRubrica;
import model.Rubrica;
import model.Voce;
import dao.RubricaDao;
import dao.VoceDao;

public class MainRubrica {

	public static void main(String[] args) {
		
		RubricaDao rDao=new RubricaDao();
		rDao.creaRubrica("Viviana");
		Rubrica r=rDao.leggiRubrica(1);
		System.out.println(r.getNome()+" "+r.getId_rubrica());
		rDao.modificaRubrica(1," paki");
		rDao.modificaRubrica(2, "vivi");
		rDao.rimuoviRubrica(3);
		
		
		ServiziRubrica s=new ServiziRubrica();
		Voce v=s.aggiungiVoce(r, "aaa", "aaaa", "11111");
		System.out.println(v.getId_voce()+" "+v.getNome()+" "+v.getCognome()+" "+v.getTelefono()+" "+v.getId_rubrica());
		
	}

}
