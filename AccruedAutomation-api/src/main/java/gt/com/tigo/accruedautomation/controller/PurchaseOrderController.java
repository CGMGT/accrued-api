package gt.com.tigo.accruedautomation.controller;

import gt.com.tigo.accruedautomation.dto.DataTableRequestDto;
import gt.com.tigo.accruedautomation.dto.ResourceDto;
import gt.com.tigo.accruedautomation.dto.TigoResponseDto;
import gt.com.tigo.accruedautomation.model.PurchaseOrderEntity;
import gt.com.tigo.accruedautomation.security.Authorized;
import gt.com.tigo.accruedautomation.service.PurchaseOrderService;
import gt.com.tigo.accruedautomation.util.CsvViewBuilder;
import gt.com.tigo.accruedautomation.util.controller.AbstractController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@CrossOrigin
@RestController
@RequestMapping("/purchaseorder")
public class PurchaseOrderController extends AbstractController<PurchaseOrderEntity, PurchaseOrderService> {

    private static final Logger LOGGER = LoggerFactory.getLogger(PurchaseOrderController.class);

    @Override
    public ResponseEntity<TigoResponseDto> findAll() {
        return null;
    }

    @Override
    public ResponseEntity<TigoResponseDto> findById(Long entityId) {
        return null;
    }

    @Override
    public ResponseEntity<TigoResponseDto> findByPage(@RequestBody DataTableRequestDto dataTableRequestDto) {
        LOGGER.debug(String.format("@%s::findByPage(%s)", this.getClass().getName(), dataTableRequestDto));

        try {
            return ResponseEntity.ok(new TigoResponseDto(super.service.findByPage(dataTableRequestDto)));
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new TigoResponseDto(HttpStatus.INTERNAL_SERVER_ERROR.value(), ex.getMessage()));
        }
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
    public ResponseEntity<TigoResponseDto> create(PurchaseOrderEntity entity, Long requesterId) {
        return null;
    }

    @Override
    public ResponseEntity<TigoResponseDto> update(@RequestBody PurchaseOrderEntity entity,@PathVariable Long requesterId) {
        LOGGER.debug(String.format("@%s::update(PurchaseOrderEntity, %d)", this.getClass().getName(), requesterId));

        try {
            return ResponseEntity.ok(new TigoResponseDto(super.service.update(entity, requesterId)));
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new TigoResponseDto(HttpStatus.INTERNAL_SERVER_ERROR.value(), ex.getMessage()));
        }
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

