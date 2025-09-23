class Solution {
    public int compareVersion(String version1, String version2) {
         String[] v1Parts = version1.split("\\.");
        String[] v2Parts = version2.split("\\.");
        
        // Get maximum length to handle different number of revisions
        int maxLength = Math.max(v1Parts.length, v2Parts.length);
        
        // Compare each revision
        for (int i = 0; i < maxLength; i++) {
            
            int rev1 = i < v1Parts.length ? Integer.parseInt(v1Parts[i]) : 0;
            int rev2 = i < v2Parts.length ? Integer.parseInt(v2Parts[i]) : 0;
            
            // Compare current revisions
            if (rev1 < rev2) {
                return -1;
            } else if (rev1 > rev2) {
                return 1;
            }
            
        }
        
        return 0; 
    }
}