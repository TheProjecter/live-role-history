package net.mouluso.liverolehistory.util;

import net.mouluso.liverolehistory.storage.DatabaseOperations;
import android.content.Context;

public class StartDataBase {

	
	public static void addEvents(Context context){
        if(DatabaseOperations.getInstance(context).getHistoryList().size() == 0){
        	DatabaseOperations.getInstance(context).insertHistory(1, "O Alemán resacoso.",
    				"Axuda a un turista alemán a recupera-las súas cousas namentres disfruta de A Coruña.", 
    				"beer_icon");
    		DatabaseOperations.getInstance(context).insertHistory(2, "O Pelegrín", 
    				"Un pelegrín perdido no tempo que tenta volver á casa namentres coñece o ámbito cultural de A Coruña.", 
    				"vieira_icon");
    		
    		DatabaseOperations.getInstance(context).insertEvent(
    				"Que resaca. Que solazo. Que fixen onte? Oh, por toda a cerveza do mundo, perdín tódalas miñas cousas. Desta mátame a muller... Creo que comecei a noite intentando ver a hora nun reloxo moi alto, xunto a unha calle verdadeira, ou algo así.", 
    				1,
    				1,
    				"En que ano se construíu o Obelisco?",
    				"1895",
    				"Obelisco Cantón Pequeno A Coruña",
    				"A ver, sei que comecei a noite cun tal Seamos en ¿Dublín? Iso non ten sentido. ¿Unha panaderia? Buf, a ver si andando me despexzo un pouco.",
    				43368659, -8402209);
    		DatabaseOperations.getInstance(context).insertEvent(
    				"Ah, carallo. Pois sí! No mesmo dublin! Xa que estou, boto unha cervexa. O camarero acaba de devolverme os lentes de sol que me olvidara onte!. Tomo outra, e xa de paso, invítoo.", 
    				1,
    				2,
    				"De qué país é capital Dublín?",
    				"Irlanda",
    				"Pub Dublin, A Coruña",
    				"Moito mellor. Nin punto de comparación. Eso sí, solazo que fai. Como non encontre o protector pronto, vou pelar enteiriño. O camarero dime que fomos a visitar ó primo de Seamus, Matthews. Igual ata o ten el. Onde cona vivirá?",
    				43372417,-8399489);
    		DatabaseOperations.getInstance(context).insertEvent(
    				"Estaba visto. Matthews é o dono do Matthews, non era tan complicado. E ten o meu protector solar! Teño que invitalo a algo. E xa que estou, refréscome un pouquiño.", 
    				1,
    				3,
    				"Como se chama a cervexa negra máis famosa do mundo, que podes atopar aquí?",
    				"Guinness",
    				"Cervecería Matthews, A Coruña",
    				"Que boa a...¿cuarta? cervexa. Cecáis debería comer algo, que onte empecéi así... Haberá por aquí algún sitio típico con tapas baratas de tortilla, albóndegas, calamares... Oh, oh, e chourizo con patacas, por suposto. E cervexa, a duda ofende",
    				43370579,-8400773);
    		DatabaseOperations.getInstance(context).insertEvent(
    				"ISTO XA É OUTRO CONTO. Onde vai parar. Creo que xa que estou, levo unha cervexa para o camiño.", 
    				1,
    				4,
    				"Cantos euros pagarías na bombilla por tres tapas?",
    				"3",
    				"Bar La Bombilla, A coruña",
    				"Eso sí, sigue pegando o sol que da gusto. Que ben me viña un xeado ahora mismo. Algo típico, caseiro, e que me quede preto, non penso andar un kilómetro para comerme un Cornetto.",
    				43370671,-8399557);
    /*		DatabaseOperations.getInstance(context).insertEvent(
    				description, 
    				historyId,
    				order,
    				question,
    				answer,
    				search,
    				success,
    				latitude,
    				longitude);
    		DatabaseOperations.getInstance(context).insertEvent(
    				description, 
    				historyId,
    				order,
    				question,
    				answer,
    				search,
    				success,
    				latitude,
    				longitude);
    		DatabaseOperations.getInstance(context).insertEvent(
    				description, 
    				historyId,
    				order,
    				question,
    				answer,
    				search,
    				success,
    				latitude,
    				longitude);*/
        
        
        }
	}

}

//(String description, int historyId,  int order, String question, String answer, int search, String success,
//int latitude, int longitude)