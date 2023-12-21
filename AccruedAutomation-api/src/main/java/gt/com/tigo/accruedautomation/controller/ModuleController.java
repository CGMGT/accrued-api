package gt.com.tigo.accruedautomation.controller;

import gt.com.tigo.accruedautomation.service.ModuleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@CrossOrigin
@RestController
@RequestMapping("/module")
public class ModuleController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ModuleController.class);

    @Autowired
    private ModuleService moduleService;

    //@Authorized
    @PostMapping("/cash-management")
    public ResponseEntity processCashManagement(@RequestParam(name = "file", required = true) MultipartFile file, @RequestParam(required = true) Long requesterId) {
        LOGGER.debug(String.format("@%s::processCashManagement(%s, %d)", this.getClass().getName(), file.getName(), requesterId));

        try {
            return ResponseEntity.ok(this.moduleService.processCashManagement(file, requesterId));
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
        }
    }

    //@Authorized
    @PostMapping("/cost-management")
    public ResponseEntity processCostManagement(@RequestParam(name = "file", required = true) MultipartFile file, @RequestParam(required = true) Long requesterId) {
        LOGGER.debug(String.format("@%s::processCostManagement(%s, %d)", this.getClass().getName(), file.getName(), requesterId));

        try {
            return ResponseEntity.ok(this.moduleService.processCostManagement(file, requesterId));
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
        }
    }

    //@Authorized
    @PostMapping("/receivables")
    public ResponseEntity processReceivables(@RequestParam(name = "file", required = true) MultipartFile file, @RequestParam(required = true) Long requesterId) {
        LOGGER.debug(String.format("@%s::processReceivables(%s, %d)", this.getClass().getName(), file.getName(), requesterId));

        try {
            return ResponseEntity.ok(this.moduleService.processReceivables(file, requesterId));
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
        }
    }

    //@Authorized
    @PostMapping("/journal-entries")
    public ResponseEntity processJournalEntries(@RequestParam(name = "file", required = true) MultipartFile file, @RequestParam(required = true) Long requesterId) {
        LOGGER.debug(String.format("@%s::processJournalEntries(%s, %d)", this.getClass().getName(), file.getName(), requesterId));

        try {
            return ResponseEntity.ok(this.moduleService.processJournalEntries(file, requesterId));
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
        }
    }

    //@Authorized
    @PostMapping("/payables")
    public ResponseEntity processPayables(@RequestParam(name = "file", required = true) MultipartFile file, @RequestParam(required = true) Long requesterId) {
        LOGGER.debug(String.format("@%s::processPayables(%s, %d)", this.getClass().getName(), file.getName(), requesterId));

        try {
            return ResponseEntity.ok(this.moduleService.processPayables(file, requesterId));
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
        }
    }

    //@Authorized
    @PostMapping("/payables-comp")
    public ResponseEntity processPayablesComp(@RequestParam(name = "file", required = true) MultipartFile file, @RequestParam(required = true) Long requesterId) {
        LOGGER.debug(String.format("@%s::processPayablesComp(%s, %d)", this.getClass().getName(), file.getName(), requesterId));

        try {
            return ResponseEntity.ok(this.moduleService.processPayablesComp(file, requesterId));
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
        }
    }

    //@Authorized
    @PostMapping("/balance")
    public ResponseEntity processBalance(@RequestParam(name = "file", required = true) MultipartFile file, @RequestParam(required = true) Long requesterId) {
        LOGGER.debug(String.format("@%s::processBalance(%s, %d)", this.getClass().getName(), file.getName(), requesterId));

        try {
            return ResponseEntity.ok(this.moduleService.processBalance(file, requesterId));
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
        }
    }

    //@Authorized
    @PostMapping("/initial-integration")
    public ResponseEntity processInitialIntegration(@RequestParam(name = "file", required = true) MultipartFile file, @RequestParam(required = true) Long requesterId) {
        LOGGER.debug(String.format("@%s::processInitialIntegration(%s, %d)", this.getClass().getName(), file.getName(), requesterId));

        try {
            return ResponseEntity.ok(this.moduleService.processInitialIntegration(file, requesterId));
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
        }
    }

}
