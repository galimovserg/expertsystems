package characteristic;

import java.util.ArrayList;

class Fact{
	private String name=new String();
	private ArrayList<String> ValuesList;
	Fact(String name){
		this.name=name;
		this.ValuesList = new ArrayList<String>();
	}
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
	boolean hasval(String val){
		int len = ValuesList.size();
		for(int i=0;i<len;i++){
			if(ValuesList.get(i).equals(val)){
				
				return true;
			}
		}
		return false;
	}
	public void print() {
		// TODO Auto-generated method stub
		System.out.println(this.name);
		for(int i=0;i<ValuesList.size();i++){
			System.out.println(" |---"+ValuesList.get(i));
		}
	}
}
