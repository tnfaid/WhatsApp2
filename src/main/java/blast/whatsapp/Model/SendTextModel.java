package blast.whatsapp.Model;

import blast.whatsapp.Model.SendMessage.Parts;
import blast.whatsapp.Model.SendMessage.Receivers;

/**
 *   "message": {
 *     "receivers": [
 *       {
 *         "name": "Dewy Y",
 *         "address": "628990908032",
 *         "Connector": "628990908032",
 *         "type": "individual"
 *       }
 *     ],
 *     "parts": [
 *       {
 *         "id": "1",
 *         "contentType": "text/plain",
 *         "data": "dewy semangat",
 *         "size": 33,
 *         "type": "body",
 *         "sort": 0
 *       }
 *     ]
 *   }
 * }
 **/
public class SendTextModel
{
    private final Receivers receivers;
    private final Parts parts;

    public SendTextModel( Receivers receivers, Parts parts )
    {
        this.receivers = receivers;
        this.parts = parts;
    }

    public Receivers getReceivers()
    {
        return receivers;
    }

    public Parts getParts()
    {
        return parts;
    }


}
