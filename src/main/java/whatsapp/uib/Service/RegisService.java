package whatsapp.uib.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;
import whatsapp.uib.Model.RegisModel;

import java.util.Objects;

public class RegisService
{
    HttpHeaders header = new HttpHeaders();
    RestTemplate restTemplate = new RestTemplate();
    HttpEntity<String> request = new HttpEntity<>(header);
    Logger log = LoggerFactory.getLogger(RegisService.class);

    public RegisModel createRegis( RegisModel regisModel, Environment environment )
    {
        String url = param(environment, "url.send");
        UriComponents builder = null;

        builder = UriComponentsBuilder.fromHttpUrl(url)
                .queryParam("uri", regisModel.getUri())
                .queryParam("name", regisModel.getName())
                .build();

        try
        {
            ResponseEntity<String> response = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, request, String.class);
            ObjectMapper mapper = new ObjectMapper();

        }
    }



    private String param( Environment environment, String s )
    {
        return Objects.requireNonNull(environment.getProperty(s));
    }
}
