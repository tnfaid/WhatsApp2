package blast.whatsapp.Model.SendMessage;

import com.fasterxml.jackson.annotation.JsonCreator;

/**
 *   "parts": [
 *       {
 *         "id": "1",
 *         "contentType": "text/plain",
 *         "data": "dewy semangat",
 *         "size": 33,
 *         "type": "body",
 *         "sort": 0
 *       }
 */
public class Parts
{
    private final int id;
    private final String data;
    private final int size;
    private final String type;
    private final int sort;
    private final String contentType;


    @JsonCreator
    public Parts( int id, String data, int size, int sort, String contentType, String type )
    {
        this.id = id;
        this.data = data;
        this.size = size;
        this.sort = sort;
        this.contentType = contentType;
        this.type = type;
    }


    public int getId()
    {
        return id;
    }

    public String getData()
    {
        return data;
    }

    public int getSize()
    {
        return size;
    }

    public String getType()
    {
        return type;
    }

    public int getSort()
    {
        return sort;
    }

    public String getContentType()
    {
        return contentType;
    }

    @Override
    public String toString()
    {
        return getId() + ","
                + getContentType() + ","
                + getData() + ","
                + getSize() + ","
                + getType()+ ","
                + getSort();
    }
}
