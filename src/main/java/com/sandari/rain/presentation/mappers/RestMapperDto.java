package com.sandari.rain.presentation.mappers;

import org.springframework.stereotype.Component;

import com.sandari.rain.domain.interfaces.IDomainUser;

@Component
public class RestMapperDto {
    
    public UserRestResponse domainUserToUserRestResponse(IDomainUser dto) {
        if (dto == null) {
            return null;
        }
        return new UserRestResponse(dto.getId(), dto.getUsername(), dto.getUserRole(), dto.getCreatedAt(), dto.getUpdatedAt());
    }
}
