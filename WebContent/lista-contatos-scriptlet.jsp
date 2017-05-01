<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import = "java.util.*, br.com.caelum.jdbc.dao.*, br.com.caelum.jdbc.modelo.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<table>
		<tr>
			<td><b>Nome</b></td>
			<td><b>Endereço</b></td>
			<td><b>Email</b></td>
			<td><b>Nascimento</b></td>
		</tr>
		<%
		ContatoDao dao = new ContatoDao();

		List<Contato> listaDeContatos = dao.getLista();


		for(Contato indexContato:listaDeContatos)
		{
		%>
			<tr>
				<td><%= indexContato.getNome()%></td>
				<td><%= indexContato.getEndereco()%></td>
				<td><%= indexContato.getEmail()%></td>
				<td><%= indexContato.getDataNascimento().getTime()%></td>
			</tr>
		<%
		}
		%>
	</table>
</body>
</html>