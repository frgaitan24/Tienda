package com.Tienda.controller;

import com.Tienda.dao.ClienteDao;
import com.Tienda.domain.Cliente;
import com.Tienda.service.ArticuloService;
import com.Tienda.service.ClienteService;
import java.util.Arrays;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author Usuario
 */
@Slf4j
@Controller
public class IndexController {

    @Autowired
    //ClienteDao clienteDao;
    //ClienteService ClienteService;
      ArticuloService articuloService;

    @GetMapping("/")
    public String inicio(Model model) {
        log.info("Utilizando MVC");

//     String mensaje = "Semana 4";
//     model.addAttribute("MensajeSaludo", mensaje);
//
//     Cliente cliente = new Cliente("Franklin", "Gaitan", "frgaitan@test.com", "66666666");
//     model.addAttribute("cliente", cliente);
//
//     Cliente cliente2 = new Cliente("Carlos", "Baltodano", "carl@test.com", "99999999");
//     model.addAttribute("cliente", cliente);
//     List<Cliente> clientes = Arrays.asList(cliente, cliente2);
//      model.addAttribute("clientes", clientes);
        //var clientes = clienteDao.findAll();
        //var clientes = Arrays.asList();
        //var clientes = ClienteService.getClientes();
        //model.addAttribute("clientes", clientes);
        //return "index";
        var articulos = articuloService.getArticulos(true);
        model.addAttribute("articulos", articulos);
        return "index";
    }
}
