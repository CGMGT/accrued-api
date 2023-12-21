package gt.com.tigo.accruedautomation.util.service;

import gt.com.tigo.accruedautomation.util.exception.RequesterNotFoundException;
import gt.com.tigo.accruedautomation.util.exception.ResourceDeleteException;
import gt.com.tigo.accruedautomation.util.exception.ResourceNotFoundException;
import gt.com.tigo.accruedautomation.util.exception.ResourceUpdateException;

public interface DeleteByIdService<T> {

    boolean deleteById(Long entityId) throws ResourceDeleteException;

    T deleteById(Long entityId, Long requesterId) throws RequesterNotFoundException, ResourceNotFoundException, ResourceUpdateException;

}
