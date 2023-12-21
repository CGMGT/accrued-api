package gt.com.tigo.accruedautomation.util.service;

import gt.com.tigo.accruedautomation.dto.DataTableRequestDto;
import gt.com.tigo.accruedautomation.util.exception.InvalidFilterException;

public interface CountService {

    Long count(DataTableRequestDto dataTableRequestDto) throws InvalidFilterException;

}
