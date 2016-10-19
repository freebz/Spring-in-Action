// 코드 9.4  SpitterRepository로부터 UserDetails 객체 얻어 오기

package spittr.security;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import org.springframework.security.core.userdetails.UsernameNotFoundException;

import spittr.Spittr;
import spittr.data.SpitterRepository;

public class SpitterUserService implements UserDetailService {

    private final SpitterRepository spitterRepository;

    public SpitterUserService(SpitterRepository spitterRepository) {  // SpitterRepository 주입
	this.spitterRepository = spitterRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username)
	throws UsernameNotFoundException {

	Spitter spitter = spitterRepository.findByUsername(username);  // Spitter 검색
	if (spitter != null) {
	    List<GrantedAuthority> authorities =
		new ArrayList<GrantedAuthority>();
	    authorities.add(new SimpleGrantedAuthority("ROLE_SPITTER"));  // 권한 리스트 생성

	    return new User(  // 사용자 반환
			    spitter.getUsername(),
			    spitter.getPassword(),
			    authorities);
	}

	throw new UsernameNotFoundException(
					    "User '" + username + "' not found.");
    }

}
