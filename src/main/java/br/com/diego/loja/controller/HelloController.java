package br.com.diego.loja.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller //spring consegue encontrar essa classe
public class HelloController {

    @RequestMapping("/")  /// diz quando vai ser chamado
    @ResponseBody // para não navegar para uma página, caso contrário o spring vai pensar que é uma
    public void executa() {
        System.out.println( "olá mundo");
    }

}





