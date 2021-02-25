package whatsapp.uib.Model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RegisModel
{
    @JsonProperty(value = "uri")
    private String uri;

    @JsonProperty(value = "name")
    private String name;

    public RegisModel( String uri, String name )
    {
        this.uri = uri;
        this.name = name;
    }

    public String getUri()
    {
        return uri;
    }

    public void setUri( String uri )
    {
        this.uri = uri;
    }

    public String getName()
    {
        return name;
    }

    public void setName( String name )
    {
        this.name = name;
    }

    public String toStringRegis()
    {
        return "{'uri': '" + uri +"'" +
                "'name' : '" + name +"'}";
    }

    @Override
    public String toString()
    {
        return "RequestBodyStatusRegis{" +
                "\"uri=\""+ uri +
                "\"name=\""+ name +
                '}';
    }
}
