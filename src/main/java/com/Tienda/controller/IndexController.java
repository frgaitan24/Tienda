package com.Tienda.controller;

import com.Tienda.dao.ClienteDao;
import com.Tienda.dao.UsuarioDao;
import com.Tienda.domain.Carrito;
import com.Tienda.domain.CarritoDetalle;
import com.Tienda.domain.Cliente;
import com.Tienda.domain.Usuario;
import com.Tienda.service.ArticuloService;
import com.Tienda.service.CarritoDetalleService;
import com.Tienda.service.CarritoService;
import com.Tienda.service.ClienteService;
import jakarta.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author Usuario
 */
@Controller
public class IndexController {

    //ClienteDao clienteDao;
    //ClienteService ClienteService;
    @Autowired
    ArticuloService articuloService;

    @Autowired
    UsuarioDao usuarioDao;

    @Autowired
    CarritoService carritoService;

    @Autowired
    CarritoDetalleService carritoDetalleService;

    @GetMapping("/")
    public String inicio(Model model, HttpServletRequest request) {

        //Obtener usuario logueado
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        UserDetails user = null;

        if (principal instanceof UserDetails) {
            user = (UserDetails) principal;
        }

        //Validar si el usuario es de un cliente 
        boolean esCliente = false;

        if (user != null) {
            Usuario usuario = usuarioDao.findByUsername(user.getUsername());

            if (usuario.getIdCliente() != null && usuario.getIdCliente() != 0) {
                Carrito carrito = carritoService.getCarritoCliente(usuario.getIdCliente());

                request.getSession().setAttribute("idCliente", usuario.getIdCliente());
                request.getSession().setAttribute("idCarrito", carrito.getIdCarrito());
                request.getSession().setAttribute("esCliente", esCliente);

                //Consultar items o cantidad de elementos en el carrito
                List<CarritoDetalle> carritoDetalles = carritoDetalleService.getCarritoDetalles(carrito.getIdCarrito());
                model.addAttribute("cantidadArcticulosCarrito", carritoDetalles.size());
            }
        }

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
        model.addAttribute("esCliente", esCliente);

        return "index";
    }
}
