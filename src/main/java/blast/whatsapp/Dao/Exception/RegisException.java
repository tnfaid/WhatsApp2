package blast.whatsapp.Dao.Exception;

import org.springframework.dao.DataAccessException;

import java.sql.SQLException;

public class RegisException extends DataAccessException
{
    public RegisException( String msg, Throwable cause)
    {
        super(msg, cause);
    }
}
