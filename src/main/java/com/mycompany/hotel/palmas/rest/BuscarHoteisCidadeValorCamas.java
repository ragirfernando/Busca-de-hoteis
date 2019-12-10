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

public class BuscarHoteisCidadeValorCamas {

    @Path("/buscarHoteisCidadeValorCamas")
    @Transactional
    public class BuscarHoteisBairro {

        @Inject
        private Dao<Hotel> dao;

        @GET
        @Path("{cidade}/{valor}/{camas}")
        @Produces(MediaType.APPLICATION_JSON)
        public List<Hotel> buscaHoteisCidadeValorCamas(@PathParam("cidade") long id, @PathParam("valor") double valor, @PathParam("camas") int camas) {
            return dao.buscarHoteisCidadeValorCamas(id, valor, camas);
        }
    }
}
