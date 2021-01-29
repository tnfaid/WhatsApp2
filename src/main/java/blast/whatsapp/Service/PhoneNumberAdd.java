package blast.whatsapp.Service;

import blast.whatsapp.Model.Phone;
import blast.whatsapp.Repository.RegisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

public class PhoneNumberAdd extends PhoneNumber
{
    @Autowired
    private RegisRepository regisRepository;

    @Override
    public Page<Phone> getAll( java.awt.print.Pageable pageable )
    {
        return null;
    }

    @Override
    public Phone add( Phone o )
    {
        return null;
    }

    @Override
    public Phone getById( int id )
    {
        return null;
    }
}
