package br.com.java.dao;


import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.java.model.Aluno;

public class AlunoDao extends FabricaConexoes{
	
//	private Connection CON;
//	PreparedStatement PS;
//	ResultSet RES;

//	@Override
	public void inserir(Aluno aluno) {
		// TODO Auto-generated method stub
//		String SQL = "Insert into Aluno (nome,idade,data_nascimento) values (?,?,?)";
		
		try {
			Connection conexao = getConexao();
			PreparedStatement PS = conexao
					.prepareStatement ("Insert into Aluno (nome,idade,dataNascimento) values (?,?,?)");
//			PS = conexao.prepareStatement(SQL);
			PS.setString(1, aluno.getNome());
			PS.setInt(2, aluno.getIdade());
			
			
			PS.setDate  (3, new java.sql.Date(aluno.getDataNascimento().getTime()));
			
//			Date data = new Date (aluno.getDataNascimento().getTimeInMillis());
			
//			PS.setDate(3, data);
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
//		String SQL = "Update Aluno set nome = ?, idade = ?, data_nascimento = ? where id = ?";
		try {
			Connection conexao = getConexao();
			PreparedStatement PS = conexao
					.prepareStatement("Update Aluno set nome = ?, idade = ?, dataNascimento = ? where id = ?");
//			PS = CON.prepareStatement(SQL);
			PS.setString(1, aluno.getNome());
			PS.setInt(2, aluno.getIdade());
			PS.setDate(3, new java.sql.Date(aluno.getDataNascimento().getTime()));
//			Date data = new Date (aluno.getDataNascimento().getTimeInMillis());
//			PS.setDate(3, data);
			PS.executeUpdate();
			PS.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

//	@Override
	public void remover(Aluno aluno) {
		// TODO Auto-generated method stub
		String SQL = "delete from Aluno Where id = ?";
		
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
		
		String SQL = "Select * from Aluno where id = ?";
		
		try {
			Connection conexao = getConexao();
			PreparedStatement PS = conexao
					.prepareStatement("Select * from Aluno where id = ?");
//			PS = CON.prepareStatement(SQL);
			PS.setInt(1, Id);
			ResultSet RES = PS.executeQuery();
			
			while (RES.next()) {
				aluno.setId(RES.getInt("id"));
				aluno.setNome(RES.getString("nome"));
				aluno.setIdade(RES.getInt("idade"));
				Date data = RES.getDate("dataNascimento");
				Calendar dt = Calendar.getInstance();
				dt.setTime(data);
				aluno.setDataNascimento(new java.util.Date(RES.getDate("dataNascimento").getTime()));
//				aluno.setDataNascimento(dt);
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
	public List<Aluno> listar() {
		// TODO Auto-generated method stub
		List<Aluno> lista = new ArrayList<>();
		String SQL = "Select * from Aluno";
		
		try {
			Connection conexao = getConexao();
			PreparedStatement PS = conexao
					.prepareStatement("Select * from Aluno");
//			PS = CON.prepareStatement(SQL);
			ResultSet RES = PS.executeQuery();
			
			while (RES.next()) {
				Aluno aluno = new Aluno();
				aluno.setId(RES.getInt("id"));
				aluno.setNome(RES.getString("nome"));
				aluno.setDataNascimento(new java.util.Date(RES.getDate("dataNascimento").getTime()));
				Date data = RES.getDate("dataNascimento");
//				Calendar dt = Calendar.getInstance();
//				dt.setTime(data);
//				
//				aluno.setDataNascimento(new java.util.Date(RES.getDate("dataNascimento").getTime()));
//				aluno.setDataNascimento(dt);
				lista.add(aluno);
				
				PS.close();
				RES.close();
				
				return lista;
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
	
	public Aluno consultar(Aluno aluno) {
		
		try {
			Connection conexao = getConexao();
			PreparedStatement pstm = conexao
					.prepareStatement("Select * from tbaluno where matricula =	?");
//			pstm.setId(1, aluno.getId());
			ResultSet rs = pstm.executeQuery();
			if (rs.next()) {
				aluno.setId(rs.getInt("id"));
				aluno.setNome(rs.getString("nome"));
				aluno.setDataNascimento(new java.util.Date(rs.getDate("dataNascimento").getTime()));
			
			}
			pstm.close();
			conexao.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return aluno;
		
	}

}
