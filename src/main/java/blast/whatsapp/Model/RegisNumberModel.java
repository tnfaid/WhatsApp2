package blast.whatsapp.Model;

import blast.whatsapp.RegisListener;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NonNull;

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
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name="PHONE")
    @NonNull
    private String phone;
    private String uri;

    @Column(name="UNIQUE_ID")
    private String uniqueId;
    private String name;

    @JsonFormat(pattern = "dd MMM yyyy")
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

    public String getUniqueId()
    {
        return uniqueId;
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
        this.uniqueId = uniqueId;
    }

    public String getName()
    {
        return name;
    }

    public String getUri()
    {
        return uri;
    }
}
