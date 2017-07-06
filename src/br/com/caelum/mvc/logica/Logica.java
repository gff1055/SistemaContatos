package br.com.caelum.mvc.logica;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*INTERFACE COM O METODO EXECUTA. CADA LOGICA DO SISTEMA TERÁ ESSE METODO*/
public interface Logica {
	
	String executa(HttpServletRequest req, HttpServletResponse res) throws Exception;
	
}
