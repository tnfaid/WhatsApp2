package blast.whatsapp.Dao;

import blast.whatsapp.Dao.Exception.RegisException;
import blast.whatsapp.Model.RegisNumberModel;
import blast.whatsapp.Model.SendTextModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.sql.SQLException;

public class DbRepoBean implements IDatabaseRepo
{
    JdbcTemplate sendTemplate;
    private static final Logger log = LoggerFactory.getLogger(DbRepoBean.class);

    public DbRepoBean( DataSource whatsAppNumberSource)
    {
        sendTemplate = new JdbcTemplate(whatsAppNumberSource);

        initJdbcTemplate(sendTemplate);
    }

    //oke karena ini riskan berhubungan dengan dao cuy, jadi buat final aja methodnya biar g bisa di extend
    private final void initJdbcTemplate( JdbcTemplate sendTemplate )
    {
        sendTemplate.setExceptionTranslator((( task, sql, ex ) ->
        {
            log.error("Query can't execute {}, error message {}",sql , ex.getMessage());
            return new RegisException(sql, ex);
        }));
    }


    @Override
    public void RegisNumber( RegisNumberModel regisNumberModel )
    {
        final String inserNumber = Query.INSERT_NUMBER;
        Object[] param = new Object[]
                {
                        regisNumberModel.getUri(),
                        regisNumberModel.getName()
                };

        sendTemplate.update(inserNumber, param);
    }

    @Override
    public void SendText( SendTextModel sendTextModel )
    {
        sendTemplate.update(Query.SEND_TEXT,
            new Object[]{
                sendTextModel.getData(),
                sendTextModel.getSize()
        });
    }
}
