package blast.whatsapp.Model;

import blast.whatsapp.RegisListener;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;
import lombok.Data;
import lombok.NonNull;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import javax.security.auth.message.config.RegistrationListener;
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

    @Column(name="UNIQUE_ID")
    @NonNull
    private int uniqueId;
    private int name;

    @JsonFormat(pattern = "dd MMM yyyy")
    private Date inputDate;

    public String getPhone()
    {
        return phone;
    }

    public void setPhone( String phone )
    {
        this.phone = phone;
    }

    public int getUniqueId()
    {
        return uniqueId;
    }

    public void setUniqueId( int uniqueId )
    {
        this.uniqueId = uniqueId;
    }
    private String uri;


    public RegisNumberModel()
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
