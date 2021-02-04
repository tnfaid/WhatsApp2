package blast.whatsapp.Model;

import blast.whatsapp.RegisListener;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Entity
@Data
@Table(name = "WHATSAPP_NUMBER")
@EntityListeners(RegisListener.class)
@JsonIgnoreProperties(value={"add"}, allowGetters = true)
public class RegisNumberModel implements Serializable
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
    private int uniqueId;
    private int name;
    private Date inputDate;

    public RegisNumberModel()
    {
        this.uri = uri;
        this.name = name;
    }


    public String getPhone()
    {
        return phone;
    }

    public int getUniqueId()
    {
        return uniqueId;
    }

    public void setUri( String uri )
    {
        this.uri = uri;
    }

    public void setName( int name )
    {
        this.name = name;
    }

    public void setPhone( String phone )
    {
        this.phone = phone;
    }

    public void setUniqueId( int uniqueId )
    {
        this.uniqueId = uniqueId;
    }

    public int getName()
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
        return "uri : whatssappsanbox://"+getUri() + "@whatsapp.com, \n name :" + getName();
    }

}
