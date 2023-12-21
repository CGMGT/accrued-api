package gt.com.tigo.accruedautomation.service;

import gt.com.tigo.accruedautomation.dao.PeriodosRepository;
import gt.com.tigo.accruedautomation.dto.*;
import gt.com.tigo.accruedautomation.model.PeriodosEntity;
import gt.com.tigo.accruedautomation.util.exception.*;
import gt.com.tigo.accruedautomation.util.service.AbstractCatalogService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

@Service
public class PeriodosService extends AbstractCatalogService<PeriodosEntity, PeriodosRepository> {

    private static final Logger LOGGER = LoggerFactory.getLogger(PeriodosService.class);


    @Override
    protected Specification buildFilterSpecification(DataTableRequestDto dataTableRequestDto) throws InvalidFilterException {
        return null;
    }

    @Override
    public List<CatalogDto<String, String>> getDefaultCatalog() throws ResourcesNotFoundException {
        LOGGER.debug(String.format("@%s::getCatalog()", this.getClass().getName()));

        return super._getCatalog();
    }

    @Override
    public PeriodosEntity create(PeriodosEntity entity, Long requesterId) throws RequesterNotFoundException, ResourceCreateException {
        return null;
    }

    @Override
    public ResourceDto exportCsv(DataTableRequestDto dataTableRequestDto) throws ResourcesNotFoundException, InvalidFilterException, IOException {
        return null;
    }

    @Override
    public boolean deleteById(Long entityId) throws ResourceDeleteException {
        return false;
    }

    @Override
    public PeriodosEntity deleteById(Long entityId, Long requesterId) throws RequesterNotFoundException, ResourceNotFoundException, ResourceUpdateException {
        return null;
    }

    @Override
    public List<PeriodosEntity> findAll() throws ResourcesNotFoundException {
        return Collections.emptyList();
    }

    @Override
    public PeriodosEntity findById(Long id) throws ResourceNotFoundException {
        return null;
    }

    @Override
    public PaginatedDataDto<PeriodosEntity> findByPage(DataTableRequestDto dataTableRequestDto) throws ResourcesNotFoundException, InvalidFilterException {
        return null;
    }

    @Override
    public PeriodosEntity update(PeriodosEntity entity, Long requesterId) throws RequesterNotFoundException, ResourceUpdateException {
        return null;
    }

    @Override
    public ModelAndView exportXlsx(DataTableRequestDto dataTableRequestDto) throws ResourcesNotFoundException, InvalidFilterException {
        return null;
    }

    public List<Object> getPeriodsByName(String name){
        LOGGER.debug(String.format("@%s::getPeriodsByName(%s)", this.getClass().getName(), name));

        if(name.equals("")){
            return this.repository.getCatalogRecent();
        }else{
            return this.repository.getPeriodsByName(name);
        }
    }



}
