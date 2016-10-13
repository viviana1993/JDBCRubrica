package servizi;

import java.util.Map;

import model.Rubrica;
import model.Voce;
import dao.VoceDao;

public class ServiziRubrica {
	
	VoceDao vDao=new VoceDao();
	// Aggiungo voce a rubrica
	public Voce aggiungiVoce(Rubrica r,String nome,String cognome,String telefono){
		
		Voce v=null;
		int id=vDao.creaVoce(nome, cognome, telefono,r.getId_rubrica());
		if(id!=0){
			v = vDao.leggiVoce(id);
		}
		return v;
	}
	
	//leggo una Voce
	
	public Voce getVoce(Rubrica r,String nome,String cognome){
		
		Voce v=vDao.leggiVoce(nome,cognome,r.getId_rubrica());
		return v;
	}
	
	//Prendi tutte le voci
	public Map<String,Voce> getTutteLeVoci(Rubrica r){
	
		return (Map<String, Voce>) vDao.leggiVoce(r.getId_rubrica());
	}
	

	
}
