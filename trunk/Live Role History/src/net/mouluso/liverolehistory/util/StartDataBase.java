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
    		DatabaseOperations.getInstance(context).insertEvent(
    				" Que máis pode pedir un home? A barriga chea, moita cervexa, un bon xeado, unha mullero que o queir...",
    				1,
    				5,
    				"En que ano se abriu a Heladería Colón?",
    				"1973",
    				"Heladería Colón, A Coruña",
    				"O ANIVERSARIO .E onte nin cheguéi ó barco. Meu deus, desta mátame. Sólo me queda fuxir. Necesito un capitán cun barco que me poda levar lonxe de aquí.",
    				43369262,-8400703);
    		DatabaseOperations.getInstance(context).insertEvent(
    				"Bueno, se aquí naide me pode levar a augas internacionáis, ninguén pode.", 
    				1,
    				6,
    				"En que ano se fundou o Real Club Náutico Da Coruña?",
    				"1926",
    				"Real Club Náutico de La Coruña",
    				"Pois parece ser que onte escoitaron os berros da miña muller dende aquí e ahgora ninguén se atreve a levarme. Dinme que vaia a un centor comercial (din que hai varios para escoller, pero que non me complique) e que lle atope O REGALO PERFECTO para ela. Isto vai ser difícil.",
    				43368454,-8397514);
    		DatabaseOperations.getInstance(context).insertEvent(
    				"Atopeino! Se isto non consegue salvarme o pescozo, nada o fará. en fin, que sexa o que Deus queira. Tomarei outra cervexa, por se acaso.", 
    				1,
    				7,
    				"Cantos centros comerciáis hai na Coruña?",
    				"6",
    				"Centro de Ocio, El Puerto, A Coruña",
    				"",
    				43368113,-840039);
    		
    		
    		
    		DatabaseOperations.getInstance(context).insertEvent(
    				" Meses de penurias e peregrinaxe ata chegar a ver A Catedral do Santo Apóstol e unhas palabras mal interpretadas por unha bruxa métenme neste problema. Que é este sitio de enormes construccións, metal e bruxería? Que Deus se apiade da miña alma. A bruxa non me mandou demasiado lonxe, pero sí moi tarde. O última voz que escoitei mandoume buscar un reloxo alto, entre árboles e edificios.", 
    				2,
    				1,
    				"En que ano se construíu o Obelisco?",
    				"1895",
    				"Obelisco Cantón Pequeno A Coruña",
    				"Atopo un trozo de antracita que destaca sobor das demáis pedras. Atráeme estrañamente. Debaixo dela hai unha nota que di: Non todo está perdido. Sigue ás árbores, busca ó bardo de metal.",
    				43368659,-8402209);
    		DatabaseOperations.getInstance(context).insertEvent(
    				"Así que este é o famoso bardo. Gustaríame escoitar algunha das súas composicións. ", 
    				2,
    				2,
    				"En que ano foi asasinado John Lennon?",
    				"1980",
    				"Monumendo a john Lennon, A Coruña",
    				"Na súa man, hai outra nota: Nesta cidade viveu o Pintor dos períodos coloridos e das innumerábeis obras. Vai a onde él viveu.",
    				43367712,-8403136);
    		DatabaseOperations.getInstance(context).insertEvent(
    				"Fun preguntando polo camiño, e foi un home realmente abraiante este Picasso, gustaríame dispoñer do tempo necesario para aprender máis, pero gustaríame máis volver á casa.", 
    				2,
    				3,
    				"En cantos días pintou Picasso o Guernica?",
    				"33",
    				"Casa Museo Picasso, A Coruña",
    				"No seu buzón, unha nota: “Alí onde a terra divide ó mar e se alzan as bandeiras deberás continuar a túa viaxe.",
    				 43367156,-8407197);
    		DatabaseOperations.getInstance(context).insertEvent(
    				"Este sitio é especialmente belo. Creo que ficarei aquí un anaco a meditar sobre esta estraña situación e disfrutar da paisaxe.", 
    				2,
    				4,
    				"Cal é a festa máis coñecida celebrada nas praias de Orzán e Riazor?",
    				"San xoán",
    				"Plaias de Riazor e Orzán,  A coruña.",
    				"A última nota que atoipei, neste mesmo banco: Busca o lugar onde tódalas artes se xuntan, non moi lonxe da relixión e o mar.",
    				43369392,-8407937);
    		DatabaseOperations.getInstance(context).insertEvent(
    				"Resultoume especialmente complicado atopar con este sitio. Aínda así, marabilloume, a arte cambiou moito dende os meus días. ", 
    				2,
    				5,
    				"En que ano se inaugurou o Museo Das Belas Artes Da Coruña?",
    				"1995",
    				"Museo Das Belas Artes Da Coruña",
    				"Vai alí onde mora o Home.",
    				43372806,-8399872);
    		DatabaseOperations.getInstance(context).insertEvent(
    				"Aquí non vive un home. Aquí vive O home.E fascíname este lugar. Tantas cousas que aprender...", 
    				2,
    				6,
    				"Cal é o lema escrito ás portas do museo?",
    				"Coñecete a ti mesmo",
    				"Museo domus, A Coruña",
    				"Continúa por este camiño. Tes outra morada que ir visitar.",
    				43377511,-8406677);
    		DatabaseOperations.getInstance(context).insertEvent(
    				"Isto é realmente impresionante. E belo. Deberíase de coidar máis da natureza.", 
    				2,
    				7,
    				"Como se chama a sala máis famosa do Acuarium?",
    				"Nautilus",
    				"Acuarium Finisterrae, A Coruña",
    				"É posible que te atopes algo perdido. Xunto á cabeza de Xerión atoparás o Norte",
    				43383507,-8409777);
    		DatabaseOperations.getInstance(context).insertEvent(
    				"on todas as marabillas e cousas abraiantes que vin, resulta impresionante que unha Rosa dos Ventos non caera no olvido.", 
    				2,
    				8,
    				"Como se chamaba o petroleiro que naufragou non moi lonxe de aquí en 1992?",
    				"Mar Egeo",
    				"Rosa dos Ventos da Torre de Hércules, A Coruña",
    				"Creo que xa sabes o seguinte paso. Achégate ó ceo todo o que podas, e descansa",
    				43386698,-8407727);
    		DatabaseOperations.getInstance(context).insertEvent(
    				"Xuntei todas as notas e parece que todo cobra sentido... Creo que a pesar de todo, voltarei á casa.", 
    				2,
    				9,
    				"Cantos metros mide a Torre de Hércules?",
    				"68",
    				"Torre de Hércules",
    				"",
    				4338569,-8406633);
        
        }
}}

//(String description, int historyId,  int order, String question, String answer, int search, String success,
//int latitude, int longitude)