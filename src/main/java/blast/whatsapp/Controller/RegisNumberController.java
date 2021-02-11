package blast.whatsapp.Controller;

import blast.whatsapp.Mapper.WebhookStatus;
import blast.whatsapp.Model.RegisNumberModel;
import blast.whatsapp.RegisDto;
import blast.whatsapp.Service.RegisNumberService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
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
     */
    @PostMapping(value = "/add", consumes = MediaType.APPLICATION_JSON_VALUE)
    public RegisNumberModel regisNumber(@RequestBody RegisNumberModel regisNumberModel)
    {
        RegisNumberModel returnValue = new RegisNumberModel();

        RegisDto regisDto = new RegisDto();
        BeanUtils.copyProperties(regisNumberModel, regisDto);

//        RegisDto addNumber = regisNumberService.addNumber(regisDto);
//        BeanUtils.copyProperties(addNumber, returnValue);
        return returnValue;
    }


    public ResponseEntity<String> regisNumberModelResponseEntity( @RequestBody String param ) throws IOException
    {
        ObjectMapper objectMapper = new ObjectMapper();
        WebhookStatus webhookStatus = null;
        RegisNumberModel regisNumberModel = new RegisNumberModel();
        RegisNumberService regisNumberService = new RegisNumberService();

        regisNumberModel.setUniqueId(regisNumberModel.getName());
        regisNumberModel.setPhone(regisNumberModel.getUri());

        String Result = String.valueOf(regisNumberService.saveNumber(regisNumberModel));

        status = Result;
        info = "200 OK";
        return new ResponseEntity<String>(status, HttpStatus.OK);
    }

//    @RequestBody RegisNumberModel regisNumberModel )
//    {
//
//
//        log.info("status :" + ResponseEntity.ok() + ", info :" + ResponseEntity.ok());
//        return ResponseEntity.ok(regisNumberModel);
//    }

}
