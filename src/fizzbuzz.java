import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Description in here 
 * https://www.codeeval.com/open_challenges/1/
 * @author ryutaromatsuda
 *
 */

public class fizzbuzz {
	int fizz;
	int buzz;
	int max;
	boolean isValid; 
	public fizzbuzz(){
		fizz = 0;	buzz = 0;	max = 0;
		isValid = true;
	}
	
	public void play(String filePath){
		File file = new File(filePath);
		BufferedReader br = null;
		String str = null;
		try{
			br = new BufferedReader(new FileReader(file));			
			while((str = br.readLine() ) != null ){
				setup(str);
				if(getValidInput()){
					turn();
				}
				setValidInput(true);
			}
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}finally{
			try{
				if (br != null) {
		            br.close();
		        }
			}catch(IOException e){
				e.printStackTrace();
			}
		}
	}
	
	public void setup(String str){
		String[] given = str.split(" ");
		setFizz(given[0]);
		setBuzz(given[1]);
		setMax(given[2]);	
	}
	private boolean getValidInput(){
		return isValid;
	}
	private void setValidInput(boolean boo){
		isValid = boo;
	}
	private void setFizz(String str){
		int num = Integer.parseInt(str);
		if(num > 0 && num < 21){
			fizz = num;
		}
		else{
			System.out.println("Out of Range Exception ");	
			setValidInput(false);
		}
	}
	private void setBuzz(String str){
		int num = Integer.parseInt(str);
		if(num > 0 && num < 21){
			buzz = num;
		}
		else{
			System.out.println("Out of Range Exception ");	
			setValidInput(false);
		}
	}
	private void setMax(String str){
		int num = Integer.parseInt(str);
		if(num > 20 && num < 101){
			max = num;
		}
		else{
			System.out.println("Out of Range Exception ");	
			setValidInput(false);
		}
	}
	private int getFizz(){
		return fizz;
	}
	private int getBuzz(){
		return buzz;
	}
	private int getFizzBuzz(){
		return fizz * buzz;
	}
	private int getMax(){
		return max;
	}
	public void turn(){
		for(int i = 1; i<= getMax(); i++ ){
			if(i == getFizz()){
				System.out.print("F");
			}
			else if (i == getBuzz()){
				System.out.print("B");
			}
			else if (i == getFizzBuzz()){
				System.out.print("FB");
			}
			else{
				System.out.print(i);
			}
			System.out.print(" ");
		}
		System.out.println();
	}
}
