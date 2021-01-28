package blast.whatsapp.Service;

import blast.whatsapp.Model.Phone;
import blast.whatsapp.Repository.PhoneNumberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class PhoneNumberAdd extends PhoneNumber
{
    @Autowired
    private PhoneNumberRepository phoneNumberRepository;

    @Override
    public Page<Phone> getAll( Pageable pageable )
    {
        return phoneNumberRepository.findAll(pageable);
    }
}
