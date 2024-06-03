package org.devtildo.odin.config;

import org.devtildo.odin.model.Task;
import org.devtildo.odin.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private TaskRepository taskRepository;

    @Override
    public void run(String... args) throws Exception {
        Task t1 = new Task(null, "Tirar o lixo", "Colocar o lixo no cesto da rua");
        Task t2 = new Task(null, "Fazer o almoço", "Comprar feijão, cebola e alho para o almoço");

        taskRepository.saveAll(Arrays.asList(t1,t2));
    }
}
