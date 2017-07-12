<%--
	DEFINICAO DE TAGLIBS A SEREM USADAS
	c = core
	fmt = formatdate
 --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
	
		<!-- IMPORTANDO A PAGINA CABECALHO.JSP -->
		<c:import url = "cabecalho.jsp" />
	
		<%-- ASSOCIANDO A ID dao A CLASSE ContatoDao --%>
		<%--<jsp:useBean id = "dao" class = "br.com.caelum.jdbc.dao.ContatoDao"/>  --%>
	
		<table>
			<tr>
				<td>nome</td>
				<td>email</td>
				<td>endereco</td>
				<td>Nascimento</td>
			</tr>
			
			<%-- ITERANDO DENTRO DE UMA COLECAO USANDO forEach
			<c:forEach var="INDICE" items="LISTA"> --%>
			<c:forEach var="contato" items="${contatos}">
			
				<tr>
					<td>${contato.nome}</td>
					<td>
					
						<%--EXECUTAND COMANDO CONDICIONAL --%>
						<c:choose>
							<c:when test = "${not empty contato.email}">
								<a href = "mailto:${contato.email}">${contato.email}</a>
							</c:when>
							<c:otherwise>
    							Email nao cadastrado
							</c:otherwise>
						</c:choose>
					
					</td>
					<td>${contato.endereco}</td>
					
					<%-- OBJETO DO TIPO java.util.Date SENDO FORMATADO PARA UM DETERMINADO PATTERN --%>
					<td><fmt:formatDate value = "${contato.dataNascimento.time}" pattern = "dd/MM/yyyy" /></td>
					
					<td>
						<a href="mvc?logica=RemoveContatoLogic&id=${contato.id}">Remover</a>
					</td>
				</tr>
			</c:forEach>
		</table>
		
		<!-- IMPORTANDO A PAGINA -->
		<c:import url = "rodape.jsp" />
	</body>
</html>