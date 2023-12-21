package gt.com.tigo.accruedautomation.controller;

import gt.com.tigo.accruedautomation.dto.TigoResponseDto;
import gt.com.tigo.accruedautomation.model.MensajesEntity;
import gt.com.tigo.accruedautomation.service.NotificationsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@CrossOrigin
@RestController
@RequestMapping("/notifications")
public class NotificationsController {
    private static final Logger LOGGER = LoggerFactory.getLogger(NotificationsController.class);

    @Autowired
    private NotificationsService service;

    @GetMapping(value = "/getNotifications/{idUser}/{type}", consumes = MediaType.ALL_VALUE)
    public ResponseEntity<TigoResponseDto> getNotifications(@PathVariable Long idUser, @PathVariable String type) {
        LOGGER.debug(String.format("@%s::getNotifications(%s, %s)", this.getClass().getName(), idUser, type));

        try {
            return ResponseEntity.ok(new TigoResponseDto(this.service.getUserMessages(idUser, type)));
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new TigoResponseDto(HttpStatus.INTERNAL_SERVER_ERROR.value(), ex.getMessage()));
        }
    }

    @PostMapping(value = "/updateNotifications")
    public ResponseEntity<TigoResponseDto> updateNotifications(@RequestBody( required = true) List<MensajesEntity> messages) {
        LOGGER.debug(String.format("@%s::updateNotifications(%s)", this.getClass().getName(), messages));

        try {
            return ResponseEntity.ok(new TigoResponseDto(this.service.updateAllMessage(messages)));
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new TigoResponseDto(HttpStatus.INTERNAL_SERVER_ERROR.value(), ex.getMessage()));
        }
    }
}
