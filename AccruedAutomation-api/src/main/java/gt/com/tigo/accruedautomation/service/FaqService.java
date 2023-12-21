package gt.com.tigo.accruedautomation.service;

import gt.com.tigo.accruedautomation.dao.FaqRepository;
import gt.com.tigo.accruedautomation.dto.DataTableRequestDto;
import gt.com.tigo.accruedautomation.dto.FilterInfoDto;
import gt.com.tigo.accruedautomation.dto.PaginatedDataDto;
import gt.com.tigo.accruedautomation.dto.ResourceDto;

import gt.com.tigo.accruedautomation.model.FaqEntity;
import gt.com.tigo.accruedautomation.util.SpecFactory;
import gt.com.tigo.accruedautomation.util.exception.*;
import gt.com.tigo.accruedautomation.util.service.AbstractService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import static gt.com.tigo.accruedautomation.util.SpecFactory.getDefaultSpecification;
import static gt.com.tigo.accruedautomation.util.SpecFactory.getValueAsString;

@Service
public class FaqService extends AbstractService<FaqEntity, FaqRepository> {
    private static final Logger LOGGER = LoggerFactory.getLogger(FaqService.class);

    @Override
    protected Specification buildFilterSpecification(DataTableRequestDto dataTableRequestDto) throws InvalidFilterException {
        try {
            Map<String, FilterInfoDto> filtersInfo = super.buildFiltersInfo(dataTableRequestDto);

            // create filter specifications
            Specification categoriaSpec = SpecFactory.<FaqEntity>getLikeSpecification("categoria", getValueAsString(filtersInfo, "categoria"));
            Specification preguntaSpec = SpecFactory.<FaqEntity>getLikeSpecification("pregunta", getValueAsString(filtersInfo, "pregunta"));
            Specification respuestaSpec = SpecFactory.<FaqEntity>getLikeSpecification("respuesta", getValueAsString(filtersInfo, "respuesta"));

            // assemble filter specifications
            return Specification
                    .where(getDefaultSpecification())
                    .and(categoriaSpec)
                    .and(preguntaSpec)
                    .and(respuestaSpec);
        } catch (Exception ex) {
            LOGGER.error(ex.getMessage());

            throw new InvalidFilterException();
        }
    }

    @Override
    public FaqEntity create(FaqEntity entity, Long requesterId) throws RequesterNotFoundException, ResourceCreateException {
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
        LOGGER.debug(String.format("@%s::deleteById(%d)", this.getClass().getName(), entityId));

        return super._deleteById(entityId);
    }

    @Override
    public FaqEntity deleteById(Long entityId, Long requesterId) throws RequesterNotFoundException, ResourceNotFoundException, ResourceUpdateException {
        return null;
    }

    @Override
    public List<FaqEntity> findAll() throws ResourcesNotFoundException {
        LOGGER.debug(String.format("%s::findAll()", this.getClass().getName()));

        return super._findAll("attribute1");
    }

    @Override
    public FaqEntity findById(Long id) throws ResourceNotFoundException {
        return null;
    }

    @Override
    public PaginatedDataDto<FaqEntity> findByPage(DataTableRequestDto dataTableRequestDto) throws ResourcesNotFoundException, InvalidFilterException {
        LOGGER.debug(String.format("@%s::findByPage(%s)", this.getClass().getName(), dataTableRequestDto));

        return super._findByPage(dataTableRequestDto, "id");
    }

    @Override
    public FaqEntity update(FaqEntity entity, Long requesterId) throws RequesterNotFoundException, ResourceUpdateException {
        LOGGER.debug(String.format("@%s::update(%s, %d)", this.getClass().getName(), entity, requesterId));

        return super._update(entity, requesterId);
    }

    @Override
    public ModelAndView exportXlsx(DataTableRequestDto dataTableRequestDto) throws ResourcesNotFoundException, InvalidFilterException {
        return null;
    }
}
