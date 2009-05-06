package cn.orz.pascal.gae

import javax.servlet.http.{HttpServlet, HttpServletResponse, HttpServletRequest}
import com.google.appengine.api.users.{User, UserService, UserServiceFactory}

class HelloServlet extends HttpServlet {
  override def doGet(req : HttpServletRequest, resp : HttpServletResponse) = {
    val userService = UserServiceFactory.getUserService()
    val user = userService.getCurrentUser()
    
    if (user != null) {
      resp.setContentType("text/plain");
      resp.getWriter().println("Hello, " + user.getNickname() + ". " + "Wellcome Scala on GAE!");
    } else {
      resp.sendRedirect(userService.createLoginURL(req.getRequestURI()));
    }    
  }
}
