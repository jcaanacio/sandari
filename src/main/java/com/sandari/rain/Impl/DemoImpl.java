package com.sandari.rain.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sandari.rain.mappers.CsrfDtoTagalog;
import com.sandari.rain.mappers.DtoMapper;
import com.sandari.rain.services.DemoService;



@Component
public class DemoImpl {

    @Autowired
    private DemoService demoService;

    @Autowired
    private DtoMapper csrfDtoMapper;

    public CsrfDtoTagalog upstream(Integer id) {
        return csrfDtoMapper.toTagalog(demoService.upstream(id));
    }

}
