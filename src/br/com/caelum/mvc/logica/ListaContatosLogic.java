package br.com.caelum.mvc.logica;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.jdbc.dao.ContatoDao;
import br.com.caelum.jdbc.modelo.Contato;

public class ListaContatosLogic implements Logica {
	
	public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception{
		
		//MONTA A LISTA DE CONTATOS
		List<Contato> contatos = new ContatoDao().getLista();
		
		//GUARDA A LISTA NO REQUEST
		req.setAttribute("contatos", contatos);
		
		//A LISTA DE CONTATOS EM contatos SERÁ ACESSADA POR EXPRESSION LANGUAGE ${contatos}
		return "lista-contatos.jsp";
		
	}
	
}
