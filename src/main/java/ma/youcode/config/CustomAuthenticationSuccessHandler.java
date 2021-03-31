package ma.youcode.config;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import ma.youcode.model.User;
import ma.youcode.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;


@Component
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    @Autowired
    private UserService userService;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
            throws IOException {

        System.out.println("\n\nIn customAuthenticationSuccessHandler\n\n");

        String email = authentication.getPrincipal().toString();
        System.out.println(email);

        System.out.println("email=" + email);
        System.out.println("================================");
        System.out.println("================================");
        System.out.println("================================");
        System.out.println("================================");
        System.out.println("================================");

        User user = userService.findByEmail(email);

        // now place in the session
        HttpSession session = request.getSession();
        session.setAttribute("user", user);

        // forward to home page

        response.sendRedirect(request.getContextPath() + "/reservation");
    }

}

