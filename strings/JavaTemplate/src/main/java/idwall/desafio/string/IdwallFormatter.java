package idwall.desafio.string;

/**
 * Created by Rodrigo Catão Araujo on 06/02/2018.
 * 
 * Implemented 
 */
public class IdwallFormatter extends StringFormatter {
	private int limit;
	private boolean justify;
	
	public IdwallFormatter(){
		this.limit = 40;
		this.justify = false;
	}
	
	public IdwallFormatter(int limit){
		this.limit = limit;
		this.justify = false;
	}
	
	public IdwallFormatter(boolean justify){
		this.limit = 40;
		this.justify = justify;
	}
	
	public IdwallFormatter(int limit, boolean justify){
		this.limit = limit;
		this.justify = justify;
	}
    /**
     * Should format as described in the challenge
     *
     * @param text
     * @return
     */
    @Override
    public String format(String text) {
    	String formattedString = "";    	
    	String[] words = text.split(" ");
    	
    	int whitespaces = 0;
    	String line = "";
    	for (String word:words){
    		
    		//TRATAMENTO DE CLRF
			while (word.contains("\n")){
				
				//Pega posição da primeira ocorrência
				int posCLRF = word.indexOf("\n");				
	    		
				//Separa a primeira palavra
				String w1 = word.substring(0, posCLRF);
				word = word.substring(posCLRF +1, word.length());
				
				//Ainda cabe w1 sem estourar o limite
				if (line.length() + w1.length() <= limit) {
					System.out.println(line + w1);
					formattedString += line + w1 + "\n";
				}
				else {
					System.out.println(line+ "\n" + w1);
					formattedString += line + "\n" + w1 + "\n";
				}

				line = "";
				whitespaces = 0;			
			}
    		
    		//DEVE FAZER LIMPEZA DA LINHA DE TRABALHO
    		if (line.length() + word.length() > limit){
    			System.out.println(line);
    			formattedString += line + "\n";     			
    			line = "";
    			whitespaces = 0;
    		}
    		
    		line += word + " ";
    		whitespaces++;
    	}
    	
    	if (!line.isEmpty()){
    		System.out.println(line);
    		formattedString += line + "\n";	
    	}
    	 
    	return formattedString;
    }
    
    private String justify(String text){
    	
    	
    	return "";
    }
}
