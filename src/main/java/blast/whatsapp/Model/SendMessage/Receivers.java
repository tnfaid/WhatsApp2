package blast.whatsapp.Model.SendMessage;

import com.fasterxml.jackson.annotation.JsonCreator;

/**
 *  "receivers": [
 *       {
 *         "name": "Dewy Y",
 *         "address": "628990908032",
 *         "Connector": "628990908032",
 *         "type": "individual"
 *       }
 *     ],
 */
public class Receivers
{
    private final String name;
    private final int address;
    private final int connector;
    private final String type;

    @JsonCreator
    public Receivers( String name, int address, int connector, String type )
    {
        this.name = name;
        this.address = address;
        this.connector = connector;
        this.type = type;
    }


    public String getName()
    {
        return name;
    }

    public int getAddress()
    {
        return address;
    }

    public int getConnector()
    {
        return connector;
    }

    public String getType()
    {
        return type;
    }
}
