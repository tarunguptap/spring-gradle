package com.spring.transformer.inf.impl;


import org.springframework.stereotype.Component;

import com.spring.transformer.dto.ExternalUserSearchDTO;
import com.spring.transformer.dto.UserDTO;
import com.spring.transformer.inf.Transformer;

@Component("externalUserTransformer")
public class ExternalUserTransformer implements Transformer<ExternalUserSearchDTO, UserDTO> {

    @Override
    public UserDTO converts(ExternalUserSearchDTO externalUserSearchDTO) {
        
    	UserDTO userDTO = new UserDTO(externalUserSearchDTO.getUserId(), externalUserSearchDTO.getUsername(), 
    			externalUserSearchDTO.getPassword(), externalUserSearchDTO.getActive(), 0L, externalUserSearchDTO.getRole());
        return userDTO;
    }     

}
