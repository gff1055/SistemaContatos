package br.com.caelum.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.jdbc.dao.ContatoDao;
import br.com.caelum.jdbc.modelo.Contato;

@WebServlet("/adicionaContato")

public class AdicionaContatoServlet extends HttpServlet
{
	protected void service(HttpServletRequest request,HttpServletResponse response)
			throws IOException, ServletException
	{
		// busca o writer
		PrintWriter out = response.getWriter();

		// buscando os parâmetros no request
		String nome = request.getParameter("nome");
		String endereco = request.getParameter("endereco");
		String email = request.getParameter("email");
		String dataEmTexto = request.getParameter("dataNascimento");
		Calendar dataNascimento = null;

		// fazendo a conversão da data
		try
		{
			Date date = new SimpleDateFormat("dd/MM/yyyy").parse(dataEmTexto);
			dataNascimento = Calendar.getInstance();
			dataNascimento.setTime(date);
		}
		catch (ParseException e)
		{
			out.println("Erro de conversão da data");
			return; //para a execução do método
		}

		// monta um objeto contato
		Contato contato = new Contato();
		contato.setNome(nome);
		contato.setEndereco(endereco);
		contato.setEmail(email);
		contato.setDataNascimento(dataNascimento);

		// salva o contato
		ContatoDao dao = new ContatoDao();
		dao.adiciona(contato);
		
		//USANDO OBJETO RequestDispatcher PARA ACESSO A OUTRO RECURSO WEB		
		RequestDispatcher rd=request.getRequestDispatcher("/contato-adicionado.jsp");
		
		//REDIRECIONANDO PARA A PAGINA ESPECIFICADA
		rd.forward(request, response);
	}
}


