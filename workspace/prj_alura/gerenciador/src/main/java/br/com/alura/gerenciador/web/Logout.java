package br.com.alura.gerenciador.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns = "/logout")
public class Logout extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		Cookie cookie = new Cookies(req.getCookies()).getUsuarioLogado();
	    HttpSession session = req.getSession();

		if (cookie != null) {
			cookie.setMaxAge(0);
			resp.addCookie(cookie);
			session.removeAttribute("usuario.logado");
			session.invalidate();
		}

		PrintWriter writer = resp.getWriter();
		writer.println("<html><body>Logout efetuado</body></html>");
	}
}