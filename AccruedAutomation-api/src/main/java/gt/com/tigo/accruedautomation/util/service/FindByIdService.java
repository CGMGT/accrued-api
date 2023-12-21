package gt.com.tigo.accruedautomation.util.service;

import gt.com.tigo.accruedautomation.util.exception.ResourceNotFoundException;

public interface FindByIdService<T> {

    T findById(Long id) throws ResourceNotFoundException;

}
