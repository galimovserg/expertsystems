package characteristic;
import java.util.ArrayList;

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
	//присоединяем к условию
	//0 - характеристика уже есть
	//1 - характеристики нет, но значение не входит в список возможных
	//3 - все удачно
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
	//присоединяем к следствию
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