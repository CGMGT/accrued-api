package gt.com.tigo.accruedautomation.util.service;

import gt.com.tigo.accruedautomation.util.exception.RequesterNotFoundException;
import gt.com.tigo.accruedautomation.util.exception.ResourceCreateException;

public interface CreateService<T> {

    T create(T entity, Long requesterId) throws RequesterNotFoundException, ResourceCreateException;

}
