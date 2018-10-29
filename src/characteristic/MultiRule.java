package characteristic;
import java.util.ArrayList;

class MultiRule{
	//�� ����� �������������
	private ArrayList<Fact> facts=new ArrayList<Fact>();
	//� ������ �� ��������
	private ArrayList<String> vals=new ArrayList<String>();
	//������� ��������������
	private ArrayList<Fact> folwfacts=new ArrayList<Fact>();
	//� ����� �� ��������
	private ArrayList<String> folwvals=new ArrayList<String>();
	MultiRule(){
		
	}
	void print(){
		System.out.println("���� ");
		int count=facts.size();
		for(int i=0;i<count;i++){
			System.out.print("    (");
			System.out.print(facts.get(i).getName()+" == \""+vals.get(i)+"\"");
			String ch=" � ";
			if(i==count-1){
				ch="";
			}
			System.out.println(")"+ch);
			
		}
		System.out.println("�� ");
		
		for(int i=0;i<folwfacts.size();i++){
			System.out.println("    "+folwfacts.get(i).getName()+" = \""+folwvals.get(i)+"\";");
		}
	}
	//������������ � �������
	//0 - �������������� ��� ����
	//1 - �������������� ���, �� �������� �� ������ � ������ ���������
	//3 - ��� ������
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
	//������������ � ���������
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