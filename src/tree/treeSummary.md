# TreeSummary

## 树的遍历
### 前序遍历
根，左，右
```java
public void preOrderTraverse1(TreeNode root) {
		if (root != null) {
			// do something

			preOrderTraverse1(root.left);
			preOrderTraverse1(root.right);
		}
```
非递归版本，利用一个栈。
栈用来存储“当前节点”，用来访问此节点的右儿子。

非递归版本有一个关键处，就是每个node只入栈一次，这样避免重复。
中序同理。
```java
public void preOrderTraverse2(TreeNode root) {
		LinkedList<TreeNode> stack = new LinkedList<>();
		TreeNode pNode = root;
		while (pNode != null || !stack.isEmpty()) {
			if (pNode != null) {
				// do something

				stack.push(pNode);
				pNode = pNode.left;
			} else { //pNode == null && !stack.isEmpty()
				TreeNode node = stack.pop();
				pNode = node.right;
			}
		}
	}
```


### 中序遍历
左，根，右
```java
public void preOrderTraverse1(TreeNode root) {
		if (root != null) {
			preOrderTraverse1(root.left);
			// do something

			preOrderTraverse1(root.right);
		}
```
非递归版本，利用一个栈。
栈用来存储“当前节点”，用来访问此节点的右儿子
```java
public void inOrderTraverse2(TreeNode root) {
		LinkedList<TreeNode> stack = new LinkedList<>();
		TreeNode pNode = root;
		while (pNode != null || !stack.isEmpty()) {
			if (pNode != null) {
				stack.push(pNode);
				pNode = pNode.left;
			} else { //pNode == null && !stack.isEmpty()
				TreeNode node = stack.pop();
				// do something

				pNode = node.right;
			}
		}
	}
```

### 后序遍历
左，右, 根
```java
public void preOrderTraverse1(TreeNode root) {
		if (root != null) {
			preOrderTraverse1(root.left);
			preOrderTraverse1(root.right);
			// do something

		}
```

### 层次遍历
利用一个队列，先进先出

```java
public class Sword32_LevelOrder {
    public int[] levelOrder(TreeNode root) {
        if(root == null) {
            return new int[0];
        }
        List<Integer> l = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();

        q.offer(root);


        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++){
                TreeNode tmpNode = q.poll();
                l.add(tmpNode.val);

                if(tmpNode.left!=null) {
                    q.offer(tmpNode.left);
                }

                if(tmpNode.right!=null) {
                    q.offer(tmpNode.right);
                }
            }
        }

        int[] res = new int[l.size()];

        for(int i = 0; i < l.size(); i++){
            res[i] = l.get(i);
        }
        return res;

    }
}
```
