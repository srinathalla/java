package com.atlassian;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class PathResolver {

    public static String getFinalPath(String path, List<String> commands) {

        Deque<String> stack  = new ArrayDeque<String>();
        for(String dir : path.split("/"))
        {
            if(!dir.isEmpty())
                stack.addLast(dir);
        }

        for(String command : commands)
        {
            if(!command.startsWith("cd"))
                continue;
            String arg = command.substring(3).trim();
            if(arg.startsWith("/"))
            {
                if(!stack.isEmpty())
                    stack.clear();
                for(String dir : arg.split("/"))
                {
                    if(!dir.isEmpty())
                    {
                        stack.addLast(dir);
                    }
                }
            }
            else if(arg.startsWith(".."))
            {
                stack.removeLast();
            }
            else {
                stack.add(arg);
            }
        }

        StringBuilder sb = new StringBuilder();
        if(stack.isEmpty())
        {
            return "/";
        }
        for(String dir:stack)
        {
            sb.append("/").append(dir);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String start = "/a/b";
        List<String> commands = List.of("cd c", "cd ..", "cd /x/y", "cd ..", "cd z");
        System.out.println(getFinalPath(start, commands)); // Output: /x/z
    }
}
