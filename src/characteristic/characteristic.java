package characteristic;

import java.util.ArrayList;
import java.util.Scanner;



public class characteristic {
	
	static ArrayList<Fact> CharacterList = new ArrayList<Fact>();
	static ArrayList<MultiRule> RulesList = new ArrayList<MultiRule>();
	
	static boolean readNewFact(){
		Scanner in = new Scanner(System.in);
		System.out.println("������� ��� ����� ��������������:");
		String stroke=in.nextLine();
		in.close();
		Fact newfact = new Fact(stroke);
		int len=CharacterList.size();
		for(int i=0;i<len;i++){
			if(CharacterList.get(i).getName().equals(newfact.getName())){
				return false;
			}
		}
		CharacterList.add(newfact);
		
		return true;
	}
	static Fact searchByName(String name){
		int len=CharacterList.size();
		for(int i=0;i<len;i++){
			
			if(CharacterList.get(i).getName().equals(name)){
				
				return CharacterList.get(i);
			}
			
		}
		return null;
	}
	static boolean readValues(){
		
		Scanner in = new Scanner(System.in);
		System.out.println("������� ��� ������������ ��������������!");
		String stroke=in.nextLine();
		Fact locfact=searchByName(stroke);
		if(locfact!=null) {
			System.out.println("������� ����� ��������!");
			String value=in.nextLine();
			locfact.addValue(value);
			
			return true;
		}
		in.close();
		return false;
	}
	static boolean readNewMultiRule(){
		MultiRule locRule=new MultiRule();
		Scanner in = new Scanner(System.in);
		
		System.out.println("���� �������...");
		System.out.println("������� ��� ������������ ��������������!");
		String name=in.nextLine();
		Fact locfact=searchByName(name);
		if(locfact==null){
			
			System.out.println("�������������� �� ������");
			return false;
		}
		System.out.println("������� ��������!");
		String value=in.nextLine();
		int rt=locRule.joincondition(locfact, value);
		//0 - �������������� ��� ����
		//1 - �������������� �� �������, �� �������� �� ������ � ������ ���������
		//2 - ��� ������
		if(rt==0){
			
			System.out.println("�������������� ��� ����");
			return false;
		}else
		if(rt==1){
			
			System.out.println("�������� �� ������ � ������ ���������");
			return false;
		}
		
		
		System.out.println("���� ���������...");
		System.out.println("������� ��� ������������ ��������������!");
		String namec=in.nextLine();
		Fact locfactc=searchByName(namec);
		if(locfactc==null){
			System.out.println("�������������� �� ������");
			
			return false;
		}
		System.out.println("������� ��������!");
		String valuec=in.nextLine();
		rt=locRule.joinconsequence(locfactc, valuec);
		if(rt==0){
			System.out.println("�������������� ��� ����");
			
			return false;
		}else
		if(rt==1){
			System.out.println("�������� �� ������ � ������ ���������");
			
			return false;
		}
		
		RulesList.add(locRule);
		
		return true;
	}
	private static void printFacts() {
		// TODO Auto-generated method stub
		int len = CharacterList.size();
		if(len==0)System.out.println("�������������� �����������!");
		for(int i=0;i<len;i++){
			CharacterList.get(i).print();
			
		}
		
	}
	private static void printRules() {
		// TODO Auto-generated method stub
		int len = RulesList.size();
		if(len==0)System.out.println("������� �����������!");
		for(int i=0;i<len;i++){
			RulesList.get(i).print();
			
		}
		
	}
	

	static void multirultest(){
		
		Fact haircolor = new Fact("����_�����");
		haircolor.addValue("�����");
		haircolor.addValue("����������");
		haircolor.addValue("����������");
		
		Fact eyecolor = new Fact("����_����");
		eyecolor.addValue("�������");
		eyecolor.addValue("�����");
		eyecolor.addValue("�������");
		eyecolor.addValue("������");
		
		Fact dresscolor = new Fact("����_������");
		eyecolor.addValue("�����");
		eyecolor.addValue("�������");
		eyecolor.addValue("������");
		eyecolor.addValue("������");
		
		
		MultiRule myrule=new MultiRule();
		myrule.joincondition(haircolor, "�����");
		myrule.joincondition(eyecolor, "�����");
		myrule.joinconsequence(dresscolor, "������");
		myrule.print();
		
		
	}

	
	
	public static void main(String[] args) {
		Navigator nav=new Navigator() {
			@Override 
			void onCreate() {
				Item item1=new Item("��������������");
				
				Item item11=new Item("���� ������ �������� ������ ��������������") {
					@Override
					void action() {
						if(!readValues()){
							System.out.println("������ �������������� �� ����������!");
						}
					}
					
				};
				Item item12=new Item("���� ����� ��������������") {
					@Override
					void action() {
						if(!readNewFact()){
							System.out.println("����� �������������� ��� ����������!");
						}
					}
					
				};
				Item item13=new Item("�������� �������������") {
					@Override
					void action() {
						printFacts();
					}
					
				};
				Item item2=new Item("�������");
				
				Item item21=new Item("���� ������ �������") {
					@Override
					void action() {
						if(!readNewMultiRule()){
							System.out.println("������� �� ���������!");
						}
					}
				};
				
				Item item22=new Item("������ �������");
				
				Item item23=new Item("�������� ������") {
					@Override
					void action() {
						System.out.write(13);
						printRules();
					}
				};
				item1.addItem(item11);
				item1.addItem(item12);
				item1.addItem(item13);
				item2.addItem(item21);
				item2.addItem(item22);
				item2.addItem(item23);
				addItem(item1);
				addItem(item2);
			}
			
		};
		nav.run();
		
		
	}
	
	

}