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
    
    Value wstaw(String s, Value v) 
    {
        Value l;
        if(first == null)
        {
            l = new Value(s, null);
            first = l;
        }
        else
        {
            l = new Value(s, v.next);
            v.next = l;
        }
 
        return l;
    }
 
public   void drukuj() 
    {
        Value f = first;
        while(f != null)
        {
            System.out.print(f.value + "  "); //wypisujemy listê
            f = f.next;
        }
    }
    
    
public    void kasuj() 
    {
        Value f = first;
        Value prev = null;
        while(f != null)
        {
            if (f != null)
                if (prev == null)
                    first = f.next;
                else
                    prev.next = f.next;
        }
        System.gc(); // - wincyj nie mogê zrobiæ :>
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
        //	System.out.println("S³owa " + s + " nie ma na liœcie.");     	
    	return null;
        	else 	
        return String.valueOf(i);
         	
    }
    
    public   void bezpowtorzen() 
    {
        Value f = first;
        //robie pusta nowa liste
        while(f != null)
        {
            //zapisuje element jako element nowej listy po ifie czy sie nie powtarza (w petli dla kazdego argumentu drugiej listy)
            f = f.next;
        }
    }
    
/*public    void scal(Value a, Value b) 
    {
        Value f = first;
        while(a.first != null)
        {
            System.out.print(f.value + "  "); //wypisujemy listê
            f = f.next;
        }
    }*/
    
}
//*/ 

//---------------------------------------------------------------------------------------------

/*dwukierunkowa wiazana
class Value
{
    int value;
    Value next;
    Value prev;
 
    Value(int x, Value Next, Value Prev)
    {
        value = x;
        next = Next;
        prev = Prev;
    }
}
 
class List
{
    Value first;
    Value last;
 
    List()
    {
        first = null;
        last = null;
    }
 
    Value add(int x, Value v)
    {
        Value l;
        if(first == null)
        {
            l = new Value(x, null, null);
            first = l;
            first.prev = last;
            last = l;
            last.next = first;
        }
        else
        {
            l = new Value(x, v.next, v);
 
            if(l.next != null)
                v.next.prev = l;
            else
            {
                last = l;
                last.next = first;
            }
 
            v.next = l;
        }
 
        return l;
    }
 
    void delete(int x)
    {
        Value f = first;
        Value prev = null;
 
        while (f != null && f.value != x) {
            prev = f ;
            f = f.next;
        }
 
        if (f != null)
            if (prev == null)
            {
                first = f.next;
                first.prev = last;
            }
            else
            {
                prev.next = f.next;
 
                if(f.next == null)
                {
                    last = prev;
                    last.next = first;
                }
                else
                    f.next.prev = prev;
            }
    }
 
    int searchValue(int x)
    {
        Value f = first;
        
        if(f.value == x)
            return f.value;
        else
            f = f.next;
 
        while(f != null && f.value != x || f != first)
            f = f.next;
 
        return f.value;
    }
}
//*/

//---------------------------------------------------------------------------------------------

public class Listy2 {
 
    public static void main(String[] args) {
 
        List l1 = new List(); //tworzymy listê
        List l2 = new List(); //tworzymy listê
       Value v1 = null;
v1 = 
        l1.wstaw("a",v1); 
		l1.wstaw("11",v1); 
        l1.wstaw("13",v1); 
        l1.wstaw("11",v1);  
        System.out.println(l1.szukaj("11"));
        l1.usun("11"); 
        l1.drukuj();
     //   l1.kasuj();
        l1.drukuj();
       
        Value v2 = null;
v2 = 
        l2.wstaw("c",v2); 
        l2.wstaw("cc1",v2); 
        l2.wstaw("1c",v2); 
    //    l2.wstaw("1c",v2);
        l2.drukuj();
        l2.kasuj();
        l2.drukuj();
        l1.drukuj();
    }
}