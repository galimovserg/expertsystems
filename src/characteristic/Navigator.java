package characteristic;

import java.util.ArrayList;
import java.util.Scanner;

public class Navigator {
	static class Item{
		private String caption="";
		private Item parent=null;
		ArrayList<Item> subitems=null;
		
		Item(String caption){
			this.caption=caption;
		}
		void action() {	
		}
		final void addItem(Item item){
			if(subitems==null)subitems=new ArrayList<Item>();
			item.setParent(this);
			subitems.add(item);  
			
		}
		final void setParent(Item item) {
			parent=item;
		}
		String getCaption() {
			return caption;
		}
		Item getByNum(String stroka) {
			if(subitems==null) return this;
			int pos=Integer.valueOf(stroka)-1;
			if(pos>=0&&pos<=subitems.size()) {
				Item item=subitems.get(pos);
				return item;
			}else {
				return null;
			}
			
		}
		void print(){
			
			System.out.println("Выбирите пункт:");
			for(int i=0;i<subitems.size();i++) {
				Item locit = subitems.get(i);
				if(locit!=null)
					System.out.println(" "+(int)(i+1)+" - "+locit.getCaption() );
				
			}
			System.out.println("0 - Выход");
		}
		Item getParent() {
			return parent;
		}
		
	}
	
	Item head=null;
	void addItem(Item item) {
		if(head==null)
			head=new Item(" ");
		item.setParent(head);
		head.addItem(item);
		
	}
	Item getItem(Item item) {
		if(item.subitems==null) {
			item.action();
			return item.getParent();
		}
		item.print();
		Scanner in=new Scanner(System.in);	
		String stroka=in.nextLine();
		
		if(stroka.equals("0")) {
			return item.getParent();
		}else {
			
			return item.getByNum(stroka);
		}	
		
	}
	void run() {		
		Item pos=head;
		while(pos!=null) {
			pos=getItem(pos);
			
		}		
		
	}
	void onCreate() {
		// TODO Auto-generated method stub
		
	}
	Navigator(){
		onCreate();
	}
}
