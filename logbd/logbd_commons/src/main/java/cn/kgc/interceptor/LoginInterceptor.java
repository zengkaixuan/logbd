package cn.kgc.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * preHandle在业务处理器处理请求之前被调用; postHandle在业务处理器处理请求执行完成后,生成视图之前执行;
 * afterCompletion在DispatcherServlet完全处理完请求后被调用, 可用于清理资源等
 * 。afterCompletion()执行完成后开始渲染页面
 * 
 * @author tom preHandle-->/emp/conditonList-->postHandle-->生成ListEmp.jsp(html)
 *         -->afterCompletion --->向浏览器回传html
 */

public class LoginInterceptor implements HandlerInterceptor {

	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object arg2, Exception arg3)
			throws Exception {

	}

	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object arg2, ModelAndView arg3)
			throws Exception {

	}

	@Override
	/**
	 * return true :不拦截， 放行，调用业务组件/emp/condition
	 */
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		Object user = request.getSession().getAttribute("user");
		if (user != null) {
			// 已经登陆
			return true;
		}
		String requestType = request.getHeader("X-Requested-With"); 
		if("XMLHttpRequest".equals(requestType)){
			response.getWriter().print("NO_LOGIN");
			return false;
		}
		// 绑定错误信息，转发到Login.jsp
		request.setAttribute("msg", "超时,请重新登录");
		// request.getServletContext().getContextPath();
		request.getRequestDispatcher("/login")
				.forward(request, response);
		return false;
	}

}
