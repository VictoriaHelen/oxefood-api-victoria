package br.com.ifpe.oxefood.api.cliente;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ifpe.oxefood.modelo.cliente.ClienteService;
import br.com.ifpe.oxefood.modelo.cliente.Cliente;

@RestController
@RequestMapping("/api/cliente")
@CrossOrigin

public class ClienteController {

    @Autowired
   private ClienteService clienteService;

   @PostMapping
   public ResponseEntity<Cliente> save(@RequestBody  ClienteRequest request) {

       Cliente cliente = clienteService.save(request.build());
       return new ResponseEntity<Cliente>(cliente, HttpStatus.CREATED);
   }
    @GetMapping
    public List<Cliente> findAll() {
  
        return clienteService.findAll();
    }

    @GetMapping("/{id}")
    public Cliente findById(@PathVariable Long id) {

        return clienteService.findById(id);
    }
  @PutMapping("/{id}")
   public ResponseEntity<Cliente> update(@PathVariable("id") Long id, @RequestBody ClienteRequest request) {

       clienteService.update(id, request.build());
       return ResponseEntity.ok().build();
   }
    @DeleteMapping("/{id}")
   public ResponseEntity<Void> delete(@PathVariable Long id) {

       clienteService.delete(id);
       return ResponseEntity.ok().build();
   }


}
