package gt.com.tigo.accruedautomation.util.service;

import gt.com.tigo.accruedautomation.util.exception.ResourcesNotFoundException;

import java.util.List;

public interface FindAllService<T> {

    List<T> findAll() throws ResourcesNotFoundException;

}
