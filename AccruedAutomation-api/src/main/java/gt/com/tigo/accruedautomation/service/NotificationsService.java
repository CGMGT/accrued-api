package gt.com.tigo.accruedautomation.service;

import java.util.List;

import gt.com.tigo.accruedautomation.dao.MessageRepository;
import gt.com.tigo.accruedautomation.model.MensajesEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

@Service
public class NotificationsService {
    private static final Logger LOGGER = LoggerFactory.getLogger(NotificationsService.class);

    @Autowired
    private MessageRepository repository;


    public List<MensajesEntity> getUserMessages(Long idUser, String type){
        LOGGER.debug(String.format("@%s::getUserMessages(%s, %s)", this.getClass().getName(), idUser, type));
        return this.repository.getUserMessages(idUser, type);
    }

    public boolean updateAllMessage(List<MensajesEntity> messages){
        LOGGER.debug(String.format("@%s::getUserMessages(%s)", this.getClass().getName(), messages));

        if(!messages.isEmpty()){
            for(MensajesEntity entity : messages){
                entity.setAttribute2("READ");
                this.repository.save(entity);
            }
            return true;
        }else{
            return false;
        }
    }

}
