package blast.whatsapp.Service;

import blast.whatsapp.Dao.DbConfig;
import blast.whatsapp.Dao.MessageParser;
import blast.whatsapp.Model.RegisNumberModel;
import blast.whatsapp.RegisDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.web.client.RestTemplate;

import java.net.http.HttpHeaders;

@Import(value = {DbConfig.class})
public class RegisNumberService
{
    final Logger log = LoggerFactory.getLogger(RegisNumberService.class);

    public RegisNumberModel saveNumber(RegisNumberModel regisNumberModel)
    {
        log.debug("New Number Successfull to registered");
        MessageParser messageParser = new MessageParser();
        HttpHeaders header = new HttpHeaders();
        RestTemplate restTemplate = new RestTemplate();

        //test
    }



}
