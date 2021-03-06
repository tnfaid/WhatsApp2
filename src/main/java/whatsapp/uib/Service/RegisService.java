package whatsapp.uib.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.tomcat.util.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.env.Environment;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;
import whatsapp.uib.Model.RegisModel;

import java.nio.charset.Charset;
import java.util.Collections;
import java.util.Objects;


public class RegisService
{

    HttpHeaders header = new HttpHeaders();
    RestTemplate restTemplate = new RestTemplate();
    HttpEntity<String> request = new HttpEntity<>(header);
    Logger log = LoggerFactory.getLogger(RegisService.class);

    public String createRegis( RegisModel regisModel, Environment environment )
    {
        String url = param(environment, "https://apiv2.unificationengine.com/v2/connection/add");
        UriComponents builder = null;

        builder = UriComponentsBuilder.fromHttpUrl(url)
                .queryParam("uri", regisModel.getUri())
                .queryParam("name", regisModel.getName())
                .build();

        String auth = "12c50fbf-0c51-4fe6-9ecb-74bbe0109685:5d3da338-52d4-46ac-b1e4-b0e4430e0af4";
        byte[] authBytes = auth.getBytes();
        byte[] base64AuthBytes = Base64.encodeBase64(authBytes);
        String base64Auth = new String(base64AuthBytes);


        HttpHeaders headers = new HttpHeaders();
        header.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        headers.add("User-Agent", "Spring's RestTemplate");
        headers.add("Authorization", "Basic" + base64Auth);

        System.out.println("Berhasil yeyey tinggal lu tambhin case benar slah doang");

        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, new HttpEntity<>("body", headers), String.class);
        ObjectMapper mapper = new ObjectMapper();
        RegisModel register = null;
        try
        {
            register = mapper.readValue(response.getBody(), RegisModel.class);
        }
        catch ( JsonProcessingException e )
        {
            e.printStackTrace();
        }

        /**
         * cek dulu lah hasilnya apaan, kemudian yaudah
         * ketika berhasil nembak dan respon nya 200 maka berhasil gitu doang kan
         * lu cuma perlu set udah dapet name dan uri, kemudian set result ke 200
         * yaudah intinya ketika berhasil regis nmber ke uib, brarti status berhasil
         */

        log.debug(register.toString());

        return response.getBody();
    }



    private String param( Environment environment, String s )
    {
        return Objects.requireNonNull(environment.getProperty(s));
    }

    HttpHeaders createHeaders(String username, String password)
    {
        return new HttpHeaders()
        {{
            String auth = "12c50fbf-0c51-4fe6-9ecb-74bbe0109685" + ":" + "5d3da338-52d4-46ac-b1e4-b0e4430e0af4";
            byte[] encodedAuth = Base64.encodeBase64(auth.getBytes(Charset.forName("US-ASCII")));
            String authHeader = "Basic" + new String(encodedAuth);
            set("Authorization", authHeader);
        }};
    }


}
