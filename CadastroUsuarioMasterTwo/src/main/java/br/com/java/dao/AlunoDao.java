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

public class AlunoDao implements Dao{
	
	private Connection CON;
	PreparedStatement PS;
	ResultSet RES;

	@Override
	public void inserir(Aluno aluno) {
		// TODO Auto-generated method stub
		String SQL = "Insert into Aluno (nome,idade,data_nascimento) values (?,?,?)";
		
		try {
			PS = CON.prepareStatement(SQL);
			PS.setString(1, aluno.getNome());
			PS.setInt(2, aluno.getIdade());
			Date data = new Date (aluno.getDataNascimento().getTimeInMillis());
			PS.setDate(3, data);
			PS.execute();
			PS.close();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}

	@Override
	public void atualizar(Aluno aluno) {
		// TODO Auto-generated method stub
		String SQL = "Update Aluno set nome = ?, idade = ?, data_nascimento = ? where id = ?";
		try {
			PS = CON.prepareStatement(SQL);
			PS.setString(1, aluno.getNome());
			PS.setInt(2, aluno.getIdade());
			Date data = new Date (aluno.getDataNascimento().getTimeInMillis());
			PS.setDate(3, data);
			PS.executeUpdate();
			PS.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	@Override
	public void remover(Aluno aluno) {
		// TODO Auto-generated method stub
		String SQL = "delete from Aluno Where id = ?";
		
		try {
			PS = CON.prepareStatement(SQL);
			PS.setInt(1, aluno.getId());
			PS.executeUpdate();
			PS.close();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}

	@Override
	public Aluno pesquizarId(int Id) {
		// TODO Auto-generated method stub
		Aluno aluno = new Aluno();
		
		String SQL = "Selec * from Aluno where id = ?";
		
		try {
			PS = CON.prepareStatement(SQL);
			PS.setInt(1, Id);
			RES = PS.executeQuery();
			
			while (RES.next()) {
				aluno.setId(RES.getInt("id"));
				aluno.setNome(RES.getString("nome"));
				aluno.setIdade(RES.getInt("idade"));
				Date data = RES.getDate("data_nascimento");
				Calendar dt = Calendar.getInstance();
				dt.setTime(data);
				aluno.setDataNascimento(dt);
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

	@Override
	public List<Aluno> todos() {
		// TODO Auto-generated method stub
		List<Aluno> lista = new ArrayList<>();
		String SQL = "Select * from Aluno";
		
		try {
			PS = CON.prepareStatement(SQL);
			RES = PS.executeQuery();
			
			while (RES.next()) {
				Aluno aluno = new Aluno();
				aluno.setId(RES.getInt("id"));
				aluno.setNome(RES.getString("nome"));
				Date data = RES.getDate("data_nascimento");
				Calendar dt = Calendar.getInstance();
				dt.setTime(data);
				aluno.setDataNascimento(dt);
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

}
