package gt.com.tigo.accruedautomation.controller;

import gt.com.tigo.accruedautomation.dto.DataTableRequestDto;
import gt.com.tigo.accruedautomation.dto.ResourceDto;
import gt.com.tigo.accruedautomation.dto.TigoResponseDto;
import gt.com.tigo.accruedautomation.service.VRepPoHistoricoService;
import gt.com.tigo.accruedautomation.util.CsvViewBuilder;
import gt.com.tigo.accruedautomation.util.controller.AbstractController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@CrossOrigin
@RestController
@RequestMapping("/reppurchaseorder")
public class VRepPoHistoricoController extends AbstractController<VRepPoHistoricoController, VRepPoHistoricoService> {

    private static final Logger LOGGER = LoggerFactory.getLogger(VRepPoHistoricoController.class);

    @Override
    public ResponseEntity<TigoResponseDto> findAll() {
        return null;
    }

    @Override
    public ResponseEntity<TigoResponseDto> findById(Long entityId) {
        return null;
    }

    @Override
    public ResponseEntity<TigoResponseDto> findByPage(DataTableRequestDto dataTableRequestDto) {
        return null;
    }

    @PostMapping("/findByPage/{id}")
    public ResponseEntity<TigoResponseDto> findByPage(@RequestBody DataTableRequestDto dataTableRequestDto, @PathVariable Long id) {
        LOGGER.debug(String.format("@%s::findByPage(%s, %d)", this.getClass().getName(), dataTableRequestDto, id));

        try {
            return ResponseEntity.ok(new TigoResponseDto(super.service.findByPage(dataTableRequestDto, id)));
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new TigoResponseDto(HttpStatus.INTERNAL_SERVER_ERROR.value(), ex.getMessage()));
        }
    }

    @Override
    public ResponseEntity<TigoResponseDto> create(VRepPoHistoricoController entity, Long requesterId) {
        return null;
    }

    @Override
    public ResponseEntity<TigoResponseDto> update(VRepPoHistoricoController entity, Long requesterId) {
        return null;
    }

    @Override
    public ResponseEntity<TigoResponseDto> deleteById(Long entityId, Long requesterId) {
        return null;
    }

    @Override
    public ModelAndView exportToXlsx(@RequestBody DataTableRequestDto dataTableRequestDto) {
        LOGGER.debug(String.format("@%s::exportToXlsx(%s)", this.getClass().getName(), dataTableRequestDto));

        try {
            return super.service.exportXlsx(dataTableRequestDto);
        } catch (Exception ex) {
            LOGGER.error(ex.getMessage());

            return null;
        }
    }

    @Override
    public ResponseEntity<ByteArrayResource> exportToCsv(@RequestBody DataTableRequestDto dataTableRequestDto) {
        LOGGER.debug(String.format("@%s::exportToCsv(%s)", this.getClass().getName(), dataTableRequestDto));

        try {
            ResourceDto resourceDto = this.service.exportCsv(dataTableRequestDto);

            return ResponseEntity.ok()
                    .headers(CsvViewBuilder.HEADERS)
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=" + resourceDto.getFilename())
                    .contentType(resourceDto.getMediaType())
                    .contentLength(resourceDto.getLength())
                    .body(resourceDto.getResource());
        } catch (Exception ex) {
            LOGGER.error(ex.getMessage());

            return null;
        }
    }

    @Override
    public ResponseEntity<TigoResponseDto> count(DataTableRequestDto dataTableRequestDto) {
        return null;
    }

    @PostMapping("/exportOrigen/xlsx/{id}")
    public ModelAndView exportOrigenToXlsx(@RequestBody DataTableRequestDto dataTableRequestDto, @PathVariable Long id) {
        LOGGER.debug(String.format("@%s::exportOrigenToXlsx(%s, %d)", this.getClass().getName(), dataTableRequestDto, id));

        try {
            return super.service.exportOrigenXlsx(dataTableRequestDto, id);
        } catch (Exception ex) {
            LOGGER.error(ex.getMessage());

            return null;
        }
    }

    @PostMapping("/exportOrigen/csv/{id}")
    public ResponseEntity<ByteArrayResource> exportOrigenToCsv(@RequestBody DataTableRequestDto dataTableRequestDto, @PathVariable Long id) {
        LOGGER.debug(String.format("@%s::exportOrigenToCsv(%s, %d)", this.getClass().getName(), dataTableRequestDto, id));

        try {
            ResourceDto resourceDto = this.service.exportOrigenCsv(dataTableRequestDto, id);

            return ResponseEntity.ok()
                    .headers(CsvViewBuilder.HEADERS)
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=" + resourceDto.getFilename())
                    .contentType(resourceDto.getMediaType())
                    .contentLength(resourceDto.getLength())
                    .body(resourceDto.getResource());
        } catch (Exception ex) {
            LOGGER.error(ex.getMessage());

            return null;
        }
    }
}
