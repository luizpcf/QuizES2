package br.ufmg.dcc.rs.quizes.persistence;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Vector;

import br.ufmg.dcc.rs.quizes.model.Question;



public class QuestionDatabase {

	public static QuestionDatabase instance;
	
	public static QuestionDatabase getInstance() {
		if (instance == null) {
			instance = new QuestionDatabase();
		}
		return instance;
	}
	
	public static void setInstance(QuestionDatabase questionDatabase)
	{
		instance=questionDatabase;
	}

	private List questions;
	private List treinodatabase;
	private List torneiodatabase;

	//private Map<String, List<Question>> questionsByCategory;
	
	
	public boolean isInitalized() {
		return ((QuestionDatabase) this).questions!=null;
	}
	
	public void prepare(List questions) {
		((QuestionDatabase) this).questions=questions;
		//initQuestionsByCategory();
		
	}
	
	public void getQuestionsByCategory() {
		
	}
	
	
	public List randomizeQuestions(List questions){
		Collections.shuffle(questions);
		return questions;
	}
	
	public List getAllQuestions() {
		List questions = new ArrayList();
		
		
		//Quiz 2
		questions.add(new Question("Qual ?? o documento tipicamente produzido na fase Elicita????o e An??lise de Requisitos?", "Documento de Requisitos", "Relat??rio de Viabilidade", "Modelos de Sistema", "Todos os anteriores", "Modelos de Sistema", "Categoria", "Tipo"));
		questions.add(new Question("A fase de Valida????o de Requisitos avalia o documento de requisitos quanto a:", "Realismo", "Consist??nncia", "Completude", "Todos os anteriores", "Todos os anteriores", "Categoria", "Tipo"));
		questions.add(new Question("Um processo de software sempre define, exceto:", "O que ?? feito", "Quando ?? feito", "Como ?? feito", "Quem faz", "Como ?? feito", "Categoria", "Tipo"));
		questions.add(new Question("As seguintes op????es s??o vantagens de se ter um processo de software, exceto:", "Melhor documenta????o dos artefatos", "Maior padroniza????o dos artefatos", "Melhor comunica????o da equipe", "Menos treinamento de pessoal", "Melhor documenta????o dos artefatos", "Categoria", "Tipo"));
		questions.add(new Question("As seguintes op????es s??o vantagens do Modelo Cascata, exceto:", "Ader??ncia a outros modelos de processo", "Permite trabalhar melhor o entendimento dos requisitos", "Reflete abordagens adotadas em outras engenharias", "Documenta????o r??gida em cada atividade", "Permite trabalhar melhor o entendimento dos requisitos", "Categoria", "Tipo"));
		questions.add(new Question("Qual das seguintes atividades n??o aparece no modelo de processo Desenvolvimento Incremental?", "Especifica????o", "Projeto de arquitetura", "Desenvolvimento", "Valida????o", "Projeto de arquitetura", "Categoria", "Tipo"));
		
		//Quiz 3
		//Essa quest??o cont??m tamb??m a resposta: Valorizamos software em funcionamento mais que documenta????o abrangente.
		questions.add(new Question("Qual das seguintes afirma????es n??o faz parte do manifesto ??gil?", "Valorizamos indiv??duos e intera????es mais que processos e ferramentas.", "Valorizamos satisfa????o do cliente mais que funcionalidade implementada.", "Valorizamos colabora????o com o cliente mais que negocia????o de contratos.", "Valorizamos responder a mudan??as mais que seguir um plano.", "Valorizamos satisfa????o do cliente mais que funcionalidade implementada.", "Categoria", "Tipo"));
		questions.add(new Question("Como s??o expressos os requisitos de software em Programa????o Extrema (XP)?", "Hist??rias do usu??rio", "Casos de uso", "Tarefas", "Product Backlog", "Hist??rias do usu??rio", "Categoria", "Tipo"));
		//Essa quest??o cont??m tamb??m a resposta: Ritmo sustent??vel
		questions.add(new Question("Qual das seguintes op????es n??o corresponde a uma pr??tica de Programa????o Extrema (XP)?", "Planejamento incremental", "Refatora????o", "Propriedade coletiva", "Programar para reusar", "Programar para reusar", "Categoria", "Tipo"));
		questions.add(new Question("Qual das seguintes op????es n??o ?? uma fun????o central do Scrum Master?", "Organizar reuni??es di??rias", "Registrar decis??es", "Resolver impedimentos", "Definir as tarefas priorit??rias", "Definir as tarefas priorit??rias", "Categoria", "Tipo"));
		questions.add(new Question("Qual das seguintes op????es n??o ?? um papel de porco segundo a nomenclatura do Scrum?", "Scrum Master", "Team", "Representante do Cliente", "Todos os anteriores s??o porcos", "Representante do Cliente", "Categoria", "Tipo"));
		questions.add(new Question("Quanto tempo dura cada reuni??o di??ria no Scrum?", "15 minutos", "1 hora", "4 horas", "8 horas", "15 minutos", "Categoria", "Tipo"));
		questions.add(new Question("Quanto tempo dura cada reuni??o de planejamento do sprint no Scrum?", "15 minutos", "1 hora", "4 horas", "8 horas", "8 horas", "Categoria", "Tipo"));
		
		//Quiz 4
		questions.add(new Question("Qual das op????es abaixo n??o ?? uma caracter??stica de requisitos de usu??rio?", "Descreve as fun????es e restri????es do sistema de forma abstrata", "Devem ser padronizados, completos e consistentes", "Escrito em linguagem natural com diagramas simples", "Ponto de vista das necessidades da empresa cliente", "Devem ser padronizados, completos e consistentes", "Categoria", "Tipo"));
		//Essa quest??o cont??m tamb??m as respostas: Use linguagem consistente para distinguir entre os requisitos obrigat??rios e os desej??veis.
		//										   Invente um formato padr??o e garanta que todas as defini????es de requisitos aderem a esse formato.
		questions.add(new Question("Qual das op????es abaixo n??o ?? uma diretriz recomendada por Sommerville para minimizar os mal entendidos na reda????o de requisitos em linguagem natural?", "Use uma forma de destacar as partes fundamentais do requisito.", "N??o assuma que os leitores compreendem a linguagem t??cnica de engenharia de software.", "Sempre que poss??vel, tente associar uma l??gica a cada um dos requisitos de usu??rio.", "Todas as op????es acima s??o diretrizes para reda????o de requisitos em linguagem natural.", "Todas as op????es acima s??o diretrizes para reda????o de requisitos em linguagem natural.", "Categoria", "Tipo"));
		questions.add(new Question("Qual das op????es abaixo n??o faz parte da defini????o de requisitos funcionais?", "Declara????es que podem explicitar o que o sistema n??o deve fazer.", "Declara????es de servi??os que o sistema deve fornecer.", "Declara????es de restri????es aos servi??os oferecidos pelo sistema.", "Declara????es de como o sistema deve reagir a entradas espec??ficas.", "Declara????es de restri????es aos servi??os oferecidos pelo sistema.", "Categoria", "Tipo"));
		questions.add(new Question("Os requisitos n??o funcionais podem ser provenientes de: I - Caracter??sticas requeridas para o software (requisitos do produto) II - Caracter??sticas da organiza????o que desenvolve o software (requisitos organizacionais) III - Caracter??sticas de outras fontes (requisitos externos) Qual das op????es abaixo melhor se aplica a esta classifica????o de requisitos n??o funcionais?", "Apenas a op????o I ?? um tipo de requisito n??o funcional.", "Apenas as op????es I e II s??o tipos de requisitos n??o funcionais.", "Todas as op????es s??o tipos de requisitos n??o funcionais.", "Nenhuma das op????es se refere a um tipo de requisito n??o funcional.", "Todas as op????es s??o tipos de requisitos n??o funcionais.", "Categoria", "Tipo"));
		questions.add(new Question("Sempre que poss??vel, os requisitos n??o funcionais devem descritos quantitativamente para serem objetivamente testados. Qual das seguintes m??tricas ?? indicada no livro texto para medir portabilidade?", "N??mero de sistemas alvo", "Disponibilidade", "Megabytes", "Uso de m??quina virtual", "N??mero de sistemas alvo", "Categoria", "Tipo"));
		//Essa quest??o cont??m tamb??m a resposta: Valida????o de requisitos
		questions.add(new Question("Qual das seguintes op??eses n??o ?? uma das fases principais da engenharia de requisitos?", "Elicita????o de requisitos", "Altera????o de requisitos", "Estudo de viabilidade", "Especifica????o de requisitos", "Altera????o de requisitos", "Categoria", "Tipo"));
		//Essa quest??o cont??m tamb??m a resposta: Casos de Uso
		questions.add(new Question("Qual das seguintes op????eses n??o ?? uma t??cnica de elicita????o de requisitos?", "Cen??rios", "Entrevistas", "Etnografia", "Tabula????o", "Tabula????o", "Categoria", "Tipo"));
		//Essa quest??o cont??m tamb??m a resposta: Apenas a op????o I ?? verdadeira.
		questions.add(new Question("Os objetivos da valida????o de requisitos s??o: I - Encontrar problemas com os requisitos. II - Demonstrar as funcionalidades do sistema. III - Verificar se os requisitos definem o sistema que o cliente realmente quer. Indique a op????o abaixo que melhor se aplica.", "Apenas a op????o II ?? verdadeira.", "Apenas a op????o III ?? verdadeira.", "Apenas duas op????es s??o verdadeiras.", "Todas as op????es s??o verdadeiras.", "Apenas duas op????es s??o verdadeiras.", "Categoria", "Tipo"));
		
		
		//Quiz 1
		//true false
		questions.add(new Question("Software ?????? um programa de computador e a documenta????????????o associada.", "True", "False", "Alternativa", "Alternativa", "True", "Categoria", "Tipo"));
		//true false
		questions.add(new Question("Engenharia de Software se preocupa com todos os aspectos do desenvolvimento de sistemas computacionais, incluindo hardware e processo.", "True", "False", "Alternativa", "Alternativa", "False", "Categoria", "Tipo"));
		//true false
		questions.add(new Question("Engenharia de Software ?????? uma disciplina de engenharia que se preocupa com todos os aspectos de produ????????????o de software.", "True", "False", "Alternativa", "Alternativa", "True", "Categoria", "Tipo"));
		//true false
		questions.add(new Question("A diferen??????a entre Ci??????ncia da Computa????????????o e Engenharia de Software ?????? que a primeira foca em teoria e fundamentos enquanto a segunda preocupa-se com o lado pr??????tico do desenvolvimento e entrega de software.", "True", "False", "Alternativa", "Alternativa", "True", "Categoria", "Tipo"));
		//true false
		questions.add(new Question("A diferen??????a entre Engenharia de Software e Engenharia de Sistemas ?????? que a primeira se preocupa com todos os aspectos de sistemas computacionais. Assim, Engenharia de Sistemas ?????? parte da Engenharia de Software.", "True", "False", "Alternativa", "Alternativa", "False", "Categoria", "Tipo"));
		//true false
		questions.add(new Question("As principais atividades da Engenharia de Software s??????o especifica????????????o, modelagem, testes e evolu????????????o.", "True", "False", "Alternativa", "Alternativa", "True", "Categoria", "Tipo"));
		//true false
		questions.add(new Question("Pressman apresenta uma vis??????o da Engenharia de Software em cinco camadas sobrepostas: qualidade, processos de software, m??????todos de software, ferramentas e pessoas.", "True", "False", "Alternativa", "Alternativa", "False", "Categoria", "Tipo"));
		//true false
		questions.add(new Question("As principais fases da Especifica????????????o de Requisitos s??????o estudo de viabilidade, elicita????????????o ou an??????lise de requisitos, especifica????????????o de requisitos e valida????????????o dos requisitos.", "True", "False", "Alternativa", "Alternativa", "True", "Categoria", "Tipo"));
		//true false
		questions.add(new Question("A lei da Complexidade Crescente de Lehman diz que a medida que um sistema evolui, sua complexidade aumenta, a menos que seja realizado esfor??????o para mant??????-la ou diminu??????-la.", "True", "False", "Alternativa", "Alternativa", "True", "Categoria", "Tipo"));
		//true false
		questions.add(new Question("Uma das leis de evolu????????????o diz que a qualidade de sistemas parecer?????? estar declinando a menos que eles sejam mantidos e adaptados ??????s modifica????????????es do ambiente.", "True", "False", "Alternativa", "Alternativa", "True", "Categoria", "Tipo"));
		
		//Quiz 2
		//true false
		questions.add(new Question("Na fase de An??????lise de Requisitos s??????o usadas v??????rias t??????cnicas baseadas em observa????????????o e entrevistas.", "True", "False", "Alternativa", "Alternativa", "True", "Categoria", "Tipo"));
		//true false
		questions.add(new Question("O objetivo do Teste de Componentes ?????? garantir que dois ou mais componentes funcionam juntos.", "True", "False", "Alternativa", "Alternativa", "False", "Categoria", "Tipo"));
		//true false
		questions.add(new Question("A principal vantagem da Prototipa????????????o ?????? que ela auxilia o engenheiro de software e o cliente a entenderem melhor o que deve ser constru??????do.", "True", "False", "Alternativa", "Alternativa", "True", "Categoria", "Tipo"));
		//true false
		questions.add(new Question("No Modelo Espiral o software ?????? desenvolvido em vers??????es.", "True", "False", "Alternativa", "Alternativa", "True", "Categoria", "Tipo"));
		
		//Quiz 3
		//true false
		questions.add(new Question("Em m??????todos ??????geis, o cliente geralmente paga pelo tempo necess??????rio para o desenvolvimento do sistema, e n??????o pelo desenvolvimento de um determinado conjunto de requisitos.", "True", "False", "Alternativa", "Alternativa", "True", "Categoria", "Tipo"));
		//true false
		questions.add(new Question("Em Programa????????????o Extrema (XP), os programadores trabalham em pares e desenvolvem testes antes de escreverem o c??????digo.", "True", "False", "Alternativa", "Alternativa", "True", "Categoria", "Tipo"));
		//true false
		questions.add(new Question("O Scrum recomenda o uso de pr??????ticas de programa????????????o ??????gil, como programa????????????o por pares e desenvolvimento dirigido por testes.", "True", "False", "Alternativa", "Alternativa", "False", "Categoria", "Tipo"));
		
		
		//Quiz 4
		//true false
		questions.add(new Question("Engenharia de Requisitos ?????? o processo de descobrir, analisar, documentar e verificar os servi??????os que o sistema deve oferecer e as restri????????????es ao seu funcionamento.", "True", "False", "Alternativa", "Alternativa", "True", "Categoria", "Tipo"));
		//true false
		questions.add(new Question("Stakeholders s??????o pessoas que t??????m qualquer influ??????ncia direta ou indireta sobre os requisitos, como os usu??????rios finais.", "True", "False", "Alternativa", "Alternativa", "True", "Categoria", "Tipo"));
						
		
		return questions;
	}
	
/*	public void initQuestionsByCategory() {
		questionsByCategory = new HashMap<String, List<Question>>();
		for (Question question : this.questions) {
			List<String> categories = question.getCATEG();
			if (categories!=null){
				for (String category : categories) {
					List<Question> questionByCategoryList = this.questionsByCategory
							.get(category);
					if (questionByCategoryList == null) {
						this.questionsByCategory.put(category,
								new Vector<Question>());
						questionByCategoryList = this.questionsByCategory
								.get(category);
					}
					questionByCategoryList.add(question);
					this.questionsByCategory.put(category, questionByCategoryList);
				}
			}
			
		}
	}
	
	

	
	
	public List<Question> getQuestions() {
		return questions;
	}
	
	
	
	public List<Question> getFilteredQuestions(List<String> categories) {
		
		List<Question> filteredQuestions = new LinkedList<Question>();
		for (Question question:this.questions) {
			boolean match=false;
			for (String category : question.getCategories()) {
				if (categories.contains(category)) {
					match=true;
				}
			}
			if (match) {
				filteredQuestions.add(question);
			}
		}
		
		return filteredQuestions;
	}*/
	

	public List getCategories(){
		 List categories =  new LinkedList();
		 //categories.addAll(questionsByCategory.keySet());
		 Collections.sort(categories);
		 return categories;
	}

	
}