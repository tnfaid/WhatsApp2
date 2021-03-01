package whatsapp.uib.Controller;

import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;
import whatsapp.uib.Model.RegisModel;

import java.util.Collections;

public class RegisController
{
    public String Register()
    {
        String url = "https://apiv2.unificationengine.com/v2/connection/add";
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders header = new HttpHeaders();
        header.setContentType(MediaType.APPLICATION_JSON);
        header.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

        RegisModel regisModel = new RegisModel("{\"uri\":\"whatsappsandbox://628567638348@whatsapp.com\",\"name\":\"628567638348\"}");
        HttpEntity<RegisModel> register = new HttpEntity<>(regisModel, header);
        ResponseEntity<RegisModel> response = restTemplate.postForEntity(url, register, RegisModel.class);

        if(response.getStatusCode() == HttpStatus.OK )
        {
            System.out.println("Berhasil Registrasi");
            System.out.println(response.getBody());
        }
        else
        {
            System.out.println("Registrasi Gagal");
            System.out.println(response.getStatusCode());
        }



        return Register();
    }

}
