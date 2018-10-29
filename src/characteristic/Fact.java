package characteristic;

import java.util.ArrayList;
/**
 * �������������� �� ������� ��������� ��������.
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
	 * ��������� ����� ��������, ������ true ���� ���������� ������ ������� 
	 * � false ���� ����� �������� ��� ����.
	 * @param value
	 * @return
	 */
	boolean addValue(String value){
		if(hasval(value)){
			System.out.println("����� �������� ��� ����!");
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
	 * ������ true ���� �������� val ���� � ������ �������� ���� ��������������, 
	 * ����� ������ false.
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
	 * ������� ��� �������������� � �� ��������� ��������
	 * � �������� ���� � �������.
	 */
	public void print() {
		System.out.println(this.name);
		for(int i=0;i<ValuesList.size();i++){
			System.out.println(" |---"+ValuesList.get(i));
		}
	}
}
