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
                    "WEBHOOK_STATUS, " +
                    "DATA, " +
                    "SIZE)"+
                    "VALUES " +
                    "(?, ?, ?, ?, ?, ?, ?,?)";

    public static final String UPDATE_WEBHOOK_STATUS =
            "UPDATE WHATSAPP_NUMBER " +
                    "SET WEBHOOK_STATUS = ? " +
                    "WHERE WHATSAPP_ID = ? limit 1";


   public static final String SEND_TEXT =
           "UPDATE WHATSAPP_NUMBER " +
                   "SET DATA = ?, " +
                   "SIZE = ? " +
                   "WHERE PHONE = ? ";

}
