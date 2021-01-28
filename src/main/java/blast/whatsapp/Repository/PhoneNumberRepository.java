package blast.whatsapp.Repository;

import blast.whatsapp.Model.Phone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PhoneNumberRepository extends JpaRepository<Phone, Integer>
{

}
