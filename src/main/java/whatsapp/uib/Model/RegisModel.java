package whatsapp.uib.Model;

public class RegisModel
{

    String uri;
    String name;

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
}
