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
		/**
		 * Переопределяемый метод, выполняется при выборе этого пункта.
		 */
		void action() {	
		}
		/**
		 * Добавляет дочерний пункт
		 * @param item
		 */
		final void addItem(Item item){
			if(subitems==null)subitems=new ArrayList<Item>();
			item.setParent(this);
			subitems.add(item);  
			
		}
		//устанавливает родительский пункт
		final void setParent(Item item) {
			parent=item;
		}
		/**
		 * возвращает описание меню
		 * @return
		 */
		String getCaption() {
			return caption;
		}
		/**
		 * Возвращает пункт который выбрал пользователь
		 * @param stroka
		 * @return
		 */
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
		/**
		 * выводит пункты на выбор
		 */
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
	/**
	 * Добавляет главный пункт
	 * @param item
	 */
	void addItem(Item item) {
		if(head==null)
			head=new Item(" ");
		item.setParent(head);
		head.addItem(item);
		
	}
	/**
	 * Выводит меню и ожидает выбора, возвращает следующий пункт к которому следует перейти
	 * @param item
	 * @return
	 */
	Item getItem(Item item) {
		item.action();
		if(item.subitems==null) {	
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
	/**
	 * метод вызывается при инициализации объекта меню,
	 * здесь следует задовать его структуру и методы для пунктов
	 */
	void onCreate() {
		// TODO Auto-generated method stub
		
	}
	Navigator(){
		onCreate();
	}
}
