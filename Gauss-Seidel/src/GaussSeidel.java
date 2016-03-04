
public class GaussSeidel {
	
	
	public static void main(String[] args) {
		
		/* SISTEMA DE ECUACIONES LINEALES
		 * 3x1 - 0.2x2 - 0.5x3 = 8
		 * 0.1x1 + 7x2 + 0.4x3 = -19.5
		 * 0.45x1 - 0.1x2 + 10x3 = 72.4
		 * */
		
		double[][] matriz = { { 3 , -0.2 , -0.5 , 8 }, 
							  { 0.1 , 7 , 0.4 , -19.5 }, 
							  { 0.4 , -0.1 , 10 , 72.4 }};
		
		// declarar las variables con 0
		double x1 = 0;
		double x2 = 0; 
		double x3 = 0;
		double x1Ant;
		double x2Ant;
		double x3Ant;
		double ERROR_TOTAL = 1;
		double error1 = 0;
		double error2 = 0;
		double error3 = 0;
		int iteracion = 0;
		double errorAnt1 = 0;
		double errorAnt2 = 0;
		double errorAnt3 = 0;
		
		// primera aproximacion
		x1 = (matriz[0][3] - matriz[0][1]*(x2) - matriz[0][2] * (x3)) / matriz[0][0];
		x2 = (matriz[1][3] - matriz[1][0]*(x1) - matriz[1][2] * (x3)) / matriz[1][1];
		x3 = (matriz[2][3] - matriz[2][0]*(x1) - matriz[2][1] * (x2)) / matriz[2][2];
		errorAnt1 = x1;
		errorAnt2 = x2;
		errorAnt3 = x3;
		
		System.out.println("iteracion: " + iteracion);
		System.out.println("x1: " + x1);
		System.out.println("x2: " + x2);
		System.out.println("x3: " + x3);
		System.out.println("error1: 0");
		System.out.println("error2: 0");
		System.out.println("error3: 0\n");
		
		do{
			
			iteracion++;
			
			x1Ant = x1;
			x2Ant = x2;
			x3Ant = x3;
			
			// sustitucion de las formulas
			x1 = (matriz[0][3] - matriz[0][1]*(x2Ant) - matriz[0][2] * (x3Ant)) / matriz[0][0];
			x2 = (matriz[1][3] - matriz[1][0]*(x1Ant) - matriz[1][2] * (x3Ant)) / matriz[1][1];
			x3 = (matriz[2][3] - matriz[2][0]*(x1Ant) - matriz[2][1] * (x2Ant)) / matriz[2][2];
			
			System.out.println("iteracion: " + iteracion);
			System.out.println("x1: " + x1);
			System.out.println("x2: " + x2);
			System.out.println("x3: " + x3);
			
			error1 = Math.abs( (( x1 - errorAnt1 ) / x1) * 100 );
			error2 = Math.abs( (( x2 - errorAnt2 ) / x2) * 100 );
			error3 = Math.abs( (( x3 - errorAnt3 ) / x3) * 100 );
			
			System.out.println("error1: " + error1);
			System.out.println("error2: " + error2);
			System.out.println("error3: " + error3);
			
			errorAnt1 = x1;
			errorAnt2 = x2;
			errorAnt3 = x3;
			
			System.out.println();
			
		}while( error1 > ERROR_TOTAL || error2 > ERROR_TOTAL || error3 > ERROR_TOTAL );
		
	}

}
