package br.com.alura.gerenciador.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.alura.gerenciador.Usuario;
import br.com.alura.gerenciador.dao.UsuarioDAO;

@WebServlet(urlPatterns = "/login")
public class Login extends HttpServlet {
	static Map<String, String> USUARIOS_LOGADOS = new HashMap<>();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		PrintWriter writer = resp.getWriter();

		String email = req.getParameter("email");
		String senha = req.getParameter("senha");

		Usuario usuario = new UsuarioDAO().buscaPorEmailESenha(email, senha);

		if (usuario == null) {
			writer.println("<html><body>Usuário ou senha inválida</body></html>");
		} else {
			HttpSession session = req.getSession();
			session.setAttribute("usuario.logado", usuario);

			Cookie cookie = new Cookie("usuario.logado", email);
			cookie.setMaxAge(60 * 10); // 10 * 60 segundos, são dez minutos

			resp.addCookie(cookie);
			writer.println("<html><body>Usuário logado: " + email + "</body></html>");
		}

	}

	public String login(String usuario) {
		String codigo = System.currentTimeMillis() + ""; // exemplo de geração
															// de código fraco
		USUARIOS_LOGADOS.put(codigo, usuario);
		return codigo;
	}

}
