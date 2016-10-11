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
	public boolean creaVoce(String nome,String cognome,String telefono){

		boolean bool=false;
		PreparedStatement st=null;
		Connection con=null;

		try{
			con=DataSource.getInstance().getConnection();
			String sql="insert into VOCE(nome,COGNOME,TELEFONO)"+"VALUES(?,?,?)";
			st=con.prepareStatement(sql);

			st.setString(1, nome);
			st.setString(2, cognome);
			st.setString(3, telefono);
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

	//3-Update
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

	//4-delete
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
