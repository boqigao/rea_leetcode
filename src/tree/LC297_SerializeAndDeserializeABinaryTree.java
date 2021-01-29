package tree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LC297_SerializeAndDeserializeABinaryTree {

    public String serialize(TreeNode root) {      //用StringBuilder
        StringBuilder res = ser_help(root, new StringBuilder());
        return res.toString();
    }

    public StringBuilder ser_help(TreeNode root, StringBuilder str){
        if(null == root){
            str.append("null,");
            return str;
        }
        str.append(root.val);
        str.append(",");
        str = ser_help(root.left, str);
        str = ser_help(root.right, str);
        return str;
    }

    public TreeNode deserialize(String data) {
        String[] str_word = data.split(",");
        List<String> list_word = new LinkedList<String>(Arrays.asList(str_word));
        return deser_help(list_word);
    }

    public TreeNode deser_help(List<String> li){
        // 如果是null的话，那么就要直接取出，相当于某个左儿子，或者右儿子是null
        if(li.get(0).equals("null")){
            li.remove(0);
            return null;
        }
        // 如果非null的话，就将其值取出，然后将其作为新的根
        // (虽然这里他是新的根，但是还是要作为儿子被返回的)
        TreeNode res = new TreeNode(Integer.valueOf(li.get(0)));
        li.remove(0);
        res.left = deser_help(li);
        res.right = deser_help(li);
        return res;
    }
}
