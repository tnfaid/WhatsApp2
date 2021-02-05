package blast.whatsapp.Service;

import blast.whatsapp.Dao.DbConfig;
import blast.whatsapp.Dao.MessageParser;
import blast.whatsapp.Model.RegisNumberModel;
import blast.whatsapp.RegisDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.http.*;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

import java.net.http.HttpResponse;

@Import(value = {DbConfig.class})
public class RegisNumberService
{
    final Logger log = LoggerFactory.getLogger(RegisNumberService.class);

    public RegisNumberModel saveNumber(RegisNumberModel regisNumberModel) throws JsonProcessingException
    {
        log.debug("Register Number");
        MessageParser messageParser = new MessageParser();
        HttpHeaders header = new HttpHeaders();
        RestTemplate restTemplate = new RestTemplate();
        String URLSend = "/apiv2.unificationengine.com/v2/message/send";

        header.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> request = new HttpEntity<String>(header);

        try
        {
            ResponseEntity<String> responseEntity = restTemplate.postForEntity(URLSend, request, String.class);
            String[] responseRegis = (responseEntity.getBody()).split("\n");
            String status = responseRegis[0];

            if( status.equals("200"))
            {
                log.info("Success Registered Number");
            }

        }
        catch ( ResourceAccessException e )
        {
            log.info("can't register number");
        }

        return regisNumberModel;

    }



}
