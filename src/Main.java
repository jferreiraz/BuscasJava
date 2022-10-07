import espacoDeEstados.*;
import estrategiasDeBusca.cega.BuscaCega;
import estrategiasDeBusca.cega.BuscaEmLargura;
import estrategiasDeBusca.cega.BuscaEmProfundidade;
import estrategiasDeBusca.cega.BuscaEmProfundidadeLimitada;
import estrategiasDeBusca.cega.BuscaEmProfundidadeIterativa;
import estrategiasDeBusca.heuristica.*;
import java.util.Scanner;
   
public class Main {
        static Scanner entrada = new Scanner(System.in);
        
        public static void menuInicial(){
            
            System.out.println("          MENU PRINCIPAL       ");
            System.out.println("------------------------------");
            System.out.println("                               ");
            System.out.println("1. Estratégias de busca cega");
            System.out.println("2. Estratégias de busca heuristica");
            System.out.println("                                 ");
            System.out.print("Opção: ");
        }//--------------------- MENU INICIAL ---------------------------
        
        public static void menuCega(){
            System.out.println("                                 ");
            System.out.println("         MENU DE BUSCA CEGA     ");
            System.out.println("------------------------------");
            System.out.println("                               ");
            System.out.println("1. Busca em profundidade iterativa");
            System.out.println("2. Busca em profundidade limitada");
            System.out.println("3. Busca em largura");
            System.out.println("                                 ");
            System.out.print("Opção: ");
        }//--------------------- MENU DE BUSCA CEGA ----------------------
        
        public static void menuHeuristica(){
            System.out.println("                                 ");  
            System.out.println("         MENU DE BUSCA HEURISTÍCA     ");
            System.out.println("------------------------------");
            System.out.println("   ESTRATÉGIAS DE BUSCA HEURISTICA   ");
            System.out.println("                               ");
            System.out.println("1. Busca heruistica AStar");
            System.out.println("2. Busca heruistica BestFirst");
            System.out.println("3. Busca heuristica BranchAndBound");
            System.out.println("4. Busca heuristica HillClimbing");
            System.out.println("                                 ");
            System.out.print("Opção: ");
        }//--------------------- MENU DE BUSCA HEURISTICA ---------------------
        
        public static void configPuzzle(){
            //char[] cfgIni = {' ','2','3','1','4','6','7','5','8'};
            //char[] cfgIni = {'2','4','3','7','1','6','5',' ','8'};
            //char[] cfgIni = {'2','3',' ','7','4','1','5','8','6'};
            //char[] cfgIni = {'1','2','3',' ','4','6','7','5','8'};
            char[] cfgIni = {'7','2','3','4',' ','1','5','8','6'}; // OutOfMemory

            Puzzle8 puzzleInicial = new Puzzle8();
            puzzleInicial.setEstado(cfgIni);
            puzzleInicial.setCusto(0);
            puzzleInicial.setAvaliacao( puzzleInicial.heuristica(Puzzle8.TABULEIRO_ORGANIZADO) );
			
            Puzzle8 puzzleFinal = new Puzzle8();
            puzzleFinal.setEstado( Puzzle8.TABULEIRO_ORGANIZADO);
            puzzleFinal.setCusto(0);
            puzzleFinal.setAvaliacao(0);
        }
        
        
        
        //--------------------BUSCAS CEGAS ABAIXO----------------------
        
