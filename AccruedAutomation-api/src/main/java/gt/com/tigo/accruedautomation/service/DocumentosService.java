package gt.com.tigo.accruedautomation.service;

import gt.com.tigo.accruedautomation.dao.DocumentosRepository;
import gt.com.tigo.accruedautomation.dto.DataTableRequestDto;
import gt.com.tigo.accruedautomation.dto.FilterInfoDto;
import gt.com.tigo.accruedautomation.dto.PaginatedDataDto;
import gt.com.tigo.accruedautomation.dto.ResourceDto;
import gt.com.tigo.accruedautomation.model.DocumentosEntity;

import gt.com.tigo.accruedautomation.util.SpecFactory;
import gt.com.tigo.accruedautomation.util.exception.*;
import gt.com.tigo.accruedautomation.util.service.AbstractService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import static gt.com.tigo.accruedautomation.util.SpecFactory.*;

@Service
public class DocumentosService extends AbstractService<DocumentosEntity, DocumentosRepository> {

    private static final Logger LOGGER = LoggerFactory.getLogger(TestService.class);
    private static final String NOMBRE = "nombre";
    @Override
    protected Specification buildFilterSpecification(DataTableRequestDto dataTableRequestDto) throws InvalidFilterException {
        try {
            Map<String, FilterInfoDto> filtersInfo = super.buildFiltersInfo(dataTableRequestDto);

            // create filter specifications
            Specification idEntidadSpec = SpecFactory.<DocumentosEntity>getEqualSpecification("idEntidad", getValueAsLong(filtersInfo, "idEntidad"));
            Specification tipoEntidadSpec = SpecFactory.<DocumentosEntity>getLikeSpecification("tipoEntidad", getValueAsString(filtersInfo, "tipoEntidad"));
            Specification nombreSpec = SpecFactory.<DocumentosEntity>getLikeSpecification(NOMBRE, getValueAsString(filtersInfo, NOMBRE));

            // assemble filter specifications
            return Specification
                    .where(getDefaultSpecification())
                    .and(idEntidadSpec)
                    .and(tipoEntidadSpec)
                    .and(nombreSpec);

        } catch (Exception ex) {
            LOGGER.error(ex.getMessage());

            throw new InvalidFilterException();
        }
    }

    @Override
    public DocumentosEntity create(DocumentosEntity entity, Long requesterId) throws RequesterNotFoundException, ResourceCreateException {
        LOGGER.debug(String.format("@%s::create(%s, %d)", this.getClass().getName(), entity, requesterId));

        entity.setEstado("A");

        return super._create(entity, requesterId);
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
    public DocumentosEntity deleteById(Long entityId, Long requesterId) throws RequesterNotFoundException, ResourceNotFoundException, ResourceUpdateException {
        return null;
    }

    @Override
    public List<DocumentosEntity> findAll() throws ResourcesNotFoundException {
        return Collections.emptyList();
    }

    @Override
    public DocumentosEntity findById(Long id) throws ResourceNotFoundException {
        LOGGER.debug(String.format("%s::findById(%d)", this.getClass().getName(), id));

        return super._findById(id);
    }

    @Override
    public PaginatedDataDto<DocumentosEntity> findByPage(DataTableRequestDto dataTableRequestDto) throws ResourcesNotFoundException, InvalidFilterException {
        LOGGER.debug(String.format("@%s::findByPage(%s)", this.getClass().getName(), dataTableRequestDto));

        return super._findByPage(dataTableRequestDto, NOMBRE);
    }

    @Override
    public DocumentosEntity update(DocumentosEntity entity, Long requesterId) throws RequesterNotFoundException, ResourceUpdateException {
        return null;
    }

    @Override
    public ModelAndView exportXlsx(DataTableRequestDto dataTableRequestDto) throws ResourcesNotFoundException, InvalidFilterException {
        return null;
    }

}
