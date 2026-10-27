package com.edu.fod.agentic.sprout;

import org.springaicommunity.agent.tools.*;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Map;
import java.util.Scanner;

@SpringBootApplication
public class SproutApplication {

    public static void main(String[] args) {
        SpringApplication.run(SproutApplication.class, args);
    }

    @Bean
    CommandLineRunner demo(ChatClient.Builder builder) {

        return (args) -> {
            ChatClient chatClient = builder
                    .defaultSystem("""
                            	You are a helpful coding assistant.
                                 Use available skills and tools to help with the codebase.
                                 Current directory: %s
                            """.formatted(System.getProperty("user.dir")))
                    .defaultTools(
                            SkillsTool.builder()
                                    .addSkillsDirectory(".claude/skills").build(),
                            FileSystemTools.builder().build(),
                            GrepTool.builder().build(),
                            GlobTool.builder().build(),
                            ShellTools.builder().build()
                    ).build();

            var scanner = new Scanner(System.in);
            System.out.println("Agent at your service");
            while(true){
                System.out.println("\n>");
                String input = scanner.nextLine();
                if("exit".equalsIgnoreCase(input.trim())) break;

                try{
                    String response = chatClient.prompt(input)
                            //.toolContext(Map.of("workDir",System.getProperty("user.dir")))
                            .call()
                            .content();
                    System.out.println("\n"+response);
                }catch (Exception e){
                    System.err.println("Error:"+e.getMessage());
                }
            }
        };
    }

}
