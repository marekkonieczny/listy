//*dwukierunkowa z wartownikiem
package listy2;
class Node
{
	 Integer key;
	 Node  parent;
	 Node  left;
	 Node  right;
 
	 Node(Integer k, Node p, Node l, Node r)
    {
        this.key    = k;
        this.parent = p;
        this.left   = l;
        this.right  = r;
    }
}
 
class Tree
{
    Node root;

    Tree()
    {
    }
    
public void  wstaw(Integer k) 
    {
        Node n;
            n = new Node (k, null, null);

    }
 
public   void drukuj() 
    {
        Value g = Gandalf.next;
        System.out.print("Wezly:\n");
        while(g != Gandalf)
        {
            System.out.print(g.value + "  "); //wypisujemy listę
            g = g.next;
        }
        System.out.print("\n");
    }

public   void drukujOdKonca() 
{                        
    Value g = Gandalf.prev;
    System.out.print("Wezly:\n");
    while(g != Gandalf)
    {
        System.out.print(g.value + "  "); //wypisujemy listę od tylu
        g = g.prev;
    }
    System.out.print("\n");
}
    

public    void kasuj() 
{
    	Gandalf.prev = Gandalf;
    	Gandalf.next = Gandalf;
    	System.gc(); 
}

public    void usun(String s)
    {
		Value g = Gandalf.next;
        while (g != Gandalf) {
            if(g.value==s)
            {
            	g.prev.next=g.next;
            	g.next.prev=g.prev;
            	break;
            }
        	g = g.next;
        }
    }
 
public   String szukaj(String s)
    {
        Value g = Gandalf.next;
        int i=0;
        while(g != Gandalf && g.value != s) {
            g = g.next;
        	i++;
           }
        if (g == Gandalf) 
        //	System.out.println("Słowa " + s + " nie ma na liście.");     	
    	return null;
        	else 	
        return String.valueOf(i);
         	
    }
    
    public void bezpowtorzen() 
    {
    	List kopia = new List();
    	Value g = Gandalf.next;
        while(g != Gandalf)
        {
        	if (kopia.szukaj(g.value)==null)
        	kopia.wstaw(g.value);
            g = g.next;
        }
        kopia.drukuj();
    }
    
    public void scal(List a) 
    {
    	this.Gandalf.prev.next=a.Gandalf.next;
    	a.Gandalf.next.prev=this.Gandalf.prev;
    	a.Gandalf.prev.next=this.Gandalf;
    a.kasuj();
    }
    
}


//---------------------------------------------------------------------------------------------



//---------------------------------------------------------------------------------------------

public class listy4 {
 
    public static void main(String[] args) {
 
    	 List l1 = new List(); //tworzymy listę
         //l1.wstaw("a",v1); 
          l1.wstaw("a");
          l1.wstaw("a");
          System.out.print("Szukam a w l1, wyswietli null albo nr wezla (od 0)\n");
  		System.out.println(l1.szukaj("a"));
  		System.out.print("Drukuje l1, wstawilem a, a\n");
  		l1.drukuj();
          List l2 = new List();
          l2.wstaw("b");
          l2.wstaw("3a");
          l2.wstaw("4");
          l2.wstaw("3");
          l2.usun("3a");
          System.out.print("Drukuje l2, wstawilem b, 3a, 4, 3, usunalem 3a\n");
          l2.drukuj();
          System.out.print("Drukuje od konca l2, wstawilem b, 3a, 4, 3, usunalem 3a\n");
          l2.drukujOdKonca();
          l2.kasuj();
          System.out.print("Drukuje l2 po skasowaniu\n");
          l2.drukuj();
          System.out.print("Drukuje l1 po skasowaniu l2\n");
          l1.drukuj();
          l2.wstaw("I did it");
          l2.wstaw("ccc");
          l1.scal(l2);
          System.out.print("Drukuje l1 po scaleniu z l2, do ktorego dodalem I did it, ccc\n");
          l1.drukuj();
          System.out.print("Drukuje l2 po scaleniu do l1, powinno byc skasowane\n");
          l2.drukuj();
          System.out.print("Drukuje l1 bez powtorzen\n");
          l1.bezpowtorzen();
         
    }
}