package br.com.ifba.pgr03mariaesaraujo;

import br.com.ifba.usuario.dao.UsuarioDao;
import br.com.ifba.usuario.dao.UsuarioIDao;
import br.com.ifba.usuario.service.UsuarioService;
import br.com.ifba.usuario.service.UsuarioIService;
import br.com.ifba.usuario.controller.UsuarioController;
import br.com.ifba.usuario.controller.UsuarioIController;
import br.com.ifba.usuario.view.TelaCadastro;
import br.com.ifba.usuario.view.ViewLogin;
import javax.swing.SwingUtilities;
import org.flywaydb.core.Flyway;

public class Pgr03mariaesaraujo {

    public static void main(String[] args) {

        // Executa as migrations
        Flyway flyway = Flyway.configure()
                .dataSource(
                        "jdbc:postgresql://localhost:5432/bd_psiconecta",
                        "postgres",
                        "123456"
                )
                .load();

        flyway.migrate();

        // 1. Cria o DAO
        UsuarioIDao dao = new UsuarioDao();

        // 2. Injeta o DAO no Service
        UsuarioIService service = new UsuarioService(dao);

        // 3. Injeta o Service no Controller
        UsuarioIController controller
                = new UsuarioController(service);

        // 4. Entrega o Controller à View
        SwingUtilities.invokeLater(() -> {
            new ViewLogin(controller).setVisible(true);
        });
    }
}

