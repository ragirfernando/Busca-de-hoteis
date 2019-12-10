package com.mycompany.hotel.palmas.rest;

import com.mycompany.hotel.palmas.dao.Dao;
import com.mycompany.hotel.palmas.model.Hotel;
import java.util.List;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/buscarHoteisBairro")
@Transactional
public class BuscarHoteisBairro {
    
    @Inject
    private Dao<Hotel> dao;
    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Hotel> buscarHoteisBairro(@PathParam("id") long id){
        return dao.buscarHoteisBairro(id);
    }
}
