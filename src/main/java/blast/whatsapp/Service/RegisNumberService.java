package blast.whatsapp.Service;

import blast.whatsapp.Dao.DbConfig;
import blast.whatsapp.RegisDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;

@Import(value = {DbConfig.class})
public class RegisNumberService
{
    final Logger log = LoggerFactory.getLogger(RegisNumberService.class);


}
