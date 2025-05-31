package come.example.repository;


import com.example.model.Patient;
import org.springframework.data.repository.CrudRepository;


public interface PatientRepository extends CrudRepository<Patient, Long> {}
