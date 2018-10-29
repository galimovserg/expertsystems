package characteristic;

import java.util.ArrayList;
import java.util.Scanner;



public class characteristic {
	
	static ArrayList<Fact> CharacterList = new ArrayList<Fact>();
	static ArrayList<MultiRule> RulesList = new ArrayList<MultiRule>();
	
	static boolean readNewFact(){
		Scanner in = new Scanner(System.in);
		System.out.println("Введите имя новой характеристики:");
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
		System.out.println("Введите имя существующей характеристики!");
		String stroke=in.nextLine();
		Fact locfact=searchByName(stroke);
		if(locfact!=null) {
			System.out.println("Введите новое значение!");
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

	
	
	public static void main(String[] args) {
		Navigator nav=new Navigator() {
			@Override 
			void onCreate() {
				Item item1=new Item("Характеристики");
				
				Item item11=new Item("Ввод нового значения старой характеристики") {
					@Override
					void action() {
						if(!readValues()){
							System.out.println("Данной характеристики не существует!");
						}
					}
					
				};
				Item item12=new Item("Ввод новой характеристики") {
					@Override
					void action() {
						if(!readNewFact()){
							System.out.println("Такая характеристика уже существует!");
						}
					}
					
				};
				Item item13=new Item("Просмотр характеристик") {
					@Override
					void action() {
						printFacts();
					}
					
				};
				Item item2=new Item("Правила");
				
				Item item21=new Item("Ввод нового правила") {
					@Override
					void action() {
						if(!readNewMultiRule()){
							System.out.println("Правило не добавлено!");
						}
					}
				};
				
				Item item22=new Item("Правка правила");
				
				Item item23=new Item("Просмотр правил") {
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