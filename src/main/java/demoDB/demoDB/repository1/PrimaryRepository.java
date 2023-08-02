package demoDB.demoDB.repository1;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import demoDB.demoDB.bean1.primary_details;


@Repository
public interface PrimaryRepository extends JpaRepository<primary_details, Long> {

}
