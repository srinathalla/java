package com.atlassian;

import java.util.*;

public class CommandProcessor {
    public static List<String> processCommands(List<String> commands) {
        List<String> output = new ArrayList<>();
        Deque<String> stack = new ArrayDeque<>();

        for (String command : commands) {
            if (command.startsWith("APPEND")) {
                String word = command.substring(7); // after "APPEND "
                stack.addLast(word);
            } else if (command.equals("DELETE")) {
                if (!stack.isEmpty()) {
                    stack.removeLast();
                }
            } else if (command.equals("PRINT")) {
                output.add(String.join(" ", stack));
            }
        }

        return output;
    }

    // Test run
    public static void main(String[] args) {
        List<String> cmds = List.of(
                "APPEND hello", "APPEND world", "PRINT",
                "DELETE", "PRINT", "DELETE", "DELETE", "PRINT"
        );
        System.out.println(processCommands(cmds)); // [hello world, hello, , ]
    }
}
