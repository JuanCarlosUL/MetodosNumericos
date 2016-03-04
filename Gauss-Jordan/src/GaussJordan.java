
public class GaussJordan {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/* SISTEMA DE ECUACIONES LINEALES
		 * 2x1 + 8x2 + 6x3 = 20
		 * 4x1 + 2x2 - 2x3 = -2
		 * 3x1 -  x2 +  x3 = 11
		 * */
		
		double[][] matriz = { { 2 , 8 , 6 , 20 } ,
							  { 4 , 2 , - 2 , - 2 } ,
							  { 3, -1 , 1 , 11 } };
		
		for( int i = 0; i < matriz.length ; i++ ){
			
			// pivote
			double pivote = matriz[i][i];
			// dividir todo el renglon por el pivote
			for( int j = i; j < matriz[i].length; j++ )
				matriz[i][j] /= pivote;
			
			// actualiza los otros renglones de abajo
			for( int k = i + 1; k < matriz.length ; k++){
				double aux = -matriz[k][i];
				for( int l = i; l < matriz[k].length ; l++)
					matriz[k][l] = matriz[i][l] * aux + matriz[k][l];
			}
			
			// actualiza los otros renglones de arriba
			for( int k = i - 1; k >= 0 ; k--){
				double aux = -matriz[k][i];
				for( int l = i; l < matriz[k].length ; l++)
					matriz[k][l] = matriz[i][l] * aux + matriz[k][l];
			}
			
		}
		
		for( double[] a : matriz){
			for( double b : a)
				System.out.print(b + "\t");
			System.out.println();
		}
		
		
	}

}
