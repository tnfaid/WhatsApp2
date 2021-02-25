package whatsapp.uib.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
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

import java.util.Objects;

public class RegisService
{

    HttpHeaders header = new HttpHeaders();
    RestTemplate restTemplate = new RestTemplate();
    HttpEntity<String> request = new HttpEntity<>(header);
    Logger log = LoggerFactory.getLogger(RegisService.class);

    public HttpStatus createRegis( RegisModel regisModel, Environment environment )
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
        headers.add("Authorization", "Basic" + base64Auth);

        try
        {
            ResponseEntity<String> response = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, request, String.class);
            ObjectMapper mapper = new ObjectMapper();
            RegisModel register = mapper.readValue(response.getBody(), RegisModel.class);

            /**
             * cek dulu lah hasilnya apaan, kemudian yaudah
             * ketika berhasil nembak dan respon nya 200 maka berhasil gitu doang kan
             * lu cuma perlu set udah dapet name dan uri, kemudian set result ke 200
             * yaudah intinya ketika berhasil regis nmber ke uib, brarti status berhasil
             * tapi kalo g berhasil ya gagal,
             *
             * terus apa bedanya sama codingan pak ghufron, iya gw bikin yang versi spring nya
             * yang itu kan lietralli nembak using java udah gitu kan, nah gw nembak versi apaan java juga
             * terus yang curl itu beneran buat hit nya, tetep kepake di code versi gw kan,
             * jadi lu g bikin status disini, karena tugasnynya cuma detect uri dan name dan auth,
             * kemudian ketika auth sesuai serta nama dan name maka dia dapat respon oke
             */

            log.debug(register.toString());

        }
        catch ( JsonMappingException e )
        {
            e.printStackTrace();
        }
        catch ( JsonProcessingException e )
        {
            e.printStackTrace();
        }

        return status;
    }



    private String param( Environment environment, String s )
    {
        return Objects.requireNonNull(environment.getProperty(s));
    }

}
