package gt.com.tigo.accruedautomation.util.service;

import gt.com.tigo.accruedautomation.dto.DataTableRequestDto;
import gt.com.tigo.accruedautomation.dto.PaginatedDataDto;
import gt.com.tigo.accruedautomation.util.exception.InvalidFilterException;
import gt.com.tigo.accruedautomation.util.exception.ResourcesNotFoundException;

public interface FindByPageService<T> {

    PaginatedDataDto<T> findByPage(DataTableRequestDto dataTableRequestDto) throws ResourcesNotFoundException, InvalidFilterException;

}
