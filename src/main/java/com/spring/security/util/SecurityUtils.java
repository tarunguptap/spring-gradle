package com.spring.security.util;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

import com.spring.domain.User;
import com.spring.security.UserAwareUserDetails;

public class SecurityUtils {

	public static final User getAuthenticatedUser() {
		SecurityContext sc = SecurityContextHolder.getContext();
		User user = null;
		if (sc == null || sc.getAuthentication() == null)
			return null;

		Authentication auth = sc.getAuthentication();
		if (!(auth instanceof AnonymousAuthenticationToken)) {
		    user = ((UserAwareUserDetails) sc.getAuthentication().getPrincipal()).getUser();
		}
		
		return user;
	}

}
