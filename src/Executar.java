import java.io.FileWriter;
import java.io.IOException;

public class Executar {

	public static void main(String[] args) {
		 String sequence = "65313243655652465636662646166324536256223665525256463525566534512662656666";
		 //String sequence = "65313243655652465636662646166324536";
		 
		 int linhas = 20;
		 int colunas = 10;
		 
		 
		 char[][] matrix = new char[linhas][colunas];

	        for (int i = 0; i < linhas; i++) {
	            for (int j = 0; j < colunas; j++) {
	                matrix[i][j] = ' ';
	            }
	        }

	        for (char piece : sequence.toCharArray()) {
	            if (piece == '6') {
	            	boolean check = false;
	            	for (int i = linhas-1; i >0; i--) {
	                    for (int j = 0; j < colunas; j++) {
	                        if (matrix[i][j] == ' ' && j < colunas) {
	                            matrix[i][j] = '6';
	                            check = true;
	                            break;
	                        }
	                    }
	                    if(check)
	                    	break;
	                }
	            } else if (piece == '1') {
	            	boolean check = false;
	            	for (int i = linhas-1; i >0; i--) {
	                    for (int j = 0; j < colunas; j++) {
	                        if (matrix[i][j] == ' ' && j + 2 < colunas) {
	                            matrix[i][j] = '1';
	                            matrix[i][j + 1] = '1';
	                            matrix[i][j + 2] = '1';
	                            check = true;
	                            break;
	                        }
	                    }
	                    if(check)
	                    	break;
	                }
	            } else if (piece == '2') {
	            	boolean check = false;
	            	for (int i = linhas-1; i > 0; i--) {
	                    for (int j = 0; j < colunas; j++) {
	                        if (matrix[i][j] == ' ' && matrix[i-1][j] == ' ' && matrix[i-2][j]==' ') {
	                            matrix[i][j] = '2';
	                            matrix[i - 1][j] = '2';
	                            matrix[i - 2][j] = '2';
	                            check = true;
	                            break;
	                        }
	                    }
	                    if(check)
	                    	break;
	                }
	            } else if (piece == '3') {
	            	boolean check = false;
	                for (int i = linhas-1; i >0; i--) {
	                    for (int j = 0; j < colunas; j++) {
	                        if (matrix[i][j] == ' ' && j + 2 < colunas && matrix[i][j+1] == ' ' && matrix[i][j+2] == ' ' && matrix[i-1][j+1] == ' ') {
	                            matrix[i][j] = '3';
	                            matrix[i][j + 1] = '3';
	                            matrix[i][j + 2] = '3';
	                            matrix[i-1][j + 1] = '3';
	                            check = true;
	                            break;
	                        }
	                    }
	                    if(check)
	                    	break;
	                    
	                }
	            } else if (piece == '4') {
	            	boolean check = false;
	            	for (int i = linhas-1; i > 0; i--) {
	                    for (int j = 0; j < colunas; j++) {
	    
	                    	try{
	                    		if (matrix[i][j] == ' ' && j+1<colunas && j-1<colunas && matrix[i - 1][j] == ' ' && matrix[i - 1][j + 1] == ' ') {  
		                        	matrix[i][j] = '4';
		                            matrix[i - 1][j-1] = '4';
		                            matrix[i - 1][j] = '4';
		                            matrix[i - 1][j + 1] = '4';
		                            check = true;
		                            break;
		                        }
	                	    }catch(ArrayIndexOutOfBoundsException ex){
	                	    	matrix[i][j] = ' ';
	                	    	if (matrix[i][j+1] == ' ' && j+1<colunas && j-1<colunas && matrix[i - 1][j+1] == ' ' && matrix[i - 2][j + 2] == ' ') {  
		                        	matrix[i][j+1] = '4';
		                        	matrix[i - 1][j] = '4';
		                            matrix[i - 1][j+1] = '4';
		                            matrix[i - 1][j + 2] = '4';
		                            check = true;
		                            break;
		                        }
	                	    }
	                    	
	                    	
	                    }
	                    if(check)
	                    	break;
	                }
	            } else if (piece == '5') {
	            	boolean check = false;
	                for (int i = linhas-1; i >0; i--) {
	                    for (int j = 0; j < colunas; j++) {
	                        if (matrix[i][j] == ' ' && i - 1 > 0 && j + 1 < colunas) {
	                            if (matrix[i - 1][j] == ' ' && matrix[i][j + 1] == ' ' && matrix[i -1][j + 1] == ' ') {
	                                matrix[i][j] = '5';
	                                matrix[i - 1][j] = '5';
	                                matrix[i][j + 1] = '5';
	                                matrix[i - 1][j + 1] = '5';
	                                check = true;
	                                break;
	                            }
	                        }
	                    }
	                    if(check)
	                    	break;
	                }
	            }
	        }

	    
	        
	        try (FileWriter writer = new FileWriter("resultado.txt")) {
	            for (int i = 0; i < linhas; i++) {
	                for (int j = 0; j < colunas; j++) {
	                	System.out.println(matrix[i][j]);
	                    writer.write(matrix[i][j]);
	                }
	                writer.write("\n");
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	}
