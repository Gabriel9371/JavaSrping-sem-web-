package com.com.alura.screenmatch;

import com.com.alura.screenmatch.model.DadosSerie;
import com.com.alura.screenmatch.service.ConsumoApi;
import com.com.alura.screenmatch.service.ConverteDados;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ScreenmatchApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ScreenmatchApplication.class, args);

	}


    @Override
    public void run(String... args) throws Exception {
        var api = new ConsumoApi();
        var json = api.obterDados("https://www.omdbapi.com/?t=gilmore+girls&apikey=d869af45");
        //gilmore+girls

//        System.out.println(json);
//
//        json = api.obterDados("https://coffee.alexflipnote.dev/random.json");
        System.out.println(json);
        ConverteDados convdados = new ConverteDados();

        DadosSerie dados = convdados.obterdados(json, DadosSerie.class);

        System.out.println(dados);
    }
}
