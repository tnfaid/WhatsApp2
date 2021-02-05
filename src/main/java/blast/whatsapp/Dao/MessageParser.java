package blast.whatsapp.Dao;

import blast.whatsapp.Model.RegisNumberModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MessageParser
{
    private static final Logger log = LoggerFactory.getLogger(MessageParser.class);

    private String message;
    private String delimiter;
    private String[] messageFragments;

    public MessageParser()
    {
        super();
        this.message = message;
        this.delimiter = delimiter;
        this.messageFragments = messageFragments;
    }

    public String getMessage()
    {
        return message;
    }

    public void setMessage( String message )
    {
        this.message = message;
    }

    public String getDelimiter()
    {
        return delimiter;
    }

    public void setDelimiter( String delimiter )
    {
        this.delimiter = delimiter;
    }

    public String[] getMessageFragments()
    {
        return messageFragments;
    }

    public void setMessageFragments( String[] messageFragments )
    {
        this.messageFragments = messageFragments;
    }




}
