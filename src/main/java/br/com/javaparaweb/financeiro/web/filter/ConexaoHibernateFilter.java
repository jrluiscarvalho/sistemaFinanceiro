package br.com.javaparaweb.financeiro.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import br.com.javaparaweb.financeiro.util.HibernateUtil;

@WebFilter(urlPatterns = { "*.jsf" })
public class ConexaoHibernateFilter implements Filter {
	private SessionFactory sf;

	public void init(FilterConfig config) throws ServletException {
		this.sf = HibernateUtil.getSessionFactory();
	}

	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
			throws IOException, ServletException {
		Session currentSession = this.sf.getCurrentSession();
		
		Transaction transaction = null;
		
		try {
			transaction = currentSession.beginTransaction();
			filterChain.doFilter(servletRequest, servletResponse);
			transaction.commit();
			if (currentSession.isOpen()) {
				currentSession.close();
			}
		} catch (Throwable ex) {
			try {
				if (transaction.isActive()) {
					transaction.rollback();
				} 
				
			} catch (Throwable t) {
				t.printStackTrace();
			}
			throw new ServletException(ex);
		}
	}
	
	public void destroy() {	}

}
