package blast.whatsapp.Dao;

import blast.whatsapp.Model.RegisNumberModel;
import blast.whatsapp.Model.SendTextModel;

import java.sql.SQLException;

public interface IDatabaseRepo
{
    public void RegisNumber( RegisNumberModel regisNumberModel );
    public void SendText( SendTextModel sendTextModel );
}
