package com.example.tp3;

import com.example.external.repositories.UserRepository;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@SpringBootTest
@RunWith(SpringRunner.class)
@WebAppConfiguration
public class RepositorioTeste {

    @Autowired
    UserRepository armaRepository;

    // @Test
    // public void get(){
    //     User armaTeste = new User("nome", "ataque", "dano", "raridade", "id", 0.2,  1000, 1500);
    //     User arma = armaRepository.get("id");

    //     Assert.assertEquals(arma.getAtaque(), armaTeste.getAtaque());
    //     Assert.assertEquals(arma.getNome(), armaTeste.getNome());
    //     Assert.assertEquals(arma.getDano(), armaTeste.getDano());
    //     Assert.assertEquals(arma.getId(), armaTeste.getId());
    //     Assert.assertEquals(arma.getRaridade(), armaTeste.getRaridade());
    // }

    // @Test
    // public void getAll(){
    //     List<User> armas = armaRepository.getAll();

    //     Assert.assertEquals(armas.isEmpty(), true);
    // }

    // @Test
    // public void create(){
    //     User arma = new User("nome", "ataque", "dano", "raridade", "id", 0.2,  1000, 1500);
    //     List<User> armas = armaRepository.getAll();
    //     Assert.assertEquals(armas.isEmpty(), true);
    //     armaRepository.create(arma);
    //     Assert.assertEquals(armas.isEmpty(), false);
    // }

    // @Test
    // public void edit(){
    //     User arma = new User("nome", "ataque", "dano", "raridade", "id", 0.2,  1000, 1500);
    //     User armaEditada = new User("nome2", "ataque", "dano", "raridade", "id", 0.2,  1000, 1500);
    //     List<User> armas = armaRepository.getAll();
    //     armaRepository.create(arma);
    //     armaRepository.edit(armaEditada, arma);
    //     User novaArma = armaRepository.get("id");
    //     Assert.assertEquals(novaArma.getNome(), armaEditada.getNome());
    // }
}
