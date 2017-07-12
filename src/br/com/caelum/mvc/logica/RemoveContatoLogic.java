package br.com.caelum.mvc.logica;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.jdbc.dao.ContatoDao;
import br.com.caelum.jdbc.modelo.Contato;

public class RemoveContatoLogic implements Logica{
	
	// METODO EXEUTA RECEBE COMO PARAMETRO AS VARIAVEIS 
	// req (REQUISICOES DO USUARIO) e 
	// res (RESPOSTA AO USUARIO)
	public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception{
		
		//BUSCANDO PARMETRO NO ID
		long id = Long.parseLong(req.getParameter("id"));
		
		//INSERINDO O ID PASSADO EM UM OBJETO
		Contato contato = new Contato();
		contato.setId(id);
		
		//INICIALIZA UM OBJETO DE ACESSO AOS DADOS(DAO) E
		// EXCLUSAO DO CONTATO A PARTIR DESSE
		ContatoDao dao = new ContatoDao();
		dao.remove(contato);
		
		System.out.println("Excluindo contato...");
		
		return "mvc?logica=ListaContatosLogic";
		
	}
	
}
