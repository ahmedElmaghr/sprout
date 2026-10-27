package com.edu.fod.agentic.sprout;

import org.springaicommunity.agent.tools.*;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.tool.ToolCallback;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;
import java.util.Scanner;

@SpringBootApplication
public class SproutApplication {

    public static void main(String[] args) {
        SpringApplication.run(SproutApplication.class, args);
    }

    @Bean
    CommandLineRunner demo(ChatClient.Builder builder) {
        return args -> {
            Path skillPath = Path.of(
                    System.getProperty("user.dir"),
                    ".claude",
                    "skills",
                    "java-21-coding",
                    "SKILL.md"
            );

            String skillInstructions = Files.readString(skillPath);

            FileSystemTools fileSystemTools = FileSystemTools.builder().build();
            GrepTool grepTool = GrepTool.builder().build();
            GlobTool globTool = GlobTool.builder().build();
            ShellTools shellTools = ShellTools.builder().build();

            ChatClient chatClient = builder
                    .defaultSystem("""
                        You are a Java coding agent working in the current project.

                        Follow these Java coding standards:
                        %s

                        When asked to create or modify files, use the
                        available tools to perform the operation.
                        Never claim a file was created unless the tool
                        confirms the operation.
                        """.formatted(skillInstructions))
                    .defaultTools(
                            fileSystemTools,
                            grepTool,
                            globTool,
                            shellTools
                    )
                    .build();

            String response = chatClient.prompt()
                    .user("""
                        Create HelloWordController.java in the project root.
                        It must be a Spring REST controller with a GET endpoint
                        that returns "Hello, World!".

                        Create the actual file using the filesystem tool.
                        create the file under the /controller package, create it if not exist
                        """)
                    .call()
                    .content();

            System.out.println("Agent response: [" + response + "]");
        };
    }

    //@Bean
    CommandLineRunner demoo(ChatClient.Builder builder) {
        Path skillsDirectory = Path.of(".claude", "skills")
                .toAbsolutePath()
                .normalize();

        checkSkillsFilePath(skillsDirectory);
        checkFileCreation();
        return (args) -> {
            ChatClient chatClient = builder
                    .defaultSystem("""
                            You are a coding agent working in the current project.

                            Working directory: %s

                            When the user asks you to create or modify code:
                            1. Inspect the relevant files and project structure.
                            2. Use FileSystemTools to read existing files when needed.
                            3. Use FileSystemTools to create new files or edit existing files.
                            4. Follow the registered Java coding skills.
                            5. Report the files created or modified.
                            6. Never claim a change succeeded unless the tool confirms it.
                            """.formatted(System.getProperty("user.dir")))
                    .defaultTools(
                            SkillsTool.builder()
                                    .addSkillsDirectory(".claude/skills")
                                    .build(),
                            FileSystemTools.builder().build(),
                            GrepTool.builder().build(),
                            GlobTool.builder().build(),
                            ShellTools.builder().build()
                    ).build();

            var scanner = new Scanner(System.in);
            System.out.println("Agent at your service, Type 'exit' to quit.");
            while (true) {
                System.out.println("\n>");
                String input = scanner.nextLine();
                if ("exit".equalsIgnoreCase(input.trim())) break;

                try {
                    String response = chatClient.prompt()
                            .user(input)
                            .toolContext(Map.of("workDir", System.getProperty("user.dir")))
                            .call()
                            .content();
                    System.out.println("\n" + response);
                } catch (Exception e) {
                    System.err.println("Error:" + e.getMessage());
                }
            }
        };
    }

    private static void checkFileCreation() {
        FileSystemTools fileTools = FileSystemTools.builder().build();

        String result = fileTools.write(
                Path.of(System.getProperty("user.dir"),
                        "hello-test.txt").toAbsolutePath().toString(),
                "Hello from Sprout!"
        );

        System.out.println("File creation result: " + result);
    }

    private static void checkSkillsFilePath(Path skillsDirectory) {
        System.out.println("Skills directory: " + skillsDirectory);
        System.out.println("Exists: " + Files.isDirectory(skillsDirectory));

        Path skillFile = skillsDirectory
                .resolve("java-21-coding")
                .resolve("SKILL.md");

        System.out.println("SKILL.md exists: " + Files.isRegularFile(skillFile));
    }

}
