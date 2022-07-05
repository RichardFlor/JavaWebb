package servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/novaEmpresa")
public class NovaEmpresaServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Cadastrando nova empresa!!");

		String nomeEmpresa = request.getParameter("nome");
		
		Empresa empresa = new Empresa();
		empresa.setNome(nomeEmpresa);
		
		Banco banco = new Banco();
		banco.adicionar(empresa);

		//Chamar o JSP 
		RequestDispatcher rd = request.getRequestDispatcher("/novaEmpresaCriada.jsp");
		
		//Vincula na requisição um atributo e um valor 
		request.setAttribute("empresa", empresa.getNome());
		
		//Dispacha a requisição e a resposta
		rd.forward(request, response);
	}
	

}