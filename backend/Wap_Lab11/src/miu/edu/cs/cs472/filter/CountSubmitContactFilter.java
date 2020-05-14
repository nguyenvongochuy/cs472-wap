package miu.edu.cs.cs472.filter;

import java.io.IOException;
import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * Servlet Filter implementation class CountSubmitContact
 */
@WebFilter(
		dispatcherTypes = {
				DispatcherType.REQUEST, 
				//DispatcherType.FORWARD
		}
					, 
		urlPatterns = { 
				//"/*"
				"/submitcontact"
		})
public class CountSubmitContactFilter implements Filter {

    /**
     * Default constructor. 
     */
    public CountSubmitContactFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		long value = (long) request.getServletContext().getAttribute("countSubmitContact");
		value++;
		request.getServletContext().setAttribute("countSubmitContact", value);
		// pass the request along the filter chain
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		long total = 0;
		fConfig.getServletContext().setAttribute("countSubmitContact", total);
	}

}
