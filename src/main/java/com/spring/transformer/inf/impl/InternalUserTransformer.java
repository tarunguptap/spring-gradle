package com.spring.transformer.inf.impl;


import org.springframework.stereotype.Component;

import com.spring.transformer.dto.InternalUserSearchDTO;
import com.spring.transformer.dto.UserDTO;
import com.spring.transformer.inf.Transformer;

/**
 * @author 
 *
 */
@Component("internalUserTransformer")
public class InternalUserTransformer implements Transformer<InternalUserSearchDTO, UserDTO> {

    @Override
    public UserDTO converts(InternalUserSearchDTO internalUserSearchDTO) {
        
    	UserDTO userDTO = new UserDTO(internalUserSearchDTO.getUserId(), internalUserSearchDTO.getUsername(), 
    			internalUserSearchDTO.getPassword(), internalUserSearchDTO.getActive(), 0L, internalUserSearchDTO.getRole() );
        return userDTO;
    }

}
