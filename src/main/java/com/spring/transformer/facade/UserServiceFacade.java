
package com.spring.transformer.facade;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.spring.transformer.dto.UserDTO;
import com.spring.transformer.service.CustomUserService;
import com.spring.transformer.dto.ExternalUserSearchDTO;
import com.spring.transformer.dto.InternalUserSearchDTO;
import com.spring.transformer.inf.Transformer;


@Service("userServiceFacade")
public class UserServiceFacade {
	private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceFacade.class);

    private boolean enableExternalUserSearch =  false;

    @Resource
    private CustomUserService<InternalUserSearchDTO> internalCustomUserService;

    @Resource
    private CustomUserService<ExternalUserSearchDTO> externalCustomUserService;

    @Resource
    private Transformer<InternalUserSearchDTO, UserDTO> internalUserTransformer;

    @Resource
    private Transformer<ExternalUserSearchDTO, UserDTO> externalUserTransformer;


    public UserDTO searchUsers(Long userid) {
    	
        InternalUserSearchDTO internalUserSearchDTO =null;
    	try{
    		if (enableExternalUserSearch) {
    		    ExternalUserSearchDTO externalUserSearchDTO = externalCustomUserService.searchUser(userid);
    		    return externalUserTransformer.converts(externalUserSearchDTO);
    		}
    		internalUserSearchDTO = internalCustomUserService.searchUser(userid);
            return internalUserTransformer.converts(internalUserSearchDTO);
       	} catch(Exception exception) {
    		LOGGER.error(exception.getMessage(), exception);
    		
    	}
    	return internalUserTransformer.converts(internalUserSearchDTO);
    }

}
