package characteristic;

import java.util.ArrayList;
import java.util.Scanner;

public class characteristic {
	
	
	
	static final String ONE="1";
	static final String TWO="2";
	static final String PRINTFACTS="3";
	static final String EXIT="4";
	static final String THREE="5";
	static final String FOUR="6";
	
	static class Fact{
		private String name=new String();
		private ArrayList<String> ValuesList;
		Fact(String name){
			this.name=name;
			this.ValuesList = new ArrayList<String>();
		}
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
	
	static class MultiRule{
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
	
	static ArrayList<Fact> CharacterList = new ArrayList<Fact>();
	static ArrayList<MultiRule> RulesList = new ArrayList<MultiRule>();
	
	
	static String getLine(int mode){
		if(mode==1){
			System.out.println("�������� �������:");
			System.out.println("1 - ���� ������ �������� ������ ��������������");
			System.out.println("2 - ���� ����� ��������������.");
			System.out.println("3 - �������� ������.");
			System.out.println("4 - �����.");
			Scanner in = new Scanner(System.in);
			String stroke=in.nextLine();
			return stroke;
		}else 
		if(mode==2){
			System.out.println("�������� �������:");
			System.out.println("5 - ���� ������ �������");
			System.out.println("6 - �������� ������");
			System.out.println("4 - �����.");
			Scanner in = new Scanner(System.in);
			String stroke=in.nextLine();
			return stroke;
		}
		return "";
		
	}
	static boolean readNewFact(){
		Scanner in = new Scanner(System.in);
		System.out.println("������� ��� ����� ��������������:");
		String stroke=in.nextLine();
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
		int len=CharacterList.size();
		for(int i=0;i<len;i++){
			
			if(CharacterList.get(i).getName().equals(stroke)){
				System.out.println("������� ����� ��������!");
				String value=in.nextLine();
				CharacterList.get(i).addValue(value);
				return true;
			}
			
		}
		
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
	static boolean implicate(String stroke){
		if(stroke.equals(ONE)){
			
			if(!readValues()){
				System.out.println("������ �������������� �� ����������!");
			}
			return true;
		}else
		if(stroke.equals(TWO)){
			if(!readNewFact()){
				System.out.println("�������������� � ����� ������ ��� ����������!");
			}
			return true;
		}else
		if(stroke.equals(PRINTFACTS)){
			printFacts();
			return true;
			
		}else
		if(stroke.equals(EXIT)){
			return false;
		}else
		if(stroke.equals(THREE)){
			if(!readNewMultiRule()){
				System.out.println("������� �� ���������!");
			}
			return true;
		}else
		if(stroke.equals(FOUR)){
			printRules();
			return false;
		}
		else{
			System.out.println("������� ����� �� 1 �� 4!");
			return true;
		}
		
		
	}
	static void readCharacteristics(){
		System.out.println("�� ���������� � ������� ������ � ����������������.");
		while(implicate(getLine(1))){
			
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
	static void readRules(){
		System.out.println("�� ���������� � ������� ������ � ���������.");
		while(implicate(getLine(2))){
			
		}
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		readCharacteristics();
		readRules();
		
	}

}