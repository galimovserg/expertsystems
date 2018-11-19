package characteristic;

import java.util.ArrayList;
import java.util.Scanner;



public class characteristic {
	
	static ArrayList<Fact> CharacterList = new ArrayList<Fact>();
	static ArrayList<MultiRule> RulesList = new ArrayList<MultiRule>();
	static ArrayList<Fact> CharacterUserList = new ArrayList<Fact>();
	
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
	static void printchars() {
		for(int i=0;i< CharacterList.size();i++) {
			System.out.println("|"+i+"| "+CharacterList.get(i).getName());
		}
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
	private static int fl=0;
	static void makeTest() {
		// TODO Auto-generated method stub

		if(fl==0) {
			Fact bol = new Fact("Наличие_боли");
			bol.addValue("да");
			bol.addValue("нет");
			CharacterList.add(bol);
			Fact locbol = new Fact("Локализация_боли");
			locbol.addValue("грудная_клетка");
			locbol.addValue("в_горле");
			locbol.addValue("в_спина");
			locbol.addValue("в_животе");
			locbol.addValue("поясница");
			locbol.addValue("в_лобной_части");
			locbol.addValue("в_затылке");
			locbol.addValue("в_висках");
			locbol.addValue("глаза");
			CharacterList.add(locbol);
			Fact charbol = new Fact("Характер_боли");		
			charbol.addValue("Острая");
			charbol.addValue("Слабая");
			charbol.addValue("Давящая");
			charbol.addValue("Пульсирующая");
			CharacterList.add(charbol);
			Fact tmbol = new Fact("Проявление_боли");
			tmbol.addValue("Всегда");
			tmbol.addValue("По_вечерам");
			tmbol.addValue("После_приема_пищи");
			tmbol.addValue("После_приема_сахара");
			tmbol.addValue("При_движении");
			tmbol.addValue("Иногда");
			CharacterList.add(tmbol);
			Fact bodynterm = new Fact("Температура_в_норме");
			bodynterm.addValue("да");
			bodynterm.addValue("нет");
			CharacterList.add(bodynterm);
			Fact bodytopterm = new Fact("Наличие_повышенной_температуры");
			bodytopterm.addValue("да");
			bodytopterm.addValue("нет");
			
			CharacterList.add(bodytopterm);
			Fact bodybotterm = new Fact("Наличие_пониженной_температуры");
			bodybotterm.addValue("да");
			bodybotterm.addValue("нет");	
			CharacterList.add(bodybotterm);
			Fact colour = new Fact("Цвет_кожи_лица");
			colour.addValue("Желтый");
			colour.addValue("Бледный");
			colour.addValue("Красный");
			CharacterList.add(colour);
			Fact sahr = new Fact("Сахар");
			sahr.addValue("в норме");
			sahr.addValue("повышенное");
			sahr.addValue("пониженное");
			
			Fact arterdv = new Fact("Артериальное_давление");
			arterdv.addValue("в норме");
			arterdv.addValue("повышенное");
			arterdv.addValue("пониженное");
			CharacterList.add(arterdv);
			
			Fact hgg = new Fact("Внутречерепное_давление");
			hgg.addValue("в норме");
			hgg.addValue("повышенное");
			hgg.addValue("пониженное");
			CharacterList.add(hgg);
			Fact ptlog = new Fact("Паталогия");
			ptlog.addValue("гипогликемия");
			
			Fact dps = new Fact("Дополнительные_симптомы");
			dps.addValue("кашель");
			dps.addValue("рвота");
			dps.addValue("головокружение");
			dps.addValue("слабость");
			dps.addValue("сонливость");
			dps.addValue("пот");
			dps.addValue("отдышка");
			dps.addValue("оттек_папиллоэдема");
			dps.addValue("наличие_уплотнений");
			CharacterList.add(dps);
			Fact pod = new Fact("Подозрение");
			pod.addValue("простуда");
			pod.addValue("сколиоз");
			pod.addValue("ОРВИ");
			pod.addValue("ХОБЛ");
			pod.addValue("СПИД");
			pod.addValue("Гепатит_C");
			pod.addValue("рак_легких");
			pod.addValue("рак_головного_мозга");
			pod.addValue("туберкулез");
			pod.addValue("внутричерепная_гипертензия");
			CharacterList.add(pod);
			Fact zab = new Fact("Заболевание");
			zab.addValue("простуда");
			zab.addValue("ОРВИ");
			zab.addValue("ХОБЛ");
			zab.addValue("СПИД");
			zab.addValue("Гепатит C");
			zab.addValue("рак_легких");
			zab.addValue("рак_головного_мозга");
			zab.addValue("язва_желудка");
			zab.addValue("язва_прямой_кишки");
			zab.addValue("аппендицит");
			zab.addValue("туберкулез");
			zab.addValue("внутричерепная_гипертензия");
			CharacterList.add(zab);
			Fact obs = new Fact("Обследование");
			obs.addValue("офтальмолог");
			obs.addValue("рентгенография");
			obs.addValue("стробоскопия");
			obs.addValue("анализ_крови");
			obs.addValue("анализ_калла");
			obs.addValue("анализ_макроты");
			CharacterList.add(obs);
			
			
			
		}

	}
	static void multirultest(){
		
		MultiRule myrule1=new MultiRule();
		Fact f1=searchByName("Наличие_боли");
		myrule1.joincondition(f1, "да");
		Fact f2=searchByName("Локализация_боли");
		myrule1.joincondition(f2, "в_затылке");
		Fact f3=searchByName("Характер_боли");
		myrule1.joincondition(f3, "давящая");
		Fact f4=searchByName("Температура_в_норме");
		myrule1.joincondition(f4, "да");
		
		Fact r1=searchByName("Подозрение");
		myrule1.joinconsequence(r1, "внутричерепная_гипертензия");
		RulesList.add(myrule1);
		
		MultiRule myrule2=new MultiRule();
		Fact f21=searchByName("Наличие_боли");
		myrule2.joincondition(f21, "да");
		Fact f22=searchByName("Локализация_боли");
		myrule2.joincondition(f22, "в_горле");
		Fact f23=searchByName("Температура_в_норме");
		myrule2.joincondition(f23, "нет");
		Fact f24=searchByName("Наличие_повышенной_температуры");
		myrule2.joincondition(f24, "да");
		Fact f25=searchByName("Дополнительные_симптомы");
		myrule2.joincondition(f25, "кашель");
		Fact f26=searchByName("Дополнительные_симптомы");
		myrule2.joincondition(f26, "пот");
		Fact r21=searchByName("Подозрение");
		myrule2.joinconsequence(r21, "туберкулез");
		RulesList.add(myrule2);
		
		MultiRule myrule3=new MultiRule();
		Fact f31=searchByName("Подозрение");
		myrule3.joincondition(f31, "туберкулез");
		Fact r31=searchByName("Обследование");
		myrule3.joinconsequence(r31, "анализ_макроты");
		RulesList.add(myrule3);
		
		
		MultiRule myrule4=new MultiRule();
		Fact f41=searchByName("Подозрение");
		myrule4.joincondition(f31, "внутричерепная_гипертензия");
		Fact r41=searchByName("Обследование");
		myrule4.joinconsequence(r31, "офтальмолог");
		RulesList.add(myrule4);
		
		
		
	}
	static void readFacts(){
		Scanner in= new Scanner(System.in);
		System.out.println("Введите номер характеристики:");
		printchars();
		int namec=in.nextInt();
		if(namec>=0&&namec<CharacterList.size()) {
		Fact f=CharacterList.get(namec);
		if(f!=null) {
			System.out.println("Введите номер:");
			f.print();
			int namev=in.nextInt();
			f.setExp(namev);
		}else {
			System.out.println("Характеристика не найдена!");
		}
		}else {
			System.out.println("Характеристика не найдена!");
		}
		
	}
	static void expertize() {
		Boolean lastprogon=false;
		while(lastprogon==false) {
			lastprogon=true;
			for(int i=0;i<RulesList.size();i++) {
				if(RulesList.get(i).prog()) {
					lastprogon=false;
				}
			}
		}
	}
	public static void main(String[] args) {
		//создаю меню
		Navigator nav=new Navigator() {
			@Override 
			void onCreate() {
				Item item1=new Item("Характеристики") {
					@Override
					void action() {
						
						System.out.println("Вы попали в раздел характеристики!");
						
					}
					
				};
				
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
				Item item14=new Item("Тестовые данные") {
					@Override
					void action() {
						makeTest();
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
				Item item24=new Item("Тестовые правила") {
					@Override
					void action() {
						multirultest();
					}
				};
				Item item3=new Item("Экспертиза") {
					@Override
					void action() {
						
					}
				};
				Item item31=new Item("Ввод исходного факта") {
					@Override
					void action() {
						readFacts();
					}
				};
				Item item32=new Item("Запуск экспертизы") {
					@Override
					void action() {
						expertize();
					}
				};
				Item item33=new Item("Просмотр исходных фактов") {
					@Override
					void action() {
						for(int i=0;i<CharacterList.size();i++) {
							CharacterList.get(i).printexpert();
						}
					}
				};
				item1.addItem(item11);
				item1.addItem(item12);
				item1.addItem(item13);
				item1.addItem(item14);
				item2.addItem(item21);
				item2.addItem(item22);
				item2.addItem(item23);
				item2.addItem(item24);
				item3.addItem(item31);
				item3.addItem(item32);
				item3.addItem(item33);
				addItem(item1);
				addItem(item2);
				addItem(item3);
			}
			
		};
		
		//запускаю меню
		nav.run();
		
		
	}
	
	

}