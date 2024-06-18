package com.sandari.rain.mappers;

import org.springframework.stereotype.Component;

@Component
public class DtoMapper {
    public CsrfDtoTagalog toTagalog(CsrfDto dto) {
        if (dto == null) {
            return null;
        }

        CsrfDtoTagalog tagalogDto = new CsrfDtoTagalog();
        tagalogDto.setNumero(dto.getId());
        tagalogDto.setNumeroNgKasapi(dto.getUserId());
        tagalogDto.setTitulo(dto.getTitle());
        tagalogDto.setKatawan(dto.getBody());

        return tagalogDto;
    }
}
