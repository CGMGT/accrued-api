package gt.com.tigo.accruedautomation.util.service;

import gt.com.tigo.accruedautomation.dto.DataTableRequestDto;
import gt.com.tigo.accruedautomation.util.exception.InvalidFilterException;
import gt.com.tigo.accruedautomation.util.exception.ResourcesNotFoundException;
import org.springframework.web.servlet.ModelAndView;

public interface XlsxExportService {

    ModelAndView exportXlsx(DataTableRequestDto dataTableRequestDto) throws ResourcesNotFoundException, InvalidFilterException;

}
