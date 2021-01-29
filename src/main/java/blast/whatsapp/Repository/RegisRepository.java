package blast.whatsapp.Repository;

import blast.whatsapp.Model.RegisNumberModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RegisRepository extends JpaRepository<RegisNumberModel, Integer>
{

}
