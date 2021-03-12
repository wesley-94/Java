package org.edwith.webbe.securityexam.service.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

public class CustomUserDetailsService implements UserDetailsService {

	// CustomUserDbService는 인터페이스 / 해당 인터페이스를 구현하고 있는 객체가 Bean으로 등록되어 있어야 함
	@Autowired
	UserDbService userdbService;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// loginId에 해당하는 정보를 데이터베이스에서 읽어 CustomUser 객체에 저장
		// 해당 정보를 CustomUserDetails 객체에 저장
		
		UserEntity customUser = userdbService.getUser(loginUserId);
		if (customUser == null)
			throw new UsernameNotFoundException("사용자가 입력한 아이디에 해당하는 사용자를 찾을 수 없습니다.");
			
		CustomUserDetails customUserDetails = new CustomUserDetails();
		customUserDetails.setUsername(customUser.getLoginUserId());
		customUserDetails.setPassword(customUser.getPassword());
		
		List<UserRoleEntity> customRoles = userdbService.getUserRoles(loginUserId);
		// 로그인한 사용자의 권한 정보를 GrantedAuthority를 구현하고 있는 SimpleGrantedAuthority 객체에 담아
		// 리스트에 추가한다. MemberRole 이름은 "ROLE_"로 시작되어야 함
		List<GrantedAuthority> authorities = new ArrayList<>();
		if (customRoles != null) {
			for (UserRoleEntity customRole : customRoles) {
				authorities.add(new SimpleGrantedAuthority(customRole.getRoleName()));
			}
		}
		
		// CustomUserDetails 객체에 권한 목록(authorities)을 설정
		customUserDetails.setAuthorities(authorities);
		customUserDetails.setEnabled(true);
		customUserDetails.setAccountNonExpired(true);
		customUserDetails.setAccountNonLocked(true);
		customUserDetails.setCredentialsNonExpired(true);
		return customUserDetails;
	}
}
