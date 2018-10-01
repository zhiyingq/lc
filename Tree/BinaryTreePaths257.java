import java.lang.StringBuilder;
import java.util.List;
import java.util.ArrayList;
class BinaryTreePaths257 {
	public List<String> binaryTreePaths(TreeNode root) {
        List<String> strList = new ArrayList<>();
        StringBuilder str = new StringBuilder();
        pathHelper(root, str, strList);
        return strList;
    }

    private void pathHelper(TreeNode root, StringBuilder str, List<String> strList) {
    	if (root == null) return;
        String rootValue = String.valueOf(root.val);
        str.append(rootValue); 
    	if (root.left == null && root.right == null) {       	
    		strList.add(str.toString());
    		str.delete(str.length() - rootValue.length(), str.length()); 
    	}
    	else {
    		str.append("->"); 
    		pathHelper(root.left, str, strList);
    		pathHelper(root.right, str, strList);
            str.delete(str.length() - rootValue.length() - 2, str.length()); 
    	}
    }

    public static void main(String[] args) {
    	StringBuilder str = new StringBuilder();
    	str.append(-1);
    	System.out.println(str.toString());
    }
}