package characteristic;
import java.util.ArrayList;
/**
 * Составное правило или правило которое состоит из составного условия и составного следствия.
 * Подразумевается что при выполнении составного условия составное следствие является истинным.
 * Чтобы составное условие было истинным нужно чтобы каждое условие было истинным.
 * @author sergey
 *
 */
class MultiRule{
	//из набор характеристик
	private ArrayList<Fact> facts=new ArrayList<Fact>();
	//и набора их значений
	private ArrayList<String> vals=new ArrayList<String>();
	//следуют характеристики
	private ArrayList<Fact> folwfacts=new ArrayList<Fact>();
	//и набор их значений
	private ArrayList<String> folwvals=new ArrayList<String>();
	MultiRule(){
		
	}
	/**
	 * Выводит правило в понятном виде в консоль.
	 */
	void print(){
		System.out.println("ЕСЛИ ");
		int count=facts.size();
		for(int i=0;i<count;i++){
			System.out.print("    (");
			System.out.print(facts.get(i).getName()+" == \""+vals.get(i)+"\"");
			String ch=" И ";
			if(i==count-1){
				ch="";
			}
			System.out.println(")"+ch);
		}
		System.out.println("ТО ");
		
		for(int i=0;i<folwfacts.size();i++){
			System.out.println("    "+folwfacts.get(i).getName()+" = \""+folwvals.get(i)+"\";");
		}
	}

	/**
	 * Добавляет условие к составному условию, то есть характеристику и ее значение.
	 * Вернет 0 если характеристика nfact в условии уже есть, 1 если значение val не входит в список возможных
	 * характеристики nfact
	 * и 2 если условие успешно добавлено. 
	 * 
	 * @param nfact
	 * @param val
	 * @return
	 */
	int joincondition(Fact nfact, String val){
		for(int i=0;i<facts.size();i++){
			if(nfact!=facts.get(i)){
				
			}else{
				return 0;
			}
		}
		if(nfact.hasval(val)){
			facts.add(nfact);
			vals.add(val);
			return 2;
		}
		return 1;
	}
	/**
	 * Добавляет следствие к составному следствию, то есть характеристику и ее значение.
	 * Вернет 0 если характеристика nfact в следствии уже есть, 1 если значение val не входит в список возможных
	 * характеристики nfact
	 * и 2 если следствие успешно добавлено.
	 * Следствия, добавленные этим методом будут вытекать при истинности всех условий составного условия, 
	 * добавленные методом joinconduction.
	 * @param nfact
	 * @param val
	 * @return
	 */
	int joinconsequence(Fact nfact, String val){
		for(int i=0;i<folwfacts.size();i++){
			if(nfact!=folwfacts.get(i)){	
			}else{
				return 0;
			}
		}
		if(nfact.hasval(val)){
			folwfacts.add(nfact);
			folwvals.add(val);
			return 2;
		}
		return 1;
	}
	
	
}