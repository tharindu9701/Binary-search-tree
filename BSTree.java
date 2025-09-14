class Node{
    int data;
    Node left;
    Node right;

    public Node(int data){
        this.data = data;
        this.left = null;
        this.right= null;
    } 
}

public class BSTree{
    Node root;

    public BSTree(){
        this.root = null;
    }

    public boolean isEmpty(){
        return root == null;
    }

    public Node insert(Node cNode, int data){
        if(cNode == null){
            cNode = new Node(data);//create new node
            return cNode;
        }

        else if (data < cNode.data){
            cNode.left = insert(cNode.left, data); // update left node
        }

        else if (data > cNode.data){
            cNode.right = insert(cNode.right, data); // update right node
        }
        return cNode;    
        
    }

    public void inordertraversal(Node cNode){
        if (cNode!=null){
            inordertraversal(cNode.left);
            System.out.print(cNode.data + " ");
            inordertraversal(cNode.right);
        }
    }

    public void postorderTraversal(Node cNode){
        if (cNode!=null){
            postorderTraversal(cNode.left);
            postorderTraversal(cNode.right);
            System.out.print(cNode.data + " ");
        }
    }

    public void preorderTraversal(Node cNode){
        if (cNode!= null){
            System.out.print(cNode.data + " ");
            preorderTraversal(cNode.left);
            preorderTraversal(cNode.right);

        }
    }

    public boolean search(Node cNode, int data){
        if (cNode == null){
            return false;
        }
        else if (cNode.data == data){
            return true;
        }
        else if (cNode.data < data){
            return  search(cNode.right,data);
        }
        else{
            return search(cNode.left,data);
        }
    }

    public int min(Node cNode){
        if (cNode.left == null){
            return cNode.data;
        }
        else{
            return min(cNode.left);
        }
    }
    public int max(Node cNode){
        if (cNode.right == null){
            return cNode.data;
        }
        else{
            return max(cNode.right);
        }
    }

    public Node delete(Node cNode,int data){
        if (cNode == null){
            return cNode;
        }
        else if(data < cNode.data){
            cNode.left = delete(cNode.left,data);
        }
        else if(data > cNode.data){
            cNode.right = delete(cNode.right,data);
        }
        else{
            if(cNode.right == null && cNode.left == null) {
                return cNode = null;
            }
            else if(cNode.left==null){
                cNode =cNode.right;
            }
            else if(cNode.right == null){
                cNode = cNode.left;
            }
            else{
                int minvalue = min(cNode.right);
                cNode.data = minvalue;
                cNode.right = delete(cNode.right,minvalue);
            }
        }return cNode;

    }


    public static void main(String[] args){
        BSTree mylist = new BSTree();

        System.out.println(mylist.isEmpty());

        mylist.root = mylist.insert(mylist.root,10);
        mylist.root = mylist.insert(mylist.root,20);
        mylist.root = mylist.insert(mylist.root,40);
        mylist.root = mylist.insert(mylist.root,70);
        mylist.root = mylist.insert(mylist.root,90);
        mylist.root = mylist.insert(mylist.root,65);
        mylist.root = mylist.insert(mylist.root,14);
        mylist.root = mylist.insert(mylist.root,7);
        mylist.root = mylist.insert(mylist.root,50);
        mylist.root = mylist.insert(mylist.root,87);

        System.out.print("Inorder traversal : ");
        mylist.inordertraversal(mylist.root);
        System.out.println();

        System.out.print("postorderTraversal : ");
        mylist.postorderTraversal(mylist.root);
        System.out.println();


        System.out.print("preorderTraversal : ");
        mylist.preorderTraversal(mylist.root);
        System.out.println();

        System.out.println(mylist.search(mylist.root,10));

        System.out.print("Min value " +mylist.min(mylist.root)+"\n");
        System.out.print("Max value " +mylist.max(mylist.root)+"\n");

        mylist.delete(mylist.root, 20);
        mylist.inordertraversal(mylist.root);
    }

}