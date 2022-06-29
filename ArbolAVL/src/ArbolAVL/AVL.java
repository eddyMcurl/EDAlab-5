package ArbolAVL;

public class AVL<E extends Comparable<E>>  {
    private Node<E> root;
	private boolean height;
    public AVL() {
		this.root = null;
	}
	public boolean isEmpty() {
		return this.root == null;
	}
    public void insert(E x) throws ItemDuplicated{
        this.height = false;
		this.root = insertRec(x, this.root);
	}
    private Node<E> insertRec(E x,Node<E> current) throws ItemDuplicated {
        Node<E> res = current;
        if (current == null) {//buscamos ver si el árbol esta vacio.
			this.height = true;
			res = new Node<E>(x);
		}
        else {
			int resC = current.data.compareTo(x);
			if(resC == 0)//si hay repeticion
				throw new ItemDuplicated("El numero ingresado "+x+" ya existe");
            else if(resC < 0)//el numero es mayor ue el nodo 
				res.right = insertRec(x, current.right);
				if (this.height) {
					switch(res.fb) {
					case -1 : res.fb = 0; 
                        this.height = false; break;
					case 0 : res.fb = 1; 
                        this.height = true; break;
					case 1 : res.fb = 2;
						res = balanceToLeft(res);
						this.height = false;
					}
				}
            else {
                res.left = insertRec(x, current.left);
				if (this.height) {
					switch(res.fb) {
					case -1 : res.fb = 0; this.height = false; break;
					case 0 : res.fb = 1; this.height = true; break;
					case 1 : res.fb = 2;
							 res = balanceToRight(res);
							 this.height = false;
					}
				} 
            }  
        }
        return res;

    }
    public E search(E x) {
        return null;
    }
    public void remove(E x) {	
    }
    public String toString() {
        return null;
    }
}
