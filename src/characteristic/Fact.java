package characteristic;

import java.util.ArrayList;
/**
 * Характеристика со списком возможных значений.
 * @author sergey
 *
 */
class Fact{
	private String name=new String();
	private ArrayList<String> ValuesList;
	Fact(String name){
		this.name=name;
		this.ValuesList = new ArrayList<String>();
	}
	/**
	 * Добавляет новое значение, вернет true если добавление прошло успешно 
	 * и false если такое значение уже есть.
	 * @param value
	 * @return
	 */
	boolean addValue(String value){
		if(hasval(value)){
			System.out.println("Такое значение уже есть!");
			return false;
		}
		this.ValuesList.add(value);
		return true;
	}
	String getName(){
		return this.name;
	}
	ArrayList<String> getValues(){
		return null;
	}
	/**
	 * Вернет true если значение val есть в списке значений этой характеристики, 
	 * иначе вернет false.
	 * @param val
	 * @return
	 */
	boolean hasval(String val){
		int len = ValuesList.size();
		for(int i=0;i<len;i++){
			if(ValuesList.get(i).equals(val)){
				
				return true;
			}
		}
		return false;
	}
	/**
	 * Выводит имя характеристики и ее возможные значения
	 * в понятном виде в консоль.
	 */
	public void print() {
		System.out.println(this.name);
		for(int i=0;i<ValuesList.size();i++){
			System.out.println(" |---"+ValuesList.get(i));
		}
	}
}
