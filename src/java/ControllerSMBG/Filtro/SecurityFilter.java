package ControllerSMBG.Filtro;

import java.io.IOException;
import javax.faces.application.ResourceHandler;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter(filterName = "FiltroConexao", urlPatterns = {"/*"})
public class SecurityFilter implements Filter {

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp,
            FilterChain chain) throws IOException, ServletException {

        HttpServletRequest requisicao = (HttpServletRequest) req;
        HttpServletResponse resposta = (HttpServletResponse) resp;
        HttpSession sessao = requisicao.getSession(false);
        
        String loginURI = requisicao.getContextPath() + "/faces/ViewSMBG/PaginaLoginSMBG.xhtml";

        boolean logado = sessao != null && sessao.getAttribute("user") != null;
        boolean requisicaoLogin = requisicao.getRequestURI().equals(loginURI);
        boolean requisicaoRecurso = requisicao.getRequestURI().contains(requisicao.getContextPath()+ "/faces" + ResourceHandler.LOCALE_PREFIX);

        if (logado || requisicaoLogin || requisicaoRecurso) {
            chain.doFilter(requisicao, resposta);
        } else {
            resposta.sendRedirect(loginURI);
        }
    }

    @Override
    public void destroy() {
    }

    @Override
    public void init(FilterConfig arg0) throws ServletException {
        // TODO Auto-generated method stub

    }
}
