package blast.whatsapp.Service;

import org.springframework.data.domain.Page;

import java.awt.print.Pageable;

public interface MainService<T>
{
    Page<T> getAll( Pageable pageable );

    T add( T o);

    T getById( int id);

}
