package blast.whatsapp.Model;

public class RegisNumberModel
{
    private String uri;
    private int name;


    public RegisNumberModel( String uri, int name )
    {
        this.uri = uri;
        this.name = name;
    }

    public void setUri( String uri )
    {
        this.uri = uri;
    }

    public void setName( int name )
    {
        this.name = name;
    }

    public int getName()
    {
        return name;
    }

    public String getUri()
    {
        return uri;
    }
}
