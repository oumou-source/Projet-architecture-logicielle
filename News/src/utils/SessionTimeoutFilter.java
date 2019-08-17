package utils;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;


/**
* 
* A la fin de la session l'utilisateur est redirig� vers la page d'authentification
*
*/

public class SessionTimeoutFilter implements Filter {
		
		static Logger logger = Logger.getLogger(SessionTimeoutFilter.class);	
		private String timeoutPage = "index.jsp";
		
		public void init(FilterConfig filterConfig) throws ServletException {
		}
		
		public void doFilter(ServletRequest request,ServletResponse response, FilterChain filterChain) throws IOException,ServletException {
			if ((request instanceof HttpServletRequest)&& (response instanceof HttpServletResponse)) {
				HttpServletRequest httpServletRequest = (HttpServletRequest) request;
				HttpServletResponse httpServletResponse = (HttpServletResponse) response;				

				// si la session est invalide				
				if (isSessionInvalid(httpServletRequest) ) {
					String timeoutUrl = httpServletRequest.getContextPath()+ "/" + getTimeoutPage();
					logger.info("La Session n'est plus valide!");
					httpServletResponse.sendRedirect(timeoutUrl);
					return;
				}
						
			}
			filterChain.doFilter(request, response);
		}
		
		private boolean isSessionInvalid(HttpServletRequest httpServletRequest) {
			boolean sessionInValid = (httpServletRequest.getRequestedSessionId() != null)&& !httpServletRequest.isRequestedSessionIdValid();
			return sessionInValid;
		}
		
		public void destroy() {
		}
		
		public String getTimeoutPage() {		
			return timeoutPage;	
		}
		
		public void setTimeoutPage(String timeoutPage) {	
			this.timeoutPage = timeoutPage;
		}
}