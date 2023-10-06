package br.com.ifpe.oxefood.modelo.produto;

import java.time.LocalDate;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import br.com.ifpe.oxefood.modelo.cliente.Produto;

import br.com.ifpe.oxefood.modelo.produto.Produto;



@Service
public class ProdutoService {
    @Autowired
    private ProdutoRepository repository;

    @Transactional
    public Produto save(Produto produto){

    produto.setHabilitado(Boolean.TRUE);
    produto.setVersao(1L);
    produto.setDataCriacao(LocalDate.now());
    return repository.save(produto);

    }
     public List<Produto> findAll() {
  
        return repository.findAll();
    }

    public Produto findById(Long id) {

        return repository.findById(id).get();
    }
     @Transactional
    public void update(Long id, Produto produtoAlterado) {
      Produto produto = repository.findById(id).get();
      produto.setTitulo(produtoAlterado.getTitulo());
      produto.setCodigoProduto(produtoAlterado.getCodigoProduto());
      produto.setDescricao(produtoAlterado.getDescricao());
      produto.setValorUnitario(produtoAlterado.getValorUnitario());
      produto.setTempMin(produtoAlterado.getTempMin());
	    
      produto.setVersao(produto.getVersao() + 1);
      repository.save(produto);
  }

  @Transactional
   public void delete(Long id) {

       Produto produto = repository.findById(id).get();
       produto.setHabilitado(Boolean.FALSE);
       produto.setVersao(produto.getVersao() + 1);

       repository.save(produto);
   }

}
