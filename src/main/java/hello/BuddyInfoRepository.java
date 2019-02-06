package hello;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "AddressBook", path = "AddressBook")
public interface BuddyInfoRepository extends CrudRepository<BuddyInfo, Long> {

    List<BuddyInfo> findByPhoneNumber(String phoneNumber);
    List<BuddyInfo> findByName(String name);
}
