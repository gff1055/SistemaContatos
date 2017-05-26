<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
 <head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>Insert title here</title>
 </head>
 <body>
  <c:import url = "cabecalho.jsp" />
  <jsp:useBean id = "dao" class = "br.com.caelum.jdbc.dao.ContatoDao"/>
  <table>
   <tr>
    <td>nome</td>
    <td>email</td>
    <td>endereco</td>
    <td>Nascimento</td>
   </tr>
   <c:forEach var="contato" items="${dao.lista}">
    <tr>
    <td>${contato.nome}</td>
    <td>
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
    <td>${contato.dataNascimento.time}</td>
    </tr>
   </c:forEach>
  </table>
  <c:import url = "rodape.jsp" />
 </body>
</html>