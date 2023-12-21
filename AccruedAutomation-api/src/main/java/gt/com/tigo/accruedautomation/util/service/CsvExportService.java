package gt.com.tigo.accruedautomation.util.service;

import gt.com.tigo.accruedautomation.dto.DataTableRequestDto;
import gt.com.tigo.accruedautomation.dto.ResourceDto;
import gt.com.tigo.accruedautomation.util.exception.InvalidFilterException;
import gt.com.tigo.accruedautomation.util.exception.ResourcesNotFoundException;

import java.io.IOException;

public interface CsvExportService {

    ResourceDto exportCsv(DataTableRequestDto dataTableRequestDto) throws ResourcesNotFoundException, InvalidFilterException, IOException;

}
