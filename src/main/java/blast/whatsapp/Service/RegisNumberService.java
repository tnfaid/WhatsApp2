package blast.whatsapp.Service;

import blast.whatsapp.Dao.DbConfig;
import blast.whatsapp.Dao.MessageParser;
import blast.whatsapp.Model.RegisNumberModel;
import blast.whatsapp.RegisDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

import java.net.http.HttpResponse;

@Component
@Import(value = {DbConfig.class})
public class RegisNumberService
{
    final Logger log = LoggerFactory.getLogger(RegisNumberService.class);

    public RegisNumberModel saveNumber(RegisNumberModel regisNumberModel) throws JsonProcessingException
    {
        String accessKey = "12c50fbf-0c51-4fe6-9ecb-74bbe0109685:5d3da338-52d4-46ac-b1e4-b0e4430e0af4";
        log.debug("Register Number");
        MessageParser messageParser = new MessageParser();
        HttpHeaders header = new HttpHeaders();
        header.setBasicAuth(accessKey);
        RestTemplate restTemplate = new RestTemplate();
        String URLSend = "URL_webhokk_ntar_pokoknya";

        header.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> request = new HttpEntity<String>(header);

        try
        {
            ResponseEntity<String> responseEntity = restTemplate.exchange(URLSend, HttpMethod.POST, request, String.class);
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