    @Authorized
    @PostMapping("/file/upload")
    public ResponseEntity<TigoResponseDto> upload(@RequestParam(name = "file", required = true) MultipartFile file, @RequestParam(required = true) Long poId, @RequestParam(required = true) Long requesterId) {
        LOGGER.debug(String.format("@%s::upload(%s, %d, %d)", this.getClass().getName(), file.getName(), poId, requesterId));

        try {
            return ResponseEntity.ok(new TigoResponseDto(this.service.upload(file, poId, requesterId)));
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new TigoResponseDto(HttpStatus.INTERNAL_SERVER_ERROR.value(), ex.getMessage()));
        }
    }

    @PostMapping("/file/findAll")
    public ResponseEntity<TigoResponseDto> findFiles(@RequestBody DataTableRequestDto dataTableRequestDto) {
        LOGGER.debug(String.format("@%s::findFiles(%s)", this.getClass().getName(), dataTableRequestDto));

        try {
            return ResponseEntity.ok(new TigoResponseDto(super.service.findFiles(dataTableRequestDto)));
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new TigoResponseDto(HttpStatus.INTERNAL_SERVER_ERROR.value(), ex.getMessage()));
        }
    }

    @Authorized
    @GetMapping("/resumenPoUsuario")
    public ResponseEntity<TigoResponseDto> getData4PoChart(@RequestParam(required = true) Long requesterId) {
        LOGGER.debug(String.format("%s::getData4PoChart()", this.getClass().getName()));

        try {
            return ResponseEntity.ok(new TigoResponseDto(this.service.getData4PoChart(requesterId)));
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new TigoResponseDto(HttpStatus.INTERNAL_SERVER_ERROR.value(), ex.getMessage()));
        }
    }

    @Authorized
    @GetMapping("/resumenPoUsuarioByAmount")
    public ResponseEntity<TigoResponseDto> getData4PoByAmount(@RequestParam(required = true) Long requesterId) {
        LOGGER.debug(String.format("%s::getData4PoByAmount()", this.getClass().getName()));

        try {
            return ResponseEntity.ok(new TigoResponseDto(this.service.getData4PoByAmount(requesterId)));
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new TigoResponseDto(HttpStatus.INTERNAL_SERVER_ERROR.value(), ex.getMessage()));
        }
    }

    @Authorized
    @GetMapping("/dbKpiGeneral")
    public ResponseEntity<TigoResponseDto> getData4KpiGeneral(@RequestParam(required = true) String origen) {
        LOGGER.debug(String.format("%s::getData4KpiGeneral()", this.getClass().getName()));

        try {
            return ResponseEntity.ok(new TigoResponseDto(this.service.getData4KpiGeneral(origen)));
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new TigoResponseDto(HttpStatus.INTERNAL_SERVER_ERROR.value(), ex.getMessage()));
        }
    }

    @Authorized
    @GetMapping("/dbSaldoEstadoEmpresa")
    public ResponseEntity<TigoResponseDto> getData4SaldoEstadoEmpresa(@RequestParam(required = true) String origen) {
        LOGGER.debug(String.format("%s::getData4SaldoEstadoEmpresa()", this.getClass().getName()));

        try {
            return ResponseEntity.ok(new TigoResponseDto(this.service.getData4SaldoEstadoEmpresa(origen)));
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new TigoResponseDto(HttpStatus.INTERNAL_SERVER_ERROR.value(), ex.getMessage()));
        }
    }

    @Authorized
    @GetMapping("/dbAntiguedadAcciones")
    public ResponseEntity<TigoResponseDto> getData4AntiguedadAcciones(@RequestParam(required = true) String origen) {
        LOGGER.debug(String.format("%s::getData4AntiguedadAcciones()", this.getClass().getName()));

        try {
            return ResponseEntity.ok(new TigoResponseDto(this.service.getData4AntiguedadAcciones(origen)));
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new TigoResponseDto(HttpStatus.INTERNAL_SERVER_ERROR.value(), ex.getMessage()));
        }
    }

    @Authorized
    @GetMapping("/dbSaldoVencidoProveedor")
    public ResponseEntity<TigoResponseDto> getData4SaldoVencidoProveedor(@RequestParam(required = true) String origen) {
        LOGGER.debug(String.format("%s::getData4SaldoVencidoProveedor()", this.getClass().getName()));

        try {
            return ResponseEntity.ok(new TigoResponseDto(this.service.getData4SaldoVencidoProveedor(origen)));
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new TigoResponseDto(HttpStatus.INTERNAL_SERVER_ERROR.value(), ex.getMessage()));
        }
    }

    @Authorized
    @GetMapping("/dbSaldoVencidoRequester")
    public ResponseEntity<TigoResponseDto> getData4SaldoVencidoRequester(@RequestParam(required = true) String origen) {
        LOGGER.debug(String.format("%s::getData4SaldoVencidoRequester()", this.getClass().getName()));

        try {
            return ResponseEntity.ok(new TigoResponseDto(this.service.getData4SalvoVencidoRequester(origen)));
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new TigoResponseDto(HttpStatus.INTERNAL_SERVER_ERROR.value(), ex.getMessage()));
        }
    }

    @Authorized
    @GetMapping("/dbOpexCapex")
    public ResponseEntity<TigoResponseDto> getData4OpexCapex(@RequestParam(required = true) String origen) {
        LOGGER.debug(String.format("%s::getData4OpexCapex()", this.getClass().getName()));

        try {
            return ResponseEntity.ok(new TigoResponseDto(this.service.getData4SOpexCapex(origen)));
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new TigoResponseDto(HttpStatus.INTERNAL_SERVER_ERROR.value(), ex.getMessage()));
        }
    }

    @Authorized
    @GetMapping("/dbEstadosJustificaciones")
    public ResponseEntity<TigoResponseDto> getData4EstadosJustificaciones(@RequestParam(required = true) String origen, @RequestParam(required = true) String usuario) {
        LOGGER.debug(String.format("%s::getData4EstadosJustificaciones()", this.getClass().getName()));

        try {
            return ResponseEntity.ok(new TigoResponseDto(this.service.getData4EstadoJustificaciones(origen, usuario)));
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new TigoResponseDto(HttpStatus.INTERNAL_SERVER_ERROR.value(), ex.getMessage()));
        }
    }

    @Authorized
    @GetMapping("/totalkpiempresa")
    public ResponseEntity<TigoResponseDto> getData4TotalKpiEmpresa(@RequestParam(required = true) Long requesterId, @RequestParam(required = true) String empresa) {
        LOGGER.debug(String.format("%s::getData4TotalKpiEmpresa()", this.getClass().getName()));

        try {
            return ResponseEntity.ok(new TigoResponseDto(this.service.getData4TotalKpiEmpresa(requesterId, empresa)));
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new TigoResponseDto(HttpStatus.INTERNAL_SERVER_ERROR.value(), ex.getMessage()));
        }
    }

    @Authorized
    @GetMapping("/empresas")
    public ResponseEntity<TigoResponseDto> getEmpresas() {
        LOGGER.debug(String.format("%s::getEmpresas()", this.getClass().getName()));

        try {
            return ResponseEntity.ok(new TigoResponseDto(this.service.getEmpresas()));
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new TigoResponseDto(HttpStatus.INTERNAL_SERVER_ERROR.value(), ex.getMessage()));
        }
    }

    @Authorized
    @GetMapping("/detallekpiempresa")
    public ResponseEntity<TigoResponseDto> getData4DetalleKpiEmpresa(@RequestParam(required = true) Long requesterId) {
        LOGGER.debug(String.format("%s::getData4DetalleKpiEmpresa()", this.getClass().getName()));

        try {
            return ResponseEntity.ok(new TigoResponseDto(this.service.getData4DetalleKpiEmpresa(requesterId)));
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new TigoResponseDto(HttpStatus.INTERNAL_SERVER_ERROR.value(), ex.getMessage()));
        }
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
