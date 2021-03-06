package com.mycompany.hotel.palmas.rest;

import com.mycompany.hotel.palmas.dao.Dao;
import com.mycompany.hotel.palmas.dao.HotelDao;
import com.mycompany.hotel.palmas.model.Hotel;
import java.util.List;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/hotel")
@Transactional
public class HotelResource {

    @Inject
    private HotelDao dao;

    @GET
    @Path("busca-camas/{cidade}/{valor}/{camas}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Hotel> buscaHoteisCidadeValorCamas(@PathParam("cidade") long id, @PathParam("valor") double valor, @PathParam("camas") int camas) {
        List<Hotel> hoteis = dao.buscarHoteisCidadeValorCamas(id, valor, camas);
        for (Hotel hotel : hoteis) {
            hotel.setQuartos(null);
        }
        return hoteis;
    }

    @GET
    @Path("busca-bairro/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Hotel> buscarHoteisBairro(@PathParam("id") long id) {
        List<Hotel> hoteis = dao.buscarHoteisBairro(id);
        for (Hotel hotel : hoteis) {
            hotel.setQuartos(null);
        }
        return hoteis;
    }

    @GET
    @Path("busca-cidade/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Hotel> buscarHoteisCidade(@PathParam("id") long id) {
        List<Hotel> hoteis = dao.buscarHoteisCidade(id);
        for (Hotel hotel : hoteis) {
            hotel.setQuartos(null);
        }
        
        return hoteis;
    }

}
