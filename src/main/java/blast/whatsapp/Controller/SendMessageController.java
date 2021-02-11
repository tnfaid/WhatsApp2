package blast.whatsapp.Controller;


import blast.whatsapp.Model.SendTextModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.*;

@RestController
@RequestMapping
public class SendMessageController
{
    /**
     * Response :
     * {
     *   "Status": {
     *     "628990908032": {
     *       "status": 200,
     *       "info": "OK"
     *     }
     *   },
     *   "URIs": [
     *     "whatsappsandbox://whatsapp.com/gBEGYomQkIAyAgnF8iLcg4zSYgM"
     *   ]
     * }
     */
    private static Logger log = LoggerFactory.getLogger(SendMessageController.class);

    @PostMapping(value = "/apiv2.unificationengine.com/v2/message/send", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SendTextModel> sendText( @RequestBody SendTextModel sendTextModel )
    {
        log.info("{ Status:{"+ sendTextModel.getReceivers().getAddress() + ": { status"
                + ResponseEntity.ok() + ", info :" + ResponseEntity.ok(sendTextModel)
                + "}}, URIs : [ whatsappsandbox://whatsapp.com/gBEGYomQkIAyAgnF8iLcg4zSYgM");

        return ResponseEntity.ok(sendTextModel);
    }





}
