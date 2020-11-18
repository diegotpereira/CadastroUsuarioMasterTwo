package br.com.java.dao;


import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.java.model.Aluno;

public class AlunoDao extends FabricaConexoes{
	

//	@Override
	public void inserir(Aluno aluno) {
		// TODO Auto-generated method stub
		
		try {
			Connection conexao = getConexao();
			PreparedStatement PS = conexao
					.prepareStatement ("Insert into Aluno (nome,idade,dataNascimento) values (?,?,?)");

			PS.setString(1, aluno.getNome());
			PS.setInt(2, aluno.getIdade());
			PS.setDate  (3, new java.sql.Date(aluno.getDataNascimento().getTime()));
			PS.execute();
			PS.close();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}

//	@Override
	public void atualizar(Aluno aluno) {
		// TODO Auto-generated method stub
		try {
			Connection conexao = getConexao();
			PreparedStatement PS = conexao
					.prepareStatement("Update Aluno set nome = ?, idade = ?, dataNascimento = ?" +  " WHERE id = ? ");
			PS.setString(1, aluno.getNome());
			PS.setInt   (2, aluno.getIdade());
			PS.setDate  (3, new java.sql.Date(aluno.getDataNascimento().getTime()));
			PS.executeUpdate();
			PS.close();
			//conexao.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

//	@Override
	public void remover(Aluno aluno) {
		// TODO Auto-generated method stub
//		String SQL = "delete from Aluno Where id = ?";
		
		try {
			Connection conexao = getConexao();
			PreparedStatement PS = conexao
					.prepareStatement("delete from Aluno Where id = ?");
//			PS = CON.prepareStatement(SQL);
			PS.setInt(1, aluno.getId());
			PS.executeUpdate();
			PS.close();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}

//	@Override
	public Aluno pesquizarId(int Id) {
		// TODO Auto-generated method stub
		Aluno aluno = new Aluno();
		
		try {
			Connection conexao = getConexao();
			PreparedStatement PS = conexao
					.prepareStatement("Select * from aluno where id =	?");
			PS.setInt(1, Id);
			ResultSet RES = PS.executeQuery();
			
			while (RES.next()) {
				aluno.setId(RES.getInt("id"));
				aluno.setNome(RES.getString("nome"));
				aluno.setIdade(RES.getInt("idade"));
				aluno.setDataNascimento(new java.util.Date(RES.getDate("dataNascimento").getTime()));
			}
			
			PS.close();
			RES.close();
			return aluno;

			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

//	@Override
	public List<Aluno> todos() {
		// TODO Auto-generated method stub
		List<Aluno> lista = new ArrayList<>();
//		String SQL = "Select * from Aluno";
		
		try {
			Connection conexao = getConexao();
			Statement PS = conexao.createStatement();
			ResultSet RES = PS.executeQuery("Select * from aluno");

			
			while (RES.next()) {
				Aluno aluno = new Aluno();
				aluno.setId(RES.getInt("id"));
				aluno.setNome(RES.getString("nome"));
				aluno.setIdade(RES.getInt("idade"));
				aluno.setDataNascimento(new java.util.Date(RES.getDate("dataNascimento").getTime()));
				lista.add(aluno);
				
			
				
			}
			PS.close();
			RES.close();
			
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return lista;
	}
	
//	public Aluno consultar(Aluno aluno) {
//		
//		try {
//			Connection conexao = getConexao();
//			PreparedStatement pstm = conexao
//					.prepareStatement("Select * from aluno where id =	?");
//			pstm.setInt(1, aluno.getId());
//			ResultSet rs = pstm.executeQuery();
//			if (rs.next()) {
//				aluno.setId(rs.getInt("id"));
//				aluno.setNome(rs.getString("nome"));
//				aluno.setDataNascimento(new java.util.Date(rs.getDate("dataNascimento").getTime()));
//			
//			}
//			pstm.close();
//			conexao.close();
//		} catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//		}
//		return aluno;
//		
//	}

}
