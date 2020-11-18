<%@page import="java.text.SimpleDateFormat"%>
<%@page import="br.com.java.model.Aluno"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cadastro de Alunos</title>

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
	height: 300px;
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
		<h1>Cadastro de Alunos</h1>
	</div>
	<ul>
		<li><a href="cadastroAlunos.jsp">Cadastrar Aluno</a>
		<li>
		<li><a href="AlunoController?action=listar">Consultar Aluno</a>
		<li>
	</ul>
	<fieldset>
		<div id="conteudo">

			<form action="AlunoController" method="post">

				<table>
					<tr>
						<td>Id:</td>
						<td><input type="text" name="id" value="${aluno.id}" size="5"></td>
					</tr>
					<tr>
						<td>Nome:</td>
						<td><input type="text" name="nome" value="${aluno.nome}" size="40"></td>
					</tr>
					<tr>
						<td>Idade:</td>
						<td><input type="text" name="idade" value="${aluno.idade}" size="5"></td>
					</tr>
					<tr>
						<td>Data Nascimento:</td>
						<td><input type="text" name="dataNascimento" value="${aluno.dataNascimento}" size="10">
						</td>
					</tr>
					<tr>
						<td colspan="4">
                                    <input type="submit" name="action"value="salvar" class="botao"> 
                                    <input type="submit" name="action" value="editar" class="botao"> 
                                    <input type="submit" name="action" value="deletar" class="botao">
                              	    <input type="submit" name="action" value="pesquisar" class="botao">
   
                       </td>
					</tr>
				</table>
			</form>

		</div>
	</fieldset>
	<div id="rodape">Diego Pereira WebSystemMaster - Todos os direitos reservados @2020</div>

</body>
</html>