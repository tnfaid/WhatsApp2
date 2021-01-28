package blast.whatsapp.Exception;

public class ResourceNotFoundException extends RuntimeException
{
    public ResourceNotFoundException( String exception )
    {
        super(exception);
    }

    public ResourceNotFoundException()
    {
        super();
    }

    public ResourceNotFoundException ( String message, Throwable cause)
    {
        super(message, cause);
    }
}
