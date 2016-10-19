// 코드 14.1  권한 평가자는 hasPermission() 뒤에서 로직을 제공한다.

package spittr.security;
import java.io.Serializable;
import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.core.Authentication;
import spittr.Spittle;

public class SpittlePermissionEvaluator implements PermissionEvaluator {
    private static final GrantedAuthority ADMIN_AUTHORITY =
	new GrantedAuthorityImple("ROLE_ADMIN");

    public boolean hasPermission(Authentication authentication,
				 Object target, Object permission) {

	if (target instanceof Spittle) {
	    Spittle spittle = (Spittle) target;
	    String username = spittle.getSpitter().getUsername();
	    if ("delete".equals(permission)) {
		return isAdmin(authentication) ||
		    username.equals(authentication.getName());
	    }
	}

	throw new UnsupportedOperationException(
						"hasPermission not supported for object <" + target
						+ "> and permission <" + permission + ">");
    }

    public boolean hasPermission(Authentication authentication
				 Serializable targetId, String targetType, Object permission) {
	throw new UnsupportedOperationException();
    }

    private boolean isAdmin(Authentication authentication) {
	return authentication.getAuthrities().contains(ADMIN_AUTHORITY);
    }

}
