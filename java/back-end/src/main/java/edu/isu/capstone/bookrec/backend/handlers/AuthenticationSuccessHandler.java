package edu.isu.capstone.bookrec.backend.handlers;

//public class AuthenticationSuccessHandler implements org.springframework.security.web.authentication.AuthenticationSuccessHandler {
//
//    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
//
//    @Override
//    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
//                                        Authentication authentication) throws IOException, ServletException {
//
//        String redirectURL = determineRedirectURL(authentication);
//        redirectStrategy.sendRedirect(httpServletRequest, httpServletResponse, redirectURL);
//        clearAuthenticationAttributes(httpServletRequest);
//    }
//
//    protected String determineRedirectURL(Authentication authentication) {
//        Object principal = authentication.getPrincipal();
//        if (principal instanceof UserDetailsImpl) {
//            Long id = ((UserDetailsImpl)principal).getId();
//            return String.format("/user/%s", id); //TODO: Modify to correctly reflect current business logic
//        } else {
//            throw new IllegalStateException();
//        }
//    }
//
//    protected void clearAuthenticationAttributes(HttpServletRequest request) {
//        HttpSession session = request.getSession(false);
//        if (session == null) {
//            return;
//        }
//        session.removeAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
//    }
//
//}
