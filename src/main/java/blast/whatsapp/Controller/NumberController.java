package blast.whatsapp.Controller;

import blast.whatsapp.Model.Phone;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Validated
@RestController
@RequestMapping("/apiv2.unificationengine.com/v2/connection/add")
public class NumberController
{
//    Logger log = LoggerFactory.getLogger(NumberController.class);
//
//    @Autowired
//    private PhoneNumber phoneNumber;
//
//    @PostMapping
//    public ResponseWrapper<Phone> createAuthor(@Valid @RequestBody Phone phone)
//    {
//        return new ResponseWrapper<>( phoneNumber.add(phone), HttpStatus.OK);
//    }
//


}
