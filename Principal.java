import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;
import java.util.Date;


public class Principal {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		

		Scanner scanner = new Scanner(System.in); 
         
        int valorDiariaSemanaA =0; 
        int valorDiariaSemanaB =0;  
        int valorDiariaSemanaC =0; 
        int valorDiariaFdsA =0;
        int valorDiariaFdsB =0;
        int valorDiariaFdsC =0;   
        int quantidadeDiaSemana = 0;
        int quantidadeDiaFds = 0;
        int tarifaA; 
        int tarifaB; 
        int tarifaC; 
        int menorTarifa; 
        int opcao =0; 
         
        
        do{
            System.out.println("--------------------MENU---------------------");  
            System.out.println("| Digite 1 para informar a sua classificação |"); 
            System.out.println("| Digite 2 para Informar o período desejado  |");   
            System.out.println("| Digite 3 para sair                         |");
            System.out.println("---------------------------------------------"); 
    
            opcao = scanner.nextInt();    
            scanner.nextLine();   
            
                 
             {    
    
            
                switch(opcao) { 
                     
    
                    case 1: 
                    System.out.println(" Digite 'r' para REGULAR ou 'v' para VIP"); 
                    String classificacao = scanner.nextLine();  
    
                    if (classificacao.equals("r")) {  
                     
                    valorDiariaSemanaA= 110;
                    valorDiariaSemanaB = 160;
                    valorDiariaSemanaC = 220;
                     
                    valorDiariaFdsA = 90;
                    valorDiariaFdsB = 60;
                    valorDiariaFdsC = 15;
                     
                    
                  
                    } else if (classificacao.equals("v")) { 
                 
                    valorDiariaSemanaA = 80;
                    valorDiariaSemanaB = 110;
                    valorDiariaSemanaC = 100;
                     
                    valorDiariaFdsA = 80;
                    valorDiariaFdsB = 50;
                    valorDiariaFdsC = 40; 
                
                    } //System.out.println(classificacao);  
                    break;
                
                    case 2:
             
                    System.out.println("Digite a data de início da reserva desejada (DD/MM/AAAA): ");
                    String dataInicioStr = scanner.nextLine();
    
                    System.out.println("Digite a data de fim da reserva desejada (DD/MM/AAAA): ");
                    String dataFimStr = scanner.nextLine();
    
                     try {
                        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                        Date dataInicio = sdf.parse(dataInicioStr);
                        Date dataFim = sdf.parse(dataFimStr);
    
    
                        Calendar calendar = Calendar.getInstance();
                        calendar.setTime(dataInicio);
    
                        while (!calendar.getTime().after(dataFim)) {
                        int diaDaSemana = calendar.get(Calendar.DAY_OF_WEEK);
    
                        if (diaDaSemana == Calendar.SATURDAY || diaDaSemana == Calendar.SUNDAY) {
                        quantidadeDiaFds++;
                        } else {
                        quantidadeDiaSemana++;
                        }
    
                        calendar.add(Calendar.DAY_OF_MONTH, 1);
                        }
    
                        //System.out.println("Dias durante a semana: " + quantidadeDiaSemana);
                        //System.out.println("Dias durante o final de semana: " + quantidadeDiaFds);
    
                        }  catch (ParseException e) {
                        System.out.println("Formato de data inválido. Utilize o formato DD/MM/AAAA.");
                        } 
                        break; 
    
                        case 3: 
                        System.out.println("-----Operação finalizada-----"); 
                        break;
                }      
             
                
            }  
            }    while(opcao<3);  
                 
                    tarifaA = ((quantidadeDiaSemana * valorDiariaSemanaA) + (quantidadeDiaFds * valorDiariaFdsA)); 
                    tarifaB = ((quantidadeDiaSemana * valorDiariaSemanaB) + (quantidadeDiaFds * valorDiariaFdsB));
                    tarifaC = ((quantidadeDiaSemana * valorDiariaSemanaC) + (quantidadeDiaFds * valorDiariaFdsC)); 
             
                    menorTarifa = tarifaA; 
                    if (tarifaB < tarifaA){ 
                        menorTarifa = tarifaB;
                    } else if(tarifaB == tarifaA){ 
                        menorTarifa = tarifaA;
                    } else if(tarifaC < tarifaB){ 
                        menorTarifa = tarifaC;
                    } else if (tarifaC == tarifaB){ 
                        menorTarifa = tarifaB;
                    } else if (tarifaC == tarifaA){ 
                        menorTarifa = tarifaA;
                    } 
                 
                       if (menorTarifa == tarifaA){ 
                           System.out.println("A menor tarifa para o período escolhido custa R$" + menorTarifa + " no hotel Palm Plaza. ");
                        } else if (menorTarifa == tarifaB){ 
                           System.out.println("A menor tarifa para o período escolhido custa R$" + menorTarifa + " no hotel Ellegance. ");
                        } else if (menorTarifa == tarifaC){ 
                            System.out.println("A menor tarifa para o período escolhido custa R$" + menorTarifa + " no hotel Azure. ");
                        }
         
         
         
    
         
            
                    scanner.close();
    
        }}