package blast.whatsapp.Controller;

import blast.whatsapp.Mapper.WebhookStatus;
import blast.whatsapp.Model.RegisNumberModel;
import blast.whatsapp.RegisDto;
import blast.whatsapp.Service.RegisNumberService;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import netscape.javascript.JSObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Stack;


@RestController
@RequestMapping(RegisNumberController.BASE_PATH)
public class RegisNumberController
{

    public  final  static  String BASE_PATH = "connection";
    private static Logger log = LoggerFactory.getLogger(RegisNumberController.class);
    String status;
    String info;

    @Autowired
    RegisNumberService regisNumberService;
    private Object ResponseEntity;

    /**
     * {"status":200,"info":"200 OK"}
     *
     * // Generated by curl-to-java: https://fivesmallq.github.io/curl-to-java
     *
     * Request request = Request.Post("http://localhost:9000/connection/add");
     * String body = "{\"uri\":\"whatsappsandbox://628990908031@whatsapp.com\",\"name\":\"628990908031\"}";
     * request.bodyString(body,ContentType.APPLICATION_FORM_URLENCODED);
     * request.setHeader("Content-Type", "application/x-www-form-urlencoded");
     * HttpResponse httpResponse = request.execute().returnResponse();
     * System.out.println(httpResponse.getStatusLine());
     * if (httpResponse.getEntity() != null) {
     * 	String html = EntityUtils.toString(httpResponse.getEntity());
     * 	System.out.println(html);
     * }
     */
    @PostMapping(value = "/add", produces = {MediaType.ALL_VALUE, MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_FORM_URLENCODED_VALUE}, consumes = {MediaType.ALL_VALUE, MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_FORM_URLENCODED_VALUE})

    public ResponseEntity<?> regisNumberModelResponseEntity(RegisNumberModel regisNumberModel) throws IOException
    {
        ObjectMapper objectMapper = new ObjectMapper();
        WebhookStatus webhookStatus = null;
//        RegisNumberModel regisNumberModel = null;
;
        RegisNumberService regisNumberService = new RegisNumberService();

        regisNumberModel.setUniqueId(regisNumberModel.getName());
        regisNumberModel.setPhone(regisNumberModel.getUri());

        String Result = String.valueOf(regisNumberService.saveNumber(regisNumberModel));

        status = Result;
        info = "{status : 200" + ", info : " + HttpStatus.OK + "} \n";
        return new ResponseEntity<String>(info, HttpStatus.OK);
    }

//    @RequestBody RegisNumberModel regisNumberModel )
//    {
//
//
//        log.info("status :" + ResponseEntity.ok() + ", info :" + ResponseEntity.ok());
//        return ResponseEntity.ok(regisNumberModel);
//    }

}
