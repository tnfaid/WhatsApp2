package blast.whatsapp.Controller;

import blast.whatsapp.Model.RegisNumberModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/apiv2.unificationengine.com/v2/message")
public class RegisNumberController
{
    private static Logger log = LoggerFactory.getLogger(RegisNumberController.class);

    @Autowired
    RegisNumberService regisNumberService;

    /**
     * {"status":200,"info":"200 OK"}
     */
    @PostMapping(value = "/send", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RegisNumberModel> registerUser( @RequestBody RegisNumberModel regisNumberModel )
    {

        log.info("status :" + ResponseEntity.ok() + ", info :" + ResponseEntity.ok());
        return ResponseEntity.ok(regisNumberModel);
    }

}
