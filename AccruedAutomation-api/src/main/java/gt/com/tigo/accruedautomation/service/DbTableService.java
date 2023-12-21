package gt.com.tigo.accruedautomation.service;


import gt.com.tigo.accruedautomation.dao.DbTableRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DbTableService {

    private static final Logger LOGGER = LoggerFactory.getLogger(DbTableService.class);

    @Autowired
    private DbTableRepository dbTableRepository;

    public List<String> getColumnLabelsByTableName(String tableName) {
        LOGGER.debug("@{}::getColumnLabelsByTableName({})", this.getClass().getName(), tableName);

        return this.dbTableRepository.getColumnLabelsByTableName(tableName);
    }

}
