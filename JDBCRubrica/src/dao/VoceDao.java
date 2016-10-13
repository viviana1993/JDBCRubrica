package dao;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Voce;
import utility.DataSource;

public class VoceDao {
	//1-Create
	public int creaVoce(String nome,String cognome,String telefono, int id_rubrica){

		int id_Voce=0;
		PreparedStatement st=null;
		Connection con=null;

		try{
			con=DataSource.getInstance().getConnection();
			String sql="insert into VOCE(nome,COGNOME,TELEFONO,id_rubrica)"+"VALUES(?,?,?,?)";
			st=con.prepareStatement(sql,new String[]{"id_voce"});

			st.setString(1, nome);
			st.setString(2, cognome);
			st.setString(3, telefono);
			st.setInt(4, id_rubrica);
			st.executeUpdate();
			ResultSet rs=st.getGeneratedKeys();
			
			if(rs.next() && rs!=null) {
				id_Voce=rs.getInt(1);
				
			}

		}catch(SQLException|PropertyVetoException|IOException e){
			e.printStackTrace();
		}finally{
			if(st!=null)
			{
				try {
					st.close();
				}catch(SQLException e){ 
					e.printStackTrace();
				}
			}
		}
		return id_Voce;
	}



	//2-Read
	public Voce leggiVoce(int id){
		Voce v=null;
		PreparedStatement st=null;
		Connection con=null;
		ResultSet rs=null;
		try{
			con=DataSource.getInstance().getConnection();
			String sql="select*from VOCE where id_voce=?";
			st=con.prepareStatement(sql);

			st.setInt(1, id);
			rs=st.executeQuery();


			if(rs.next()){
				int id_voce=rs.getInt(1);
				int id_rubrica=rs.getInt(2);
				String nome=rs.getString(3);
				String cognome=rs.getString(4);
				String telefono=rs.getString(5);
				v=new Voce(id_voce,nome,cognome,telefono,id_rubrica);

			}



		}catch(SQLException|PropertyVetoException|IOException e){
			e.printStackTrace();
		}finally{
			if(st!=null)
			{
				try {
					st.close();
				}catch(SQLException e){ 
					e.printStackTrace();
				}
			}
		}

		return v;

	}
	
	
	//3-Read
	
	public Voce leggiVoce(String nome,String cognome,int id_r){
		Voce v=null;
		PreparedStatement st=null;
		Connection con=null;
		ResultSet rs=null;
		try{
			con=DataSource.getInstance().getConnection();
			String sql="select*from VOCE where nome=? and cognome=? and id_rubrica=?";
			st=con.prepareStatement(sql);

			st.setString(1, nome);
			st.setString(2, cognome);
			st.setInt(3,id_r);
			rs=st.executeQuery();


			if(rs.next()){
				int id_voce=rs.getInt(1);
				String telefono=rs.getString(4);
				
				
				v=new Voce(id_voce,nome,cognome,telefono,id_r);

			}



		}catch(SQLException|PropertyVetoException|IOException e){
			e.printStackTrace();
		}finally{
			if(st!=null)
			{
				try {
					st.close();
				}catch(SQLException e){ 
					e.printStackTrace();
				}
			}
		}

		return v;

	}
	
	

	//4-Update
	public boolean aggiornaVoce(int id_voce, String nome, String cognome, String telefono){

		boolean bool=false;
		PreparedStatement st=null;
		Connection con=null;

		try{
			con=DataSource.getInstance().getConnection();
			String sql="Update VOCE set nome=?,cognome=?,telefono=? where id_voce=?";
			st=con.prepareStatement(sql);
			st.setString(1, nome);
			st.setString(2, cognome);
			st.setString(3,telefono);
			st.setInt(4, id_voce);
			int rs=st.executeUpdate();

			if(rs>0) bool=true;

		}catch(SQLException|PropertyVetoException|IOException e){
			e.printStackTrace();
		}finally{
			if(st!=null)
			{
				try {
					st.close();
				}catch(SQLException e){ 
					e.printStackTrace();
				}
			}
		}
		return bool;
	}

	//5-delete
	public boolean rimuoviVoce(int id){

		boolean bool=false;
		PreparedStatement st=null;
		Connection con=null;

		try{
			con=DataSource.getInstance().getConnection();
			String sql="delete from VOCE where id_voce=?";
			st=con.prepareStatement(sql);

			st.setInt(1,id );
			int rs=st.executeUpdate();

			if(rs>0) bool=true;

		}catch(SQLException|PropertyVetoException|IOException e){
			e.printStackTrace();
		}finally{
			if(st!=null)
			{
				try {
					st.close();
				}catch(SQLException e){ 
					e.printStackTrace();
				}
			}
		}
		return bool;
	}

}
