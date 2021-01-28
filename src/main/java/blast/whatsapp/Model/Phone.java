package blast.whatsapp.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="WHATSAPP_NUMBER")
public class Phone implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name =  "PHONE")
    @NotNull
    private int phone;

    @Column(name = "UNIQUE_ID")
    @NotNull
    private String uniqueID;


//    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
//    //@JsonManagedReference("author")
//    @JsonIgnore
//    private List<Book> bookList = new ArrayList<>();
//
//    public void addPhone (Phone phone)
//    {
//        this.phoneList.add(phone);
//    }

}
