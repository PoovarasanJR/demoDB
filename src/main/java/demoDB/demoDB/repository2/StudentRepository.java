package demoDB.demoDB.repository2;

import org.springframework.data.jpa.repository.JpaRepository;

import demoDB.demoDB.bean2.student;

public interface StudentRepository extends JpaRepository<student, String> {

}
