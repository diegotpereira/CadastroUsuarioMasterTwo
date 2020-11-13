<%@page import="java.io.IOException"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.dougllas.model.Aluno"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Consulta Alunos</title>

<style type="text/css">
body {
	font-family: sans-serif;
}

h1 {
	font-size: 25px;
	padding: 20px;
}

#top {
	height: 80px;
	background: black;
	color: white;
	margin-top: 50px;
}

#conteudo {
	height: 600px;
	margin-top: 10px;
}

#rodape {
	font-size: 14px;
}

.botao {
	background-color: #638cb5;
	color: white;
	border: 0;
	height: 30px;
	font-size: 14px;
}

.textfield {
	border-radius: 20px;
}

table td {
	border: 1;
	padding: 5px;
}

.tabela {
	font-size: 12px;
	width: 50%;
}

.coluna {
	background: silver;
	font-weight: bold;
	font-size: 14px;
}

ul {
	background: aqua;
	color: black;
	font-weight: bold;
	font-family: monospace;
	padding: 20px;
	height: 20px;
}

ul li {
	display: inline;
	padding: 20px;
}
</style>
</head>
<body>

	<div id="top">
		<h1>Consulta Alunos</h1>
	</div>
	<ul>
		<li><a href="cadastroAlunos.jsp">Cadastrar Aluno</a>
		<li>
		<li><a href="AlunoController?action=listar">Consultar Aluno</a>
		<li>
	</ul>
	<fieldset>
		<div id="conteudo">

			<table border="2" class="tabela">
				<tr>
					<td class="coluna" align="center">Id</td>
					<td class="coluna" align="center">Nome</td>
					<td class="coluna" align="center">Idade</td>
					<td class="coluna" align="center">Data Nascimento</td>
					<td class="coluna" align="center">Editar</td>
				</tr>
				<%
					@SuppressWarnings("unchecked")
				List<Aluno> alunos = (List<Aluno>) request.getAttribute("alunos");
				for (Aluno aluno : alunos) {
				%>
				<tr>
					<td>
						<%
							out.println(aluno.getId());
						%>
					</td>
					<td>
						<%
							out.println(aluno.getNome());
						%>
					</td>
					<td>
						<%
							out.println(aluno.getIdade());
						%>
					</td>
					<td>
						<%
							out.println(new SimpleDateFormat("dd/MM/yyyy").format(aluno.getDataNascimento().getTime()));
						%>
					</td>
					<td><a
						href="AlunoController?action=editando&id=<%out.println(aluno.getId());%>">editar</a>
					</td>
				</tr>
				<%
					}
				%>
			</table>

		</div>
	</fieldset>
	<div id="rodape">Diego Pereira WebSystemMaster - Todos os direitos reservados @2020</div>

</body>
</html>