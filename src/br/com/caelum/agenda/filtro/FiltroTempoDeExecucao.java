package br.com.caelum.agenda.filtro;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

//DEFININDO UM FILTRO, QUE FILTRARÁ TODAS AS REQUISICOES (/*)
@WebFilter("/*")

//IMPLEMENTANTO A INTERFACE FILTER NA CRIACAO DA CLASSE FILTRO
public class FiltroTempoDeExecucao implements Filter{

	//EXECUTA QUANDO O FILTRO É DESCARREGADO DO CONTAINER
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	//METODO QUE FAZERÁ O EFETIVAMENTE O PROCESSAMENTO
	//
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		long tempoInicial = System.currentTimeMillis();
		
		//"fechando a porta" - O REQUEST "SAI" DO FILTRO E PROSSEGUE SEU PROCESSAMENTO
		chain.doFilter(request, response);
		
		long tempoFinal = System.currentTimeMillis();
		
		String uri = ((HttpServletRequest)request).getRequestURI();
		
		String parametros = ((HttpServletRequest)request).getParameter("Logica");
		
		System.out.print("Tempo da Requisicao"+uri+"?logica="+parametros+" demorou (ms) "+(tempoFinal-tempoInicial));
		
	}

	//EXECUTA QUANDO O FILTRO FOR CARREGADO NO CONTAINER
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
