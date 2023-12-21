package gt.com.tigo.accruedautomation.util.controller;

import gt.com.tigo.accruedautomation.dto.TigoResponseDto;
import gt.com.tigo.accruedautomation.util.service.AbstractCatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

public abstract class AbstractCatalogController<T, U extends AbstractCatalogService> extends AbstractController<T, U> {

    @Autowired
    protected U service;

    @GetMapping("/catalog")
    public abstract ResponseEntity<TigoResponseDto> getCatalog();

}
