package br.com.java.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.java.dao.AlunoDao;
import br.com.java.model.Aluno;

@WebServlet("/AlunoController")
public class AlunoController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	protected void doPost (HttpServletRequest request,
			 HttpServletResponse response) throws ServletException, IOException{
		String action = request.getParameter("action");
		String pagina = "/consultaAlunos.jsp";
		
		Aluno aluno = new Aluno();
		
		   aluno.setNome(request.getParameter("nome"));
		   aluno.setIdade(Integer.parseInt(request.getParameter("idade")));
		   
		   try {
			   DateFormat df = new SimpleDateFormat("dd/MM/yyyy");	
			   aluno.setDataNascimento(df.parse(request.getParameter("dataNascimento")));

		} catch (ParseException e) {
			// TODO: handle exception
			aluno.setDataNascimento(new Date());
			e.printStackTrace();
		}
		AlunoDao dao = new AlunoDao();
		
		List<Aluno> alunos = new ArrayList<>();
		
		switch (action) {
		case "salvar":
			dao.inserir(aluno);
			alunos = dao.todos();
			break;
			
		case "editar":
			dao.atualizar(aluno);
			alunos = dao.todos();
			break;
			
		case "deletar":
			dao.remover(aluno);
			alunos = dao.todos();
			break;
			
		case"pesquisar":
			aluno = dao.pesquizarId(aluno.getId());
			alunos.add(aluno);
			break;
		}
		
		request.setAttribute("alunos", alunos);
		request.getRequestDispatcher(pagina).forward(request, response);
	}
	public void doGet(HttpServletRequest request,
			 HttpServletResponse response) throws ServletException, IOException {
		
		AlunoDao dao = new AlunoDao();
		
		if (request.getParameter("action").equals("listar")) {
			List<Aluno> alunos = dao.todos();
			request.setAttribute("alunos", alunos);
		}else if (request.getParameter("action").equals("editando")) {
			String id = request.getParameter("id");
			int idAluno = Integer.parseInt(id);
			
			Aluno aluno = dao.pesquizarId(idAluno);
			
			request.setAttribute("aluno", aluno);
			request.getRequestDispatcher("editandoAluno.jsp").forward(request, response);
			
		}
	}

}
