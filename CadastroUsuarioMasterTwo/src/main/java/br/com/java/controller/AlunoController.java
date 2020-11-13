package br.com.java.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.java.dao.AlunoDaoImpl;
import br.com.java.model.Aluno;

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
		
		if (!request.getParameter("id").equals("")
				 || request.getParameter("id") != null) {
			
			aluno.setId(Integer.parseInt(request.getParameter("id")));
		}
		   aluno.setNome(request.getParameter("nome"));
		   aluno.setIdade(Integer.parseInt(request.getParameter("idade")));
		   
		   try {
			Calendar c = Calendar.getInstance();
			Date datanascimento = new SimpleDateFormat("dd/MM/yyyy").parse(request.getParameter("dataNascimento"));
			c.setTime(datanascimento);
		} catch (ParseException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		AlunoDaoImpl dao = new AlunoDaoImpl();
		Aluno aluno = getParameters(request);
		
		List<Aluno> alunos = new ArrayList<>();
		
		switch (action) {
		case "salvar":
			dao.adicionar(aluno);
			alunos = dao.getTodos();
			break;
			
		case "editar":
			dao.atualizar(aluno);
			alunos = dao.getTodos();
			break;
			
		case "deletar":
			dao.remover(aluno.getId());
			alunos = dao.getTodos();
			break;
			
		case"pesquisar":
			aluno = dao.achar(aluno.getId());
			alunos.add(aluno);
			break;
		}
		
		request.setAttribute("alunos", alunos);
		request.getRequestDispatcher(pagina).forward(request, response);
	}
	public void doGet(HttpServletRequest request,
			 HttpServletResponse response) {
		
		AlunoDaoImpl dao = new AlunoDaoImpl();
		
		if (request.getParameter("action").equals("listar")) {
			List<Aluno>alunos = dao.getTodos();
			request.setAttribute("alunos", alunos);
			request.getRequestDispatcher("consultaAlunos.jsp").forward(request, response);
		}else if (request.getParameter("action").equals("editando")) {
			String id = request.getParameter("id");
			int idAluno = Integer.parseInt(id);
			
			Aluno aluno = dao.achar(idAluno);
			
			request.setAttribute("aluno", aluno);
			request.getRequestDispatcher("edutandoAluno.jsp").forward(request, response);
			
		}
	}

}