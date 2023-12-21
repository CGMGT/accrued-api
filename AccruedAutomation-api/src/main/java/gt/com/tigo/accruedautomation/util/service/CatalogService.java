package gt.com.tigo.accruedautomation.util.service;

import gt.com.tigo.accruedautomation.dto.CatalogDto;
import gt.com.tigo.accruedautomation.util.exception.ResourcesNotFoundException;

import java.util.List;

public interface CatalogService<K, V> {

    List<CatalogDto<K,V>> getDefaultCatalog() throws ResourcesNotFoundException;

}
