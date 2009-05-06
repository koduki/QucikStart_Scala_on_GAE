package cn.orz.pascal.gae

import javax.servlet.http.{HttpServlet, HttpServletResponse, HttpServletRequest}
import com.google.appengine.api.users.{User, UserService, UserServiceFactory}

class HelloServlet extends HttpServlet {
  override def doGet(req : HttpServletRequest, resp : HttpServletResponse) = {
    val userService = UserServiceFactory.getUserService()
    val user = userService.getCurrentUser()
    
    if (user != null) {
      resp.setContentType("text/html")
      resp.getWriter().println(
	<html>
	<head><title>Hello World</title></head>
	<body>
	<h1>Wellcome { user.getNickname() } !</h1>
	<p>Hello World with GAE </p>
	</body>
	</html>
      )
    } else {
      resp.sendRedirect(userService.createLoginURL(req.getRequestURI()));
    }    
  }
}
