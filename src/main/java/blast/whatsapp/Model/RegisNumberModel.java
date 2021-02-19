package blast.whatsapp.Model;

import blast.whatsapp.RegisListener;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

public class RegisNumberModel
{

    /**
     * {
     *   "uri": "whatsappsandbox://628990908032@whatsapp.com",
     *   "name": "628990908032"
     * }
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private String phone;
    private String uri;
    private String unique_id;
    private String name;
    private Date inputDate;

    public String getPhone()
    {
        return phone;
    }

    public String getUniqueId()
    {
        return unique_id;
    }

    public void setUri( String uri )
    {
        this.uri = uri;
    }

    public void setName( String name )
    {
        this.name = name;
    }

    public void setPhone( String phone )
    {
        this.phone = phone;
    }

    public void setUniqueId( String uniqueId )
    {
        this.unique_id = uniqueId;
    }

    public String getName()
    {
        return name;
    }

    public String getUri()
    {
        return uri;
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("'{");
        sb.append("uri :  whatssappsanbox://" + getUri() + "@whatsapp.com \n");
        sb.append("name : " + getName());
        sb.append("}'");
        return sb.toString();
    }

}
