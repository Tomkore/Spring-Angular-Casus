package Test.demo.repository;

import Test.demo.domain.Role;
import org.hibernate.mapping.Collection;

public interface RoleRepository<T extends Role> {
    /* Basic CRUD operations */
    T create(T data);
    Collection list(int page, int pageSize);
    T get(long id);
    T update(T data);
    Boolean delete(long id);

    /* Complex Operations*/
    void addRoleToUser(long userId, String roleName);
    Role getRoleByUserId(long userId);
    Role getRoleByEmail(String email);
    void updateUserRole(long userId, String roleName);
}
