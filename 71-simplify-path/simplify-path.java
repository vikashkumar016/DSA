class Solution {
    public String simplifyPath(String path) {
           Stack<String> stack = new Stack<>();
        
        // Split the input path by "/"
        String[] components = path.split("/");
        
        for (String component : components) {
            // If the component is empty or "." → ignore it (current directory)
            if (component.equals("") || component.equals(".")) {
                continue;
            }
            
            // If the component is "..", pop from the stack (go to parent directory)
            if (component.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                // Otherwise, push the directory onto the stack
                stack.push(component);
            }
        }
        
        // If the stack is empty, return "/"
        if (stack.isEmpty()) {
            return "/";
        }
        
        // Join the stack components with "/" to form the simplified path
        StringBuilder simplifiedPath = new StringBuilder();
        while (!stack.isEmpty()) {
            simplifiedPath.insert(0, "/" + stack.pop());
        }
        
        return simplifiedPath.toString();
    }
}