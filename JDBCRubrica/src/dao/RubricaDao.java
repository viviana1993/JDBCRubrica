package dao;

import java.beans.PropertyVetoException;
import java.io.IOException;

import java.sql.Connection;

import java.sql.PreparedStatement;

import java.sql.ResultSet;

import java.sql.SQLException;


import model.Rubrica;
import utility.DataSource;

public class RubricaDao {
	//le classi di tipo dao contengono tutti i metodi CRUD(Create,Read,UpDate,Delete)


	//1-Create
	public boolean creaRubrica(String nome){

		boolean bool=false;
		PreparedStatement st=null;
		Connection con=null;

		try{
			con=DataSource.getInstance().getConnection();
			String sql="insert into RUBRICA(nome)"+"VALUES(?)";
			st=con.prepareStatement(sql);

			st.setString(1, nome);
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
	public Rubrica leggiRubrica(int id){
		Rubrica r=null;
		PreparedStatement st=null;
		Connection con=null;
		ResultSet rs=null;
		try{
			con=DataSource.getInstance().getConnection();
			String sql="select*from RUBRICA where id_rubrica=?";
			st=con.prepareStatement(sql);

			st.setInt(1, id);
			rs=st.executeQuery();


			if(rs.next()){
				int id_rubrica=rs.getInt(1);
				String nome=rs.getString(2);
				r=new Rubrica(id_rubrica,nome);

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

		return r;

	}

	//3-Update
	public boolean modificaRubrica(int id,String nome){

		boolean bool=false;
		PreparedStatement st=null;
		Connection con=null;

		try{
			con=DataSource.getInstance().getConnection();
			String sql="Update RUBRICA set nome=? where id_rubrica=?";
			st=con.prepareStatement(sql);

			st.setString(1, nome);
			st.setInt(2,id );
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
	public boolean rimuoviRubrica(int id){

		boolean bool=false;
		PreparedStatement st=null;
		Connection con=null;

		try{
			con=DataSource.getInstance().getConnection();
			String sql="delete from RUBRICA where id_rubrica=?";
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