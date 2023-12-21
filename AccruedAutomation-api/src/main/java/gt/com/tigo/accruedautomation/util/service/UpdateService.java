package gt.com.tigo.accruedautomation.util.service;

import gt.com.tigo.accruedautomation.util.exception.RequesterNotFoundException;
import gt.com.tigo.accruedautomation.util.exception.ResourceUpdateException;

public interface UpdateService<T> {

    T update(T entity, Long requesterId) throws RequesterNotFoundException, ResourceUpdateException;

}
