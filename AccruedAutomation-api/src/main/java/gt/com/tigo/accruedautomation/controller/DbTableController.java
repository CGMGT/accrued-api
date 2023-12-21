package gt.com.tigo.accruedautomation.controller;

import gt.com.tigo.accruedautomation.dto.TigoResponseDto;
import gt.com.tigo.accruedautomation.service.DbTableService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/table-definition")
public class DbTableController {

    private static final Logger LOGGER = LoggerFactory.getLogger(DbTableController.class);

    @Autowired
    private DbTableService dbTableService;

    @GetMapping("/findColumnLabels")
    public ResponseEntity<TigoResponseDto> getColumnLabelsByTableName(@RequestParam String tableName) {
        LOGGER.debug("@{}::getColumnLabelsByTableName({})", this.getClass().getName(), tableName);

        try {
            return ResponseEntity.ok(new TigoResponseDto(this.dbTableService.getColumnLabelsByTableName(tableName)));
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new TigoResponseDto(HttpStatus.INTERNAL_SERVER_ERROR.value(), ex.getMessage()));
        }
    }

}