        public static void puzzleIterativa(){
            //char[] cfgIni = {' ','2','3','1','4','6','7','5','8'};
            //char[] cfgIni = {'2','4','3','7','1','6','5',' ','8'};
            //char[] cfgIni = {'2','3',' ','7','4','1','5','8','6'};
            //char[] cfgIni = {'1','2','3',' ','4','6','7','5','8'};
            char[] cfgIni = {'7','2','3','4',' ','1','5','8','6'}; // OutOfMemory

            Puzzle8 puzzleInicial = new Puzzle8();
            puzzleInicial.setEstado(cfgIni);
            puzzleInicial.setCusto(0);
            puzzleInicial.setAvaliacao( puzzleInicial.heuristica(Puzzle8.TABULEIRO_ORGANIZADO) );
			
            Puzzle8 puzzleFinal = new Puzzle8();
            puzzleFinal.setEstado( Puzzle8.TABULEIRO_ORGANIZADO);
            puzzleFinal.setCusto(0);
            puzzleFinal.setAvaliacao(0);
             
            BuscaEmProfundidadeLimitada buscaProfundidadeIterativa = new BuscaEmProfundidadeLimitada();
                
            buscaProfundidadeIterativa.setInicio(puzzleInicial);
            buscaProfundidadeIterativa.setLimite(100);  //Determinar um 'for' que busca pelo menor numero apartir de uma variavel definida no setlimite
            buscaProfundidadeIterativa.setObjetivo(puzzleFinal);
            buscaProfundidadeIterativa.buscar();
            while(buscaProfundidadeIterativa.getCaminhoSolucao() != buscaProfundidadeIterativa.getObjetivo()){
            for(Estado e : buscaProfundidadeIterativa.getCaminhoSolucao()) {
		System.out.println(e);
                System.out.println("             ");
                System.out.println("             ");
            }}

            System.exit(0);
        }
        
        public static void puzzleLimitada(){
            
            //char[] cfgIni = {' ','2','3','1','4','6','7','5','8'};
            //char[] cfgIni = {'2','4','3','7','1','6','5',' ','8'};
            //char[] cfgIni = {'2','3',' ','7','4','1','5','8','6'};
            //char[] cfgIni = {'1','2','3',' ','4','6','7','5','8'};
            char[] cfgIni = {'7','2','3','4',' ','1','5','8','6'}; // OutOfMemory

            Puzzle8 puzzleInicial = new Puzzle8();
            puzzleInicial.setEstado(cfgIni);
            puzzleInicial.setCusto(0);
            puzzleInicial.setAvaliacao( puzzleInicial.heuristica(Puzzle8.TABULEIRO_ORGANIZADO) );
			
            Puzzle8 puzzleFinal = new Puzzle8();
            puzzleFinal.setEstado( Puzzle8.TABULEIRO_ORGANIZADO);
            puzzleFinal.setCusto(0);
            puzzleFinal.setAvaliacao(0);
            
            //BuscaInformada busca = new AStar();
             
            BuscaEmProfundidadeLimitada buscaProfundidadeLimitada = new BuscaEmProfundidadeLimitada();
                
            buscaProfundidadeLimitada.setInicio(puzzleInicial);
            buscaProfundidadeLimitada.setLimite(20);  //Determinar um 'for' que busca pelo menor numero apartir de uma variavel definida no setlimite
            buscaProfundidadeLimitada.setObjetivo(puzzleFinal);
            buscaProfundidadeLimitada.buscar();
            for(Estado e : buscaProfundidadeLimitada.getCaminhoSolucao()) {
		System.out.println(e);
                System.out.println("             ");
                System.out.println("             ");
            }

            System.exit(0);
        }
        
