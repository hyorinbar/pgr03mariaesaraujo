
package br.com.ifba.infrastructure.util;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class JPAUtil {

    private static final EntityManagerFactory FACTORY = criarFactory();

    private static EntityManagerFactory criarFactory() {
        Properties propriedades = new Properties();

        try (InputStream arquivo = JPAUtil.class.getClassLoader()
                .getResourceAsStream("application.properties")) {

            if (arquivo == null) {
                throw new IllegalStateException(
                        "Arquivo application.properties não encontrado."
                );
            }

            propriedades.load(arquivo);

        } catch (IOException e) {
            throw new RuntimeException(
                    "Erro ao carregar as configurações do banco.", e
            );
        }

        Map<String, Object> configuracoes = new HashMap<>();

        configuracoes.put(
                "jakarta.persistence.jdbc.driver",
                propriedades.getProperty("spring.datasource.driver-class-name")
        );

        configuracoes.put(
                "jakarta.persistence.jdbc.url",
                propriedades.getProperty("spring.datasource.url")
        );

        configuracoes.put(
                "jakarta.persistence.jdbc.user",
                propriedades.getProperty("spring.datasource.username")
        );

        configuracoes.put(
                "jakarta.persistence.jdbc.password",
                propriedades.getProperty("spring.datasource.password")
        );

        configuracoes.put(
                "hibernate.hbm2ddl.auto",
                propriedades.getProperty("spring.jpa.hibernate.ddl-auto")
        );

        configuracoes.put(
                "hibernate.show_sql",
                propriedades.getProperty("spring.jpa.show-sql")
        );

        return Persistence.createEntityManagerFactory(
                "bd_psiconecta", configuracoes
        );
    }

    public static EntityManager getEntityManager() {
        return FACTORY.createEntityManager();
    }
}

