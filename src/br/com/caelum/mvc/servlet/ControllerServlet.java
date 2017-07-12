package br.com.caelum.mvc.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.mvc.logica.Logica;

/*TODA ESSA SERVLET CONTROLA A LOGICA*/
@WebServlet("/mvc")


public class ControllerServlet extends HttpServlet{
	
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		
		/*LOGICA DE NEGOCIOS APROPRIADA-PEGANDO NOME DA CLASSE A PARTIR DO NOME DO PARAMETRO INSTANCIAR*/
		
		/*BUSCANDO A LOGICA QUE FOI ACIONADA NA VIEW*/
		String parametro=request.getParameter("logica");
		
		/*CONCATENANDO A STRING DA LOGICA COM A STRING DO PACOTE PARA A GERACAO DA STRING DO CAMINHO DO PACOTE*/
		String nomeDaClasse="br.com.caelum.mvc.logica."+parametro;
		
		
		try{
		
			/*PEGANDO A CLASSE EM TEMPO DE EXECUCAO A PARTIR DA STRING DO NOME DO PACOTE*/
			Class classe=Class.forName(nomeDaClasse);	//Gerando uma representacao da classe
			Logica logica=(Logica)classe.newInstance();	//Instanciando a classe utilizando uma interface
			
			
			String pagina=logica.executa(request,response);	 //executando funcao predefinida da interface
			
			
			//USANDO OBJETO RequestDispatcher PARA ACESSAR OUTRO RECURSO WEB(pagina no caso)
			request.getRequestDispatcher(pagina).forward(request,response);			
		}catch(Exception e){
			throw new ServletException("A logica de negocios causou uma excecao", e);
		}
		
	}
	
}
