package cn.kgc.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * preHandle��ҵ��������������֮ǰ������; postHandle��ҵ��������������ִ����ɺ�,������ͼ֮ǰִ��;
 * afterCompletion��DispatcherServlet��ȫ����������󱻵���, ������������Դ��
 * ��afterCompletion()ִ����ɺ�ʼ��Ⱦҳ��
 * 
 * @author tom preHandle-->/emp/conditonList-->postHandle-->����ListEmp.jsp(html)
 *         -->afterCompletion --->��������ش�html
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
	 * return true :�����أ� ���У�����ҵ�����/emp/condition
	 */
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		Object user = request.getSession().getAttribute("user");
		if (user != null) {
			// �Ѿ���½
			return true;
		}
		String requestType = request.getHeader("X-Requested-With"); 
		if("XMLHttpRequest".equals(requestType)){
			response.getWriter().print("NO_LOGIN");
			return false;
		}
		// �󶨴�����Ϣ��ת����Login.jsp
		request.setAttribute("msg", "��ʱ,�����µ�¼");
		// request.getServletContext().getContextPath();
		request.getRequestDispatcher("/login")
				.forward(request, response);
		return false;
	}

}
