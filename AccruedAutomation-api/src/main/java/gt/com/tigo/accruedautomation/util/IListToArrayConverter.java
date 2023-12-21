package gt.com.tigo.accruedautomation.util;

import java.util.List;

public interface IListToArrayConverter<T> {

    List<Object[]> toArray(List<T> list);

}
