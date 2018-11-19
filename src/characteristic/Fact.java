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
	private ArrayList<Booleanv> ExpertList;
	class Booleanv{
		Boolean val=false;
		void booleanv(){
			val=false;
		}
		void setVal() {
			val=true;
		}
		Boolean getVal() {
			return val;
		}
	}
	Fact(String name){
		this.name=name;
		this.ValuesList = new ArrayList<String>();
		this.ExpertList = new ArrayList<Booleanv>();
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
		this.ExpertList.add(new Booleanv());
		return true;
	}
	boolean setExp(int num) {
		if(num<ValuesList.size()&&num>=0) {
			ExpertList.get(num).setVal();;
			return true;
		}else {
			return false;
		}
	}
	boolean setExp(String value) {
		int len = ValuesList.size();
		for(int i=0;i<len;i++){
			if(ValuesList.get(i).equals(value)){
				ExpertList.get(i).setVal();
				return true;
			}
		}
		return false;
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
	
	boolean isvaluetrue(String value) {
		int len = ValuesList.size();
		for(int i=0;i<len;i++){
			if(ValuesList.get(i).equals(value)){
				if(ExpertList.get(i).getVal()) {return true;}else {
					return false;
				}
				
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
			System.out.println(" |"+i+"|---"+ValuesList.get(i));
		}
	}
	public void printexpert() {
		System.out.println(this.name);
		for(int i=0;i<ValuesList.size();i++){
			if(ExpertList.get(i).getVal())
				System.out.println(" |"+i+"|---"+ValuesList.get(i));
		}
	}
	
}
