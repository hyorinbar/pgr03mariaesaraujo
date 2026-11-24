package br.com.ifba;

import br.com.ifba.usuario.view.ViewLogin;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class ProjetoApplication {

    public static void main(String[] args) {

        ConfigurableApplicationContext context
                = new SpringApplicationBuilder(ProjetoApplication.class)
                        .headless(false)
                        .run(args);

        ViewLogin tela = context.getBean(ViewLogin.class);
        tela.setVisible(true);
    }
}
