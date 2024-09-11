package Test.demo.repository;

import Test.demo.domain.User;
import org.hibernate.mapping.Collection;

public interface UserRepository <T extends User>{
    /* Basic CRUD operations */
    T create(T data);
    Collection list(int page, int pageSize);
    T get(long id);
    T update(T data);
    Boolean delete(long id);

    /* Complex Operations*/
}
