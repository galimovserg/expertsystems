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
	
	static ArrayList<Fact> CharacterList = new ArrayList<Fact>();
	static ArrayList<MultiRule> RulesList = new ArrayList<MultiRule>();
	
	
	static String getLine(int mode){
		if(mode==1){
			System.out.println("Выберите команду:");
			System.out.println("1 - Ввод нового значения старой характеристики");
			System.out.println("2 - Ввод новой характеристики.");
			System.out.println("3 - Просмотр фактов.");
			System.out.println("4 - Выход.");
			Scanner in = new Scanner(System.in);
			String stroke=in.nextLine();
			return stroke;
		}else 
		if(mode==2){
			System.out.println("Выберите команду:");
			System.out.println("5 - Ввод нового правила");
			System.out.println("6 - Просмотр правил");
			System.out.println("4 - Выход.");
			Scanner in = new Scanner(System.in);
			String stroke=in.nextLine();
			return stroke;
		}
		return "";
		
	}
	
	static boolean implicate(String stroke){
		if(stroke.equals(ONE)){
			
			if(!readValues()){
				System.out.println("Данной характеристики не существует!");
			}
			return true;
		}else
		if(stroke.equals(TWO)){
			if(!readNewFact()){
				System.out.println("Характеристика с таким именем уже существует!");
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
				System.out.println("Правило не добавлено!");
			}
			return true;
		}else
		if(stroke.equals(FOUR)){
			printRules();
			return true;
		}
		else{
			System.out.println("Введите цифру от 1 до 4!");
			return true;
		}
		
		
	}
	static boolean readNewFact(){
		Scanner in = new Scanner(System.in);
		System.out.println("Введите имя новой характеристики:");
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
		System.out.println("Введите имя существующей характеристики!");
		String stroke=in.nextLine();
		int len=CharacterList.size();
		Fact locfact=searchByName(stroke);
		if(locfact!=null) {
			System.out.println("Введите новое значение!");
			String value=in.nextLine();
			locfact.addValue(value);
			return true;
		}
		
		return false;
	}
	static boolean readNewMultiRule(){
		MultiRule locRule=new MultiRule();
		Scanner in = new Scanner(System.in);
		
		System.out.println("Ввод условия...");
		System.out.println("Введите имя существующей характеристики!");
		String name=in.nextLine();
		Fact locfact=searchByName(name);
		if(locfact==null){
			System.out.println("характеристики не задана");
			return false;
		}
		System.out.println("Введите значение!");
		String value=in.nextLine();
		int rt=locRule.joincondition(locfact, value);
		//0 - характеристика уже есть
		//1 - характеристика не найдена, но значение не входит в список возможных
		//2 - все удачно
		if(rt==0){
			System.out.println("характеристика уже усть");
			return false;
		}else
		if(rt==1){
			System.out.println("значение не входит в список возможных");
			return false;
		}
		
		
		System.out.println("Ввод следствия...");
		System.out.println("Введите имя существующей характеристики!");
		String namec=in.nextLine();
		Fact locfactc=searchByName(namec);
		if(locfactc==null){
			System.out.println("характеристики не задана");
			return false;
		}
		System.out.println("Введите значение!");
		String valuec=in.nextLine();
		rt=locRule.joinconsequence(locfactc, valuec);
		if(rt==0){
			System.out.println("характеристика уже есть");
			return false;
		}else
		if(rt==1){
			System.out.println("значение не входит в список возможных");
			return false;
		}
		
		RulesList.add(locRule);
		
		return true;
	}
	private static void printFacts() {
		// TODO Auto-generated method stub
		int len = CharacterList.size();
		if(len==0)System.out.println("Характеристики отсутствуют!");
		for(int i=0;i<len;i++){
			CharacterList.get(i).print();
			
		}
		
	}
	private static void printRules() {
		// TODO Auto-generated method stub
		int len = RulesList.size();
		if(len==0)System.out.println("Правила отсутствуют!");
		for(int i=0;i<len;i++){
			RulesList.get(i).print();
			
		}
		
	}
	
	static void readCharacteristics(){
		System.out.println("Вы находитесь в разделе работы с характеристиками.");
		while(implicate(getLine(1))){
			
		}
	}
	static void multirultest(){
		
		Fact haircolor = new Fact("цвет_волос");
		haircolor.addValue("русые");
		haircolor.addValue("каштановые");
		haircolor.addValue("золотистые");
		
		Fact eyecolor = new Fact("цвет_глаз");
		eyecolor.addValue("голубые");
		eyecolor.addValue("карие");
		eyecolor.addValue("зеленые");
		eyecolor.addValue("черные");
		
		Fact dresscolor = new Fact("цвет_платья");
		eyecolor.addValue("белое");
		eyecolor.addValue("красное");
		eyecolor.addValue("черное");
		eyecolor.addValue("пёстрое");
		
		
		MultiRule myrule=new MultiRule();
		myrule.joincondition(haircolor, "русые");
		myrule.joincondition(eyecolor, "карие");
		myrule.joinconsequence(dresscolor, "черное");
		myrule.print();
		
		
	}
	static void readRules(){
		System.out.println("Вы находитесь в разделе работы с правилами.");
		while(implicate(getLine(2))){
			
		}
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		readCharacteristics();
		readRules();
		
	}

}