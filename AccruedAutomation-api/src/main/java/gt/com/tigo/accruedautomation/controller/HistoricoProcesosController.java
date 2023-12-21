package gt.com.tigo.accruedautomation.controller;

import gt.com.tigo.accruedautomation.dto.DataTableRequestDto;
import gt.com.tigo.accruedautomation.dto.ResourceDto;
import gt.com.tigo.accruedautomation.dto.TigoResponseDto;
import gt.com.tigo.accruedautomation.model.HistoricoProcesosEntity;
import gt.com.tigo.accruedautomation.security.Authorized;
import gt.com.tigo.accruedautomation.service.HistoricoProcesosService;
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
@RequestMapping("/historicoProcesos")
public class HistoricoProcesosController extends AbstractController<HistoricoProcesosEntity, HistoricoProcesosService> {

    private static final Logger LOGGER = LoggerFactory.getLogger(HistoricoProcesosController.class);


    @Override
    public ResponseEntity<TigoResponseDto> findAll() {
        return null;
    }

    @Override
    public ResponseEntity<TigoResponseDto> findById(Long entityId) {
        return null;
    }

    @Override
    @Authorized
    public ResponseEntity<TigoResponseDto> findByPage(@RequestBody DataTableRequestDto dataTableRequestDto) {
        LOGGER.debug(String.format("@%s::findByPage(%s)", this.getClass().getName(), dataTableRequestDto));

        try {
            return ResponseEntity.ok(new TigoResponseDto(super.service.findByPage(dataTableRequestDto)));
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new TigoResponseDto(HttpStatus.INTERNAL_SERVER_ERROR.value(), ex.getMessage()));
        }
    }

    @Override
    public ResponseEntity<TigoResponseDto> create(HistoricoProcesosEntity entity, Long requesterId) {
        return null;
    }

    @Override
    public ResponseEntity<TigoResponseDto> update(HistoricoProcesosEntity entity, Long requesterId) {
        return null;
    }

    @Override
    public ResponseEntity<TigoResponseDto> deleteById(Long entityId, Long requesterId) {
        return null;
    }

    @Override
    @Authorized
    public ModelAndView exportToXlsx(@RequestBody(required = true) DataTableRequestDto dataTableRequestDto) {
        LOGGER.debug(String.format("@%s::exportToXlsx(%s)", this.getClass().getName(), dataTableRequestDto));

        try {
            return super.service.exportXlsx(dataTableRequestDto);
        } catch (Exception ex) {
            LOGGER.error(ex.getMessage());

            return null;
        }
    }

    @Override
    @Authorized
    public ResponseEntity<ByteArrayResource> exportToCsv(@RequestBody(required = true) DataTableRequestDto dataTableRequestDto) {
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

    @Authorized
    @GetMapping("/getStatus")
    public ResponseEntity<TigoResponseDto> getStatus() {
        LOGGER.debug(String.format("@%s::getStatus()", this.getClass().getName()));

        try {
            return ResponseEntity.ok(new TigoResponseDto(this.service.getStatus()));
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new TigoResponseDto(HttpStatus.INTERNAL_SERVER_ERROR.value(), ex.getMessage()));
        }
    }

    @Authorized
    @GetMapping("/getUserProceso")
    public ResponseEntity<TigoResponseDto> getUserProcesos(@RequestParam String usuario) {
        LOGGER.debug(String.format("@%s::getUserProcesos(%s)", this.getClass().getName(), usuario));

        try {
            return ResponseEntity.ok(new TigoResponseDto(this.service.getUserProcesos(usuario)));
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new TigoResponseDto(HttpStatus.INTERNAL_SERVER_ERROR.value(), ex.getMessage()));
        }
    }


    @Authorized
    @GetMapping("/getNombreProceso")
    public ResponseEntity<TigoResponseDto> getNombreProceso(@RequestParam String nombre) {
        LOGGER.debug(String.format("@%s::getUserProcesos(%s)", this.getClass().getName(), nombre));

        try {
            return ResponseEntity.ok(new TigoResponseDto(this.service.getNombreProceso(nombre)));
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new TigoResponseDto(HttpStatus.INTERNAL_SERVER_ERROR.value(), ex.getMessage()));
        }
    }

    @Authorized
    @GetMapping("/validateProcess")
    public ResponseEntity<TigoResponseDto> validateProcess(@RequestParam String typeProcess) {
        LOGGER.debug(String.format("@%s::validateProcess(%s)", this.getClass().getName(), typeProcess));

        try {
            return ResponseEntity.ok(this.service.getMostRecentProcess(typeProcess));
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new TigoResponseDto(HttpStatus.INTERNAL_SERVER_ERROR.value(), ex.getMessage()));
        }
    }
}
