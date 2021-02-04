package blast.whatsapp.Model;

import blast.whatsapp.Model.SendMessage.Parts;
import blast.whatsapp.Model.SendMessage.Receivers;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

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

public class SendTextModel implements Serializable
{
    private final Receivers receivers;
    private final Parts parts;
    String data, messageBody;
    int size, messageBodySize;


    public void setData( String data )
    {
        this.data = data;
    }

    public void setMessageBody( String messageBody )
    {
        this.messageBody = messageBody;
    }

    public void setSize( int size )
    {
        this.size = size;
    }

    public void setMessageBodySize( int messageBodySize )
    {
        this.messageBodySize = messageBodySize;
    }

    public String getData()
    {
        return data;
    }

    public String getMessageBody()
    {
        return messageBody;
    }

    public int getSize()
    {
        return size;
    }

    public int getMessageBodySize()
    {
        return messageBodySize;
    }


    public Receivers getReceivers()
    {
        return receivers;
    }

    public Parts getParts()
    {
        return parts;
    }

    public SendTextModel( Receivers receivers, Parts parts )
    {
        this.receivers = receivers;
        this.parts = parts;
    }

    public SendTextModel( Receivers receivers, Parts parts, String data, String messageBody, int size, int messageBodySize )
    {
        this.receivers = receivers;
        this.parts = parts;
        this.data = data;
        this.messageBody = messageBody;
        this.size = size;
        this.messageBodySize = messageBodySize;
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("TextMessage Received");
        sb.append("receivers ="+ getReceivers()+"\n");
        sb.append("receivers ="+ getParts()+"\n");

        return sb.toString();
    }


}
