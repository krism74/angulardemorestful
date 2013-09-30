package ngdemo.web.rest;

import com.google.inject.Singleton;

import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/*
    Allow CORS requests.
 */
@Singleton
public class ResponseCorsFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException { }

    @Override
    public void destroy() { }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        if (servletResponse instanceof HttpServletResponse) {
            HttpServletResponse alteredResponse = ((HttpServletResponse) servletResponse);
            addHeadersFor200Response(alteredResponse);
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }

    private void addHeadersFor200Response(HttpServletResponse response) {
//        response.addHeader("Access-Control-Allow-Origin", "*");
//        response.addHeader("Access-Control-Allow-Methods", "*, Cache-Control, Pragma, Origin, Authorization, Content-Type, X-Requested-With");
//        response.addHeader("Access-Control-Allow-Headers", "*, GET, PUT, OPTIONS, X-XSRF-TOKEN");
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "Cache-Control, Pragma, Origin, Authorization, Content-Type, X-Requested-With, Accept, Accept-Version");
        response.setHeader("Access-Control-Allow-Headers", "GET, PUT, OPTIONS, X-XSRF-TOKEN");

    }
}
