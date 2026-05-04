import java.util.HashSet;
import java.util.Set;

class Solution {
    public int numUniqueEmails(String[] emails) {
        Set<String> uniqueEmails = new HashSet<>();
        
        for (String email : emails) {
            // Split into local and domain parts
            int atIndex = email.indexOf('@');
            String local = email.substring(0, atIndex);
            String domain = email.substring(atIndex); // Keeps the '@'
            
            // Apply plus rule: ignore everything after '+'
            if (local.contains("+")) {
                local = local.substring(0, local.indexOf('+'));
            }
            
            // Apply dot rule: remove all '.'
            local = local.replace(".", "");
            
            // Reconstruct and add to set
            uniqueEmails.add(local + domain);
        }
        
        return uniqueEmails.size();
    }
}
