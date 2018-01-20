//*jednokierunkowa
class Value
{
	 String  value;
	 Value next;
 
    Value(String s, Value Next)
    {
        this.value = s;
        this.next = Next;
    }
}
 
class List
{
    Value first;
 
    List()
    {
        first = null; //odnosnik do pierwszego elementu, wazne
    }
    
public void  wstaw(String s) 
    {
        Value l;
        if(first == null)
        {
            l = new Value(s, null);
            first = l;
        }
        else
        {
			l = new Value(s, first);
            first = l;
        }
 
    }
 
public   void drukuj() 
    {
        Value f = first;
        System.out.print("Wezly:\n");
        while(f != null)
        {
            System.out.print(f.value + "  "); //wypisujemy listę
            f = f.next;
        }
        System.out.print("\n");
    }
    


public    void kasuj() 
{

    if (first != null)
    	first = null;
    System.gc(); 
}


public    void usun(String s)
    {
        Value f = first;
        Value prev = null;
 
        while (f != null && f.value != s) {
            prev = f ;
            f = f.next;
        }
 
        if (f != null)
            if (prev == null)
                first = f.next;
            else
                prev.next = f.next;
    }
 
public   String szukaj(String s)
    {
        Value f = first;
        int i=0;
        while(f != null && f.value != s) {
            f = f.next;
        	i++;
           }
        if (f == null) 
        //	System.out.println("Słowa " + s + " nie ma na liście.");     	
    	return null;
        	else 	
        return String.valueOf(i);
         	
    }
    
    public void bezpowtorzen() 
    {
    	List kopia = new List();
    	Value f = first;
        while(f != null)
        {
        	if (kopia.szukaj(f.value)==null)
        	kopia.wstaw(f.value);
            f = f.next;
        }
        kopia.drukuj();
    }
    
    public void scal(List a) 
    {
	Value f = a.first;
    while(f != null)
    	{
    	this.wstaw(f.value);
        f = f.next;
    	}
    a.kasuj();
    }
    
}


//---------------------------------------------------------------------------------------------



//---------------------------------------------------------------------------------------------

public class Listy2 {
 
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
