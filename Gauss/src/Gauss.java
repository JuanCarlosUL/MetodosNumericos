
public class Gauss {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/* SISTEMA DE ECUACIONES LINEALES
		 * 2x1 + 8x2 + 6x3 = 20
		 * 4x1 + 2x2 - 2x3 = -2
		 * 3x1 -  x2 +  x3 = 11
		 * */
		
		float[][] matriz = { { 2 , 8 , 6 , 20 } ,
							  { 4 , 2 , - 2 , - 2 } ,
							  { 3, -1 , 1 , 11 } };
		
		// sacar la matriz triangular superior
		for( int i = 0; i < matriz.length ; i++ ){
			
			// pivote
			float pivote = matriz[i][i];
			
			// dividir todo el renglon por el pivote
			for( int j = i; j < matriz[i].length; j++ )
				matriz[i][j]=matriz[i][j] / pivote;
			
			// actualiza los otros renglones de abajo
			for( int k = i + 1; k < matriz.length ; k++){
				float aux = -matriz[k][i];
				for( int l = i; l < matriz[k].length ; l++)
					matriz[k][l] += matriz[i][l] * aux;
			}
			
		}
		
		// sustituir 
		float x3 = matriz[2][3];
		
		// sustituir para obtener x2
		float x2 = -(matriz[1][2] * x3) + matriz[1][3];
		
		// sustituir para obtener x1
		float x1 = -(matriz[0][1] * x2) -(matriz[0][2] * x3) + matriz[0][3];
		
		// resultado de la matriz aumentada
		for( float[] a : matriz){
			for( float b : a)
				System.out.print(b + "\t");
			System.out.println();
		}
		
		// resultados de las x
		System.out.println("X1: " + x1);
		System.out.println("X2: " + x2);
		System.out.println("X3: " + x3);
		
	}

}