        public static void puzzleLargura(){
            //busca em largura
            //char[] cfgIni = {' ','2','3','1','4','6','7','5','8'};
            //char[] cfgIni = {'2','4','3','7','1','6','5',' ','8'};
            //char[] cfgIni = {'2','3',' ','7','4','1','5','8','6'};
            //char[] cfgIni = {'1','2','3',' ','4','6','7','5','8'};
            char[] cfgIni = {'1','2','3','4','5','6','7',' ','8'}; // OutOfMemory

            Puzzle8 puzzleInicial = new Puzzle8();
            puzzleInicial.setEstado(cfgIni);
            puzzleInicial.setCusto(0);
            puzzleInicial.setAvaliacao( puzzleInicial.heuristica(Puzzle8.TABULEIRO_ORGANIZADO) );
			
            Puzzle8 puzzleFinal = new Puzzle8();
            puzzleFinal.setEstado( Puzzle8.TABULEIRO_ORGANIZADO);
            puzzleFinal.setCusto(0);
            puzzleFinal.setAvaliacao(0);
            
            BuscaEmLargura buscaLargura = new BuscaEmLargura();
            buscaLargura.setInicio(puzzleInicial);
            buscaLargura.setObjetivo(puzzleFinal);
            buscaLargura.buscar();
            for(Estado e : buscaLargura.getCaminhoSolucao()) {
		System.out.println(e);
                System.out.println("             ");
                System.out.println("             ");
            }
        }
        
        
        
        
        //----------------------BUSCAS HEURISTICAS ABAIXO---------------------------------
        
        public static void puzzleAstar(){
            //busca Astar
            //char[] cfgIni = {' ','2','3','1','4','6','7','5','8'};
            //char[] cfgIni = {'2','4','3','7','1','6','5',' ','8'};
            //char[] cfgIni = {'2','3',' ','7','4','1','5','8','6'};
            //char[] cfgIni = {'1','2','3',' ','4','6','7','5','8'};
            char[] cfgIni = {'7','2','3','4',' ','1','5','8','6'}; // OutOfMemory

            Puzzle8 puzzleInicial = new Puzzle8();
            puzzleInicial.setEstado(cfgIni);
            puzzleInicial.setCusto(0);
            puzzleInicial.setAvaliacao( puzzleInicial.heuristica(Puzzle8.TABULEIRO_ORGANIZADO) );
			
            Puzzle8 puzzleFinal = new Puzzle8();
            puzzleFinal.setEstado( Puzzle8.TABULEIRO_ORGANIZADO);
            puzzleFinal.setCusto(0);
            puzzleFinal.setAvaliacao(0);
            
            AStar buscaAstar = new AStar();
            buscaAstar.setInicio(puzzleInicial);
            buscaAstar.setObjetivo(puzzleFinal);
            buscaAstar.buscar();
            for(Estado e : buscaAstar.getCaminhoSolucao()) {
		System.out.println(e);
                System.out.println("             ");
                System.out.println("             ");
            }
        }
        public static void puzzleBestFirst(){
            //busca BestFirst
            //char[] cfgIni = {' ','2','3','1','4','6','7','5','8'};
            //char[] cfgIni = {'2','4','3','7','1','6','5',' ','8'};
            //char[] cfgIni = {'2','3',' ','7','4','1','5','8','6'};
            //char[] cfgIni = {'1','2','3',' ','4','6','7','5','8'};
            char[] cfgIni = {'1','2','3','4','5','6','7',' ','8'}; // OutOfMemory

            Puzzle8 puzzleInicial = new Puzzle8();
            puzzleInicial.setEstado(cfgIni);
            puzzleInicial.setCusto(0);
            puzzleInicial.setAvaliacao( puzzleInicial.heuristica(Puzzle8.TABULEIRO_ORGANIZADO) );
			
            Puzzle8 puzzleFinal = new Puzzle8();
            puzzleFinal.setEstado( Puzzle8.TABULEIRO_ORGANIZADO);
            puzzleFinal.setCusto(0);
            puzzleFinal.setAvaliacao(0);
            
            BestFirst buscaBF = new BestFirst();
            buscaBF.setInicio(puzzleInicial);
            buscaBF.setObjetivo(puzzleFinal);
            buscaBF.buscar();
            for(Estado e : buscaBF.getCaminhoSolucao()) {
		System.out.println(e);
                System.out.println("             ");
                System.out.println("             ");
            }
        }
        public static void puzzleBranch(){
            //busca branch
            //char[] cfgIni = {' ','2','3','1','4','6','7','5','8'};
            //char[] cfgIni = {'2','4','3','7','1','6','5',' ','8'};
            //char[] cfgIni = {'2','3',' ','7','4','1','5','8','6'};
            //char[] cfgIni = {'1','2','3',' ','4','6','7','5','8'};
            char[] cfgIni = {'1','2','3','4','5','6','7',' ','8'}; // OutOfMemory

            Puzzle8 puzzleInicial = new Puzzle8();
            puzzleInicial.setEstado(cfgIni);
            puzzleInicial.setCusto(0);
            puzzleInicial.setAvaliacao( puzzleInicial.heuristica(Puzzle8.TABULEIRO_ORGANIZADO) );
			
            Puzzle8 puzzleFinal = new Puzzle8();
            puzzleFinal.setEstado( Puzzle8.TABULEIRO_ORGANIZADO);
            puzzleFinal.setCusto(0);
            puzzleFinal.setAvaliacao(0);
            
            BranchAndBound buscaBranch = new BranchAndBound();
            buscaBranch.setInicio(puzzleInicial);
            buscaBranch.setObjetivo(puzzleFinal);
            buscaBranch.buscar();
            for(Estado e : buscaBranch.getCaminhoSolucao()) {
		System.out.println(e);
                System.out.println("             ");
                System.out.println("             ");
            }
        }
        public static void puzzleHillClimbing(){
            //busca hillClimbing
            //char[] cfgIni = {' ','2','3','1','4','6','7','5','8'};
            //char[] cfgIni = {'2','4','3','7','1','6','5',' ','8'};
            //char[] cfgIni = {'2','3',' ','7','4','1','5','8','6'};
            //char[] cfgIni = {'1','2','3',' ','4','6','7','5','8'};
            char[] cfgIni = {'1','2','3','4','5','6','7',' ','8'}; // OutOfMemory

            Puzzle8 puzzleInicial = new Puzzle8();
            puzzleInicial.setEstado(cfgIni);
            puzzleInicial.setCusto(0);
            puzzleInicial.setAvaliacao( puzzleInicial.heuristica(Puzzle8.TABULEIRO_ORGANIZADO) );
			
            Puzzle8 puzzleFinal = new Puzzle8();
            puzzleFinal.setEstado( Puzzle8.TABULEIRO_ORGANIZADO);
            puzzleFinal.setCusto(0);
            puzzleFinal.setAvaliacao(0);
            
            HillClimbing buscaHC = new HillClimbing();
            buscaHC.setInicio(puzzleInicial);
            buscaHC.setObjetivo(puzzleFinal);
            buscaHC.buscar();
            for(Estado e : buscaHC.getCaminhoSolucao()) {
		System.out.println(e);
                System.out.println("             ");
                System.out.println("             ");
            }
        }


