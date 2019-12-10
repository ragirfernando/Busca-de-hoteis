package com.mycompany.hotel.palmas.rest;

import com.mycompany.hotel.palmas.dao.Dao;
import com.mycompany.hotel.palmas.model.Reserva;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

@Path("/reserva")
@Transactional
public class ReservarQuarto {
    
    @Inject
    private Dao<Reserva> dao;
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public long salvar(Reserva reserva){
        return dao.salvar(reserva);
    }
    
    @DELETE
    @Path("{id}")
    public boolean deletar(@PathParam("id") int id){
        return dao.delete(id);
    }
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public int atualizar(Reserva reserva) {
        return (int) dao.atualizar(reserva);
    }
}
