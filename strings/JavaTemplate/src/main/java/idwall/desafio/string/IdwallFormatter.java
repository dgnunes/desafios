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
					if (justify)
						formattedString += justifyString(line + w1);
					else
						formattedString += line + w1 + "\n";
				}
				else {
					if (justify){
						formattedString += justifyString(line); 
						formattedString += justifyString(w1);
					}
					else{
						formattedString += line + "\n"; 
						formattedString += w1 + "\n";
					}
				}

				line = "";
			}
    		
    		//DEVE FAZER LIMPEZA DA LINHA DE TRABALHO
    		if (line.length() + word.length() > limit){
    			if (justify){
    				formattedString += justifyString(line);
    			}
    			else{
    				formattedString += line + "\n";	
    			}
    			     			
    			line = "";
    		}
    		
    		line += word + " ";
    	}
    	
    	if (!line.isEmpty()){
    		if (justify){
				formattedString += justifyString(line);
			}
			else{
				formattedString += line + "\n";	
			}	
    	}
    	 
    	return formattedString;
    }
    
    private String justifyString(String text){
    	
    	String[] words = text.split(" ");
    	String justifiedString = words[0];
    	
    	int diff = limit - text.trim().length();
    	int whitespaces = words.length - 1;
    	int singles = 0;
    	int rounds = 0;
    	
    	if (whitespaces > 0){
    		singles = diff % whitespaces;
        	rounds = diff  / whitespaces; 	
    	}
    	
    	for (int i = 1; i < words.length; i++){
    		
    		if (singles > 0){
    			justifiedString += " ";
    			singles--;
    		}
    		
    		for (int j = 0; j < rounds;j++){
    			justifiedString += " ";
    		}
    		
    		justifiedString += " " + words[i];
    	}
    	
    	//OLD STYLE DEBUG
//    	System.out.println("===========================================");
//    	System.out.println("LINE: " + text);
//    	System.out.println("LIMIT: " + limit);
//    	System.out.println("LENGTH: " + text.trim().length());
//    	System.out.println("WORDS: " + words.length);
//    	System.out.println("SPACES: " + whitespaces);
//    	System.out.println("SINGLES: " + singles);
//    	System.out.println("ROUNDS: " + rounds);
//    	System.out.println("RESULT: " + justifiedString);
    	
    	return justifiedString + "\n";
    }
}
