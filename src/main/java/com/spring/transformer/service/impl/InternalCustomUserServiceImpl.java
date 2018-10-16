package com.spring.transformer.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.stereotype.Service;

import com.spring.dao.UserDAO;
import com.spring.domain.User;
import com.spring.error.CustomError;
import com.spring.exception.ValidationException;
import com.spring.transformer.dto.InternalUserSearchDTO;
import com.spring.transformer.service.CustomUserService;

@Service("internalCustomUserService")
public class InternalCustomUserServiceImpl implements CustomUserService<InternalUserSearchDTO> {

    @Autowired
    private UserDAO userDAO;
    
    private MessageSourceAccessor messageSourceAccessor;
    
    @Override
    public InternalUserSearchDTO searchUser(Long userId) {
        User user = userDAO.findByPK(userId);
        if(user == null) {
            throw new ValidationException(CustomError.ErrorCode.USER_NOT_FOUND.getErrorCode(),
                    messageSourceAccessor.getMessage("error.user.not.found"));
        }
        
        String role = user.getRoles().iterator().next().getType().toString();
        InternalUserSearchDTO internalUserSearchDTO = new InternalUserSearchDTO(user.getId(), user.getUsername(), user.getPassword(), 
                user.getActive(), user.getDeleted(), role);
        return internalUserSearchDTO;
    }
     
}
