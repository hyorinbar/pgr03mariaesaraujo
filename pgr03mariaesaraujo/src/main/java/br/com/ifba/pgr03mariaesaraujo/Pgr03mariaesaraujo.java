
package br.com.ifba.pgr03mariaesaraujo;

import br.com.ifba.usuario.entity.Usuario;
import br.com.ifba.usuario.repositorio.RepositorioUsuarioEmMemoria;
import java.util.ArrayList;
import java.util.List;
import org.flywaydb.core.Flyway;

public class Pgr03mariaesaraujo {

    public static void main(String[] args) {
        Flyway flyway = Flyway.configure()
                .dataSource(
                        "jdbc:postgresql://localhost:5432/bd_psiconecta",
                        "postgres",
                        "123456"
                )
                .load();

        flyway.migrate();
    }
}

