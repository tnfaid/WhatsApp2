package blast.whatsapp.Dao;

public class Query
{
    public static final String INSERT_NUMBER =
            "INSERT INTO WHATSAPP_NUMBER" +
                    "(WHATSAPP_ID, " +
                    "PHONE, " +
                    "UNIQUE_ID, " +
                    "CREATED_AT, " +
                    "MESSAGE_TYPE, " +
                    "WEBHOOK_STATUS)"+
                    "VALUES " +
                    "(?, ?, ?, ?, ?,?)";

    public static final String UPDATE_WEBHOOK_STATUS =
            "UPDATE WHATSAPP_NUMBER " +
                    "SET WEBHOOK_" +
                    "STATUS = ? " +
                    "WHERE WHATSAPP_ID = ? limit 1";


//   public static final String SEND_TEXT =

}
