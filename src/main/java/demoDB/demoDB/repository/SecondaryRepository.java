package demoDB.demoDB.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import demoDB.demoDB.bean.secondary_details;


@Repository
public interface SecondaryRepository extends JpaRepository<secondary_details, Long>{

}