	@SuppressWarnings("rawtypes")
	public static void main(String[] args) {
                int opcao = 0; //opção digitada pelo usuario
                
                do{
                    menuInicial();
                    opcao = entrada.nextInt();
                    switch(opcao){
                        case 1: //Menu de busca cega
                            menuCega();
                            opcao = entrada.nextInt();
                            switch(opcao){
                                case 1:
                                    puzzleIterativa();
                                    break;
                                case 2:
                                    puzzleLimitada();
                                    break;
                                case 3:
                                    puzzleLargura();
                                    break;
                                default:
                                    System.out.println("Opção inválida!");
                                    break;
                            }
                            break;
                        
                        case 2: //Menu de busca heuristica
                            menuHeuristica();
                            opcao = entrada.nextInt();
                            switch(opcao){
                                case 1:
                                    puzzleAstar();
                                    break;
                                case 2:
                                    puzzleBestFirst();
                                    break;
                                case 3:
                                    puzzleBranch();
                                    break;
                                case 4:
                                    puzzleHillClimbing();
                                    break;
                                default:
                                    System.out.println("Opção inválida!");
                                    break;
                            }
                            break;
                        
                        default:
                            System.out.println("Opção inválida!");
                            break;
                    }
                } while(opcao !=0);	
	}

}
