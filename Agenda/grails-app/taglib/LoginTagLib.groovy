
import agenda.Usuario
import agenda.PapelSec

class LoginTagLib {
    def springSecurityService
    def loginControl = {
        def userRole = PapelSec.findByAuthority("ROLE_USER")
        
        try { if (springSecurityService.isLoggedIn()) {
                def user = springSecurityService.getCurrentUser()
                if (user.getAuthorities().contains(userRole)) {
                    out << user.nome
                }
                out << """ [${link(controller: "logout"){"Logout"}}]"""
            } } catch(Exception e) {
            e.printStackTrace();
        }
    
    }
}